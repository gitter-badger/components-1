/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Topay.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

import com.github.wxpay.sdk.WXPay;
import org.dom4j.DocumentException;
import org.hiylo.components.commons.utils.CommonUtils;
import org.hiylo.components.commons.utils.NumberUtils;
import org.hiylo.components.commons.utils.StringUtils;
import org.hiylo.components.exceptions.Constants;
import org.hiylo.components.exceptions.PaymentException;
import org.hiylo.components.wechat.config.WechatConfig;
import org.hiylo.components.wechat.utils.Sha1Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微信下单
 * TODO 支付 ClassName: TopayServlet
 *
 * @author hiylo
 * @date Jan 13, 2017 3:20:15 PM
 */
public class Topay implements Serializable {
    private static final long serialVersionUID = -1;
    private final static String RETURN_CODE_SUCCESS = "SUCCESS";
    private final static String RETURN_CODE = "return_code";
    private final WechatConfig wechatConfig;
    private final ResponseHandle responseHandle;
    private WXPay wxPay;
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    public Topay(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
        this.responseHandle = new ResponseHandle(wechatConfig);
        wxPay = new WXPay(wechatConfig);

    }

    @PostConstruct
    public void init() {

    }

    /**
     * 微信支付下单
     *
     * @param orderItemName 微信订单商品名称
     * @param orderNo       业务订单编号
     * @param price         订单价格 (没有乘100)
     * @param notifyUrl     回调地址
     * @param tradeType     交易类型 NATIVE 扫码支付 JSAPI 微信公众号 微信小程序 网页支付 APP App支付
     * @param ip            请求的IP可以随便填
     * @param openId        用户的openId, 某些情况可以忽略
     * @param attach        附加信息, 回调时会原样传回
     * @return 下单信息
     * @throws NoSuchAlgorithmException     签名异常
     * @throws InvalidKeyException          签名异常
     * @throws UnsupportedEncodingException 签名异常
     * @throws PaymentException             支付异常
     */
    public Map getPackage(String orderItemName, String orderNo, double price, String notifyUrl, String tradeType, String ip, String openId, String attach) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, PaymentException {
        return this.getPackage(orderItemName, orderNo, price, notifyUrl, tradeType, ip, openId, attach, null);
    }

