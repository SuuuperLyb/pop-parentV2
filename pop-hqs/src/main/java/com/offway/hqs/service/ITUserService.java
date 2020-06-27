package com.offway.hqs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.hqs.dto.UserDto;

public interface ITUserService extends IService<TUser> {
    /**
     * 校验手机号是否存在
     */
    R checkPhone(String phone);

    /**
     * 注册新用户
     */
    R register(UserDto userDto);

    /**
     * 登录
     */
    R login(UserDto userDto);

    /**
     * 校验登录令牌的有效性
     */
    R checkToken(String token);

    /**
     * 注销 退出
     */
    R exit(String token);
}
