package com.offway.dyh.Utile;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     *
     * @param type 操作的值
     * @param year 日历字段
     * @return
     */
    public static Date comDate(int type,int year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(type,year);
        return calendar.getTime();
    }
}
