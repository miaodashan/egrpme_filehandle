package com.tospur.egrpme.dao;

import com.tospur.egrpme.model.MediaShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MediaShowDao {
    List<MediaShow> findAll(@Param("nowpage")Integer starpage, @Param("pagesize")Integer pagesize);
}
