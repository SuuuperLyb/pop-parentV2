package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TStarStyle;
import com.offway.common.util.Rutil;
import com.offway.dyh.dao.StarStyleMapper;
import com.offway.dyh.service.ITStarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TStarStyleServiceImpl extends ServiceImpl<StarStyleMapper, TStarStyle> implements ITStarStyleService {
    @Autowired
    private StarStyleMapper starStyleMapper;
    @Override
    public R postStarStyle(TStarStyle tStarStyle) {
        return Rutil.Ok(starStyleMapper.insert(tStarStyle));
    }
}
