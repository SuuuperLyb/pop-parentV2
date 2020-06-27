package com.offway.zyn.controller;

import com.offway.common.entity.R;
import com.offway.zyn.service.GoodDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author starzyn
 * @className:GoodDetailController
 * @date : 2020/6/25
 * @description: 商品详情的的页面控制类
 */
@RestController
public class GoodDetailController {
    @Autowired
    GoodDetailService goodDetailService;

    /**
     * @Author starzyn
     * @Description 根据传入的商品id来查询商品详情
     * @Date 11:32 2020/6/25
     * @Param [goodId]
     * @return com.offway.common.entity.R
     **/
    @GetMapping("/good/detail")
    public R showDetail(@RequestParam(name = "goodId") int goodId,@RequestParam(name = "token",required = false)String token){
        return goodDetailService.show(goodId,token);
    }

    /**
     * @Author starzyn
     * @Description 根据商品id来添加当前用户的喜欢
     * @Date 11:33 2020/6/25
     * @Param [goodId]
     * @return com.offway.common.entity.R
     **/
    @PostMapping("/good/addLike")
    public R addLike(@RequestParam(name = "goodId") int goodId,String token){
        return goodDetailService.addLike(goodId,token);
    }

    @PostMapping("/good/addCar")
    public R addCar(@RequestParam(name = "goodId") int goodId,String token){
        return goodDetailService.addCar(goodId,token);
    }
}
