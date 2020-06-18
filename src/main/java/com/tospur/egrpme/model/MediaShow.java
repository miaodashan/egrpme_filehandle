package com.tospur.egrpme.model;

public class MediaShow {
    public String importBatch;
    public String lDate;
    public String mediaSource;
    public String account;
    public String promotionPlan;
    public String promotionUnit;
    public String keywork;
    public String showCount;
    public String click_count;
    public String before_discount_price;
    public String discount_price;
    public String act_consume_Price;
    public String click_rate;
    public String avg_click_price;
    public String operateTime;
    public String operator;

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

    public String getKeywork() {
        return keywork;
    }

    public void setKeywork(String keywork) {
        this.keywork = keywork;
    }

    public String getShowCount() {
        return showCount;
    }

    public void setShowCount(String showCount) {
        this.showCount = showCount;
    }

    public String getClick_count() {
        return click_count;
    }

    public void setClick_count(String click_count) {
        this.click_count = click_count;
    }

    public String getBefore_discount_price() {
        return before_discount_price;
    }

    public void setBefore_discount_price(String before_discount_price) {
        this.before_discount_price = before_discount_price;
    }

    public String getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(String discount_price) {
        this.discount_price = discount_price;
    }

    public String getAct_consume_Price() {
        return act_consume_Price;
    }

    public void setAct_consume_Price(String act_consume_Price) {
        this.act_consume_Price = act_consume_Price;
    }

    public String getClick_rate() {
        return click_rate;
    }

    public void setClick_rate(String click_rate) {
        this.click_rate = click_rate;
    }

    public String getAvg_click_price() {
        return avg_click_price;
    }

    public void setAvg_click_price(String avg_click_price) {
        this.avg_click_price = avg_click_price;
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

    @Override
    public String toString() {
        return "MediaShow{" +
                "importBatch='" + importBatch + '\'' +
                ", lDate='" + lDate + '\'' +
                ", mediaSource='" + mediaSource + '\'' +
                ", account='" + account + '\'' +
                ", promotionPlan='" + promotionPlan + '\'' +
                ", promotionUnit='" + promotionUnit + '\'' +
                ", keywork='" + keywork + '\'' +
                ", showCount='" + showCount + '\'' +
                ", click_count='" + click_count + '\'' +
                ", before_discount_price='" + before_discount_price + '\'' +
                ", discount_price='" + discount_price + '\'' +
                ", act_consume_Price='" + act_consume_Price + '\'' +
                ", click_rate='" + click_rate + '\'' +
                ", avg_click_price='" + avg_click_price + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
