package com.offway.popzgy.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TDiscount;
import com.offway.common.util.Rutil;
import com.offway.popzgy.service.TDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TDiscountControllerzgy {

    @Autowired @Qualifier("discountServicezgy")
    private TDiscountService discountService;

    //添加优惠券
    @PostMapping("discount/add.do")
    public R addDisCount(@RequestBody TDiscount tDiscount){
        Integer result=discountService.addDisCount(tDiscount);
        return Rutil.Ok("添加成功",null);
    }
    //删除优惠券
    @DeleteMapping("discount/add.do")
    public R deleteDisCountById(@RequestParam(value = "dId") String dId){
        Integer result=discountService.deleteDisCountById(dId);
        return Rutil.Ok("删除成功",null);
    }

    //展示所有优惠券
    @GetMapping("discount/findAllDisCount.do")
    public R findAllDisCount(){
        return Rutil.Ok(discountService.findAllDisCount());
    }
}
