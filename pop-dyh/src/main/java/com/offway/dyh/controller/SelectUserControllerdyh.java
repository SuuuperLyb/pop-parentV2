package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.dyh.service.IAdminGoodsDetailService;
import com.offway.dyh.service.ISelectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SelectUserControllerdyh {
    @Autowired
    @Qualifier("ISelectUserServicedyh")
    private ISelectUserService service;
    /**
     * 查询本日
     *
     * @return
     */
    @GetMapping("/api/offway/selectuserday.do")
    public R selectUserDay() {
        return service.selectUserDay();
    }

    /**
     * 查询近七天新增用户数量
     */
    @GetMapping("/api/offway/selectuserweek.do")
    public R selectUserWeek(){
        return service.selectUserWeek();
    }
    /**
     * 查询用户总和
     */
    @GetMapping("/api/offway/selectusercount.do")
    public R selectUserCount(){
        return service.selectusercount();
    }
}
