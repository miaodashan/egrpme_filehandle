package com.tospur.egrpme.service;

import com.tospur.egrpme.model.BatchData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BatchHandleService {

    /**
     * 根据批次删除
     * @param type 类型
     * @param batch 批次号
     * */
    boolean deleteBatch(String batch, Integer type);

    /**
     * 根据批次查询
     * @param type 类型
     * @param batch 批次
     * */
    List<BatchData> findBatchByBatch(String batch, Integer type);
}

