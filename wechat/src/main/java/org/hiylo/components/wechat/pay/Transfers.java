/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Transfers.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.wechat.pay;

import com.github.wxpay.sdk.WXPayUtil;
import org.hiylo.components.commons.encrypttools.Base64;
import org.hiylo.components.commons.encrypttools.Encrypt;
import org.hiylo.components.commons.utils.CommonUtils;
import org.hiylo.components.wechat.config.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TODO 查账接口  重试逻辑
 * 微信转账到用户余额
 *
 * @author hiylo
 * @date 2018年4月3日 16:14:46
 */
public class Transfers {
    private static final String NONCE_STR = "nonce_str";
    private WechatConfig wechatConfig;
    private ResponseHandle responseHandle;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Transfers() {

    }

    @Autowired
    public Transfers(WechatConfig wechatConfig) {
        this.wechatConfig = wechatConfig;
        this.responseHandle = new ResponseHandle(wechatConfig);
    }

    /**
     * 转账到银行卡
     *
     * @param tradeNo     流水号
     * @param openId      openid
     * @param realname    真实姓名 必须是和微信相同的
     * @param amount      转账金额, 单位分 比如1元 为100
     * @param description 描述
     * @param ip          创建交易的机器的ip
     * @return wechat返回结果
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     */
    public Map<String, String> transferToBalance(String tradeNo, String openId, String realname, String amount, String description,
                                                 String ip) throws Exception {
        String mchid = wechatConfig.getMchID();
        String nonceStr = CommonUtils.getNonceStr();
        SortedMap packageParams = new TreeMap();
        packageParams.put("mch_appid", wechatConfig.getAppID());
        packageParams.put("mchid", mchid);
        packageParams.put(NONCE_STR, nonceStr);
        packageParams.put("partner_trade_no", tradeNo);
        packageParams.put("openid", openId);
        packageParams.put("check_name", "FORCE_CHECK");
        packageParams.put("re_user_name", realname);
        packageParams.put("amount", amount);
        packageParams.put("desc", description);
        packageParams.put("spbill_create_ip", ip);
        String sign = WechatPayUtil.generateSignature(packageParams, wechatConfig.getKey());
        packageParams.put("sign", sign);
        log.info("提现参数 {}", packageParams);
        String s = responseHandle
                .requestWithCert("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers", packageParams,
                        1000 * 8, 1000 * 8);
        log.info(s);
        return WXPayUtil.xmlToMap(s);
    }

    /**
     * 转账到银行卡
     *
     * @param tradeNo     流水号
     * @param openId      openid
     * @param realname    真实姓名 必须是和微信相同的
     * @param amount      转账金额, 单位分 比如1元 为100
     * @param description 描述
     * @param ip          创建交易的机器的ip
     * @return wechat返回结果
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     */
    public Map<String, String> getTransferToBalanceInfo(String tradeNo, String openId, String realname, String amount, String description,
                                                 String ip) throws Exception {
        String mchid = wechatConfig.getMchID();
        String nonceStr = CommonUtils.getNonceStr();
        SortedMap packageParams = new TreeMap();
        packageParams.put("mch_appid", wechatConfig.getAppID());
        packageParams.put("mchid", mchid);
        packageParams.put(NONCE_STR, nonceStr);
        packageParams.put("partner_trade_no", tradeNo);
        packageParams.put("openid", openId);
        packageParams.put("check_name", "FORCE_CHECK");
        packageParams.put("re_user_name", realname);
        packageParams.put("amount", amount);
        packageParams.put("desc", description);
        packageParams.put("spbill_create_ip", ip);
        String sign = WechatPayUtil.generateSignature(packageParams, wechatConfig.getKey());
        packageParams.put("sign", sign);
        String s = responseHandle
                .requestWithCert("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers", packageParams,
                        1000 * 8, 1000 * 8);
        log.info(s);
        return WXPayUtil.xmlToMap(s);
    }

    public Map<String, String> transferToBankCard(String tradeNo, String realname, String amount, String description, String ip,
                                                  String bankName, String bankCardNumber, String bankNote) throws Exception {
        String mchid = wechatConfig.getMchID();
        String nonceStr = CommonUtils.getNonceStr();
        SortedMap packageParams = new TreeMap();
        packageParams.put("bank_code", bankName);
        packageParams.put("bank_note", bankNote);
        packageParams.put("enc_bank_no", Base64.encode(Encrypt.Rsa.encrypt(bankCardNumber, WechatPayConstants.PKCS8RSA, 11, "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING")));
        packageParams.put("enc_true_name", Base64.encode(Encrypt.Rsa.encrypt(realname, WechatPayConstants.PKCS8RSA, 11, "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING")));
        packageParams.put("mch_id", mchid);
        packageParams.put(NONCE_STR, nonceStr);
        packageParams.put("partner_trade_no", tradeNo);
        packageParams.put("amount", amount);
        packageParams.put("desc", description);
        packageParams.put("spbill_create_ip", ip);
        String sign = null;
        try {
            sign = WechatPayUtil.generateSignature(packageParams, wechatConfig.getKey());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            log.debug("transferToBankCard", e);
        }
        packageParams.put("sign", sign);
        String s = responseHandle
                .requestWithCert("https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank", packageParams, 1000 * 8, 1000 * 8);
        return WXPayUtil.xmlToMap(s);
    }

    public String getPublicKey() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String mchid = wechatConfig.getMchID();
        String nonceStr = CommonUtils.getNonceStr();
        SortedMap packageParams = new TreeMap();
        packageParams.put("mch_id", mchid);
        packageParams.put(NONCE_STR, nonceStr);
        String sign = WechatPayUtil.generateSignature(packageParams, wechatConfig.getKey());
        packageParams.put("sign", sign);
        String json = responseHandle.requestWithCert("https://fraud.mch.weixin.qq.com/risk/getpublickey", packageParams, 1000 * 8, 1000 * 8);
        log.info(json);
        return json;
    }
}
