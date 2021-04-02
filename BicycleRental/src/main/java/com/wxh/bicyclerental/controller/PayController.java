package com.wxh.bicyclerental.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.wxh.bicyclerental.utils.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
public class PayController {

    /**
     * 处理支付请求
     */
    //1、接收页面传来的数据：订单号、金额、名称、商品描述，要求表单中的name值=参数名
    @RequestMapping("/aliPay")
    public String aliPay(HttpServletRequest request, HttpServletResponse response)
            throws AlipayApiException,IOException{
        //获取前端传来的参数
        String out_trade_no = request.getParameter("out_trade_no");
        String subject = request.getParameter("subject");
        String total_amount = request.getParameter("total_amount");
        String body = request.getParameter("body");
        //2、获取支付的客户端,就是AlipayClient和配置支付信息的对象AlipayTradePagePayRequest
        AlipayClient alipayClient = new DefaultAlipayClient(PayUtil.GATEWAY_URL,PayUtil.APP_ID,PayUtil.merchant_private_key,"json",PayUtil.charset,PayUtil.ALIPAY_PUBLIC_KEY,PayUtil.SIGN_TYPE);
        AlipayTradePagePayRequest req = new AlipayTradePagePayRequest();
        //3、设置响应地址，就是支付宝返回给商户的响应地址来源于哦配置中的两个地址
        req.setNotifyUrl(PayUtil.NOTIFY_URL);
        req.setReturnUrl(PayUtil.RETURN_URL);
        //4、设置请求参数，就是传递给支付宝的数据
        req.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+subject+"\","
                + "\"body\":\""+body+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //5、通过客户端发送请求
        AlipayTradePagePayResponse res = alipayClient.pageExecute(req);
        String result = res.getBody();
        if(res.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        //6、响应结果返回给前端
        return result;
    }
}