    /**
     * 微信支付下单
     *
     * @param orderItemName 微信订单商品名称
     * @param orderNo       业务订单编号
     * @param price         订单价格 (没有乘100)
     * @param notifyUrl     回调地址
     * @param tradeType     交易类型 NATIVE 扫码支付 JSAPI 微信公众号 微信小程序 网页支付 APP App支付
     * @param ip            请求的IP可以随便填
     * @param openId        用户的openId, 某些情况可以忽略
     * @param attach        附加信息, 回调时会原样传回
     * @param productionId  商品编号, 某些情况可以忽略, 忽略可以调用上面的方法
     * @return 下单信息
     * @throws NoSuchAlgorithmException     签名异常
     * @throws InvalidKeyException          签名异常
     * @throws UnsupportedEncodingException 签名异常
     * @throws PaymentException             支付异常
     */
    public Map getPackage(String orderItemName, String orderNo, double price, String notifyUrl, String tradeType, String ip, String openId, String attach, String productionId) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, PaymentException {
        if (NumberUtils.greaterThanZero(price)) {
            String totalFee = String.valueOf((int) (price * 100));
            String mchId = wechatConfig.getMchID();
            String nonceStr = CommonUtils.getNonceStr();
            SortedMap<String, String> packageParams = new TreeMap<>();
            packageParams.put("appid", wechatConfig.getAppID());
            packageParams.put("mch_id", mchId);
            packageParams.put("nonce_str", nonceStr);
            packageParams.put("attach", attach);
            packageParams.put("out_trade_no", orderNo);
            packageParams.put("spbill_create_ip", ip);
            log.debug(packageParams.toString());
            String prepayId = "";
            try {
                // TODO
                Map<String, String> stringStringMap = wxPay.orderQuery(packageParams);
                log.debug("-----------------------------------------------------" + stringStringMap.toString());
                if (stringStringMap.get(RETURN_CODE).equals(RETURN_CODE_SUCCESS) && Objects.nonNull(stringStringMap.get("err_code")) && stringStringMap.get("err_code").equals("ORDERNOTEXIST")) {

                } else if (stringStringMap.get(RETURN_CODE).equals(RETURN_CODE_SUCCESS) && Objects.nonNull(stringStringMap.get("result_code").equals(RETURN_CODE_SUCCESS)) && stringStringMap.get("trade_state").equals("NOTPAY")) {
                    packageParams.remove("spbill_create_ip");
                    Map<String, String> closeResult = wxPay.orderQuery(packageParams);
                    log.debug(String.valueOf(closeResult));
                }
                packageParams.put("body", orderItemName);
                packageParams.put("notify_url", notifyUrl);
                packageParams.put("openid", Optional.ofNullable(openId).orElse(""));
                packageParams.put("total_fee", totalFee);
                packageParams.put("trade_type", tradeType);
                if ("NATIVE".equals(tradeType)) {
                    packageParams.put("product_id", productionId);
                }
                log.debug(String.valueOf(packageParams));
                Map<String, String> map = wxPay.unifiedOrder(packageParams);
                if ("NATIVE".equals(tradeType)) {
                    return map;
                }
                log.debug(String.valueOf(map));
                if (!RETURN_CODE_SUCCESS.equals(map.get(RETURN_CODE))) {
                    throw PaymentException.<PaymentException>buildException(Constants.EXCEPTION_CODE_PAYMENT_REQUEST_THIRD_PART_FAIL);
                }
                prepayId = map.get("prepay_id");
                if ("".equals(prepayId)) {
                    throw PaymentException.<PaymentException>buildException(Constants.EXCEPTION_CODE_PAYMENT_REQUEST_THIRD_PART_FAIL);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            SortedMap<String, String> finalpackage = new TreeMap<>();
            if ("APP".equals(tradeType)) {
                String timestamp = Sha1Util.getTimeStamp();
                finalpackage.put("appid", wechatConfig.getAppID());
                finalpackage.put("partnerid", wechatConfig.getMchID());
                finalpackage.put("timestamp", timestamp);
                finalpackage.put("noncestr", nonceStr);
                finalpackage.put("prepayid", prepayId);
                finalpackage.put("package", "Sign=WXPay");
                String finalsign = WechatPayUtil.generateSignature(finalpackage, wechatConfig.getKey());
                finalpackage.put("sign", finalsign);
            } else if ("JSAPI".equals(tradeType)) {
                String timestamp = Sha1Util.getTimeStamp();
                finalpackage.put("appId", wechatConfig.getAppID());
                finalpackage.put("timeStamp", timestamp);
                finalpackage.put("nonceStr", nonceStr);
                finalpackage.put("package", "prepay_id=" + prepayId);
                finalpackage.put("signType", "MD5");
                String finalsign = WechatPayUtil.generateSignature(finalpackage, wechatConfig.getKey());
                finalpackage.put("paySign", finalsign);
            }
            log.debug(finalpackage.toString());
            return finalpackage;
        }
        throw PaymentException.<PaymentException>buildException(Constants.EXCEPTION_CODE_PAYMENT_TOTAL_FEE_CANT_BE_ZERO);
    }

    /**
     * 微信退款
     *
     * @param transactionId       微信訂單號
     * @param outTradeNo          咱们给微信提交的订单编号
     * @param refundTransactionId 咱们退款表里面的id
     * @param totalFee            订单总金额
     * @param refundFee           退款金额
     * @param notifyUrl           异步通知地址
     * @return 结果
     */
    public String refund(String transactionId, String outTradeNo, String refundTransactionId, double totalFee,
                         double refundFee, String notifyUrl) throws PaymentException {
        String totalFeeStr = String.valueOf((int) (totalFee * 100));
        String refundFeeStr = String.valueOf((int) (refundFee * 100));
        String nonceStr = CommonUtils.getNonceStr();
        SortedMap<String, String> packageParams = new TreeMap<>();
        packageParams.put("appid", wechatConfig.getAppID());
        packageParams.put("mch_id", wechatConfig.getMchID());
        packageParams.put("nonce_str", nonceStr);
        if (Objects.nonNull(transactionId)) {
            packageParams.put("transaction_id", transactionId);
        } else if (Objects.nonNull(outTradeNo)) {
            packageParams.put("out_trade_no", outTradeNo);
        } else {
            throw new PaymentException(0x10400000, "微信订单号和商户内部订单号其中一个为必填");
        }
        packageParams.put("out_refund_no", refundTransactionId);
        packageParams.put("total_fee", totalFeeStr);
        packageParams.put("refund_fee", refundFeeStr);
        packageParams.put("notify_url", notifyUrl);
        String sign = null;
        try {
            sign = WechatPayUtil.generateSignature(packageParams, wechatConfig.getKey());
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        packageParams.put("sign", sign);
        log.debug(String.valueOf(packageParams));
        return responseHandle
                .requestWithCert("https://api.mch.weixin.qq.com/secapi/pay/refund", packageParams, 1000 * 8, 1000 * 8);
    }

    /**
     * 微信回调
     *
     * @param request 回调时的请求
     * @return 封装过的微信毁掉内容
     */
    public WechatNotifyVO notify(HttpServletRequest request) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = request.getReader();
        String str;
        while (Objects.nonNull(str = reader.readLine())) {
            content.append(str);
        }
        reader.close();
        return this.parseWeChatAsyncXML(content.toString());
    }

    /**
     * 微信回调
     *
     * @param weChatAsyncXML 微信回调内容
     * @return 封装过的微信毁掉内容
     */
    public WechatNotifyVO notify(String weChatAsyncXML) {
        return this.parseWeChatAsyncXML(weChatAsyncXML);
    }

    private WechatNotifyVO parseWeChatAsyncXML(String content) {
        if (StringUtils.isNotEmpty(content)) {
            try {
                Map<String, Object> asyncMap = new TreeMap<>(CommonUtils.xml2Map(content, "xml").get("xml"));
                if (RETURN_CODE_SUCCESS.equals(asyncMap.get(RETURN_CODE)) && RETURN_CODE_SUCCESS.equals(asyncMap.get(RETURN_CODE))) {
                    // 异步通知签名
                    String notifySign = (String) asyncMap.get("sign");
                    asyncMap.remove("sign");
                    String notifyMySign = CommonUtils.signWithMd5(asyncMap, wechatConfig.getKey(), true);
                    if (notifyMySign.equals(notifySign)) {
                        // 支付完成时间	time_end
                        long paymentTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(asyncMap.get("time_end") + "").getTime();
                        // 微信支付订单号	transaction_id
                        String outTradeNumber = (String) asyncMap.get("transaction_id");
                        // 商户订单号	out_trade_no
                        String orderNo = (String) asyncMap.get("out_trade_no");
                        // 订单总金额
                        double totalFee = Double.parseDouble(asyncMap.get("total_fee").toString());
                        //扩展字段
                        String attach = asyncMap.get("attach").toString();
                        return new WechatNotifyVO().setPaymentTime(paymentTime).setOutTradeNumber(outTradeNumber).setOrderNo(orderNo).setTotalFee(totalFee).setAttach(attach);
                    } else {
                        //todo 异常如何处理
                        log.debug("微信 <异步通知> 签名失败,签名参数[" + asyncMap.toString() + "]");
                        log.debug("微信 <异步通知> 签名失败,返回签名[" + notifySign + "]");
                        log.debug("微信 <异步通知> 签名失败,返回参数加密后签名[" + notifyMySign + "]");
                    }
                } else {
                    log.debug("微信 <异步通知> 返回报文:" + asyncMap.toString());
                }
            } catch (DocumentException | ParseException e) {
                log.warn("微信 <异步通知> 失败,返回报文:", e);
                log.debug("微信 <异步通知> 失败,返回报文:" + content);
            } catch (SAXException e) {
                log.warn("微信 <异步通知> 失败,返回报文:", e);
                log.debug("微信 <异步通知> 失败,返回报文:" + content);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Topay{" +
                "wechatConfig=" + wechatConfig +
                ", responseHandle=" + responseHandle +
                ", wxPay=" + wxPay +
                '}';
    }
}
