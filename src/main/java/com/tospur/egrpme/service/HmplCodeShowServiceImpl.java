package com.tospur.egrpme.service;

import com.tospur.egrpme.dao.HmplCodeShowDao;
import com.tospur.egrpme.dao.MediaShowDao;
import com.tospur.egrpme.model.HmplCodeShow;
import com.tospur.egrpme.model.MediaShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HmplCodeShowServiceImpl implements  HmplCodeShowService{

    @Autowired
    private HmplCodeShowDao hmplCodeShowDao;
    @Override
    public List<HmplCodeShow> findAll(Integer nowpage,Integer pagesize) {
        List<HmplCodeShow> dataList = hmplCodeShowDao.findAll(nowpage*pagesize,pagesize);
        if (dataList!=null&&!dataList.isEmpty()){
            return dataList;
        }
        return null;
    }
}
