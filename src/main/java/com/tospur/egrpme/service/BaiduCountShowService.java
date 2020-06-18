package com.tospur.egrpme.service;

import com.tospur.egrpme.model.BaiduCountShow;

import java.util.List;

public interface BaiduCountShowService {
    List<BaiduCountShow> findAll(Integer nowpage,Integer pagesize);
}
