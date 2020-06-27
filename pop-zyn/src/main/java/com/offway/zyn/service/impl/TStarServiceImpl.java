package com.offway.zyn.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TStar;
import com.offway.common.entity.TStarStyle;
import com.offway.common.entity.TStylePhotos;
import com.offway.common.mapper.TStarMapper;
import com.offway.common.mapper.TStarStyleMapper;
import com.offway.common.mapper.TStylePhotosMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.zyn.dto.HotStarInf;
import com.offway.zyn.dto.StarInfo;
import com.offway.zyn.mapper.StarInfoMapper;
import com.offway.zyn.service.TStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author starzyn
 * @className:TStarServiceImpl
 * @date : 2020/6/25
 * @description: 明星业务层的实现类
 */
@Service
public class TStarServiceImpl implements TStarService {
    @Resource
    TStarStyleMapper tssm;//明星穿搭dao层实例
    @Resource
    TStylePhotosMapper tspm;//明星穿搭的照片dao层实例
    @Resource
    TStarMapper tStarMapper;//明星的dao层实例
    @Resource
    StarInfoMapper starInfoMapper;
    @Autowired
    JedisCore jedisCore;//redis 核心类，主要用来访问缓存
    
    /**
     * @Author starzyn
     * @Description 展示明星展示页面上的热度前三的信息
     * @Date 10:17 2020/6/26
     * @Param []
     * @return com.offway.common.entity.R
     **/
    @Override
    public R getHotStyle() {
        boolean isExit = jedisCore.isExist("hotStarInfo");//判断缓存是否有明星穿搭的轮播图信息
        if(isExit){//如果缓存中存在
//            jedisCore.del("hotStarInfo");
//            return Rutil.Ok();
            String jsonStr = jedisCore.getVal("hotStarInfo");
            JSONArray starInfsarr = JSONArray.parseArray(jsonStr);
            List<HotStarInf> starInfs = starInfsarr.toJavaList(HotStarInf.class);
            return Rutil.Ok(starInfs);
        }else {//缓存中不存在，去数据库中查询并添加到缓存中
//            tStarService.getMainStarInfo();
            List<TStarStyle> tss = tssm.selectList(new QueryWrapper<TStarStyle>().orderByDesc("like_num").last("limit 0,3"));
            List<HotStarInf> starInfs = new ArrayList<>();//初始化dto对象
            for(TStarStyle tStarStyle:tss){
                //根据用查询到的明星风格来查询对应的图片
                List<TStylePhotos> photos = tspm.selectList(new QueryWrapper<TStylePhotos>().eq("stat_style_id",tStarStyle.getStarStyleId()));
                //将两者组合到一起变成输出模板
                HotStarInf hsi = new HotStarInf(tStarStyle,photos);
                //加入到结果集中
                starInfs.add(hsi);
            }
            jedisCore.set("hotStarInfo",24*68*60, JSONObject.toJSONString(starInfs));
            return Rutil.Ok(starInfs);
        }
    }

    /**
     * @Author starzyn
     * @Description 列出所有的明星穿搭风格的信息
     * @Date 10:17 2020/6/26
     * @Param [starPage, pageSize]
     * @return com.offway.common.entity.R
     **/
    @Override
    public R listAll(int startPage,int pageSize) {
        if(startPage==1){//如果是首页，去缓存查，如果没有就加入
            boolean isExit = jedisCore.isExist("firstStarList");//判断缓存是否有明星穿搭的轮播图信息
            if(isExit){//如果缓存中存在,对于缓存来说，第一页的数据是热数据，让在缓存中，后面的分页数据可以不放在缓存中
//                jedisCore.del("firstStarList");
//                return Rutil.Ok();
                String jsonStr = jedisCore.getVal("firstStarList");
                Page<StarInfo> page = JSONObject.parseObject(jsonStr,Page.class);
                return Rutil.Ok(page);
            }else {//缓存中不存在，去数据库中查询并添加到缓存中
//            tStarService.getMainStarInfo();
//                IPage<TStarStyle> firstPage = tssm.selectPage(new Page<>(1,pageSize),new QueryWrapper<TStarStyle>().orderByDesc("like_num"));
                Page<StarInfo> firstPage = new Page(1,pageSize);
                firstPage.setRecords(starInfoMapper.getStarInfoByPage(firstPage));
                jedisCore.set("firstStarList",24*68*60, JSONObject.toJSONString(firstPage));
                return Rutil.Ok(firstPage);
            }
        }else{//冷数据去数据库查
//            IPage<TStarStyle> firstPage = tssm.selectPage(new Page<TStarStyle>(startPage,pageSize),new QueryWrapper<TStarStyle>().orderByDesc("like_num"));
            Page<StarInfo> page = new Page(startPage,pageSize);
            page.setRecords(starInfoMapper.getStarInfoByPage(page));
            return Rutil.Ok(page);
        }
    }


    /**
     * @Author starzyn
     * @Description 通过明星姓名来查询明星的所有穿搭风格,分页展示
     * @Date 12:00 2020/6/26
     * @Param [starName]
     * @return com.offway.common.entity.R
     **/
    @Override
    public R listByName(String starName,int startPage,int pageSize) {
        Page<StarInfo> page = new Page(startPage,pageSize);//创建page对象
        page.setRecords(starInfoMapper.getStarInfoByPageWithName(page,starName));//设置查询信息
        return Rutil.Ok(page);//json字符串返回给前端
    }
}
