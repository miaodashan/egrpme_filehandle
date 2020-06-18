package com.tospur.egrpme.dao;

import com.tospur.egrpme.model.BatchData;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface BatchHandleDao {

    /**
     * 根据批次删除
     * @param map 批次号+类型
     * */
    int deleteBatch(HashMap<String, Object> map);

    /**
     * 根据批次查询
     * */
    List<BatchData> findBatchByBatch(@Param("batch") String batch, @Param("type") Integer type);
}

