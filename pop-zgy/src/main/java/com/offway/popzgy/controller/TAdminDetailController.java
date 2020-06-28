package com.offway.popzgy.controller;

import com.offway.common.entity.R;
import com.offway.popzgy.dto.AdminDto;
import com.offway.popzgy.service.TAdminDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TAdminDetailController {

    @Autowired
    private TAdminDetailService adminDetailService;
    @PostMapping ("admin/login.do")
    public R login(@RequestBody AdminDto adminDto){
        return adminDetailService.login(adminDto);
    }

    @PostMapping("admin/exit.do")
    public R exit(@RequestParam (value = "token") String token){
        return adminDetailService.exit(token);
    }
}
