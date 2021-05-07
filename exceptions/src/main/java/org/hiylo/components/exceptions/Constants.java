/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Constants.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.exceptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:Contants
 *
 * @author Johnny
 * @version 1.0
 */
public class Constants {

    // response status
    public static final Integer RESPONSE_STATUS_NOT_EXIST = 400;
    public static final Integer RESPONSE_STATUS_SUCCESS = 200;
    public static final Integer RESPONSE_STATUS_FAIL = 500;

    // 0x00000000为请求正确代码
    public static final Integer EXCEPTION_CODE_CORRECT = 0x00000000;
    // 0x99999998为未知错误
    public static final Integer EXCEPTION_CODE_UNKNOWN_ERROR = 0x99999998;
    // 0x99999999为自定义信息代码
    public static final Integer EXCEPTION_CODE_CUSTOM_INFORMATION = 0x99999999;

    // 0X001为参数不合法
    public static final Integer EXCEPTION_CODE_EINVAL = 0X001;

    public static final Integer EXCEPTION_CODE_UNKNOW_TARGET = 0X002;
    public static final Integer EXCEPTION_CODE_UPDATE_DATA_FAILD = 0X003;
    public static final Integer EXCEPTION_CODE_INFO_ALREADY_ACCEPTED = 0X003;


    // 0x100开头为用户异常
    public static final Integer EXCEPTION_CODE_USER_PHONE_NUMBER_ALREADY_EXIST = 0x10000000;
    public static final Integer EXCEPTION_CODE_USER_EMAIL_ALREADY_EXIST = 0x10000001;
    public static final Integer EXCEPTION_CODE_USERNAME_OR_PASSWORD_WRONG = 0x10000002;
    public static final Integer EXCEPTION_CODE_USER_NOT_EXIST = 0x10000003;
    public static final Integer EXCEPTION_CODE_USER_TOKEN_NOT_EXIST = 0x10000004;
    public static final Integer EXCEPTION_CODE_USER_PAYMENT_PASSWORD_EXIST = 0x10000005;
    public static final Integer EXCEPTION_CODE_USER_LOGIN_FAIL = 0x10000006;
    public static final Integer EXCEPTION_CODE_WRONG_PHONE_NUMBER = 0x10000007;
    public static final Integer EXCEPTION_CODE_USER_CARE_PRODUCE_EXIST = 0x10000008;
    public static final Integer EXCEPTION_CODE_PHONE_NUMBER_NOT_EXIST = 0x10000009;
    public static final Integer EXCEPTION_CODE_WRONG_SMS_CODE = 0x10000010;
    public static final Integer EXCEPTION_CODE_USER_REGISTER_FAIL = 0x10000011;
    public static final Integer EXCEPTION_CODE_USER_PASSWORD_TYPE_WRONG = 0x10000012;
    public static final Integer EXCEPTION_CODE_USER_HAVE_SAME_PASSWORD = 0x10000013;
    public static final Integer EXCEPTION_CODE_USER_CARE_PRODUCE_NOT_FIND = 0x10000014;
    public static final Integer EXCEPTION_CODE_USER_CARE_BRAND_NOT_FIND = 0x10000015;
    public static final Integer EXCEPTION_CODE_WRONG_NICK_NAME = 0x10000016;
    public static final Integer EXCEPTION_CODE_USER_SAME_PHONE_NUMBER = 0x10000017;
    public static final Integer EXCEPTION_CODE_USER_WRONG_PASSWORD_LENGTH = 0x10000018;
    public static final Integer EXCEPTION_CODE_NICK_NAME_ALREADY_EXIST = 0x10000019;
    public static final Integer EXCEPTION_CODE_USER_BROWSER_HISTORY_NOT_EXIST = 0x10000020;
    public static final Integer EXCEPTION_CODE_USER_NOT_REALNAME_AUTHORIZATION = 0x10000021;
    public static final Integer EXCEPTION_CODE_USER_ALREADY_AUTHORIZATION = 0x10000022;
    public static final Integer EXCEPTION_CODE_USER_ALREADY_IS_FRIENDS = 0x10000023;
    public static final Integer EXCEPTION_CODE_USER_CANNOT_ADD_SELF = 0x10000024;
    public static final Integer EXCEPTION_CODE_USER_IS_NOT_FRIEND = 0x10000025;
    public static final Integer EXCEPTION_CODE_USER_IS_NOT_ENABLE = 0x10000026;
    public static final Integer EXCEPTION_CODE_USERNAME_ALREADY_EXIST = 0x10000027;
    public static final Integer EXCEPTION_CODE_USER_OPEN_ID_ALREADY_EXIST = 0x10000028;
    public static final Integer EXCEPTION_CODE_USER_ACCESS_DENIED = 0x10000029;
    public static final Integer EXCEPTION_CODE_USER_CURRENT_PASSWORD_EQUAL_NEW_PASSWORD = 0x10000030;
    public static final Integer EXCEPTION_CODE_USER_NEW_PASSWORD_NOT_SET = 0x10000031;
    public static final Integer EXCEPTION_CODE_USER_OPEN_ID_NOT_EXIST = 0x10000032;
    public static final Integer EXCEPTION_CODE_USER_IDCARD_FORMAT_WRONG = 0x10000033;
    public static final Integer EXCEPTION_CODE_USER_ALREADY_AUDIT = 0x10000034;
    public static final Integer EXCEPTION_CODE_USER_TOKEN_OVERDUE = 0x10000035;
    public static final Integer EXCEPTION_CODE_USER_AMOUNT_NOT_ENOUGH = 0x10000036;
    public static final Integer EXCEPTION_CODE_USER_ALREADY_IS_VIP = 0x10000037;
    // 0x101开头为produce 产品
    public static final Integer EXCEPTION_CODE_PRODUCE_NOT_EXIST = 0x10100000;
    public static final Integer EXCEPTION_CODE_CARE_PRODUCE_NOT_EXIST = 0x10100001;
    public static final Integer EXCEPTION_CODE_PRODUCE_ACTIVITY_NOT_BEGIN = 0x10100002;
    public static final Integer EXCEPTION_CODE_PRODUCE_ACTIVITY_END = 0x10100003;
    public static final Integer EXCEPTION_CODE_PRODUCE_TYPE_NOT_EXIST = 0x10100004;
    public static final Integer EXCEPTION_CODE_PRODUCE_INVENTORY_NOT_ENOUGH = 0x10100005;
    public static final Integer EXCEPTION_CODE_PRODUCE_INVENTORY_NOT_EXIST = 0x10100006;
    public static final Integer EXCEPTION_CODE_PRODUCE_EVALUATE_NOT_EXIST = 0x10100007;
    public static final Integer EXCEPTION_CODE_PRODUCE_WRONG_EVALUATE_FILTER_TYPE = 0x10100008;

