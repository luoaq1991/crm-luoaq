package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.laq.common.util.MathUtil;
import com.laq.common.util.Result;
import com.laq.crm.dao.YgCustomerDao;
import com.laq.crm.dao.YgDataDicDao;
import com.laq.crm.model.YgCustomer;
import com.laq.crm.model.YgDataDic;
import com.laq.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerSeviceImpl implements ICustomerService {

    @Autowired
    YgCustomerDao customerDao;

    @Autowired
    YgDataDicDao dataDicDao;

    @Override
    public List<YgCustomer> queryAllCustomers() {
        //isValid = 1的都可以被查到
        Map<String, Object> params = new HashMap<>();
        params.put("isValid", 1);
        List<YgCustomer> list = customerDao.find(params);
        return list;
    }

    @Override
    public Map<String, Object> queryCustomersByParams(YgCustomer customer) {
        //分页参数
        PageHelper.startPage(customer.getPage(), customer.getRows());

        Map<String, Object> params = new HashMap<>();
        //查询，可观察springfield如何实现模糊查询。
        if (StringUtil.isNotEmpty(customer.getKhno())) {
            params.put("khno", customer.getKhno());
        }
        if (StringUtil.isNotEmpty(customer.getName())) {
            params.put("name", customer.getName());
        }
        params.put("isValid", 1);
        List<YgCustomer> info = customerDao.find(params);

        PageInfo pageInfo = new PageInfo(info);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;

    }

    @Override
    @Transactional
    public Result insertCustomerInfo(YgCustomer customer) {
        //生成客户编号:
        customer.setKhno(MathUtil.genereateKhCode());
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
        customer.setIsValid(1);
        customer.setState(0);

        long ste = customerDao.saveSte(customer);
        if (ste == 1) {
            return Result.success("添加客户数据成功");
        }
        return Result.fail("添加客户数据失败");
    }

    @Override
    @Transactional
    public Result updateCustomerInfo(YgCustomer customer) {
        customer.setUpdateDate(new Date());
        long ste = customerDao.updateSte(customer);
        if (ste == 1) {
            return Result.success("修改信息成功");
        }
        return Result.fail("修改信息失败");
    }

    @Override
    public List<YgDataDic> queryDataDicValueByDataDicName(String dicName) {
        return dataDicDao.queryDataDicValueByDataDicName(dicName);
    }

    @Override
    @Transactional
    public Result deleteCustomerInfo(Integer[] ids) {
        //通过list删除
        List<YgCustomer> list = new ArrayList<>();

        for (Integer temp : ids) {
            YgCustomer customer = new YgCustomer();
            customer.setId(temp);
            list.add(customer);
        }

        customerDao.deleteCustomerInfo(list);

        return Result.success("删除数据成功");


    }

    //查找customer_order用
    @Override
    public YgCustomer get(Integer id) {
        return customerDao.get(id);
    }


}
