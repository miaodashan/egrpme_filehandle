package com.tospur.egrpme.service;


import com.tospur.egrpme.model.ErrorData;

import java.util.List;

public interface ErrorDataService {
    List<ErrorData> findErrorData(Integer type);
}
