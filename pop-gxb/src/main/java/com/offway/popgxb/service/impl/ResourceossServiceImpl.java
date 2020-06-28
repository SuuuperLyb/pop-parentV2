package com.offway.popgxb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.mapper.TGoodimgMapper;
import com.offway.common.util.Rutil;
import com.offway.popgxb.config.OssConfig;
import com.offway.popgxb.dao.ResourceossDao;
import com.offway.popgxb.dto.TResourceossDto;
import com.offway.popgxb.service.ResourceossService;
import com.offway.popgxb.three.OssCore;
import com.offway.popgxb.util.DateUtil;
import com.offway.popgxb.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @PackgeName: com.offway.popgxb.service.impl
 * @ClassName: ResourceossServiceImpl
 * @Author: gxb
 * Date: 2020/6/28 11:26:08
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@Service("resourceossServiceImplgxb")
public class ResourceossServiceImpl extends ServiceImpl<ResourceossDao, TResourceossDto> implements ResourceossService {

    @Resource
    private ResourceossDao resourceossDao;
    @Resource
    private TGoodimgMapper tGoodimgMapper;

    /**
     * 上传商品图片
     *
     * @param file
     * @return
     */
    @Override
    public R sendFile(MultipartFile file) {
        if (!file.isEmpty()) {
            String fn = FileUtil.renameFile(file.getOriginalFilename());
            try {
            // 3.上传到OSS
            String url = OssCore.sendResource(OssConfig.bucketName, fn, file.getBytes());
            // 4.记录到数据库  对象存储类oss,将图片或其他的文件上传到阿里云服务器的oss中，返回一个url
            TResourceossDto resourceoss = new TResourceossDto(fn, url, DateUtil.comDate(Calendar.YEAR, 1), LocalDateTime.now());
            // resourceossDao.insert(resourceoss);

            // 5.添加成功将 生成的url返回
            return Rutil.Ok(url);
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Rutil.err();
    }
}
