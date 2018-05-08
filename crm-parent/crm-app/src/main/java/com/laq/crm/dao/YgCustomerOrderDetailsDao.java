package com.laq.crm.dao;

import com.laq.crm.model.YgCustomerOrderDetails;
import com.laq.framework.dao.BaseDao;

import java.util.List;

public interface YgCustomerOrderDetailsDao extends BaseDao<Integer, YgCustomerOrderDetails> {

    List<YgCustomerOrderDetails> queryOrderDetailsByOrderId(Integer orderId);
}