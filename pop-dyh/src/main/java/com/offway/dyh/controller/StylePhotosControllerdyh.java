package com.offway.dyh.controller;

import com.offway.common.entity.*;
import com.offway.dyh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin
public class StylePhotosControllerdyh {

    @Autowired
    @Qualifier("IStylePhotosServicedyh")
    private IStylePhotosService service;
    /**
     *添加照片明细
     * @param
     * @param
     * @param tp
     * @return
     */
    @PostMapping("/api/offway/poststartstyle.do")
    public R postStartStyle( @RequestBody TStylePhotos tp){
        TStylePhotos ts = new TStylePhotos();
        return service.postStartStyle(tp);
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @PostMapping("/api/offway/ossfileuploda.do")
    public R postfileimg(MultipartFile file){
        return service.sendFile(file);
    }
}
