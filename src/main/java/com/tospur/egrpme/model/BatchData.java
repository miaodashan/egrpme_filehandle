package com.tospur.egrpme.model;

/**
 * 百度统计、媒体数据、hmpl code
 * */

public class BatchData {
    /**导入批次* */
    private String importBatch;
    /**日期*/
    private String lDate;
    /**媒体*/
    private String mediaSource;
    /**账户*/
    private String account;
    /**推广计划*/
    private String promotionPlan;
    /**推广单元*/
    private String promotionUnit;
    /**关键词*/
    private String keyword;
    /**展现次数*/
    private Integer showCount;
    /**点击次数*/
    private Integer clickCount;
    /**折扣前金额*/
    private Double beforeDiscountPrice;
    /**金额折扣*/
    private Double discountPrice;
    /**实际消费金额*/
    private Double actConsumePrice;
    /**点击率*/
    private String clickRate;
    /**平均点击价格*/
    private Double avgClickPrice;
    /**操作时间*/
    private String operateTime;
    /**操作者*/
    private String operator;
    /**hmpl code*/
    private String hmplCode;
    /**浏览量*/
    private Integer pv;
    /**访客数*/
    private Integer uv;
    /**ip数*/
    private Integer ipCount;
    /**总跳出率*/
    private String bounceRate;
    /**平均访问时长*/
    private String avgVisitTime;

    public BatchData() {
    }

    public String getImportBatch() {
        return importBatch;
    }

    public void setImportBatch(String importBatch) {
        this.importBatch = importBatch;
    }

    public String getlDate() {
        return lDate;
    }

    public void setlDate(String lDate) {
        this.lDate = lDate;
    }

    public String getMediaSource() {
        return mediaSource;
    }

    public void setMediaSource(String mediaSource) {
        this.mediaSource = mediaSource;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPromotionPlan() {
        return promotionPlan;
    }

    public void setPromotionPlan(String promotionPlan) {
        this.promotionPlan = promotionPlan;
    }

    public String getPromotionUnit() {
        return promotionUnit;
    }

    public void setPromotionUnit(String promotionUnit) {
        this.promotionUnit = promotionUnit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Double getBeforeDiscountPrice() {
        return beforeDiscountPrice;
    }

    public void setBeforeDiscountPrice(Double beforeDiscountPrice) {
        this.beforeDiscountPrice = beforeDiscountPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Double getActConsumePrice() {
        return actConsumePrice;
    }

    public void setActConsumePrice(Double actConsumePrice) {
        this.actConsumePrice = actConsumePrice;
    }

    public String getClickRate() {
        return clickRate;
    }

    public void setClickRate(String clickRate) {
        this.clickRate = clickRate;
    }

    public Double getAvgClickPrice() {
        return avgClickPrice;
    }

    public void setAvgClickPrice(Double avgClickPrice) {
        this.avgClickPrice = avgClickPrice;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getHmplCode() {
        return hmplCode;
    }

    public void setHmplCode(String hmplCode) {
        this.hmplCode = hmplCode;
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

    public Integer getIpCount() {
        return ipCount;
    }

    public void setIpCount(Integer ipCount) {
        this.ipCount = ipCount;
    }

    public String getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(String bounceRate) {
        this.bounceRate = bounceRate;
    }

    public String getAvgVisitTime() {
        return avgVisitTime;
    }

    public void setAvgVisitTime(String avgVisitTime) {
        this.avgVisitTime = avgVisitTime;
    }

    @Override
    public String toString() {
        return "BatchData{" +
                "importBatch='" + importBatch + '\'' +
                ", lDate='" + lDate + '\'' +
                ", mediaSource='" + mediaSource + '\'' +
                ", account='" + account + '\'' +
                ", promotionPlan='" + promotionPlan + '\'' +
                ", promotionUnit='" + promotionUnit + '\'' +
                ", keyword='" + keyword + '\'' +
                ", showCount=" + showCount +
                ", clickCount=" + clickCount +
                ", beforeDiscountPrice=" + beforeDiscountPrice +
                ", discountPrice=" + discountPrice +
                ", actConsumePrice=" + actConsumePrice +
                ", clickRate='" + clickRate + '\'' +
                ", avgClickPrice=" + avgClickPrice +
                ", operateTime='" + operateTime + '\'' +
                ", operator='" + operator + '\'' +
                ", hmplCode='" + hmplCode + '\'' +
                ", pv=" + pv +
                ", uv=" + uv +
                ", ipCount=" + ipCount +
                ", bounceRate='" + bounceRate + '\'' +
                ", avgVisitTime='" + avgVisitTime + '\'' +
                '}';
    }
}
