/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : CallbackVO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.fooddelivered.eleme;

import lombok.Data;

/**
 * @author hiylo
 * @date 2018年10月15日 15:51:44
 */
@Data
public class CallbackVO {

    /**
     * requestId : 100000021764401594
     * type : 10
     * appId : 22954133
     * message : {"id":"1200897812792015983","orderId":"1200897812792015983","address":"上海市普陀区金沙江路丹巴路119号-NAPOS","createdAt":"2017-03-06T12:28:50","activeAt":"2017-03-06T12:28:50","deliverFee":0.0,"deliverTime":null,"description":"爱吃辣多点辣","groups":[{"name":"1号篮子","type":"normal","items":[{"id":260,"skuId":-1,"name":"红烧肉[重辣]","categoryId":1,"price":4.0,"quantity":1,"total":4.0,"additions":[]}]},{"name":"2号篮子","type":"normal","items":[{"id":262,"skuId":-1,"name":"狮子头","categoryId":1,"price":5.0,"quantity":1,"total":5.0,"additions":[]}]},{"name":"3号篮子","type":"normal","items":[{"id":261,"skuId":-1,"name":"奶茶[去冰+半塘]","categoryId":1,"price":3.0,"quantity":2,"total":6.0,"additions":[]}]}],"invoice":"上海市拉拉队有限公司","book":false,"onlinePaid":true,"railwayAddress":null,"phoneList":["13456789012"],"shopId":720032,"shopName":"测试餐厅001","daySn":7,"status":"unprocessed","refundStatus":"noRefund","userId":13524069,"totalPrice":20.0,"originalPrice":0.0,"consignee":"饿了么 先生","deliveryGeo":"121.3836479187,31.2299251556","deliveryPoiAddress":"上海市普陀区金沙江路丹巴路119号-NAPOS","invoiced":true,"income":0.0,"serviceRate":0.0,"serviceFee":0.0,"hongbao":0.0,"packageFee":0.0,"activityTotal":0.0,"shopPart":0.0,"elemePart":0.0,"downgraded":true,"vipDeliveryFeeDiscount":0.0}
     * shopId : 720032
     * timestamp : 1488774535366
     * signature : 2461328351094CA5853415FD25E36E95
     * userId : 98587250597500702
     */

    /**
     * 请求ID
     */
    private String requestId;
    /**
     * 订单生效	订单状态扭转	10	订单生效，店铺可以看到新订单	订单消息
     * 商户接单	订单状态扭转	12	商户已经接单	订单状态变更消息
     * 订单被取消	订单状态扭转	14	订单被取消（接单前）	订单状态变更消息
     * 订单置为无效	订单状态扭转	15	订单置为无效（接单后）	订单状态变更消息
     * 订单强制无效	订单状态扭转	17	订单强制无效（商家主动取消已接受订单、用户1分钟内取消）	订单状态变更消息
     * 订单完结	订单状态扭转	18	订单完结	订单状态变更消息
     * 用户申请取消单	取消单流程	20	下单用户申请取消	取消单消息
     * 用户取消取消单申请	取消单流程	21	用户取消取消订单	取消单消息
     * 商户拒绝取消单	取消单流程	22	商户拒绝取消订单	取消单消息
     * 商户同意取消单	取消单流程	23	商户同意取消订单	取消单消息
     * 用户申请仲裁取消单	取消单流程	24	用户申请仲裁	取消单消息
     * 客服仲裁取消单申请有效	取消单流程	25	客服仲裁取消单申请有效	取消单消息
     * 客服仲裁取消单申请无效	取消单流程	26	客服仲裁取消单申请无效	取消单消息
     * 用户申请退单	退单流程	30	用户申请退单	退单消息
     * 用户取消退单	退单流程	31	用户取消退单	退单消息
     * 商户拒绝退单	退单流程	32	商户拒绝退单	退单消息
     * 商户同意退单	退单流程	33	商户同意退单	退单消息
     * 用户申请仲裁	退单流程	34	用户申请仲裁	退单消息
     * 客服仲裁退单有效	退单流程	35	客服仲裁退单有效	退单消息
     * 客服仲裁退单无效	退单流程	36	客服仲裁退单无效	退单消息
     * 用户催单	催单流程	45	用户催单	催单消息
     * 订单待分配配送商	运单追踪	51	待分配配送商	运单状态变更消息
     * 订单待分配配送员	运单追踪	52	待分配配送员	运单状态变更消息
     * 配送员取餐中	运单追踪	53	已分配给配送员，配送员取餐中	运单状态变更消息
     * 配送员已到店	运单追踪	54	配送员已经到店	运单状态变更消息
     * 配送员配送中	运单追踪	55	配送员已取餐，配送中	运单状态变更消息
     * 配送成功	运单追踪	56	配送成功	运单状态变更消息
     * 配送取消，商户取消	运单追踪	57	配送取消	运单状态变更消息
     * 配送取消，用户取消	运单追踪	58	配送取消	运单状态变更消息
     * 配送取消，物流系统取消	运单追踪	59	配送取消	运单状态变更消息
     * 配送失败，呼叫配送晚	运单追踪	60	配送失败	运单状态变更消息
     * 配送失败，餐厅出餐问题	运单追踪	61	配送失败	运单状态变更消息
     * 配送失败，商户中断配送	运单追踪	62	配送失败	运单状态变更消息
     * 配送失败，用户不接电话	运单追踪	63	配送失败	运单状态变更消息
     * 配送失败，用户退单	运单追踪	64	配送失败	运单状态变更消息
     * 配送失败，用户地址错误	运单追踪	65	配送失败	运单状态变更消息
     * 配送失败，超出服务范围	运单追踪	66	配送失败	运单状态变更消息
     * 配送失败，骑手标记异常	运单追踪	67	配送失败	运单状态变更消息
     * 配送失败，系统自动标记异常	运单追踪	68	配送失败	运单状态变更消息
     * 配送失败，其他异常	运单追踪	69	配送失败	运单状态变更消息
     * 配送失败，超时标记异常	运单追踪	70	配送失败	运单状态变更消息
     * 自行配送	运单追踪	71	自行配送	运单状态变化消息
     * 不再配送	运单追踪	72	不再配送	运单状态变化消息
     * 物流拒单，仅支持在线支付	运单追踪	73	仅支持在线支付	运单状态变化消息
     * 物流拒单，超出服务范围	运单追踪	74	超出服务范围	运单状态变化消息
     * 物流拒单，请求配送晚	运单追踪	75	请求配送过晚	运单状态变化消息
     * 物流拒单，系统异常	运单追踪	76	系统异常	运单状态变化消息
     * 店铺营业状态通知	店铺管理	91	店铺营业状态变化	店铺状态变更消息
     * 店铺信息修改通知	店铺管理	93	店铺基本信息变更消息	店铺信息变更消息
     * 应用授权解除通知	授权管理	100	授权状态变更消息	授权状态变更消息
     * 服务市场订单订购通知	服务订单管理	105	服务市场订单状态扭转消息	服务市场订购消息
     */
    private int type;
    private int appId;
    private int shopId;
    private long timestamp;
    private String signature;
    private long userId;
    /**
     * 在type类型为10时
     */
    private String message;

}
