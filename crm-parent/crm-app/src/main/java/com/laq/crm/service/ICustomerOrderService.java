package com.laq.crm.service;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomerOrder;

import java.util.Map;

public interface ICustomerOrderService {

    Map<String, Object> queryOrdersByCid(Integer cid, Integer page, Integer rows);

    Result<YgCustomerOrder> queryCustomerOrderByOrderId(Integer orderId);

    Map<String,Object> queryOrderDetailsByOrderId(Integer orderId, Integer page, Integer rows);
}
