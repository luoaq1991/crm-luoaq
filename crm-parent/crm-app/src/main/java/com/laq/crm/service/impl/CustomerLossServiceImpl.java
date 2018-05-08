package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.laq.crm.dao.YgCustomerLossDao;
import com.laq.crm.model.YgCustomerLoss;
import com.laq.crm.service.ICustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerLossServiceImpl implements ICustomerLossService {

    @Autowired
    private YgCustomerLossDao customerLossDao;

    @Override
    public Map<String, Object> queryCustomerLossesByParams(YgCustomerLoss customerLoss) {

        PageHelper.startPage(customerLoss.getPage(), customerLoss.getRows());
        Map<String, Object> params = new HashMap<>();

        if (StringUtil.isNotEmpty(customerLoss.getCusNo())) {
            params.put("cusNo", customerLoss.getCusNo());
        }
        if (StringUtil.isNotEmpty(customerLoss.getCusName())) {
            params.put("cusName", customerLoss.getCusName());
        }
        if (StringUtil.isNotEmpty(customerLoss.getCusManager())) {
            params.put("cusManager", customerLoss.getCusManager());
        }
        if (null != customerLoss.getCreateDate()) {
            params.put("createDate", customerLoss.getCreateDate());
        }
        params.put("isValid", 1);

        List<YgCustomerLoss> list = customerLossDao.find(params);

        PageInfo<YgCustomerLoss> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("total", info.getTotal());
        map.put("rows", info.getList());

        return map;


    }
}
