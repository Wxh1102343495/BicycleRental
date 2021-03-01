package com.wxh.bicyclerental.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CodeUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyMMddHHMMss");
    private static SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
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

    public static long UCode() {
        long code = Long.parseLong(format1.format(Calendar.getInstance().getTime()) + random.nextInt(99999999)
        );
        return code;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            Long code = RundCode();
//            System.out.println(code);
//            System.out.println(code.toString().length());
//        }
//    }
}
