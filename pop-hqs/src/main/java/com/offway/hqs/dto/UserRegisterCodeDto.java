package com.offway.hqs.dto;


import lombok.Data;

@Data
public class UserRegisterCodeDto {//登录模板
    private String phone;
    private int code;
}
