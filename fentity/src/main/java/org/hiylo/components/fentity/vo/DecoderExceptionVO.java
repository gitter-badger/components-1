/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : DecoderExceptionVO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo;

import java.io.Serializable;

/**
 * Created by hiylo on 12/26/2016.
 */
public class DecoderExceptionVO implements Serializable {
    private String timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public DecoderExceptionVO() {
    }

    public DecoderExceptionVO(String timestamp, int status, String error, String exception, String message, String path) {

        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "DecoderExceptionVO{" + "timestamp=" + timestamp + ", status=" + status + ", error='" + error + '\''
                + ", exception='" + exception + '\'' + ", message='" + message + '\'' + ", path='" + path + '\'' + '}';
    }
}
