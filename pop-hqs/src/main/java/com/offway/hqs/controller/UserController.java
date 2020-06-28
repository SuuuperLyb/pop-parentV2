package com.offway.hqs.controller;


import com.offway.common.entity.R;
import com.offway.hqs.dto.UserDto;
import com.offway.hqs.service.ITUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Api(value = "用户相关接口", tags = "用户相关接口")
public class UserController {
    @Autowired
    private ITUserService itUserService;

    /*
     * 校验手机号是否存在
     *
     */
    @GetMapping("/api/user/checkphone.do")
    public R check(String phone) {
        return itUserService.checkPhone(phone);
    }

    /**
     * 注册新用户
     */
    @PostMapping("/api/user/register.do")
    public R register(@RequestBody UserDto dto) {
        return itUserService.register(dto);
    }

    /**
     * 登录
     */
    @PostMapping("/api/user/login.do")
    public R login(@RequestBody UserDto dto) {
        return itUserService.login(dto);
    }

    /**
     * 校验登录令牌的有效性
     */
    @PostMapping("/api/user/checktoken.do")
    public R checkToken(String token) {
        return itUserService.checkToken(token);
    }

    /**
     * 注销 退出
     */
    @PostMapping("/api/user/exit.do")
    public R exit(String token) {
        return itUserService.exit(token);
    }
}
