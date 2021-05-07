/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : Page.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo;

import org.hiylo.components.commons.beanutils.BeanUtils;

import java.util.List;

/**
 * @author hiylo
 * @date 2018年11月14日 11:32:04
 */
public class Page<T> {
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_MEDIUM_PAGE_SIZE = 20;
    public static final int DEFAULT_LARGE_PAGE_SIZE = 30;
    private Integer begin;
    private BeanUtils beanUtils = new BeanUtils();
    /**
     * 查询条件
     */
    private Integer size;
    private Integer total;
    /**
     * 实际查出的条数
     */
    private Integer pageSize;
    /**
     * 查出的结果
     */
    private List<T> list;


    public Page() {
    }

    public Page(Integer begin, Integer size) {
        this.begin = begin;
        this.size = size;
    }

    public static Page of(int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = Page.DEFAULT_PAGE_SIZE;
        } else if (size > Page.DEFAULT_LARGE_PAGE_SIZE) {
            size = Page.DEFAULT_LARGE_PAGE_SIZE;
        }
        int begin = (page - 1) * size;
        return new Page(begin, size);
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page convert(Class<T> clazz) {
        this.list = beanUtils.convertList(this.list, clazz);
        return this;
    }

    public void setList(List<?> list, Class<T> clazz) {
        this.list = beanUtils.convertList(list, clazz);
    }
}
