package com.offway.hqs.controller;

import com.offway.common.entity.R;
import com.offway.hqs.service.ITResourceossService;
import com.offway.hqs.service.impl.TResourceossServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "头像接口", tags = "头像接口")
@RestController
@CrossOrigin // 解决跨域的问题
public class TResourceossControllerhqs {
    @Autowired
    @Qualifier("tResourceossServiceImplhqs")
    private ITResourceossService itResourceossService;
/*
* 上传资源：图片、视频
* */
    @PutMapping("api/sms/sendFile.do")
    public R sendFile(MultipartFile file, String token){
        return itResourceossService.sendFile(file,token);
    }

}
