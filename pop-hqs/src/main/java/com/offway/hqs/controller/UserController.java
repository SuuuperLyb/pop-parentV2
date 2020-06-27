package com.offway.hqs.controller;


import com.offway.common.entity.R;
import com.offway.hqs.dto.UserDto;
import com.offway.hqs.service.ITUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    private ITUserService itUserService;

    @GetMapping("/api/user/checkphone.do")
    public R check(String phone) {
        return itUserService.checkPhone(phone);
    }

    @PostMapping("/api/user/register.do")
    public R register(@RequestBody UserDto dto) {
        return itUserService.register(dto);
    }

    @PostMapping("/api/user/login.do")
    public R login(@RequestBody UserDto dto) {
        return itUserService.login(dto);
    }

    @PostMapping("/api/user/checktoken.do")
    public R checkToken(String token) {
        return itUserService.checkToken(token);
    }
    @PostMapping("/api/user/exit.do")
    public R exit(String token){
       return itUserService.exit(token);
    }
}
