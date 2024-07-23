package com.langlang.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    /**
     * 获取30天后的日期  Date 类型
     * @param date
     * @return
     */
    public static Date get30DaysAgo(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date dateAfterSevenDays = calendar.getTime();
        return  dateAfterSevenDays;
    }
}
