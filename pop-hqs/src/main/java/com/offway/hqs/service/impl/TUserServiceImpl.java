package com.offway.hqs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.entity.TUserDetails;
import com.offway.common.mapper.TUserDetailsMapper;
import com.offway.common.mapper.TUserMapper;

import com.offway.common.three.JedisCore;
import com.offway.common.type.RcodeType;
import com.offway.common.util.Rutil;
import com.offway.hqs.config.RedisKeyConfig;
import com.offway.hqs.dto.LoginTokenDto;
import com.offway.hqs.dto.UserDto;
import com.offway.hqs.service.ITUserService;

import com.offway.hqs.three.JwtCore;
import com.offway.hqs.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired(required = false)
    private TUserMapper tUserMapper;
    @Autowired(required = false)
    private TUserDetailsMapper tUserdetailMapper;
    @Value("${pop.passkey}")
    private String key;
    @Autowired
    private JedisCore jedisCore;

    @Override
    public R checkPhone(String phone) {//验证手机号
        //查询user表中是否存在输入的手机号
        TUser user = tUserMapper.selectOne(new QueryWrapper<TUser>().eq("u_phone", phone));
        if(user==null){
            return Rutil.Ok();
        }else {
           return Rutil.err("手机号已存在");
        }

    }
    @Transactional
    @Override
    public R register(UserDto userDto) {//注册
        // checkPhone(userDto.getPhone())返回值为 R 成功就是RUtil.ok() 也就是R R.getCode()是状态码 为200 表示相等
        // 用户此时输入的只有手机号和密码,通过userDto对象传递  先检测手机号是否被注册过
        if((checkPhone(userDto.getPhone()).getCode())== RcodeType.成功.getValue()){
            // 手机号 可用 手机号没有备注册过
            // 密码转为密文
            // 创建user对象
            TUser user =new TUser();
            // 设置flag为1 表示注册了用户
            user.setuIsDelete(1);
            user.setuPhone(Integer.valueOf(userDto.getPhone()));
            // 对用户输入的密码通过AES方式进行加密处理
            user.setuPassword(EncryptUtil.aesenc(key, userDto.getPass()));
            // 把加密后的用户信息添加到数据库
            tUserMapper.insert(user);
            // 新增用户详情  注册成功后将用户的简单详情插入到数据库中
            TUserDetails userDetails=new TUserDetails();
            userDetails.setuId(user.getuId());
            userDetails.setUdCreateTime((LocalDate.now()));
            tUserdetailMapper.insert(userDetails);
            return Rutil.Ok();
        } else {
            return Rutil.err("手机号已存在");
        }
    }

    @Override
    public R login(UserDto userDto) {//登录
        // 存储登录相关信息 这个是redis将要存储的key的名称 (pop:login:phone:+userDto.getPhone()) 值存储token令牌字符串
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_TOKEN+userDto.getPhone())){
            return Rutil.err("亲，已登录");
        }else {
            // 根据用户传来的手机号查询user表，来确定用户是否已经进行了注册
            TUser tUser = tUserMapper.selectOne(new QueryWrapper<TUser>().eq("u_phone",userDto.getPhone()));
            // 数据库中已经存在了当前用户
            if (tUser!=null){
                // 标记为1 表示已经注册过了
                if(tUser.getuIsDelete()==1){
                    // 将用户登录输入的密码再次通过aes方式进行加密，和数据库中的加密后的密码进行比较
                    System.out.println("密码"+tUser.getuPassword());
                    System.out.println("解码"+EncryptUtil.aesenc(key,userDto.getPass()));
                    if (tUser.getuPassword().equals(EncryptUtil.aesenc(key,userDto.getPass()))){
                        // 正确
                        // 生成令牌
                        // LoginTokenDto类为数据传输对象类
                        LoginTokenDto tokenDto = new LoginTokenDto(tUser.getuId(),String.valueOf(tUser.getuPhone()), LocalDateTime.now());
                        // 先把tokenDto对象转换为json字符串 再用jwt对json字符串进行生成令牌 这个令牌也是一个字符串
                        String token = JwtCore.createToken(JSON.toJSONString(tokenDto));
                        // 记录令牌到Redis 有效期 30分钟
                        jedisCore.set(RedisKeyConfig.LOGIN_TOKEN + userDto.getPhone(), RedisKeyConfig.LOGIN_TOKEN_TIME, token);
                        jedisCore.set(RedisKeyConfig.LOGIN_USER + token, RedisKeyConfig.LOGIN_TOKEN_TIME, JSON.toJSONString(tUser));

                        return Rutil.Ok(token);
                    }else {
                        return Rutil.err("账号密码错误");
                    }
                }else {
                    return Rutil.err("账号已注销");
                }
            }else {
                return Rutil.err("账号为空");
            }
        }


    }

    @Override
    public R checkToken(String token) {//校验登录令牌的有效性
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)){
            return Rutil.Ok();
        }else {
          return Rutil.err("令牌无效，请重新登录！");
        }
    }

    @Override
    public R exit(String token) {//退出
        if (jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)){
            // 得到 key为 pop:login:token:uPhone 值为tUser的json字符串  再将这个字符串转换为tUser对象
            // tUser为用户注册时加入到数据库的信息，表示用户已经注册过了
            TUser tUser = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),TUser.class);
            // key为 pop:login:token:uPhone 里面存的是 token字符串
            jedisCore.del(RedisKeyConfig.LOGIN_TOKEN+tUser.getuPhone());
            jedisCore.del(RedisKeyConfig.LOGIN_USER+token);
            return Rutil.Ok();
        }

        return Rutil.err("令牌已失效！");
    }
}
