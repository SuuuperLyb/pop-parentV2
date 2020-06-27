package com.offway.hqs.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 短信发送记录
 * </p>

 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TSmsLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
//手机号
    private String phone;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 类型 1注册验证码 2登录验证码
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    public TSmsLogDto(String phone, String content, Integer type, LocalDateTime ctime) {
        this.phone = phone;
        this.content = content;
        this.type = type;
        this.ctime = ctime;
    }
}
