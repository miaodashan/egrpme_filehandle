package com.tospur.egrpme.controller;

import com.alibaba.fastjson.JSONObject;
import com.tospur.egrpme.config.PropertiesConfig;
import com.tospur.egrpme.model.BaiduCountShow;
import com.tospur.egrpme.model.ErrorData;
import com.tospur.egrpme.model.HmplCodeShow;
import com.tospur.egrpme.model.MediaShow;
import com.tospur.egrpme.service.BaiduCountShowService;
import com.tospur.egrpme.service.ErrorDataService;
import com.tospur.egrpme.service.HmplCodeShowService;
import com.tospur.egrpme.service.MediaShowService;
import com.tospur.egrpme.utils.ExportExcel;
import com.tospur.egrpme.utils.FilePathEnum;
import com.tospur.egrpme.utils.ShellExcutor;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 文件处理
 * */
@Controller
@CrossOrigin
public class FileHandleController {
    private static final Logger logger = LoggerFactory.getLogger(FileHandleController.class);
    @Autowired
    private ErrorDataService errorDataService;
    /**
     * 文件上传
     * @param type 上传的文件类别
     * @param uploadLog 是否覆盖上传
     * */
    @RequestMapping("/fileImport")
    @ResponseBody
        public String fileImport(MultipartFile excelFile,Integer type,Integer uploadLog,String operator) throws Exception{
        logger.info("获取文件上传路径");
        String path = FilePathEnum.getPath(type);
        File file =new File(path);
        if  (!file .exists()  && !file .isDirectory())
        {
            System.out.println("//file isnot exists");
            file .mkdirs();
        } else
        {
            System.out.println("//file is exists");
        }
        String str="上传成功";
        Map<String,Object> msgMap = new HashMap<>();
        if (excelFile != null){
            String filefullname = excelFile.getOriginalFilename();
            String []filename=filefullname.split("\\.");

            File newFile = new File(path  +File.separator + filename[0]+".csv");
            if (newFile.exists() && uploadLog == 0){
                str="文件已存在，上传失败";
                msgMap.put("msg",str);
                JSONObject jsonObject = new JSONObject(msgMap);
                return jsonObject.toJSONString();
            }
            excelFile.transferTo(newFile);
            //存储时间戳
            String stamptype="newstample"+type+operator;
            Date date=new Date();
            String stampDate=Long.toString(date.getTime())+type+operator;
            System.out.println(stampDate);
            PropertiesConfig.writeData(null,stamptype,stampDate);
        }
        msgMap.put("msg",str);
        JSONObject jsonObject = new JSONObject(msgMap);
        return jsonObject.toJSONString();
    }
    /**
     * 执行脚本sh方法
     * 时间戳+操作用户限制
     * */
    @RequestMapping(value="/ExShell",method= RequestMethod.GET)
    @ResponseBody
    public void ExcShell( String pathname, String operator,HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("执行shell脚本");
        System.out.println("执行shell脚本");
        //判断时间戳是否CSV文件更新
        String[]stampdate={"newstample1","newstample2","newstample3"};
        String[]oldstampdate={"oldstample1","oldstample2","oldstample3"};
        List<String>newdate=new ArrayList<String>();
        List<String>updatedate=new ArrayList<String>();
        for (String str:stampdate) {
            newdate.add(PropertiesConfig.readData(null,str.toString()+operator));
        }
        for (String str:oldstampdate) {
            if(PropertiesConfig.readData(null,str.toString()+operator)==null){
                updatedate.add(str.toString()+operator);
            }else{
                updatedate.add(PropertiesConfig.readData(null,str.toString()+operator));
            }
        }
        boolean res=false;
            for(int i=0;i<3;i++){
                if(newdate.get(i)!=null&&updatedate.get(i)!=null){
                    if(!newdate.get(i).toString().equals(updatedate.get(i).toString())) {
                        res=true;
                        break;
                    }
                }else if(newdate.get(i)!=null&&updatedate.get(i)==null){
                    res=true;
                    break;
                }
            }
            boolean ress=false;
        if(res){
            for (int i=0;i<stampdate.length;i++) {
                if(newdate.get(i)!=null){
                    PropertiesConfig.writeData(null,oldstampdate[i]+operator,newdate.get(i));
                }
            }
            logger.info("执行shell脚本");
            String shellfile=PropertiesConfig.readData(null,pathname);
            String dsd=shellfile+"\t"+operator;
            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.exec("import os; ");
            Thread.sleep(500);
            interpreter.exec("os.system('"+dsd+"'); ");
            //检验脚本执行结果
            Thread.sleep(1000);
            File files=new File(shellfile);
            String pathshe=files.getName();
            boolean re=ShellExcutor.Scanshell(pathshe);
            ress=true;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(ress);
    }


    /**
     * 执行脚本sh
     * 传参：operator（操作者），uploadLog（执行文件类型）
     * */
    @RequestMapping(value="/ExecuteShell",method= RequestMethod.GET)
    @ResponseBody
    public void ExecuteShell( String pathname, Integer uploadLog, Integer type,String operator,HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("执行shell脚本");
        if(pathname.equals("baidupath")){
            ShellExcutor.service("toutfbaidu");
        };
        if(pathname.equals("mediapath")){
            ShellExcutor.service("toutfmedia");
        };
        if(pathname.equals("hmplpath")){
            ShellExcutor.service("toutfhmpl");
        };

        List<ErrorData>relistErr=new ArrayList<>();
        Thread.sleep(2000);
        String shellfile=PropertiesConfig.readData(null,pathname);
        /*String as[] = new String[operator.length()];
        String sb = "";
        for (int i = 0; i < operator.length(); i++) {
        as[i] = Integer.toHexString(operator.charAt(i) & 0xffff);
            sb = sb + "\\u" + as[i];
        }*/
        String dsd=shellfile+"\t"+operator+"\t"+uploadLog;
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import os; ");
        Thread.sleep(500);
        interpreter.exec("os.system('"+dsd+"'); ");
        //检验脚本执行结果
        Thread.sleep(1000);
        File files=new File(shellfile);
        String pathshe=files.getName();
        boolean re=ShellExcutor.Scanshell(pathshe);

        if(re){
            response.setContentType("text/html;charset=UTF-8");
            if(pathname.equals("baidupath")){
                relistErr=this.getErrorData(type);
                if(relistErr!=null){
                    response.getWriter().print(relistErr);
                }else{
                    List<BaiduCountShow>list= baiduCountShowService.findAll(0,10);
                    if(list!=null){
                        response.getWriter().print(list);
                    }
                }
            }
            if(pathname.equals("mediapath")){
                relistErr=this.getErrorData(type);
                if(relistErr!=null){
                    response.getWriter().print(relistErr);
                }else{
                    List<MediaShow>list= mediaShowService.findAll(0,10);
                    if(list!=null){
                        response.getWriter().print(mediaShowService.findAll(0,10));
                    }
                }
            }
            if(pathname.equals("hmplpath")){
                relistErr=this.getErrorData(type);
                if(relistErr!=null){
                    response.getWriter().print(relistErr);
                }else{
                    List<HmplCodeShow>list= hmplCodeShowService.findAll(0,10);
                    if(list!=null){
                        response.getWriter().print(list);
                    }
                }
            }
            if(pathname.equals("ttwhi")){
                response.getWriter().print("测试成功");
            }
        }else {
            response.getWriter().print(re);
        }
    }

    /**
     * 测试执行脚本sh1
     * */
    @RequestMapping(value="/testshell",method= RequestMethod.GET)
    @ResponseBody
    public void Shell( String pathname,String operator, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("执行shell脚本");
        String shellfile=PropertiesConfig.readData(null,pathname);
        String as[] = new String[operator.length()];
        String sb = "";
        for (int i = 0; i < operator.length(); i++) {
            as[i] = Integer.toHexString(operator.charAt(i) & 0xffff);
            sb = sb + "\\u" + as[i];
        }

        String dsd=shellfile+"\t"+sb;
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import os; ");
        interpreter.exec("os.system('"+dsd+"'); ");

        Thread.sleep(30000);
    }

    /**
     * 测试配置文件读写+执行sh
     * */
    @RequestMapping(value="/test",method= RequestMethod.GET)
    @ResponseBody
    public void Shelltest( String pathname, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("配置文件读写");
        String shellfile=PropertiesConfig.readData(null,pathname);
        logger.info("执行sh脚本");
        ShellExcutor.service(pathname);
    }

    /**
     * @param pathkey 配置名
     * @param pathname 配置数据
     *修改config配置数据
     * */
    @RequestMapping(value="/config",method= RequestMethod.GET)
    @ResponseBody
    public void configUpdate( String pathkey, String pathname, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("修改配置数据");
        boolean res=false;
        try{
            PropertiesConfig.writeData(null,pathkey,pathname);
            res=true;
        }catch (Exception e){
            logger.info(e.getLocalizedMessage());
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(res);
    }

    /**
     * 读取配置文件
     * */
    @RequestMapping(value="/configRead",method= RequestMethod.GET)
    @ResponseBody
    public void configRead( String pathkey, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info("读取配置数据");

         String res=   PropertiesConfig.readData(null,pathkey);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(res);
    }

    @Autowired
    private BaiduCountShowService baiduCountShowService;

    /**
     * 获取百度数据
     * */
    @RequestMapping("/getBaiduShow")
    @ResponseBody
    public List<BaiduCountShow>getBaiduShow(  Integer nowpage, Integer pagesize,HttpServletRequest request, HttpServletResponse response){
        if(nowpage==null){
            nowpage=0;
        }
        if(pagesize==null){
            pagesize=10;
        }
        List<BaiduCountShow>baidulist=baiduCountShowService.findAll( nowpage, pagesize);

        try {
            response.setContentType("text/html;charset=UTF-8");
            if(baidulist!=null){
                response.getWriter().print(baidulist.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    private MediaShowService mediaShowService;
    /**
     * 获取Media数据
     * */
    @RequestMapping("/getMediaShow")
    @ResponseBody
    public List<MediaShow>getMediaShow( Integer nowpage, Integer pagesize,HttpServletRequest request,HttpServletResponse response){
        if(nowpage==null){
            nowpage=0;
        }
        if(pagesize==null){
            pagesize=10;
        }
        List<MediaShow>mediaShowList=mediaShowService.findAll( nowpage, pagesize);

        try {
            response.setContentType("text/html;charset=UTF-8");
            if(mediaShowList!=null){
                response.getWriter().println(mediaShowList.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    private HmplCodeShowService hmplCodeShowService;
    /**
     * 获取HmplCodeShow数据
     * */
    @RequestMapping("/getHmplCodeShow")
    @ResponseBody
    public List<HmplCodeShow>getHmplCodeShow( Integer nowpage, Integer pagesize,  HttpServletRequest request, HttpServletResponse response){
        if(nowpage==null){
            nowpage=0;
        }
        if(pagesize==null){
            pagesize=10;
        }
        List<HmplCodeShow> hmplCodeShowList =hmplCodeShowService.findAll(nowpage,pagesize);
        try {
            response.setContentType("text/html;charset=UTF-8");
                  if(hmplCodeShowList!=null){
                      response.getWriter().println(hmplCodeShowList.toString());
                  }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 返回错误提示数据
     * */
    @RequestMapping("/getErrorData")
    @ResponseBody
    public List<ErrorData> getErrorData(Integer type)throws Exception{
        return errorDataService.findErrorData(type);
    }

    /**
     * 下载错误提示文件
     * */
    @RequestMapping(value="/downloadErrorExcel")
    public void downloadErrorExcel(Integer type,HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        List<ErrorData> dataList = errorDataService.findErrorData(type);
        if (dataList != null) {
            Map<String, String> titleMap = new HashMap<>();
            titleMap.put("rowNum", "行数");
            titleMap.put("errorContent", "错误内容");
            String sheetName = "错误信息";
            String fileName = ExportExcel.excelExport(dataList, titleMap, sheetName, os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + ExportExcel.encodeFileName(fileName, request));
            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        }
    }

    /**
     * 下载模板文件
     * */
    @RequestMapping(value = "/downloadMouldFile",method = RequestMethod.GET)
    public void downloadMouldFile(Integer type,HttpServletRequest request,HttpServletResponse response)throws Exception{
        String dataDirectory = request.
                getServletContext().getRealPath("/WEB-INF/mouldFile/");
        File file = new File(dataDirectory, "mould.7z");
        if (file.exists()) {
            //设置响应类型，这里是下载zip文件
            response.setContentType("application/zip");
            //设置Content-Disposition，设置attachment，浏览器会激活文件下载框；filename指定下载后默认保存的文件名
            //不设置Content-Disposition的话，文件会在浏览器内打开，比如txt、img文件
            response.addHeader("Content-Disposition",
                    "attachment; filename=mould.7z");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            // if using Java 7, use try-with-resources

            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            bis.close();
            fis.close();
        }
    }



}
