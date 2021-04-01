package com.wxh.bicyclerental.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建支付宝所需要的对象
 */
@Configuration
public class PayBeanUtil {
    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(PayUtil.GATEWAY_URL,PayUtil.APP_ID,PayUtil.merchant_private_key,PayUtil.FORMAT,PayUtil.CHARSET,PayUtil.ALIPAY_PUBLIC_KEY,PayUtil.SIGN_TYPE);
    }
    /**
     * 支付过程中对应的接口对象,支付信息配置
     */
    @Bean
    public AlipayTradePagePayRequest alipayTradePagePayRequest() {
        return new AlipayTradePagePayRequest();
    }
}
