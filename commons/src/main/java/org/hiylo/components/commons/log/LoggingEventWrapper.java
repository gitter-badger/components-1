/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : LoggingEventWrapper.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.log;

/// **
// * LoggingEventWrapper.java
// *
// *
// * ver date author
// * ──────────────────────────────────
// * 下午12:05:15 朱玺
// *
// * Copyright (c) 2016,Landi Group All Rights Reserved.
// */
// package org.hiylo.commons.log;
//
// import java.io.Serializable;
// import java.net.InetAddress;
// import java.net.UnknownHostException;
//
// import org.apache.log4j.spi.LoggingEvent;
//
/// **
// * @ClassName: LoggingEventWrapper
// * @author 朱玺
// * @date 2016年12月14日 下午12:05:15
// *
// */
// public class LoggingEventWrapper implements Serializable {
//
// private static final String ENHANCED_PATTERN_LAYOUT = "%throwable";
// private static final long serialVersionUID = 3281981073249085474L;
// private LoggingEvent loggingEvent;
//
// private Long timeStamp;
// private String level;
// private String logger;
// private String message;
// private String detail;
// private String ipAddress;
// private String hostName;
//
// public LoggingEventWrapper(LoggingEvent loggingEvent) {
// this.loggingEvent = loggingEvent;
//
// // Format event and set detail field
// EnhancedPatternLayout layout = new EnhancedPatternLayout();
// layout.setConversionPattern(ENHANCED_PATTERN_LAYOUT);
// this.detail = layout.format(this.loggingEvent);
// }
//
// public Long getTimeStamp() {
// return this.loggingEvent.timeStamp;
// }
//
// public String getLevel() {
// return this.loggingEvent.getLevel().toString();
// }
//
// public String getLogger() {
// return this.loggingEvent.getLoggerName();
// }
//
// public String getMessage() {
// return this.loggingEvent.getRenderedMessage();
// }
//
// public String getDetail() {
// return this.detail;
// }
//
// public LoggingEvent getLoggingEvent() {
// return loggingEvent;
// }
//
// public String getIpAddress() {
// try {
// return InetAddress.getLocalHost().getHostAddress();
// } catch (UnknownHostException e) {
// return "Could not determine IP";
// }
// }
//
// public String getHostName() {
// try {
// return InetAddress.getLocalHost().getHostName();
// } catch (UnknownHostException e) {
// return "Could not determine Host Name";
// }
// }
// }