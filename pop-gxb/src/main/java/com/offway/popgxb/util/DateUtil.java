package com.offway.popgxb.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static Date comDate(int type,int year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(type,year);
        return calendar.getTime();
    }
}
