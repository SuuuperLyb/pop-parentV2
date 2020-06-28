package com.offway.popgxb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.popgxb.dto.TResourceossDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PackgeName: com.offway.popgxb.service
 * @ClassName: ResourceossService
 * @Author: gxb
 * Date: 2020/6/28 11:24:53
 * project name: pop-parent
 * @Version:
 * @Description:
 */
public interface ResourceossService extends IService<TResourceossDto> {
    /**
     * 上传商品图片
     * @param file
     * @return
     */
    R sendFile(MultipartFile file);
}
