package com.offway.popgxb.controller;

import com.offway.common.entity.R;
import com.offway.popgxb.service.ResourceossService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PackgeName: com.offway.popgxb.controller
 * @ClassName: ResourceossController
 * @Author: gxb
 * Date: 2020/6/28 11:38:39
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@RestController
@CrossOrigin
@Api(tags = "上传商品图片的接口")
public class ResourceossControllergxb {

    @Autowired
    @Qualifier("resourceossServiceImplgxb")
    private ResourceossService resourceossService;

    /**
     * 上传商品图片
     *
     * @param file
     * @return
     */
    @PostMapping("/api/goodsdetail/fileupload.do")
    public R file(MultipartFile file) {
        return resourceossService.sendFile(file);
    }
}
