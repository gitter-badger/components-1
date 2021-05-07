/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Db2ES.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.tran.DataStream;
import org.frameworkset.tran.db.input.es.DB2ESImportBuilder;
import org.hiylo.components.commons.CommonsApplicationTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommonsApplicationTester.class)
public class Db2ES {

    @Test
    public void importClientIncomesDB2ES(){
        DB2ESImportBuilder importBuilder = DB2ESImportBuilder.newInstance();
        //数据源相关配置，可选项，可以在外部启动数据源
        importBuilder.setDbName("db_user")
                .setDbDriver("com.mysql.jdbc.Driver") //数据库驱动程序，必须导入相关数据库的驱动jar包
                .setDbUrl("jdbc:mysql://127.0.0.1/db_user")
                .setDbUser("")
                .setDbPassword("")
                .setValidateSQL("select 1")
                .setUsePool(true);//是否使用连接池


        //指定导入数据的sql语句，必填项，可以设置自己的提取逻辑
        importBuilder.setSql("select * from tb_client_income");
        /**
         * es相关配置
         */
        importBuilder
                .setIndex("client_income") //必填项
                .setIndexType("docs") //必填项
                .setRefreshOption(null)//可选项，null表示不实时刷新，importBuilder.setRefreshOption("refresh");表示实时刷新
                .setUseJavaName(true) //可选项,将数据库字段名称转换为java驼峰规范的名称，例如:doc_id -> docId
                .setBatchSize(1000)  //可选项,批量导入es的记录数，默认为-1，逐条处理，> 0时批量处理
                .setJdbcFetchSize(2000);//设置数据库的查询fetchsize

        /**
         * 一次、作业创建一个内置的线程池，实现多线程并行数据导入elasticsearch功能，作业完毕后关闭线程池
         */
        importBuilder.setParallel(true);//设置为多线程并行批量导入
        importBuilder.setQueue(100);//设置批量导入线程池等待队列长度
        importBuilder.setThreadCount(200);//设置批量导入线程池工作线程数量
        importBuilder.setContinueOnError(true);//任务出现异常，是否继续执行作业：true（默认值）继续执行 false 中断作业执行
        importBuilder.setAsyn(false);//true 异步方式执行，不等待所有导入作业任务结束，方法快速返回；false（默认值） 同步方式执行，等待所有导入作业任务结束，所有作业结束后方法才返回
        importBuilder.setRefreshOption("refresh"); // 为了实时验证数据导入的效果，强制刷新数据，生产环境请设置为null或者不指定

        /**
         * 执行数据库表数据导入es操作
         */
        DataStream dataStream = importBuilder.builder();
        dataStream.execute();

        long count = ElasticSearchHelper.getRestClientUtil().countAll("client_income");
        System.out.println("数据导入完毕后索引表dbdemo中的文档数量:"+count);
    }

    @Test
    public void importCourierIncomes2ES(){
        DB2ESImportBuilder importBuilder = DB2ESImportBuilder.newInstance();
        //数据源相关配置，可选项，可以在外部启动数据源
        importBuilder.setDbName("db_user")
                .setDbDriver("com.mysql.jdbc.Driver") //数据库驱动程序，必须导入相关数据库的驱动jar包
                .setDbUrl("jdbc:mysql://127.0.0.1/db_user")
                .setDbUser("")
                .setDbPassword("")
                .setValidateSQL("select 1")
                .setUsePool(true);//是否使用连接池


        //指定导入数据的sql语句，必填项，可以设置自己的提取逻辑
        importBuilder.setSql("select * from tb_courier_income");
        /**
         * es相关配置
         */
        importBuilder
                .setIndex("courier_income") //必填项
                .setIndexType("docs") //必填项
                .setRefreshOption(null)//可选项，null表示不实时刷新，importBuilder.setRefreshOption("refresh");表示实时刷新
                .setUseJavaName(true) //可选项,将数据库字段名称转换为java驼峰规范的名称，例如:doc_id -> docId
                .setBatchSize(1000)  //可选项,批量导入es的记录数，默认为-1，逐条处理，> 0时批量处理
                .setJdbcFetchSize(2000);//设置数据库的查询fetchsize

        /**
         * 一次、作业创建一个内置的线程池，实现多线程并行数据导入elasticsearch功能，作业完毕后关闭线程池
         */
        importBuilder.setParallel(true);//设置为多线程并行批量导入
        importBuilder.setQueue(100);//设置批量导入线程池等待队列长度
        importBuilder.setThreadCount(200);//设置批量导入线程池工作线程数量
        importBuilder.setContinueOnError(true);//任务出现异常，是否继续执行作业：true（默认值）继续执行 false 中断作业执行
        importBuilder.setAsyn(false);//true 异步方式执行，不等待所有导入作业任务结束，方法快速返回；false（默认值） 同步方式执行，等待所有导入作业任务结束，所有作业结束后方法才返回
        importBuilder.setRefreshOption("refresh"); // 为了实时验证数据导入的效果，强制刷新数据，生产环境请设置为null或者不指定

        /**
         * 执行数据库表数据导入es操作
         */
        DataStream dataStream = importBuilder.builder();
        dataStream.execute();

        long count = ElasticSearchHelper.getRestClientUtil().countAll("courier_income");
        System.out.println("数据导入完毕后索引表dbdemo中的文档数量:"+count);
    }
}
