package com.offway.popzgy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TAdmindetail;
import com.offway.popzgy.dto.AdminDto;

public interface TAdminDetailService extends IService<TAdmindetail>{
    //登录
    R login(AdminDto adminDto);
    //退出
    R exit(String token);
}
