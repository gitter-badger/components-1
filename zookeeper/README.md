# zookeeper

两种启动方式

1.使用Spring Boot注解方式获取实例   

在Spring Boot的配置文件中加入配置

~~~ properties
zookeeper.locations=hostname:port
~~~

~~~ yaml
zookeeper:
    locations: hostname:port
~~~

之后在Spring  Boot启动类上加上注解@EnableZookeeper， 在需要使用Zookeeper的类中自动注入

~~~ java
    @Autowired
    private I0ItecZooKeeperServiceProvider i0ItecZooKeeperServiceProvider;
~~~   

2.非Spring形式获取实例 

实例化Zookeeper操作类

~~~ java
    private I0ItecZooKeeperServiceProvider i0ItecZooKeeperServiceProvider = new I0ItecZooKeeperServiceProvider("127.0.0.1:2181");
~~~


Zookeeper操作示例

~~~ java
    // 从Zookeeper中取出一个值
    i0ItecZooKeeperServiceProvider.get("/config/worker/sequence");
    // 向Zookeeper中放入一个值
    i0ItecZooKeeperServiceProvider.put("/config/worker/sequence", "1");
    // 清除某个路径下的所有内容
    i0ItecZooKeeperServiceProvider.resetZookeeper("/config")
~~~

Zookeeper watcher使用

在监听器类上实现I0ItecZooKeeperServiceProviderSubscribe接口， 使用i0ItecZooKeeperServiceProvider.subscribeChildChanges("/config/test", I0ItecZooKeeperServiceProviderSubscribe)进行监听
