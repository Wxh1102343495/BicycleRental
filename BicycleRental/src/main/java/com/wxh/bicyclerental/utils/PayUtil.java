package com.wxh.bicyclerental.utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 保存支付所需的参数
 */
public class PayUtil {
    //应用ID
    public static String APP_ID = "2021000117630582";
    //商户私钥
    public static String merchant_private_key  = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKqt2iDr/hesqyPVFYE6zdi/hXBTlBXw04xpFuENKL+6ECaFgrrR4L9zxQ4XjP/K/ZM866Vz30iXqmBC2QPGNMcWRIMY9C0puQk31GgGgLia4VYC7hZnqzP59VEvKYlvLnIKU5bgTgKdewmtF6XUujVmG+Yfjtj8eZHGb5HkMFvDYAYRf1JCcud77rkwKMad4LhO+4+KhYI5YAmwShYmFmB3x5kE6spgnCjJuDT4sUxUtio7ad5VTxC8zC218QSw9yrY9MA6SEW8sAaFa49j7fo+8fHy/ardAt12aXC3QJkf2NjFxB6ak5oCzrBX9XkS3qmFz5tmmbJ7Q+PMDhpWhRAgMBAAECggEAe2OHS8jsHOtyqh+93i3DyG/gTy6qv+ygi0DF77awYzdJEidfLZ4h+mvJE/9NzWT/5Log3db7njknFcrp8EqL4V2U6liPLdrR6lgTRUTFUF72tLadgJv72rxmPwFZNUY8ZkW6P9wSIpWZA+D/PW7++xzGZO4w3tLtvOR1DH9NDDAaTbbZV40h+IL2MrzTEu5A3EQGxampYMOP/QOkO6gFB+r46ttA3bE3WbpTKJ0kjfehOp9kov97SuNG9GJRpTQH9QPlYjAixk7FtbNCT5DV+8I1lvq1YoWm3j5rsbEajYB1lS6ZtuKQSZJ8xx94kTI5JV4NfaIpL7fVn8mpjXQQAQKBgQDAI97dqlquR3xXIs5pQIlSAQ7+iHAoLwt4tGdb2+pOSr/TKblgfszpJuFNgOj+uhpeRoMAMjhGFlw26NTAMPXxQVHrZckWu0q9smTIV2mvwROUaPsUoZbQ2NxXVhDfynlFs2WqK5UnODVRCBgcy0CCQzn8N4AEpbH8ItRYYkcbkQKBgQC4wU3RFSZAAJRoMr5tbw+Ah0CQw0+qK3Xp/Hu3zi1tGWspu+rlkh8P8uE+Xlc/sXsmfAR66yPSCQgcvskVS7hOdZPI9VK/ImuNtx7ub8sm4jGG8Ev7fNIxcn4Y/7Tm4zrFIzKolL1gd163Ch53En4ary+oOim4uhqvT7iCPl+gwQKBgFkSyAjfJrbQsRX8LtCgeIipsPfS7JvUY28LwzbUlqTBBniwSR4w6nHT8nLpphog0ISQD78RiQEE8K8L9UU77WhwrbeBMl31acrTXuF5lKdDzP3qRSvlVXNwdYWPgrccuGfVqPXgyn6qEh2EsRj4KOm6nLEOUazV29NVmjd3KBvhAoGAe8fm3uIQkmjRBU6aDq+N70quk06HnTco9O9X5DmabbHN/lQMeGqBrSnIhwSl5+J847fLOJ85jIrIiJm6Fy53+PkFXmoeWjgxXu0FKDJ2JUL+c62i+ocSPFa87PrEtLwgr9t5IUEl7++J4ZBCAPy+yBn/D/KH6V+maTY8I+auIwECgYALXLnmhdpUuk3Zt7NrnjedoYBqpQzY6nBqri3ELgvJ+/YM5LpQ21hhPQAsoCwxM4B789wo8B9tRg3okg9rzkWgGkn5XL0Eta7+YBoQPRndpupsn++Q7Q8MFCtqrePXku7MPJcMWUjEGQN4MoaaEZawRDVBSoEQlIbhe3wKBxEMmA==";
    //字符编码格式
    public static String charset = "utf-8";
    //支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwdyGr9tjaCs5LFA/OHgq4/2qS9jE8MdsRwxIlyuwDGrwK8QPaTV5VUGsAk1nKAxGTxN1xCxI33bLO/oMlqSN+ghf3iKPAz7fZ499qeKX1XVm5Ie48b+1JMhc+VbF/H3pSCvGiersKni0MIBia+CLeus3YUfRwt+Ro+sKeBUq2ug2OIEK+5ZgQroRiVsfmXZex8tjnbhi3OMXhYMOhMcIag2aSOYMxHciXuNMCXr4zrkaH7BETZs/Ml1M7anGnqRmkj5S2WcGBIe3zgAfApXXXSWqyDBDUnZtb8BM3o7CgWMT8COqqhTG4MqWGZnJrDSfpbu2nqtBfSGXdXW3vKD/swIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    public static String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";

    //签名方式
    public static String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    public static String NOTIFY_URL = "http://ycpw58.natappfree.cc/getNotify";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    public static String RETURN_URL = "http://ycpw58.natappfree.cc/getReturn";
    //日志地址
    public static  String log_path = "D:\\";

    /**
     * 写日志。方便测试
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
