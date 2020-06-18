package com.tospur.egrpme.controller;

import com.alibaba.fastjson.JSONObject;
import com.tospur.egrpme.model.BatchData;
import com.tospur.egrpme.service.BatchHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批次处理
 * */
@Controller
@CrossOrigin
public class BatchController {

    @Autowired
    private BatchHandleService batchHandleService;


    /**
     * 根据批次号模糊查询批次
     * @param batch 批次号
     * @param type 类型
     * */
    @RequestMapping(value = "/getBatchByBatch",method = RequestMethod.POST)
    @ResponseBody
    public String getBatchByBatch(String batch, Integer type)throws Exception{
        Map<String,Object> map = new HashMap<>();
        List<BatchData> batchData = batchHandleService.findBatchByBatch(batch, type);
        map.put("dataList",batchData);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toJSONString();
    }


    /**
     * 根据批次号删除批次
     * @param batch 批次号
     * @param type 类型
     * */
    @RequestMapping(value = "/delBatchByBatch",method = RequestMethod.POST)
    @ResponseBody
    public String delBatchByBatch(String batch,Integer type)throws Exception{
        Map<String,Object> map = new HashMap<>();
        if (batchHandleService.deleteBatch(batch, type)){
            map.put("msg","删除成功");
            JSONObject jsonObject = new JSONObject(map);
            return jsonObject.toJSONString();
        }
        map.put("msg","删除失败");
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toJSONString();
    }
}
