package com.laq.crm.service;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomerServe;
import com.laq.crm.model.YgDataDic;

import java.util.List;
import java.util.Map;

public interface IServerManageService {
    List<YgDataDic> queryDataDicValueByDataDicName(String dataDicName);

    Result insertCustomerServeCreate(YgCustomerServe customerServe);

    Map<String, Object> queryCustomerServesByParams(Integer state, Integer pageNum, Integer pageSize);

    Result updateCustomerServes(YgCustomerServe customerServe);
}
