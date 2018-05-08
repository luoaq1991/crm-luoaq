package com.laq.crm.service;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomer;
import com.laq.crm.model.YgDataDic;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<YgCustomer> queryAllCustomers();

    Map<String, Object> queryCustomersByParams(YgCustomer customer);

    Result insertCustomerInfo(YgCustomer customer);

    Result updateCustomerInfo(YgCustomer customer);

    List<YgDataDic> queryDataDicValueByDataDicName(String dicName);

    Result deleteCustomerInfo(Integer[] ids);

    YgCustomer get(Integer id);
}
