/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : OperationResponse.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

/**
 * This is the common structure for all responses
 * if the response contains a list(array) then it will have 'items' field
 * if the response contains a single item then it will have 'item'  field
 */


package org.hiylo.components.fentity.vo;


import org.hiylo.components.exceptions.Constants;

/**
 * @author hiylo
 * @date 2018年4月10日 11:13:23
 */
public class OperationResponse {
    private ResponseStatusEnum status;
    private String message;
    private String code;
    private Object data;
    private Integer pageSize;
    private Integer total;


    public OperationResponse() {
    }

    public OperationResponse(ResponseStatusEnum status, String message) {
        this.status = status;
        this.message = message;
    }

    public OperationResponse success(String message) {
        this.message = message;
        this.code = "200";
        this.status = ResponseStatusEnum.SUCCESS;
        return this;
    }

    public OperationResponse success() {
        this.message = Constants.RESPONSE_STRING_SUCCESS;
        this.code = "200";
        this.status = ResponseStatusEnum.SUCCESS;
        return this;
    }

    public OperationResponse success(Object data) {
        this.message = Constants.RESPONSE_STRING_SUCCESS;
        this.status = ResponseStatusEnum.SUCCESS;
        this.code = "200";
        this.data = data;
        return this;
    }

    public OperationResponse success(Page page) {
        this.message = Constants.RESPONSE_STRING_SUCCESS;
        this.status = ResponseStatusEnum.SUCCESS;
        this.code = "200";
        this.data = page.getList();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        return this;
    }

    public OperationResponse updatedDataFailed() {
        return this.error(Constants.EXCEPTION_CODE_UPDATE_DATA_FAILD);
    }

    public OperationResponse badArgumentValue() {
        return this.error(Constants.EXCEPTION_CODE_EINVAL);
    }

    public OperationResponse error(Integer exceptionCodeEinval) {
        return this.error(code, Constants.ExceptionDescript.get(code));
    }

    public OperationResponse error(Integer code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
        this.status = ResponseStatusEnum.ERROR;
        return this;
    }

    public OperationResponse error(String code, String message) {
        this.code = code;
        this.message = message;
        this.status = ResponseStatusEnum.ERROR;
        return this;
    }

    public static OperationResponse build(Object data) {
        return new OperationResponse().success(data);
    }

    public static OperationResponse build() {
        return new OperationResponse().success();
    }

    public ResponseStatusEnum getStatus() {
        return status;
    }

    public OperationResponse setStatus(ResponseStatusEnum status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public OperationResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public OperationResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public OperationResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public OperationResponse setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public OperationResponse setTotal(Integer total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "OperationResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }

    /**
     * 响应状态
     */
    public enum ResponseStatusEnum {
        /**
         * 请求成功
         */
        SUCCESS,
        /**
         * 请求失败
         */
        ERROR,
        /**
         * 警告
         */
        WARNING,
        /**
         * 无权访问
         */
        NO_ACCESS
    }
}
