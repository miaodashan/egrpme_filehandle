package com.tospur.egrpme.dao;

import com.tospur.egrpme.model.HmplCodeShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HmplCodeShowDao {
    List<HmplCodeShow> findAll(@Param("nowpage")Integer starpage, @Param("pagesize")Integer pagesize);
}
