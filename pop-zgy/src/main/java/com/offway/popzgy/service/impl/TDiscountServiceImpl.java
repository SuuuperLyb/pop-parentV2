package com.offway.popzgy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.TDiscount;
import com.offway.common.mapper.TDiscountMapper;
import com.offway.popzgy.service.TDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("discountServicezgy")
public class TDiscountServiceImpl extends ServiceImpl<TDiscountMapper, TDiscount> implements TDiscountService {
    @Autowired
    private TDiscountMapper discountMapper;

    //添加优惠券
    @Override
    public Integer addDisCount(TDiscount tDiscount) {

        return discountMapper.insert(tDiscount);
    }

    //删除优惠券
    @Override
    public Integer deleteDisCountById(String dId) {
        return discountMapper.deleteById(Integer.valueOf(dId));
    }

    //查找所有优惠券
    @Override
    public Object findAllDisCount() {
        return discountMapper.selectList(new QueryWrapper<TDiscount>());
    }
}
