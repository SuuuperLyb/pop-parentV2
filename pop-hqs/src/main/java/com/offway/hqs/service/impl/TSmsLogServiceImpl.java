package com.offway.hqs.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.hqs.config.RedisKeyConfig;
import com.offway.hqs.dao.TSmsLogMapper;
import com.offway.hqs.dto.TSmsLogDto;
import com.offway.hqs.dto.UserRegisterCodeDto;
import com.offway.hqs.service.ITSmsLogService;
import com.offway.hqs.three.SmsCore;
import com.offway.hqs.type.SmsType;
import com.offway.hqs.util.NumRandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;


@Service
public class TSmsLogServiceImpl extends ServiceImpl<TSmsLogMapper,TSmsLogDto> implements ITSmsLogService {

    @Resource
    private JedisCore jedisCore;

    @Autowired
    private TSmsLogMapper logDao;

    @Override
    public R sendRegisterCode(String phone) {
        // 发送注册的短信验证码
        // 1.验证码
        int code;
        if (jedisCore.isExist(RedisKeyConfig.SMS_RCODE + phone)) {
            // 上次的存储验证码+手机号的redis的key还存在，上次的验证码还未失效
            code = Integer.parseInt(jedisCore.getVal(RedisKeyConfig.SMS_RCODE + phone));
        } else {
            // 如果redis的key不存在，就创建一个6位的随机数字串
            code = NumRandomUtil.createNum(6);
        }
        // 2.发送短信
        SmsCore.sendRCode(phone, code);
        // 3.将验证码和用户手机信息记录到数据库
        System.out.println("验证码"+code);
        TSmsLogDto log = new TSmsLogDto(phone, "注册发送验证码：" + code, SmsType.注册验证码.getVal(), LocalDateTime.now());
        // 将产生的6位字符串添加到redis中去,key为 (pop:sms:rcode:+手机号)  值为code字符串   时间为5分钟
        jedisCore.set(RedisKeyConfig.SMS_RCODE + phone, RedisKeyConfig.SMS_RCODE_TIME,String.valueOf(code));

        // 4.结果返回
        return Rutil.Ok();
    }

    @Override
    public R checkRCode(UserRegisterCodeDto codeDto) {
        // 如果用户登录时传递的手机号 得到的 redis中存储的key存在，说明验证码在这段时间还有效，说明是用户在这段时间内点击过获取验证码
        // 将 key为pop:sms:rcode:+用户的手机号 值为 当时生成的验证码 保存到了redis中
        if (jedisCore.isExist(RedisKeyConfig.SMS_RCODE + codeDto.getPhone())) {
            // 此时指的是在 已经点击过了获取验证码，但是验证码还没有过期的时间段内，此时自己的 pop:sms:rcode:+用户的手机号 作为key
            // 值为 code已经存储到了redis中了
            if (codeDto.getCode() == Integer.parseInt(jedisCore.getVal(RedisKeyConfig.SMS_RCODE + codeDto.getPhone()))) {
                // 验证通过，删除验证码
                jedisCore.del(RedisKeyConfig.SMS_RCODE + codeDto.getPhone());
                return Rutil.Ok();
            } else {
                return Rutil.err("亲，验证码不正确！");
            }
        } else {
            return Rutil.err("验证码已失效");
        }
    }
}
