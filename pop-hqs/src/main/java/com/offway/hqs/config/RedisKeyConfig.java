package com.offway.hqs.config;

/**
 * @description: 记录Redis要存储的Key
 =
 */
public class RedisKeyConfig {
    /**
     * 存储注册-验证码 有效期5分钟
     * 后面追加手机号 值存验证码   要存储的redis的key为  (pop:sms:rcode:手机号)
     */
    public static final String SMS_RCODE = "pop:sms:rcode:";
    /**
     * 有效期5分钟
     */
    public static final int SMS_RCODE_TIME = 300;

    /**
     * 存储登录相关信息 这个是redis将要存储的key的名称 (pop:login:phone:+userDto.getPhone()) (pop:login:token:+)
     * 后面追加手机号 值 存储令牌
     */
    public static final String LOGIN_TOKEN = "pop:login:phone:";
    /**
     * 后面追加令牌 值 存储用户信息
     */
    public static final String LOGIN_USER = "pop:login:token:";
    /**
     * 有效期30分钟
     */
    public static final int LOGIN_TOKEN_TIME = 1800;
}
