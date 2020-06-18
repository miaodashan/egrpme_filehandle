package com.tospur.egrpme.service;

import com.tospur.egrpme.dao.MediaShowDao;
import com.tospur.egrpme.model.MediaShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaShowServiceImpl implements  MediaShowService{

    @Autowired
    private MediaShowDao mediaShowDao;
    @Override
    public List<MediaShow> findAll(Integer nowpage,Integer pagesize) {
        List<MediaShow> dataList = mediaShowDao.findAll(nowpage*pagesize, pagesize);
        if (dataList!=null&&!dataList.isEmpty()){
            return dataList;
        }
        return null;
    }
}
