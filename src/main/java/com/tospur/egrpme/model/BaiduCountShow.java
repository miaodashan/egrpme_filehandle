package com.tospur.egrpme.model;



public class BaiduCountShow {

    public String importBatch;
    public String lDate;
    public String hmplCode;
    public String pv;
    public String uv;
    public String ipCount;
    public String bounceRate;
    public String avgVisitTime;
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

    public String getHmplCode() {
        return hmplCode;
    }

    public void setHmplCode(String hmplCode) {
        this.hmplCode = hmplCode;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getIpCount() {
        return ipCount;
    }

    public void setIpCount(String ipCount) {
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "BaiduCountShow{" +
                "importBatch='" + importBatch + '\'' +
                ", lDate='" + lDate + '\'' +
                ", hmplCode='" + hmplCode + '\'' +
                ", pv='" + pv + '\'' +
                ", uv='" + uv + '\'' +
                ", ipCount='" + ipCount + '\'' +
                ", bounceRate='" + bounceRate + '\'' +
                ", avgVisitTime='" + avgVisitTime + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
