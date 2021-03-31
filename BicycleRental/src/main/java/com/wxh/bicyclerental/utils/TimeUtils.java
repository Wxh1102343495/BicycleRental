package com.wxh.bicyclerental.utils;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 日期转换为时间戳（毫秒）
     *
     * @param s
     * @return
     */
    public static String dateToStamp(String s) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long time = date.getTime();
        res = String.valueOf(time);
        return res;
    }

    /**
     * 计算时间相差多少小时
     */
    public static double differHours(String startTime, String endTime){
        double hour = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = df.parse(startTime);
            Date end = df.parse(endTime);
            Long time = (end.getTime() - start.getTime());
            double hours = time.doubleValue();
            double number = hours/(1000*3600);
            //向上取整
            hour = Math.ceil(number);
        } catch (Exception e) {
            System.out.println(e);
        }
        return hour;
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToTime(String s) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        //将时间戳转换为时间
        Date date = new Date(lt);
        //将时间调整为yyyy-MM-dd HH:mm:ss时间样式
        res = simpleDateFormat.format(date);
        return res;
    }
}
