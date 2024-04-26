package com.ruoyi.system.domain;



public class GccPeriodDetail {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 站点id
     */
    private Long stationId;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
    /**
     * 站点编码
     */
    private String stationCode;

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
    /**
     * 月份
     */
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    /**
     * 时间戳
     */
    private Long oTime;

    public Long getOTime() {
        return oTime;
    }

    public void setOTime(Long oTime) {
        this.oTime = oTime;
    }
    /**
     * 开始时段，如00:00:00
     */
    private String periodTime;

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }
    /**
     * 订单数
     */
    private Integer chargeNum;

    public Integer getChargeNum() {
        return chargeNum;
    }

    public void setChargeNum(Integer chargeNum) {
        this.chargeNum = chargeNum;
    }
    /**
     * 售电量
     */
    private Double cdzElectric;

    public Double getCdzElectric() {
        return cdzElectric;
    }

    public void setCdzElectric(Double cdzElectric) {
        this.cdzElectric = cdzElectric;
    }
    /**
     * 收入
     */
    private Double totalSaleFee;

    public Double getTotalSaleFee() {
        return totalSaleFee;
    }

    public void setTotalSaleFee(Double totalSaleFee) {
        this.totalSaleFee = totalSaleFee;
    }
    /**
     * 购电量
     */
    private Double useElectric;

    public Double getUseElectric() {
        return useElectric;
    }

    public void setUseElectric(Double useElectric) {
        this.useElectric = useElectric;
    }
    /**
     * bms充电量
     */
    private Double bmsElectric;

    public Double getBmsElectric() {
        return bmsElectric;
    }

    public void setBmsElectric(Double bmsElectric) {
        this.bmsElectric = bmsElectric;
    }
    /**
     * bms放电量
     */
    private Double bmsDiselectric;

    public Double getBmsDiselectric() {
        return bmsDiselectric;
    }

    public void setBmsDiselectric(Double bmsDiselectric) {
        this.bmsDiselectric = bmsDiselectric;
    }
    /**
     * 光伏发电量
     */
    private Double gfElectric;

    public Double getGfElectric() {
        return gfElectric;
    }

    public void setGfElectric(Double gfElectric) {
        this.gfElectric = gfElectric;
    }
    /**
     * 购电费
     */
    private Double useElectricFee;

    public Double getUseElectricFee() {
        return useElectricFee;
    }

    public void setUseElectricFee(Double useElectricFee) {
        this.useElectricFee = useElectricFee;
    }
    /**
     * 储能充电结费
     */
    private Double bmsElectricFee;

    public Double getBmsElectricFee() {
        return bmsElectricFee;
    }

    public void setBmsElectricFee(Double bmsElectricFee) {
        this.bmsElectricFee = bmsElectricFee;
    }
    /**
     * 储能放电结费
     */
    private Double bmsDiselectricFee;

    public Double getBmsDiselectricFee() {
        return bmsDiselectricFee;
    }

    public void setBmsDiselectricFee(Double bmsDiselectricFee) {
        this.bmsDiselectricFee = bmsDiselectricFee;
    }
    /**
     * 储能收益
     */
    private Double bmsProfit;

    public Double getBmsProfit() {
        return bmsProfit;
    }

    public void setBmsProfit(Double bmsProfit) {
        this.bmsProfit = bmsProfit;
    }
    /**
     * 光伏发电结费
     */
    private Double gfElectricFee;

    public Double getGfElectricFee() {
        return gfElectricFee;
    }

    public void setGfElectricFee(Double gfElectricFee) {
        this.gfElectricFee = gfElectricFee;
    }
    /**
     * 峰谷类型
     */
    private Integer peakValleyType;

    public Integer getPeakValleyType() {
        return peakValleyType;
    }

    public void setPeakValleyType(Integer peakValleyType) {
        this.peakValleyType = peakValleyType;
    }
    public GccPeriodDetail() {}
}
