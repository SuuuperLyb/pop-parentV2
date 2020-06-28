package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TGoodsDetail;
import com.offway.common.util.Rutil;
import com.offway.dyh.dao.GoodsDetailMapper;
import com.offway.dyh.service.IAdminGoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminGoodsDetailServiceImpl extends ServiceImpl<GoodsDetailMapper, TGoodsDetail> implements IAdminGoodsDetailService {
    @Autowired
    private GoodsDetailMapper tGoodsDetailMapper;
    //查询有效的商品数量
    @Override
    public R goodsNum() {
        return Rutil.Ok(tGoodsDetailMapper.goodsNum());
    }
    //查询无效的商品数量
    @Override
    public R goodsNull() {
        return Rutil.Ok(tGoodsDetailMapper.goodsNull());
    }
    //查询所有的商品数量
    @Override
    public R selectGoods() {
        return Rutil.Ok(tGoodsDetailMapper.selectCount(new QueryWrapper<TGoodsDetail>()));
    }
    //查询库存少于50的
    @Override
    public R selectGoodsFew() {
        return Rutil.Ok(tGoodsDetailMapper.selectGoodsFew());
    }

}
