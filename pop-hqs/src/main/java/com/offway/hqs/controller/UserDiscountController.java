package com.offway.hqs.controller;

import com.offway.common.entity.R;
import com.offway.hqs.service.ITUserDiscountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户优惠券接口", tags = "用户优惠券接口")
@RestController
@CrossOrigin // 解决跨域的问题
public class UserDiscountController {
    @Autowired
    private ITUserDiscountService itUserDiscountService;
    //查优惠券，返回优惠券详情
    @GetMapping("/api/userdiscount/userdicountByphone.do")
    public R userdicountByid(String token){
      return itUserDiscountService.userdicountByid(token);
  }

}
