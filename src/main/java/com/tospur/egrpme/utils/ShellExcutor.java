package com.tospur.egrpme.utils;

import com.tospur.egrpme.config.PropertiesConfig;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class ShellExcutor {
    private static Logger log = LoggerFactory.getLogger("shell_logger");
    /**
     * Java执行shell脚本入口
     * @throws Exception
     */
    public static List<String> service(String name) throws Exception{
        String shellDir = "";
        String shellPath = "";
        String shellname="";
        List<String> relist=new ArrayList<>();
        try {
            //获取脚本所在的目录
            //String configFilePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
            String configFilePath= PropertiesConfig.readData("null",name);
            File f = new File(configFilePath);
            shellDir = f.getParent();
            shellname=f.getName();
            log.info("shell dir = " + shellDir);
            System.out.println("configFilePath"+configFilePath);
            //拼接完整的脚本目录
            shellPath = shellDir +"/"+shellname;
            log.info("shell path = " + shellPath);
            System.out.println("文件路径"+shellPath);
            //执行脚本
            relist= runShell(shellPath);

        } catch (Exception e) {
            log.error("ShellExcutor异常" + e.getMessage(), e);
            throw e;
        }
        return relist;
    }

    public static void serviceshell(String name) throws Exception{
        String shellDir = "";
        String shellPath = "";
        String shellname="";
        List<String> relist=new ArrayList<>();
        try {
            //获取脚本所在的目录
            //String configFilePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
            String configFilePath= PropertiesConfig.readData("null",name);
            File f = new File(configFilePath);
            shellDir = f.getParent();
            shellname=f.getName();
            log.info("shell dir = " + shellDir);
            System.out.println("configFilePath"+configFilePath);
            //拼接完整的脚本目录
            shellPath = shellDir +"/"+shellname;
            log.info("shell path = " + shellPath);
            System.out.println("文件路径"+shellPath);
            //执行脚本
            String shellfile=PropertiesConfig.readData(null,shellPath);
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.exec("import os; ");
            interpreter.exec("os.system('"+shellfile+"'); ");

        } catch (Exception e) {
            log.error("ShellExcutor异常" + e.getMessage(), e);
            throw e;
        }
    }
    /**
     * 运行shell脚本
     * @param shell 需要运行的shell脚本
     */
    public static void execShell(String shell){
        try {
            Runtime.getRuntime().exec(shell);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行shell脚本 new String[]方式
     * @param shell 需要运行的shell脚本
     */
    public static void execShellBin(String shell){
        try {
            Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shell},null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 运行shell并获得结果，注意：如果sh中含有awk,一定要按new String[]{"/bin/sh","-c",shStr}写,才可以获得流
     *
     * @param shStr
     *            需要执行的shell
     * @return
     */
    public static List<String> runShell(String shStr) {
        List<String> strList = new ArrayList<String>();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            process.waitFor();
            while ((line = input.readLine()) != null){
                strList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strList;
    }

    public static boolean  Scanshell(String pathname){
        String pathshe="ps -ef | grep "+pathname.substring(0,pathname.length()-3);
        List<String> strList = new ArrayList<String>();
        boolean res=false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",pathshe},null,null);
                InputStreamReader ir = new InputStreamReader(process.getInputStream());
                LineNumberReader input = new LineNumberReader(ir);
                String line;
                process.waitFor();
                while ((line = input.readLine()) != null){
                    strList.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (String str:strList) {
                if(!str.contains(pathname)){
                    res=true;
                }
            }
            if(res){
                break;
            }
        }
        return res;
    }
}
