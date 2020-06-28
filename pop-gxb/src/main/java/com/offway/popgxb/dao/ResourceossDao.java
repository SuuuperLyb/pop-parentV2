package com.offway.popgxb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.R;
import com.offway.popgxb.dto.TResourceossDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PackgeName: com.offway.popgxb.dao
 * @ClassName: ResourceossDao
 * @Author: gxb
 * Date: 2020/6/28 11:27:40
 * project name: pop-parent
 * @Version:
 * @Description:
 */
public interface ResourceossDao extends BaseMapper<TResourceossDto> {
    /**
     * 上传商品图片
     * @param file
     * @return
     */
    R sendFile(MultipartFile file);
}
