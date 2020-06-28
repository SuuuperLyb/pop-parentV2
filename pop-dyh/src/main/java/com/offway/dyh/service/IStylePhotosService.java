package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.*;
import org.springframework.web.multipart.MultipartFile;

public interface IStylePhotosService extends IService<TStylePhotos> {

    //上传图片
    R sendFile(MultipartFile file);
    //增加商品明细
    R postStartStyle(TStylePhotos tp);
}
