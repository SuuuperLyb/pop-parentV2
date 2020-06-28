package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TStyle;
import com.offway.common.util.Rutil;
import com.offway.dyh.dao.StyleMapper;
import com.offway.dyh.service.ITStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TSyleServiceImpl extends ServiceImpl<StyleMapper, TStyle> implements ITStyleService {
    @Autowired
    private StyleMapper styleMapper;
    @Override
    public R getStyleList() {
        return Rutil.Ok(styleMapper.selectList(new QueryWrapper<TStyle>()));
    }

    @Override
    public R postStyle(TStyle ts) {
        return Rutil.Ok(styleMapper.insert(ts));
    }
}
