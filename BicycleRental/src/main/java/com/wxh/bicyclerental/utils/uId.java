package com.wxh.bicyclerental.utils;

/**
 * 用于存储支付用户的id值，方便支付成功后截取字符串
 */

public class uId {
    public static String uuId;

    public static String getUuId() {
        return uuId;
    }

    public static void setUuId(String uuId) {
        uId.uuId = uuId;
    }
}
