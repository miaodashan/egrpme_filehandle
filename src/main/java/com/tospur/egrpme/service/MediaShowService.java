package com.tospur.egrpme.service;

import com.tospur.egrpme.model.MediaShow;

import java.util.List;

public interface MediaShowService {
    List<MediaShow> findAll(Integer nowpage,Integer pagesize);
}
