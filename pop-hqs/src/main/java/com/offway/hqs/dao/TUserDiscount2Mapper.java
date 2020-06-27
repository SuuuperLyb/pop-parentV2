package com.offway.hqs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.TDiscount;

import java.util.List;

public interface TUserDiscount2Mapper extends BaseMapper<TDiscount> {
//根据phone查询优惠券详情
    List<TDiscount> selectUserdicountByphone(String phone);

}