    // 0x102开头为produceCategory 产品分类
    public static final Integer EXCEPTION_CODE_PRODUCE_CATEGORY_NOT_EXIST = 0x10200000;
    public static final Integer EXCEPTION_CODE_PRODUCE_CATEGORY_CAN_NOT_DELETE = 0x10200001;

    // 0x103开头为token
    public static final Integer EXCEPTION_CODE_SN_IS_MUST = 0x10300000;

    // 0x104开头为order 订单
    public static final Integer EXCEPTION_CODE_ORDER_NOT_EXIST = 0x10400000;
    public static final Integer EXCEPTION_CODE_ORDER_ALREADY_EXIST = 0x10400001;
    public static final Integer EXCEPTION_CODE_ORDER_CREATE_FAILURE = 0x10400002;
    public static final Integer EXCEPTION_CODE_ORDER_EVALUATE_LEVEL_NOT_EXIST = 0x10400003;
    public static final Integer EXCEPTION_CODE_ORDER_CAN_NOT_EVALUATE = 0x10400004;
    public static final Integer EXCEPTION_CODE_ORDER_ITEM_NOT_EXIST = 0x10400005;
    public static final Integer EXCEPTION_CODE_WRONG_ORDER_STATE = 0x10400006;
    public static final Integer EXCEPTION_CODE_COUPON_NOT_EXIST = 0x10400007;
    public static final Integer EXCEPTION_CODE_ORDER_DISTANCE_TO_FAR = 0x10400008;

