package com.offway.hqs.util;

import java.util.Random;

/**
 *
 * @description:随机数
 *
 */
public class NumRandomUtil {

    //随机生成指定位数的数字
    public static int createNum(int len) {
        Random random = new Random();
        //len=4 4位 1000-9999 5:10000-99999
        //1000-（10000-1）=1000+（0-8999）
        return (int) (random.nextInt((int) (Math.pow(10, len) -
                Math.pow(10, len - 1))) + Math.pow(10, len - 1));
    }
}
