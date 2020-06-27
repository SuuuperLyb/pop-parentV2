package com.offway.lxm.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.R;
import com.offway.common.entity.TUserlike;
import com.offway.lxm.dto.DeleteUserlikeDto;

/**
 * 用户喜欢模块
 */
public interface TUserlikeService {
    /**
     * 查询用户喜欢的所有商品
     * @param token
     * @return
     */
    R getgoods(String token);
    /**
     * 查询用户喜欢的所有店铺
     * @param token
     * @return
     */
    R getstores(String token);

    /**
     * 查询用户喜欢的所有明星穿搭风格
     * @param token
     * @return
     */
    R getstarstyles(String token);


    /**
     * 删除用户喜欢
     * @param deleteUserlikeDto
     * @return
     */
    R dellike(DeleteUserlikeDto deleteUserlikeDto);


}