    // 0x105开头为consigneeInfo 收货人信息
    public static final Integer EXCEPTION_CODE_CONSIGNEE_INFO_NOT_EXIST = 0x10500000;
    public static final Integer EXCEPTION_CODE_CONSIGNEE_INFO_MAX = 0x10500001;
    public static final Integer EXCEPTION_CODE_DEFAULT_CONSIGNEE_CAN_NOT_BE_NON_DEFAULT = 0x10500002;
    public static final Integer EXCEPTION_CODE_DEFAULT_CONSIGNEE_CAN_NOT_REMOVE = 0x10500003;

    // 0x107开头为payment 支付
    public static final Integer EXCEPTION_CODE_PAYMENT_MODEL_NOT_SUPPORT = 0x10700000;
    public static final Integer EXCEPTION_CODE_PAYMENT_TOTAL_FEE_CANT_BE_ZERO = 0x10700001;
    public static final Integer EXCEPTION_CODE_PAYMENT_REQUEST_THIRD_PART_FAIL = 0x10700002;
    public static final Integer EXCEPTION_CODE_PAYMENT_CHANNEL_ALREADY_EXIST = 0x10700003;
    public static final Integer EXCEPTION_CODE_PAYMENT_CHANNEL_NOT_EXIST = 0x10700004;
    public static final Integer EXCEPTION_CODE_PAYMENT_CHANNEL_TYPE_ALREADY_EXIST = 0x10700005;
    public static final Integer EXCEPTION_CODE_PAYMENT_CHANNEL_TYPE_NOT_EXIST = 0x10700006;
    public static final Integer EXCEPTION_CODE_PAYMENT_HAS_NOT_ENOUGH_AMOUNT = 0x10700007;

    // 0x109开头为 app
    public static final Integer EXCEPTION_CODE_CUSTOMSERVICEPHONENUM_NOT_EXIST = 0x10900000;
    public static final Integer EXCEPTION_CODE_APPLOCATION_NOT_EXIST = 0x10900001;

    // 0x110开头为短信
    public static final Integer EXCEPTION_CODE_SMS_TEMPLATE_NOT_EXIST = 0x11000000;
    public static final Integer EXCEPTION_CODE_SMS_SEND_FAILURE = 0x11000001;
    public static final Integer EXCEPTION_CODE_SMS_SEND_OVER_MAX_NUMB_PER_HOUR = 0x11000002;
    public static final Integer EXCEPTION_CODE_SMS_SEND_OVER_MAX_NUMB_PER_DAT = 0x11000003;

    // 0x111开头为快递
    public static final Integer EXCEPTION_CODE_EXPRESS_SUBSCRIBE_FAIL = 0x11100000;
    public static final Integer EXCEPTION_CODE_EXPRESS_ORDER_FAILURE = 0x11100000;

    // 0x112开头为签名
    public static final Integer EXCEPTION_CODE_MD5_SIGNATURE_VERIFICATION_FAIL = 0x11200000;

    // 0x113开头为商品品牌
    public static final Integer EXCEPTION_CODE_BRAND_NOT_EXIST = 0x11300000;

    // 0x114开头为商品可选规格
    public static final Integer EXCEPTION_CODE_SKU_NOT_EXIST = 0x11400000;
    public static final Integer EXCEPTION_CODE_SKU_NOT_SELECTED = 0x11400001;

    // 0x115开头为首页资源
    public static final Integer EXCEPTION_CODE_AD_TYPE_NOT_EXIST = 0x11500001;

    // 0x116开头为地区
    public static final Integer EXCEPTION_CODE_REGION_NOT_EXIST = 0x11600000;
    public static final Integer EXCEPTION_CODE_REGION_ALREADY_EXIST = 0x11600000;

