package com.tospur.egrpme.config;

import java.io.*;
import java.util.Properties;

public class PropertiesConfig {
    /**
     * 根据KEY，读取文件对应的值
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
     * @param key 键
     * @return key对应的值
     */
    public static String readData(String filePath, String key) {
        //获取绝对路径
        //filePath = "./src/main/resources/config.properties";
        String apath = PropertiesConfig.class.getResource("/config.properties").getPath();
        System.out.println(apath);
        filePath=apath;
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            in.close();
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 修改或添加键值对 如果key存在，修改, 反之，添加。
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
     * @param key 键
     * @param value 键对应的值
     */
    public static void writeData(String filePath, String key, String value) {
        //获取绝对路径
        //filePath = "src/main/resources/config.properties";
        String apath = PropertiesConfig.class.getResource("/config.properties").getPath();
      //  System.out.println(apath)
        //filePath="/usr/local/apache-tomcat-9.0.35/webapps/egrpme_filehandle/WEB-INF/classes";
        filePath=apath;
        Properties prop = new Properties();
        try {
            File file = new File(filePath);
            if (!file.exists())
                file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(filePath);
            prop.setProperty(key, value);

            //保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
            fos.close();
        } catch (IOException e) {
            System.err.println("Visit " + filePath + " for updating " + value + " value error");
        }
    }

   public static void main(String[] args) {
        //System.out.println(PropertiesConfig.readData("config.properties", "shellpath"));

       PropertiesConfig.writeData("config.properties", "portsdasd", "125");
    }
}
