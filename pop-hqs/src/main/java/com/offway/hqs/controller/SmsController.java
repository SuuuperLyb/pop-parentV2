package com.offway.hqs.controller;
import com.offway.common.entity.R;
import com.offway.hqs.dto.UserRegisterCodeDto;
import com.offway.hqs.service.ITSmsLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "短信相关接口", tags = "短信接口")
@RestController
@CrossOrigin // 解决跨域的问题
public class SmsController {
    @Autowired
    private ITSmsLogService itSmsLogService;

    @GetMapping("api/sms/sendrcode.do")
    public R sendRcode(String phone) {
        return itSmsLogService.sendRegisterCode(phone);
    }

    @PostMapping("api/sms/checkrcode.do")
    public R checkRCode(@RequestBody UserRegisterCodeDto codeDto) {
        return itSmsLogService.checkRCode(codeDto);
    }
}
