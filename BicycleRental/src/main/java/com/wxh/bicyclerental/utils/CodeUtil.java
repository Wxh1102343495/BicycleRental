package com.wxh.bicyclerental.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CodeUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyMMddHHMMss");
    private static SimpleDateFormat format1 = new SimpleDateFormat("HHMMss");
    private static Random random = new Random();

    /**
     * 随机生成16位数据id
     *
     * @return
     */
    public static long RundCode() {
        long code = Long.parseLong(format.format(Calendar.getInstance().getTime()) + random.nextInt(10)
                + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
        return code;
    }

    /**
     * 随机生成7位数据id
     *
     * @return
     */
    public static Integer UCode() {
        Integer code = Integer.parseInt(format1.format(Calendar.getInstance().getTime()) + random.nextInt(9)
        );
        return code;
    }
}
