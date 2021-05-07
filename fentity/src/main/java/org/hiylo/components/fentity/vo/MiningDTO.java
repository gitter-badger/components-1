/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MiningDTO.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */
package org.hiylo.components.fentity.vo;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
public class MiningDTO {
    private Integer id;
    private Integer pv;
    private Integer uv;
    private Double totleIncome;
    private Integer buyCount;
    private Integer newDeviceCount;
    private Integer newRegisterCount;
    private Double totleNormalOrderIncome;
    private Double totleTourOrderIncome;
    private Double totleExploreOrderIncome;
    private Integer totleNormalOrderCount;
    private Integer totleTourOrderCount;
    private Integer totleExploreOrderCount;
    private String addDate;

    public MiningDTO() {
        super();
    }

    public MiningDTO(Integer id, Integer pv, Integer uv, Double totleIncome, Integer buyCount, Integer newDeviceCount, Integer newRegisterCount,
                     Double totleNormalOrderIncome, Double totleTourOrderIncome, Double totleExploreOrderIncome,
                     Integer totleNormalOrderCount, Integer totleTourOrderCount, Integer totleExploreOrderCount) {
        super();
        this.id = id;
        this.pv = pv;
        this.uv = uv;
        this.totleIncome = totleIncome;
        this.buyCount = buyCount;
        this.newDeviceCount = newDeviceCount;
        this.newRegisterCount = newRegisterCount;
        this.totleNormalOrderIncome = totleNormalOrderIncome;
        this.totleTourOrderIncome = totleTourOrderIncome;
        this.totleExploreOrderIncome = totleExploreOrderIncome;
        this.totleNormalOrderCount = totleNormalOrderCount;
        this.totleTourOrderCount = totleTourOrderCount;
        this.totleExploreOrderCount = totleExploreOrderCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Double getTotleIncome() {
        return totleIncome;
    }

    public void setTotleIncome(Double totleIncome) {
        this.totleIncome = totleIncome;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getNewDeviceCount() {
        return newDeviceCount;
    }

    public void setNewDeviceCount(Integer newDeviceCount) {
        this.newDeviceCount = newDeviceCount;
    }

    public Integer getNewRegisterCount() {
        return newRegisterCount;
    }

    public void setNewRegisterCount(Integer newRegisterCount) {
        this.newRegisterCount = newRegisterCount;
    }

    public Double getTotleNormalOrderIncome() {
        return totleNormalOrderIncome;
    }

    public void setTotleNormalOrderIncome(Double totleNormalOrderIncome) {
        this.totleNormalOrderIncome = totleNormalOrderIncome;
    }

    public Double getTotleTourOrderIncome() {
        return totleTourOrderIncome;
    }

    public void setTotleTourOrderIncome(Double totleTourOrderIncome) {
        this.totleTourOrderIncome = totleTourOrderIncome;
    }

    public Double getTotleExploreOrderIncome() {
        return totleExploreOrderIncome;
    }

    public void setTotleExploreOrderIncome(Double totleExploreOrderIncome) {
        this.totleExploreOrderIncome = totleExploreOrderIncome;
    }

    public Integer getTotleNormalOrderCount() {
        return totleNormalOrderCount;
    }

    public void setTotleNormalOrderCount(Integer totleNormalOrderCount) {
        this.totleNormalOrderCount = totleNormalOrderCount;
    }

    public Integer getTotleTourOrderCount() {
        return totleTourOrderCount;
    }

    public void setTotleTourOrderCount(Integer totleTourOrderCount) {
        this.totleTourOrderCount = totleTourOrderCount;
    }

    public Integer getTotleExploreOrderCount() {
        return totleExploreOrderCount;
    }

    public void setTotleExploreOrderCount(Integer totleExploreOrderCount) {
        this.totleExploreOrderCount = totleExploreOrderCount;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Mining [id=" + id + ", pv=" + pv + ", uv=" + uv + ", totleIncome=" + totleIncome + ", buyCount="
                + buyCount + ", newDeviceCount=" + newDeviceCount + ", newRegisterCount=" + newRegisterCount
                + ", totleNormalOrderIncome=" + totleNormalOrderIncome + ", totleTourOrderIncome="
                + totleTourOrderIncome + ", totleExploreOrderIncome=" + totleExploreOrderIncome
                + ", totleNormalOrderCount=" + totleNormalOrderCount + ", totleTourOrderCount=" + totleTourOrderCount
                + ", totleExploreOrderCount=" + totleExploreOrderCount + "]";
    }

}
