package com.tospur.egrpme.service;

import com.tospur.egrpme.dao.BatchHandleDao;
import com.tospur.egrpme.model.BatchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BatchHandleServiceImpl implements BatchHandleService {
    @Autowired
    private BatchHandleDao batchHandleDao;

    @Override
    public boolean deleteBatch(String batch, Integer type) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("batch",batch);
        map.put("type",type);
        int i = batchHandleDao.deleteBatch(map);
        return i != 0;
    }

    @Override
    public List<BatchData> findBatchByBatch(String batch, Integer type) {
        List<BatchData> dataList = batchHandleDao.findBatchByBatch(batch, type);
        if (dataList != null && !dataList.isEmpty()){
            return dataList;
        }
        return null;
    }
}
