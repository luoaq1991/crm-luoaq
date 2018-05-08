package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laq.common.util.Result;
import com.laq.crm.dao.YgCustomerOrderDao;
import com.laq.crm.dao.YgCustomerOrderDetailsDao;
import com.laq.crm.model.YgCustomerOrder;
import com.laq.crm.model.YgCustomerOrderDetails;
import com.laq.crm.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService {

    @Autowired
    private YgCustomerOrderDao customerOrderDao;

    @Autowired
    private YgCustomerOrderDetailsDao customerOrderDetailsDao;

    @Override
    public Map<String, Object> queryOrdersByCid(Integer cid, Integer page, Integer rows) {

        PageHelper.startPage(page, rows);
        List<YgCustomerOrder> list = customerOrderDao.queryOrdersByCid(cid);
        PageInfo<YgCustomerOrder> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

    @Override
    public Result<YgCustomerOrder> queryCustomerOrderByOrderId(Integer orderId) {
        //result中包含了customerOrder对象
        YgCustomerOrder customerOrder = customerOrderDao.queryCustomerOrderByOrderId(orderId);
        //result中含有带对象返回的方法.
        return Result.success("查询成功", customerOrder);
    }

    @Override
    public Map<String, Object> queryOrderDetailsByOrderId(Integer orderId, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<YgCustomerOrderDetails> list = customerOrderDetailsDao.queryOrderDetailsByOrderId(orderId);
        PageInfo<YgCustomerOrderDetails> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;

    }
}