    // 0x117开头为文件
    public static final Integer EXCEPTION_CODE_FILE_NOT_EXIST = 0x11700000;
    public static final Integer EXCEPTION_CODE_FILE_TYPE_NOT_EXIST = 0x11700001;
    public static final Integer EXCEPTION_CODE_FILE_ALREADY_EXIST = 0x11700000;
    public static final Integer EXCEPTION_CODE_FILE_TYPE_ALREADY_EXIST = 0x11700003;
    public static final Integer EXCEPTION_CODE_IMAGE_ASPECT_RATIO_NOT_MATCH = 0x11700004;

    // 0x118 开头为售后服务
    public static final Integer EXCEPTION_CODE_AFTER_SALE = 0x11800000;
    // 0x200
    public static final Integer EXCEPTION_CODE_EXPLORE_NOT_EXIST = 0x20000000;
    // 0x119 开头为小組
    public static final Integer EXCEPTION_CODE_GROUP_NOT_EXIST = 0x11900000;
    public static final Integer EXCEPTION_CODE_GROUP_ALREADY_FOLLOWED = 0x11900001;
    public static final Integer EXCEPTION_CODE_FORUM_NOT_EXIST = 0x11900001;
    // 0x120 开头为APP
    public static final Integer EXCEPTION_CODE_APP_NOT_EXIST = 0x12000000;


    // 0x121 开头为APP
    public static final Integer EXCEPTION_CODE_APP_ARTICLE_NOT_EXIST = 0x12100000;
    public static final Integer EXCEPTION_CODE_APP_DISTRICT_NOT_OPERATION = 0x12100001;
    public static final Integer EXCEPTION_CODE_APP_GET_LOCATION_INFOMATION_ERROR = 0x12100002;

    //0x122 为开放平台
    // 授权过期
    public static final Integer EXCEPTION_CODE_OPEN_API_AUTHORIZATION_EXPIRES = 0x12200000;
    public static final Integer EXCEPTION_CODE_OPEN_API_MERCHANT_NOT_EXIST = 0x12200001;
    public static final Integer EXCEPTION_CODE_OPEN_API_AUTHORIZATION_NOT_EXIST = 0x12200002;

    // 0x 123 为认证中心
    public static final Integer EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_EXIST = 0x12300000;
    public static final Integer EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_ENABLE = 0x12300001;
    public static final Integer EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_SUPPORT = 0x1230000;


    // 0x124 商户
    public static final Integer EXCEPTION_CODE_STORE_NOT_EXIST = 0x12400001;

    //0x125 活动
    public static final Integer EXCEPTION_CODE_ACTIVITY_NOT_EXIST = 0x12500001;
    public static final Integer EXCEPTION_CODE_ACTIVITY_ERROR = 0x12500002;
    public static final Integer EXCEPTION_CODE_ACTIVITY_OVERDUE = 0x12500003;
    public static final Integer EXCEPTION_CODE_ACTIVITY_NOT_YET_STARTED = 0x12500004;
    public static final Integer EXCEPTION_CODE_ACTIVITY_HAS_RISKY_CONTENT = 0x12500004;

    // 0x126 优惠卷
    public static final Integer EXCEPTION_CODE_COUPON_TYPE_NOT_MATCH = 0x12600001;
    public static final Integer EXCEPTION_CODE_COUPON_ERROR = 0x12600002;
    public static final Integer EXCEPTION_CODE_COUPON_AMOUNT_ERROR = 0x12600003;
    public static final Integer EXCEPTION_CODE_COUPON_NUMBER_NOT_ENOUGH = 0x12600003;
    // 0X127 地址
    public static final Integer EXCEPTION_CODE_ADDRESS_NOT_EXIST = 0x12700001;

    // 0x128 专题
    public static final Integer EXCEPTION_CODE_TOPIC_NOT_EXIST = 0x12800001;

    // 0x129 评论
    public static final Integer EXCEPTION_CODE_COMMENT_ALREADY_EXIST = 0x12800001;


    // 0x400开头为无适用场景

    // 公共字符串返回类型
    public static final String RESPONSE_STRING_SUCCESS = "success";
    public static final String RESPONSE_STRING_FAIL = "fail";

    public static final Integer EXCEPTION_CODE_CONFIG_PROPERTY_MISSING = 0X002;


