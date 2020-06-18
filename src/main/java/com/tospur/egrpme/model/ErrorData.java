package com.tospur.egrpme.model;

public class ErrorData {
    private int rowNum;
    private String errorContent;

    public ErrorData() {
    }

    public ErrorData(int rowNum, String errorContent) {
        this.rowNum = rowNum;
        this.errorContent = errorContent;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getErrorContent() {
        return errorContent;
    }

    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent;
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "rowNum=" + rowNum +
                ", errorContent='" + errorContent + '\'' +
                '}';
    }
}
