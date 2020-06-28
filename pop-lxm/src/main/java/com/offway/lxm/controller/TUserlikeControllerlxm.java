package com.offway.lxm.controller;

import com.offway.common.entity.R;
import com.offway.lxm.dto.DeleteUserlikeDto;
import com.offway.lxm.service.TUserlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author LXM
 * 用户喜欢模块
 * @Date 2020/6/24 0024
 */
@RestController
@CrossOrigin
public class TUserlikeControllerlxm {
    @Autowired
    @Qualifier("TUserlikeServiceImpllxm")
    private TUserlikeService userlikeService;


    /**
     * 查询用户喜欢的所有商品
     * @param token
     * @return
     */
    @PostMapping("api/userlike/getgoods.do")
    public R getgoods(String token){
        return userlikeService.getgoods(token);
    }
    /**
     * 查询用户喜欢的所有店铺
     * @param token
     * @return
     */
    @PostMapping("api/userlike/getstores.do")
    public R getstores(String token){
        return userlikeService.getstores(token);
    }
    /**
     * 查询用户喜欢的所有明星穿搭风格
     * @param token
     * @return
     */
    @PostMapping("api/userlike/getstarstylesByPage.do")
    public R getstarstyles(String token){
        return userlikeService.getstarstyles(token);
    }


    /**
     * 删除用户喜欢
     * @param deleteUserlikeDto
     * @return
     */
    @PostMapping("api/userlike/dellike.do")
    public R dellike(@RequestBody DeleteUserlikeDto deleteUserlikeDto){
       return userlikeService.dellike(deleteUserlikeDto);
    }


}