    public static final Map<Integer, String> ExceptionDescript = Collections.unmodifiableMap(new HashMap<Integer, String>() {
        {
            put(EXCEPTION_CODE_CORRECT, "Success");
            put(EXCEPTION_CODE_UNKNOWN_ERROR, "未知错误");
            put(EXCEPTION_CODE_CUSTOM_INFORMATION, "服务端错误");
            put(EXCEPTION_CODE_EINVAL, "非法参数");
            put(EXCEPTION_CODE_UPDATE_DATA_FAILD, "更新数据失败");
            put(EXCEPTION_CODE_INFO_ALREADY_ACCEPTED, "信息已被受理, 请等候处理");
            put(EXCEPTION_CODE_USER_PHONE_NUMBER_ALREADY_EXIST, "手机号码已存在");
            put(EXCEPTION_CODE_USER_EMAIL_ALREADY_EXIST, "用户邮箱已存在");
            put(EXCEPTION_CODE_USERNAME_OR_PASSWORD_WRONG, "用户名或密码错误");
            put(EXCEPTION_CODE_USER_NOT_EXIST, "用户不存在");
            put(EXCEPTION_CODE_USER_TOKEN_NOT_EXIST, "用户登录状态错误");
            put(EXCEPTION_CODE_USER_PAYMENT_PASSWORD_EXIST, "支付密码错误");
            put(EXCEPTION_CODE_USER_LOGIN_FAIL, "用户登录失败");
            put(EXCEPTION_CODE_WRONG_PHONE_NUMBER, "手机号码错误");
            put(EXCEPTION_CODE_USER_CARE_PRODUCE_EXIST, "");
            put(EXCEPTION_CODE_PHONE_NUMBER_NOT_EXIST, "");
            put(EXCEPTION_CODE_WRONG_SMS_CODE, "短信验证码错误");
            put(EXCEPTION_CODE_USER_REGISTER_FAIL, "用户注册失败");
            put(EXCEPTION_CODE_USER_PASSWORD_TYPE_WRONG, "用户密码类型错误");
            put(EXCEPTION_CODE_USER_HAVE_SAME_PASSWORD, "");
            put(EXCEPTION_CODE_USER_CARE_PRODUCE_NOT_FIND, "");
            put(EXCEPTION_CODE_USER_CARE_BRAND_NOT_FIND, "");
            put(EXCEPTION_CODE_WRONG_NICK_NAME, "");
            put(EXCEPTION_CODE_USER_SAME_PHONE_NUMBER, "");
            put(EXCEPTION_CODE_USER_WRONG_PASSWORD_LENGTH, "");
            put(EXCEPTION_CODE_NICK_NAME_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_USER_BROWSER_HISTORY_NOT_EXIST, "");
            put(EXCEPTION_CODE_USER_NOT_REALNAME_AUTHORIZATION, "");
            put(EXCEPTION_CODE_USER_ALREADY_AUTHORIZATION, "");
            put(EXCEPTION_CODE_USER_ALREADY_IS_FRIENDS, "");
            put(EXCEPTION_CODE_USER_CANNOT_ADD_SELF, "");
            put(EXCEPTION_CODE_USER_IS_NOT_FRIEND, "");
            put(EXCEPTION_CODE_USER_IS_NOT_ENABLE, "用户已被禁用");
            put(EXCEPTION_CODE_USERNAME_ALREADY_EXIST, "该手机号已存在");
            put(EXCEPTION_CODE_USER_OPEN_ID_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_USER_ACCESS_DENIED, "访问被拒绝");
            put(EXCEPTION_CODE_USER_CURRENT_PASSWORD_EQUAL_NEW_PASSWORD, "");
            put(EXCEPTION_CODE_USER_NEW_PASSWORD_NOT_SET, "新密码未设置");
            put(EXCEPTION_CODE_USER_OPEN_ID_NOT_EXIST, "微信未绑定");
            put(EXCEPTION_CODE_USER_IDCARD_FORMAT_WRONG, "身份证格式不正确");
            put(EXCEPTION_CODE_USER_ALREADY_AUDIT, "您已审核通过");
            put(EXCEPTION_CODE_USER_TOKEN_OVERDUE, "登录状态已过期, 请重新登陆");
            put(EXCEPTION_CODE_USER_AMOUNT_NOT_ENOUGH, "用户余额不足");
            put(EXCEPTION_CODE_USER_ALREADY_IS_VIP, "用户已经是VIP了");
            put(EXCEPTION_CODE_PRODUCE_NOT_EXIST, "");
            put(EXCEPTION_CODE_CARE_PRODUCE_NOT_EXIST, "");
            put(EXCEPTION_CODE_PRODUCE_ACTIVITY_NOT_BEGIN, "");
            put(EXCEPTION_CODE_PRODUCE_ACTIVITY_END, "");
            put(EXCEPTION_CODE_ACTIVITY_OVERDUE, "活动已结束");
            put(EXCEPTION_CODE_ACTIVITY_NOT_YET_STARTED, "活动尚未开始");
            put(EXCEPTION_CODE_PRODUCE_TYPE_NOT_EXIST, "");
            put(EXCEPTION_CODE_PRODUCE_INVENTORY_NOT_ENOUGH, "");
            put(EXCEPTION_CODE_PRODUCE_INVENTORY_NOT_EXIST, "");
            put(EXCEPTION_CODE_PRODUCE_EVALUATE_NOT_EXIST, "");
            put(EXCEPTION_CODE_PRODUCE_WRONG_EVALUATE_FILTER_TYPE, "");
            put(EXCEPTION_CODE_PRODUCE_CATEGORY_NOT_EXIST, "");
            put(EXCEPTION_CODE_SN_IS_MUST, "");
            put(EXCEPTION_CODE_ORDER_NOT_EXIST, "订单不存在");
            put(EXCEPTION_CODE_ORDER_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_ORDER_CREATE_FAILURE, "");
            put(EXCEPTION_CODE_ORDER_EVALUATE_LEVEL_NOT_EXIST, "");
            put(EXCEPTION_CODE_ORDER_CAN_NOT_EVALUATE, "");
            put(EXCEPTION_CODE_ORDER_ITEM_NOT_EXIST, "");
            put(EXCEPTION_CODE_WRONG_ORDER_STATE, "订单当前状态不允许该操作");
            put(EXCEPTION_CODE_COUPON_NOT_EXIST, "");
            put(EXCEPTION_CODE_ORDER_DISTANCE_TO_FAR, "订单距离过远, 无法进行配送");
            put(EXCEPTION_CODE_CONSIGNEE_INFO_NOT_EXIST, "");
            put(EXCEPTION_CODE_CONSIGNEE_INFO_MAX, "");
            put(EXCEPTION_CODE_DEFAULT_CONSIGNEE_CAN_NOT_BE_NON_DEFAULT, "");
            put(EXCEPTION_CODE_DEFAULT_CONSIGNEE_CAN_NOT_REMOVE, "");
            put(EXCEPTION_CODE_PAYMENT_MODEL_NOT_SUPPORT, "");
            put(EXCEPTION_CODE_PAYMENT_TOTAL_FEE_CANT_BE_ZERO, "");
            put(EXCEPTION_CODE_PAYMENT_REQUEST_THIRD_PART_FAIL, "");
            put(EXCEPTION_CODE_PAYMENT_CHANNEL_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_PAYMENT_CHANNEL_NOT_EXIST, "");
            put(EXCEPTION_CODE_PAYMENT_CHANNEL_TYPE_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_PAYMENT_CHANNEL_TYPE_NOT_EXIST, "");
            put(EXCEPTION_CODE_PAYMENT_HAS_NOT_ENOUGH_AMOUNT, "余额不足");
            put(EXCEPTION_CODE_CUSTOMSERVICEPHONENUM_NOT_EXIST, "");
            put(EXCEPTION_CODE_APPLOCATION_NOT_EXIST, "");
            put(EXCEPTION_CODE_SMS_TEMPLATE_NOT_EXIST, "");
            put(EXCEPTION_CODE_SMS_SEND_FAILURE, "短信发送失败, 请稍后重试");
            put(EXCEPTION_CODE_SMS_SEND_OVER_MAX_NUMB_PER_HOUR, "");
            put(EXCEPTION_CODE_SMS_SEND_OVER_MAX_NUMB_PER_DAT, "");
            put(EXCEPTION_CODE_EXPRESS_SUBSCRIBE_FAIL, "");
            put(EXCEPTION_CODE_EXPRESS_ORDER_FAILURE, "");
            put(EXCEPTION_CODE_MD5_SIGNATURE_VERIFICATION_FAIL, "");
            put(EXCEPTION_CODE_BRAND_NOT_EXIST, "");
            put(EXCEPTION_CODE_SKU_NOT_EXIST, "");
            put(EXCEPTION_CODE_SKU_NOT_SELECTED, "");
            put(EXCEPTION_CODE_AD_TYPE_NOT_EXIST, "");
            put(EXCEPTION_CODE_REGION_NOT_EXIST, "");
            put(EXCEPTION_CODE_REGION_ALREADY_EXIST, "区域已存在");
            put(EXCEPTION_CODE_FILE_NOT_EXIST, "");
            put(EXCEPTION_CODE_FILE_TYPE_NOT_EXIST, "");
            put(EXCEPTION_CODE_FILE_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_FILE_TYPE_ALREADY_EXIST, "");
            put(EXCEPTION_CODE_IMAGE_ASPECT_RATIO_NOT_MATCH, "图片宽高比不符合");
            put(EXCEPTION_CODE_AFTER_SALE, "");
            put(EXCEPTION_CODE_EXPLORE_NOT_EXIST, "");
            put(EXCEPTION_CODE_GROUP_NOT_EXIST, "");
            put(EXCEPTION_CODE_GROUP_ALREADY_FOLLOWED, "");
            put(EXCEPTION_CODE_FORUM_NOT_EXIST, "");
            put(EXCEPTION_CODE_APP_NOT_EXIST, "App not found");
            put(EXCEPTION_CODE_CONFIG_PROPERTY_MISSING, "Config file not available! Please provider a available config file!");
            put(EXCEPTION_CODE_OPEN_API_AUTHORIZATION_EXPIRES, "授权过期");
            put(EXCEPTION_CODE_APP_DISTRICT_NOT_OPERATION, "区域暂未运营");
            put(EXCEPTION_CODE_APP_GET_LOCATION_INFOMATION_ERROR, "获取定位信息失败, 请重试");
            put(EXCEPTION_CODE_OPEN_API_MERCHANT_NOT_EXIST, "开放平台商户不存在");
            put(EXCEPTION_CODE_OPEN_API_AUTHORIZATION_NOT_EXIST, "授权不存在");
            put(EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_EXIST, "该应用不存在");
            put(EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_ENABLE, "该应用已被禁止登陆");
            put(EXCEPTION_CODE_AUTHORIZATION_APPLICATION_NOT_SUPPORT, "不支持该应用认证方式");
            put(EXCEPTION_CODE_STORE_NOT_EXIST, "店铺不存在");
            put(EXCEPTION_CODE_ACTIVITY_NOT_EXIST, "暂无活动");
            put(EXCEPTION_CODE_ACTIVITY_ERROR, "活动错误");
            put(EXCEPTION_CODE_ACTIVITY_HAS_RISKY_CONTENT, "输入的内容包含敏感内容, 无法发布");
            put(EXCEPTION_CODE_COUPON_TYPE_NOT_MATCH, "优惠卷类型不匹配");
            put(EXCEPTION_CODE_COUPON_ERROR, "优惠卷错误");
            put(EXCEPTION_CODE_COUPON_AMOUNT_ERROR, "优惠卷金额错误");
            put(EXCEPTION_CODE_COUPON_NUMBER_NOT_ENOUGH, "优惠卷数量不足");
            put(EXCEPTION_CODE_ADDRESS_NOT_EXIST, "地址不存在");
            put(EXCEPTION_CODE_COMMENT_ALREADY_EXIST, "评论已存在");
        }
    });

}
