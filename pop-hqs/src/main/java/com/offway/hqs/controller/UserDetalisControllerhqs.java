package com.offway.hqs.controller;

import com.offway.common.entity.R;
import com.offway.hqs.dto.TUserDetailsDto;
import com.offway.hqs.service.ITUserDetailsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户详情接口", tags = "用户详情接口")
@RestController
@CrossOrigin // 解决跨域的问题
public class UserDetalisControllerhqs {

    @Autowired
    @Qualifier("TUserDetailsServiceImplhqs")
    private ITUserDetailsService itUserDetailsService;
    //查询用户详情
    @GetMapping("/api/userdetails/selectUserdicountByphone.do")
    public  R selectUserdicountByid(String token){
        return itUserDetailsService.selectUserdicountByid(token);
    }
    //修改用户详情
    @PutMapping("/api/userdetails/updateUserDetails.do")
   public R updateUserDetails(TUserDetailsDto tUserDetailsDto){
        return itUserDetailsService.updateUserDetails(tUserDetailsDto);
    }
    //新增用户详情
    @PostMapping("/api/userdetails/addUserDetails.do")
   public R addUserDetails(TUserDetailsDto tUserDetailsDto){
        return itUserDetailsService.addUserDetails(tUserDetailsDto);
    }
}
