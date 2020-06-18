package com.tospur.egrpme.service;

import com.tospur.egrpme.dao.ErrorDataDao;
import com.tospur.egrpme.model.ErrorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorDataServiceImpl implements ErrorDataService {

    @Autowired
    private ErrorDataDao errorDataDao;
    @Override
    public List<ErrorData> findErrorData(Integer type) {
        List<ErrorData> dataList = errorDataDao.findErrorData(type);
        if (dataList!=null&&!dataList.isEmpty()){
            return dataList;
        }
        return null;
    }
}
