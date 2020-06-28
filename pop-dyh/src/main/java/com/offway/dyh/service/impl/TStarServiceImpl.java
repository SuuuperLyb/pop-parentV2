package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TStar;
import com.offway.common.util.Rutil;
import com.offway.dyh.dao.StarMapper;
import com.offway.dyh.service.ITStarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TStarServiceImpl extends ServiceImpl<StarMapper,TStar> implements ITStarService  {
    @Autowired
    private StarMapper starMapper;
    ///查询所有明星信息
    @Override
    public R getstarList() {
        return Rutil.Ok(starMapper.selectList(new QueryWrapper<TStar>()));
    }
    //添加明星信息
    @Override
    public R postStar(TStar star) {
        return Rutil.Ok(starMapper.insert(star));
    }
}
