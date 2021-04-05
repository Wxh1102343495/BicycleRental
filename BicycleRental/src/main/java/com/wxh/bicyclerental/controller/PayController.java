package com.wxh.bicyclerental.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.wxh.bicyclerental.service.IOrderService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.PayUtil;
import com.wxh.bicyclerental.utils.uId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 支付宝请求支付
 */
@RestController
@CrossOrigin
public class PayController {

    @Autowired
    private IOrderService orderService;

    /**
     * 处理支付请求
     */
    //1、接收页面传来的数据：订单号、金额、名称、商品描述，要求表单中的name值=参数名
    @RequestMapping("/aliPay")
    public String aliPay(HttpServletRequest request, HttpServletResponse response)
            throws AlipayApiException, IOException {
        //获取前端传来的参数
        //用户id
        String userId = request.getParameter("userId");
        //将用户id存起来，用于截取字符串
        uId.setUuId(userId);
        //订单号
        String trade_no = request.getParameter("out_trade_no");
        //商户订单号，必填
        String out_trade_no = userId + trade_no;
        String subject = request.getParameter("subject");
        String total_amount = request.getParameter("total_amount");
        String body = request.getParameter("body");
        //2、获取支付的客户端,就是AlipayClient和配置支付信息的对象AlipayTradePagePayRequest
        AlipayClient alipayClient = new DefaultAlipayClient(PayUtil.GATEWAY_URL, PayUtil.APP_ID, PayUtil.merchant_private_key, "json", PayUtil.charset, PayUtil.ALIPAY_PUBLIC_KEY, PayUtil.SIGN_TYPE);
        AlipayTradePagePayRequest req = new AlipayTradePagePayRequest();
        //3、设置响应地址，就是支付宝返回给商户的响应地址来源于哦配置中的两个地址
        req.setNotifyUrl(PayUtil.NOTIFY_URL);
        req.setReturnUrl(PayUtil.RETURN_URL);
        //4、设置请求参数，就是传递给支付宝的数据
        req.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //5、通过客户端发送请求
        AlipayTradePagePayResponse res = alipayClient.pageExecute(req);
        String result = res.getBody();
        if (res.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        //6、响应结果返回给前端
        return result;
    }

    //退款
    @RequestMapping("/returnPay")
    public ModelAndView refund(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
        //获取前端传来的参数
        //用户id
        String userId = request.getParameter("userId");
        //订单号
        String trade_no = request.getParameter("out_trade_no");
        //商户订单号，必填
        String out_trade_no = userId + trade_no;
        //需要退款的金额，该金额不能大于订单金额
        String refund_amount = request.getParameter("refund_amount");
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
        String out_request_no = new String(CodeUtil.UCode().toString());
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(PayUtil.GATEWAY_URL, PayUtil.APP_ID, PayUtil.merchant_private_key, "json", PayUtil.charset, PayUtil.ALIPAY_PUBLIC_KEY, PayUtil.SIGN_TYPE);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"refund_amount\":\"" + refund_amount + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");
        //请求
        AlipayTradeRefundResponse resp = alipayClient.execute(alipayRequest);
        if (resp.isSuccess()) {
            //将订单的退款状态设置为已退款
            System.out.println("退款成功");
            if (orderService.updateReturnPayOk(Integer.parseInt(trade_no)) > 0) {
                String url_to = "http://localhost:9521/#/returnPaySuccess/returnPaySuccess";
                return new ModelAndView(new RedirectView(url_to));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
