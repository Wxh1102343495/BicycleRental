package com.wxh.bicyclerental.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.wxh.bicyclerental.utils.PayUtil;
import com.wxh.bicyclerental.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class NotifyController {
    //接收支付宝返回的异步通知的信息
    @RequestMapping("/getNotify")
    public void getNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝post过来的反馈信息
        Map<String,String> params = new HashMap<String, String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        Iterator<String> iter = requestParams.keySet().iterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for(int i=0;i<values.length;i++) {
                valueStr = (i == values.length-1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"),"utf-8");
            params.put(name,valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, PayUtil.ALIPAY_PUBLIC_KEY,PayUtil.CHARSET,PayUtil.SIGN_TYPE);
        //编写自己的程序
        /*
        * 实际验证过程建议商户务必添加以下校验
        * 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号,
        * 2、判断total_amout是否确定为该订单的实际金额（即商户订单创建时的金额）
        * 3、校验通知中的seller_id(或者sell_email)是否为out_trade_no这笔单据的对应操作方
        * 4、校验app_id是否为该商户本身
        * */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            //支付宝交易号
            String trade_no = request.getParameter("trade_no");
            //交易状态
            String trade_status = request.getParameter("trade_status");
            if(trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有则根据订单号在商户网站的订单系统中查出该笔订单明细并执行商户的业务程序
                //如果有处理，不执行商户的业务程序
                //注意，付款成功后支付宝系统发送该交易状态
                //注意退款日期超过可退款期限后支付宝系统发送交易状态通知
            }else if(trade_status.equals("TRADE_SUCCESS")) {

            }
            out.println("success");
        }else {//验证失败
            out.println("fail");
        }

    }
}
