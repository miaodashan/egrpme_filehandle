package com.tospur.egrpme.model;

public class HmplCodeShow {
    public String importBatch;
    public String lDate;
    public String mediaSource;
    public String account;
    public String promotionPlan;
    public String promotionUnit;
    public String keywork;
    public String hmplCode;
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

    public String getHmplCode() {
        return hmplCode;
    }

    public void setHmplCode(String hmplCode) {
        this.hmplCode = hmplCode;
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
        return "HmplCodeShow{" +
                "importBatch='" + importBatch + '\'' +
                ", lDate='" + lDate + '\'' +
                ", mediaSource='" + mediaSource + '\'' +
                ", account='" + account + '\'' +
                ", promotionPlan='" + promotionPlan + '\'' +
                ", promotionUnit='" + promotionUnit + '\'' +
                ", keywork='" + keywork + '\'' +
                ", hmplCode='" + hmplCode + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
