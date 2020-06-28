package com.offway.popzgy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.TDiscount;

public interface TDiscountService extends IService<TDiscount> {
    //添加优惠券
    Integer addDisCount(TDiscount tDiscount);
    //删除优惠券
    Integer deleteDisCountById(String dId);
    //查找所有优惠券
    Object findAllDisCount();
}
