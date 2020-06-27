package com.offway.hqs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.hqs.dto.TResourceossDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 对象存储类oss 服务类
 * </p>
 */
public interface ITResourceossService{
    /**
     * 上传资源：图片、视频
     *
     */
    R sendFile(MultipartFile file,String token);
}
