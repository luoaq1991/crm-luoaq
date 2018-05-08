package com.laq.crm.dao;

import java.util.List;

import com.laq.crm.model.YgCustomer;
import com.laq.framework.dao.BaseDao;

public interface YgCustomerDao extends BaseDao<Integer, YgCustomer> {

    Integer deleteCustomerInfo(List<YgCustomer> list);

}