package com.offway.hqs.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * @param com  要进行操作的值
     * @param type 日历字段
     */
    public static Date comDate(int type, int com) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(type, com);
        return calendar.getTime();
    }
}
