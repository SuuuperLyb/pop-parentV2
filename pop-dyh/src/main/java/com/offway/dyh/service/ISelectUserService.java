package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserDetails;

public interface ISelectUserService extends IService<TUserDetails> {
    //查询本日新增用户数量
    R selectUserDay();
    //查询近七天
    R selectUserWeek();
    //用户数量总和
    R selectusercount();
}
