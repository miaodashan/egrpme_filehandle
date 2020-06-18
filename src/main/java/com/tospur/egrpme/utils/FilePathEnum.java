package com.tospur.egrpme.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum FilePathEnum {
    PATH_1("/data/specific_advertising_trace"),
    PATH_2("/data/mediadata"),
    PATH_3("/data/hmplcode");
    private String path;
    private static final Logger logger = LoggerFactory.getLogger(FilePathEnum.class);
    private FilePathEnum(String path) {
        this.path = path;
    }
    private String getPath(){
        return path;
    }
    public static String getPath(Integer i){
        try {
            return FilePathEnum.valueOf("PATH_" + i).getPath();
        } catch (Exception e){
            logger.error("获取文件保存路径异常");
            return null;
        }
    }
}