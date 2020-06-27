package com.offway.hqs.service;
import com.baomidou.mybatisplus.extension.service.IService;


import com.offway.common.entity.R;
import com.offway.hqs.dto.TSmsLogDto;
import com.offway.hqs.dto.UserRegisterCodeDto;

public interface ITSmsLogService extends IService<TSmsLogDto> {
    /**
     * 发送短信-注册验证码
     */
    R sendRegisterCode(String phone);

    /**
     * 校验--注册验证码
     */
    R checkRCode(UserRegisterCodeDto codeDto);
}
