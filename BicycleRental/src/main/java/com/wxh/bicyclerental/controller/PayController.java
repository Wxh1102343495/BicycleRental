package com.wxh.bicyclerental.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@RestController
public class PayController {

    private final String APP_ID = "2021000117630582";
    private final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKqt2iDr/hesqyPVFYE6zdi/hXBTlBXw04xpFuENKL+6ECaFgrrR4L9zxQ4XjP/K/ZM866Vz30iXqmBC2QPGNMcWRIMY9C0puQk31GgGgLia4VYC7hZnqzP59VEvKYlvLnIKU5bgTgKdewmtF6XUujVmG+Yfjtj8eZHGb5HkMFvDYAYRf1JCcud77rkwKMad4LhO+4+KhYI5YAmwShYmFmB3x5kE6spgnCjJuDT4sUxUtio7ad5VTxC8zC218QSw9yrY9MA6SEW8sAaFa49j7fo+8fHy/ardAt12aXC3QJkf2NjFxB6ak5oCzrBX9XkS3qmFz5tmmbJ7Q+PMDhpWhRAgMBAAECggEAe2OHS8jsHOtyqh+93i3DyG/gTy6qv+ygi0DF77awYzdJEidfLZ4h+mvJE/9NzWT/5Log3db7njknFcrp8EqL4V2U6liPLdrR6lgTRUTFUF72tLadgJv72rxmPwFZNUY8ZkW6P9wSIpWZA+D/PW7++xzGZO4w3tLtvOR1DH9NDDAaTbbZV40h+IL2MrzTEu5A3EQGxampYMOP/QOkO6gFB+r46ttA3bE3WbpTKJ0kjfehOp9kov97SuNG9GJRpTQH9QPlYjAixk7FtbNCT5DV+8I1lvq1YoWm3j5rsbEajYB1lS6ZtuKQSZJ8xx94kTI5JV4NfaIpL7fVn8mpjXQQAQKBgQDAI97dqlquR3xXIs5pQIlSAQ7+iHAoLwt4tGdb2+pOSr/TKblgfszpJuFNgOj+uhpeRoMAMjhGFlw26NTAMPXxQVHrZckWu0q9smTIV2mvwROUaPsUoZbQ2NxXVhDfynlFs2WqK5UnODVRCBgcy0CCQzn8N4AEpbH8ItRYYkcbkQKBgQC4wU3RFSZAAJRoMr5tbw+Ah0CQw0+qK3Xp/Hu3zi1tGWspu+rlkh8P8uE+Xlc/sXsmfAR66yPSCQgcvskVS7hOdZPI9VK/ImuNtx7ub8sm4jGG8Ev7fNIxcn4Y/7Tm4zrFIzKolL1gd163Ch53En4ary+oOim4uhqvT7iCPl+gwQKBgFkSyAjfJrbQsRX8LtCgeIipsPfS7JvUY28LwzbUlqTBBniwSR4w6nHT8nLpphog0ISQD78RiQEE8K8L9UU77WhwrbeBMl31acrTXuF5lKdDzP3qRSvlVXNwdYWPgrccuGfVqPXgyn6qEh2EsRj4KOm6nLEOUazV29NVmjd3KBvhAoGAe8fm3uIQkmjRBU6aDq+N70quk06HnTco9O9X5DmabbHN/lQMeGqBrSnIhwSl5+J847fLOJ85jIrIiJm6Fy53+PkFXmoeWjgxXu0FKDJ2JUL+c62i+ocSPFa87PrEtLwgr9t5IUEl7++J4ZBCAPy+yBn/D/KH6V+maTY8I+auIwECgYALXLnmhdpUuk3Zt7NrnjedoYBqpQzY6nBqri3ELgvJ+/YM5LpQ21hhPQAsoCwxM4B789wo8B9tRg3okg9rzkWgGkn5XL0Eta7+YBoQPRndpupsn++Q7Q8MFCtqrePXku7MPJcMWUjEGQN4MoaaEZawRDVBSoEQlIbhe3wKBxEMmA==";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwdyGr9tjaCs5LFA/OHgq4/2qS9jE8MdsRwxIlyuwDGrwK8QPaTV5VUGsAk1nKAxGTxN1xCxI33bLO/oMlqSN+ghf3iKPAz7fZ499qeKX1XVm5Ie48b+1JMhc+VbF/H3pSCvGiersKni0MIBia+CLeus3YUfRwt+Ro+sKeBUq2ug2OIEK+5ZgQroRiVsfmXZex8tjnbhi3OMXhYMOhMcIag2aSOYMxHciXuNMCXr4zrkaH7BETZs/Ml1M7anGnqRmkj5S2WcGBIe3zgAfApXXXSWqyDBDUnZtb8BM3o7CgWMT8COqqhTG4MqWGZnJrDSfpbu2nqtBfSGXdXW3vKD/swIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://www.baidu.com";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:9001/returnUrl";

    @RequestMapping("aliapy")
    public void alipay(HttpServletResponse httpResponse) throws IOException {

        SecureRandom r= new SecureRandom();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(r.nextInt(9999999)+1000000);
        //订单名称，必填
        String subject ="奥迪A8 2021款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2021款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
//            payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }
}
