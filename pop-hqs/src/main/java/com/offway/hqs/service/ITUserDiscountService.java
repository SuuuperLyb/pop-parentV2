package com.offway.hqs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserDiscount;

public interface ITUserDiscountService extends IService<TUserDiscount> {
    //查优惠券，返回优惠券详情
    R userdicountByid(String token);

}
