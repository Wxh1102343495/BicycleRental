package com.wxh.bicyclerental.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wxh.bicyclerental.utils.PayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PayController {
    //申明拿到支付客户端
    @Resource
    private AlipayClient alipayClient;
    //获取配置支付信息对象
    @Resource
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    /**
     * 处理支付请求
     */
    //1、接收页面传来的数据：订单号、金额、名称、商品描述，要求表单中的name值=参数名
    @RequestMapping("/aliPay")
    public void aliPay(String Bout_trade_no, String Bsubject, String Btotal_amount, String Bbody, HttpServletResponse response)
            throws AlipayApiException,IOException{
        //2、获取支付的客户端,就是AlipayClient和配置支付信息的对象AlipayTradePagePayRequest
        //3、设置响应地址，就是支付宝返回给商户的响应地址来源于哦配置中的两个地址
        alipayTradePagePayRequest.setNotifyUrl(PayUtil.NOTIFY_URL);
        alipayTradePagePayRequest.setReturnUrl(PayUtil.RETURN_URL);
        //4、设置请求参数，就是传递给支付宝的数据
        alipayTradePagePayRequest.setBizContent(
                "{\"out_trade_no\":\""+ Bout_trade_no +"\","
                + "\"total_amount\":\""+ Btotal_amount +"\","
                + "\"subject\":\""+ Bsubject +"\","
                + "\"body\":\""+ Bbody +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //5、通过客户端发送请求
        String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        //6、响应结果返回给前端
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(result);
    }
}
