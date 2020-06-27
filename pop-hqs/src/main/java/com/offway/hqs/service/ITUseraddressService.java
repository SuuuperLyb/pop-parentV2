package com.offway.hqs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserAddress;

public interface ITUseraddressService extends IService<TUserAddress> {
    //新增
    R add(TUserAddress tUserAddress);
    //查询
    R select(String token);
}
