package com.offway.hqs.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TUserAddress;
import com.offway.hqs.service.ITUseraddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "地址接口", tags = "地址接口")
@RestController
@CrossOrigin // 解决跨域的问题
public class UseradderssController {
    @Autowired
    private ITUseraddressService itUseraddressService;
    public R add(TUserAddress tUserAddress){ //新增
        return itUseraddressService.add(tUserAddress);
    }
    //新增


}
