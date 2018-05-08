package com.laq.crm.dao;

import com.laq.crm.model.YgUser;
import com.laq.framework.dao.BaseDao;

import java.util.List;

public interface YgUserDao extends BaseDao<Integer, YgUser> {

    List<YgUser> queryAllCustomerManager();
}