package com.laq.crm.dao;

import com.laq.crm.model.YgCustomerOrder;
import com.laq.framework.dao.BaseDao;

import java.util.List;

public interface YgCustomerOrderDao extends BaseDao<Integer, YgCustomerOrder> {

    List<YgCustomerOrder> queryOrdersByCid(Integer cid);

    YgCustomerOrder queryCustomerOrderByOrderId(Integer orderId);
}