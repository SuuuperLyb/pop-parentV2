package com.offway.dyh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.TUserDetails;

/**
 * <p>
 * 用户详情表 Mapper 接口
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public interface UserDetailsMapper extends BaseMapper<TUserDetails> {
    //查询当日新增用户数量
    int selectUserDay();
    //查询近七天
    int selectUserWeek();
}
