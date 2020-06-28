package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserDetails;
import com.offway.common.util.Rutil;
import com.offway.dyh.dao.UserDetailsMapper;
import com.offway.dyh.service.ISelectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ISelectUserServicedyh")
public class ISelectUserServiceImpl extends ServiceImpl<UserDetailsMapper, TUserDetails> implements ISelectUserService {
    @Autowired
    private UserDetailsMapper userDetailsMapper;
    //查询本日新增用户
    @Override
    public R selectUserDay() {
        return Rutil.Ok(userDetailsMapper.selectUserDay());
    }
    //查询近七天
    @Override
    public R selectUserWeek() {
        return Rutil.Ok(userDetailsMapper.selectUserWeek());
    }

    @Override
    public R selectusercount() {
        return Rutil.Ok(userDetailsMapper.selectCount(new QueryWrapper<TUserDetails>().eq("ud_is_deleted", 1)));
    }
}
