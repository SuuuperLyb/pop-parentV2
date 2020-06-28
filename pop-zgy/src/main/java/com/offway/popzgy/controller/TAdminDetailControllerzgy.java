package com.offway.popzgy.controller;

import com.offway.common.entity.R;
import com.offway.popzgy.dto.AdminDto;
import com.offway.popzgy.service.TAdminDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TAdminDetailControllerzgy {

    @Autowired
    @Qualifier("adminDetailServicezgy")
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
