/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : JMSQueueAppender.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.log;

/// **
// * JMSQueueAppender.java
// *
// *
// * ver date author
// * ──────────────────────────────────
// * 上午11:47:30 朱玺
// *
// * Copyright (c) 2016,Landi Group All Rights Reserved.
// */
// package org.hiylo.commons.log;
//
// import javax.annotation.Resource;
// import javax.jms.DeliveryMode;
// import javax.jms.Destination;
// import javax.jms.MessageProducer;
// import javax.jms.ObjectMessage;
// import javax.jms.Session;
//
// import org.apache.activemq.ActiveMQConnectionFactory;
// import org.apache.log4j.Appender;
// import org.apache.log4j.AppenderSkeleton;
// import org.apache.log4j.Layout;
// import org.apache.log4j.Logger;
// import org.apache.log4j.spi.ErrorHandler;
// import org.apache.log4j.spi.Filter;
// import org.apache.log4j.spi.LoggingEvent;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jms.core.JmsMessagingTemplate;
//
// import org.hiylo.commons.activemq.LogMQ;
//
/// **
// * @ClassName: JMSQueueAppender
// * @author 朱玺
// * @date 2016年12月14日 上午11:47:30
// *
// */
// public class JMSQueueAppender extends AppenderSkeleton implements Appender {
// private static Logger log = Logger.getLogger("JMSQueueAppender");
//
// @Override
// public void close() {
//
// }
//
// @Override
// public boolean requiresLayout() {
// return false;
// }
//
// /*
// * (non-Javadoc) <p>Title: addFilter</p> <p>Description: </p>
// *
// * @param arg0
// *
// * @see org.apache.log4j.Appender#addFilter(org.apache.log4j.spi.Filter)
// */
// @Override
// public void addFilter(Filter arg0) {
//
// }
//
// /*
// * (non-Javadoc) <p>Title: clearFilters</p> <p>Description: </p>
// *
// * @see org.apache.log4j.Appender#clearFilters()
// */
// @Override
// public void clearFilters() {
//
// }
//
// /*
// * (non-Javadoc) <p>Title: doAppend</p> <p>Description: </p>
// *
// * @param arg0
// *
// * @see
// * org.apache.log4j.Appender#doAppend(org.apache.log4j.spi.LoggingEvent)
// */
// @Override
// public void doAppend(LoggingEvent arg0) {
// try {
// jmsMessagingTemplate.getConnectionFactory().
// // Create the destination (Topic or Queue)
// Destination destination = session.createQueue(this.queueName);
//
// // Create a MessageProducer from the Session to the Topic or Queue
// MessageProducer producer = session.createProducer(destination);
// producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//
// ObjectMessage message = session.createObjectMessage(new
/// LoggingEventWrapper(event));
//
// // Tell the producer to send the message
// producer.send(message);
//
// // Clean up
// session.close();
// connection.close();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
//
// /*
// * (non-Javadoc) <p>Title: getErrorHandler</p> <p>Description: </p>
// *
// * @return
// *
// * @see org.apache.log4j.Appender#getErrorHandler()
// */
// @Override
// public ErrorHandler getErrorHandler() {
// return null;
// }
//
// /*
// * (non-Javadoc) <p>Title: getFilter</p> <p>Description: </p>
// *
// * @return
// *
// * @see org.apache.log4j.Appender#getFilter()
// */
// @Override
// public Filter getFilter() {
// return null;
// }
//
// /*
// * (non-Javadoc) <p>Title: getLayout</p> <p>Description: </p>
// *
// * @return
// *
// * @see org.apache.log4j.Appender#getLayout()
// */
// @Override
// public Layout getLayout() {
// return null;
// }
//
// /*
// * (non-Javadoc) <p>Title: getName</p> <p>Description: </p>
// *
// * @return
// *
// * @see org.apache.log4j.Appender#getName()
// */
// @Override
// public String getName() {
// return null;
// }
//
// /*
// * (non-Javadoc) <p>Title: setErrorHandler</p> <p>Description: </p>
// *
// * @param arg0
// *
// * @see org.apache.log4j.Appender#setErrorHandler(org.apache.log4j.spi.
// * ErrorHandler)
// */
// @Override
// public void setErrorHandler(ErrorHandler arg0) {
//
// }
// }