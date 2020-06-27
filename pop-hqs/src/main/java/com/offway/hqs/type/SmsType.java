package com.offway.hqs.type;

/**
 * @program: HungryApi
 * @description: 验证码类型
 * @author: Feri(邢朋辉)
 * @create: 2020-06-18 14:49
 */
public enum SmsType {
    注册验证码(1), 登录验证码(2), 生日提醒(3);

    private int val;

    private SmsType(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }
}
