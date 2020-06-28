package com.offway.hqs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserDetails;
import com.offway.hqs.dto.TUserDetailsDto;

public interface ITUserDetailsService{

    //查询用户详情
    R selectUserdicountByid(String token);
    //修改用户详情
    R updateUserDetails(TUserDetailsDto tUserDetailsDto);
    //新增用户详情
    R addUserDetails(TUserDetailsDto tUserDetailsDto);

}
