package com.tospur.egrpme.service;

import com.tospur.egrpme.model.HmplCodeShow;

import java.util.List;

public interface HmplCodeShowService {
    List<HmplCodeShow> findAll(Integer nowpage,Integer pagesize);
}
