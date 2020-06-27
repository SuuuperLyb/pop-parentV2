package com.offway.hqs.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 对象存储类oss,将图片或其他的文件上传到服务器的oss中，返回一个url
 * </p>
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TResourceossDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;

    private String name;

    /**
     * 链接地址
     */
    private String objurl;

    /**
     * 描述信息
     */
    private Date endtime;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    public TResourceossDto(String name, String objurl, Date endtime, LocalDateTime ctime) {
        this.name = name;
        this.objurl = objurl;
        this.endtime = endtime;
        this.ctime = ctime;
    }
}
