package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.dyh.service.IAdminGoodsDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminGoodsDetailController {
    @Resource
    private IAdminGoodsDetailService service;
    @GetMapping("/api/offway/goodsnum.do")
    /**
     * 查询上架的商品数量（有效的）
     */
    public R goodsNum(){
        return service.goodsNum();
    }
    /**
     * 查询下架的商品总数（无效的）
     */
    @GetMapping("/api/offway/goodsnull.do")
    public R goodsNull(){
        return service.goodsNull();
    }
    /**
     * 查询商城的商品总数
     */
    @GetMapping("/api/offway/selectgoods.do")
    public R selectGoods(){
        return service.selectGoods();
    }
    /**
     * 查询库存少于50的商品
     */
    @GetMapping("/api/offway/selectgoodsfew.do")
    public R selectGoodsFew(){
        return service.selectGoodsFew();
    }
}
