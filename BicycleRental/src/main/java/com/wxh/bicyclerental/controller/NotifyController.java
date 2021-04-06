package com.wxh.bicyclerental.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.wxh.bicyclerental.service.IOrderService;
import com.wxh.bicyclerental.service.IUserCouponService;
import com.wxh.bicyclerental.utils.PayUtil;
import com.wxh.bicyclerental.utils.uId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 支付宝支付异步通知
 */
@Controller
public class NotifyController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserCouponService userCouponService;

    //接收支付宝返回的异步通知的信息
    @RequestMapping("/getNotify")
    public ModelAndView getNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
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
        boolean signVerified = AlipaySignature.rsaCheckV1(params, PayUtil.ALIPAY_PUBLIC_KEY,PayUtil.charset,PayUtil.SIGN_TYPE);
        //编写自己的程序
        /*
        * 实际验证过程建议商户务必添加以下校验
        * 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号,
        * 2、判断total_amout是否确定为该订单的实际金额（即商户订单创建时的金额）
        * 3、校验通知中的seller_id(或者sell_email)是否为out_trade_no这笔单据的对应操作方
        * 4、校验app_id是否为该商户本身
        * */
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no_noSub = request.getParameter("out_trade_no");
            //支付宝交易号
            String trade_no = request.getParameter("trade_no");
            //交易金额
            String trade_status = request.getParameter("trade_status");
            //实收金额
            String receipt_amount = request.getParameter("receipt_amount");
            //获取当前支付用户的id的长度
            int length  = uId.getUuId().length();
            //截取返回的订单号
            String out_trade_no = out_trade_no_noSub.substring(length);
            //判断订单号长度，大于十位是优惠券id，小于十位是订单id
            if(out_trade_no.length() > 10) {
                //根据订单号查询中间表中未支付的id
                Integer id = userCouponService.selectByCouponId(Long.parseLong(out_trade_no));
                //将优惠券状态改为已支付
                if(userCouponService.updateState(id) > 0){
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.setViewName("redirect:http://127.0.0.1:9521/#/paySuccess/paySuccess");
                    return modelAndView;
                }else {
                    return null;
                }
            }else {
                //将订单状态改为已完成
                if(orderService.updateOrderEnd(Integer.parseInt(out_trade_no))>0) {
                    String url_to = "http://127.0.0.1:9521/#/paySuccess/paySuccess";
                    return new ModelAndView(new RedirectView(url_to));
                }else {
                    return null;
                }
            }
        }else {//验证失败
            return null;
        }
    }
}
