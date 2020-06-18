package com.tospur.egrpme.dao;


import com.tospur.egrpme.model.BaiduCountShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaiduCountShowDao {
    List<BaiduCountShow> findAll(@Param("nowpage")Integer starpage, @Param("pagesize")Integer pagesize);
}
