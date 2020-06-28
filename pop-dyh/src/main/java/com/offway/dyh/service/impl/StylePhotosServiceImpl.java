package com.offway.dyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.*;

import com.offway.common.util.Rutil;
import com.offway.dyh.Utile.FileUtil;
import com.offway.dyh.config.OssConfig;
import com.offway.dyh.dao.*;
import com.offway.dyh.service.IStylePhotosService;

import com.offway.dyh.three.OssCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Transactional
@Service("IStylePhotosServicedyh")
public class StylePhotosServiceImpl extends ServiceImpl<StylePhotosMapper,TStylePhotos> implements IStylePhotosService {

    @Autowired
    private StylePhotosMapper photosMapper;

    @Override
    public R sendFile(MultipartFile file) {
        //1、校验
        if(!file.isEmpty()){
            //2.重命名
            String fn= FileUtil.renameFile(file.getOriginalFilename());
            try {
                //3.上传到OSS
                String url= OssCore.sendResource(OssConfig.bucketName,fn,file.getBytes());
                return Rutil.Ok(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Rutil.err();
        }
    //添加照片信息数据
    @Override
    public R postStartStyle(TStylePhotos tp) {
        return Rutil.Ok(photosMapper.insert(tp));
    }


}

