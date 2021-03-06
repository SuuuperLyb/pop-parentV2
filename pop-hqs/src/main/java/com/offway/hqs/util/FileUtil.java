package com.offway.hqs.util;

import java.util.UUID;

/**
 *
 * @description: 截取文件的名字
 *
 */
public class FileUtil {

    public static String renameFile(String fname) {
        if (fname.length() > 30) {
            // substring 方法 索引值是从0开始的  从(fname.length() - 30)位置索引开始到结尾结束 要头也要尾
            // substring(int beginIndex, int endIndex) 截取字符串，要头不要尾部
            fname = fname.substring(fname.length() - 30);
        }
        return UUID.randomUUID().toString().replace("-", "") + "_" + fname;
    }
}
