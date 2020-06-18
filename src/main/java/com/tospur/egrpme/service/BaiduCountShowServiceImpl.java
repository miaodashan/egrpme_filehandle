package com.tospur.egrpme.service;

import com.tospur.egrpme.dao.BaiduCountShowDao;
import com.tospur.egrpme.model.BaiduCountShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaiduCountShowServiceImpl implements  BaiduCountShowService{

    @Autowired
    private BaiduCountShowDao baiduCountShowDao;
    @Override
    public List<BaiduCountShow> findAll(Integer nowpage,Integer pagesize) {
        List<BaiduCountShow> dataList = baiduCountShowDao.findAll(nowpage*pagesize, pagesize);
        if (dataList!=null&&!dataList.isEmpty()){
            return dataList;
        }
        return null;
    }
}
