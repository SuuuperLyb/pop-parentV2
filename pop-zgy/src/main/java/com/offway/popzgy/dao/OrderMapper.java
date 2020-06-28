package com.offway.popzgy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.TOrder;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public interface OrderMapper extends BaseMapper<TOrder> {

    Integer todayOrderSum();

    Double todaySumMoney();

    Double yesterdaySumMoney();

    List<TOrder> findOrderByMsg(TOrder tOrder);

}
