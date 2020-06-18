package com.tospur.egrpme.dao;


import com.tospur.egrpme.model.ErrorData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErrorDataDao {
    List<ErrorData> findErrorData(@Param("type") Integer type);
}
