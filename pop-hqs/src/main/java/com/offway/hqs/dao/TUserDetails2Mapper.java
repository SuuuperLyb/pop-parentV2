package com.offway.hqs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.TDiscount;
import com.offway.common.entity.TUserDetails;
import com.offway.hqs.dto.TUserDetailsDto;

import java.util.List;

public interface TUserDetails2Mapper extends BaseMapper<TUserDetails> {
//更新用户详情
    int  updateUserDetails(TUserDetailsDto tUserDetailsDto);
    //添加用户详情
    int insertUserDetails(TUserDetailsDto tUserDetailsDto);

}
