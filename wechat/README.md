# wechat

这个模块中会有微信开发中一些常见的工具类和工具方法, 包含了微信公众号和微信小程序以及微信支付相关功能, 能够快速的接入到项目中, 近几年工作中遇到的需求, 基本上都提炼出来了, 如果有问题和Bug可以和我联系

下面进入正题

1. 配置

- 单个微信(微信公众号, 微信小程序以及微信支付)配置

在Spring配置文件中加入
~~~properties
# 微信公众号或微信小程序配置
wechat.appid=appid 
wechat.appsecret=appsecret

# 微信支付相关设置
wechat.partner=partner
wechat.partnerkey=partnerkey
wechat.certPath=classpath:mall/apiclient_cert.p12
~~~

如果使用微信小程序相关功能使用在程序入口类上注解
~~~java
// 微信支付
@EnableWechat
@EnableWechatPublicAccount
~~~
小程序使用
~~~java
// 微信支付
@EnableWechat
@EnableWechatMiniProgram
~~~
微信公众号相关功能查看
~~~java
org.hiylo.components.wechat.user.WechatUtils
~~~

多微信环境需要使用 @EnableMultiWechat 注解, 配置参照
~~~java
org.hiylo.components.wechat.WechatConfig
~~~

微信支付相关功能使用
~~~java
org.hiylo.components.wechat.pay.Topay
~~~

微信支付转账相关功能使用
~~~java
org.hiylo.components.wechat.pay.Topay
~~~