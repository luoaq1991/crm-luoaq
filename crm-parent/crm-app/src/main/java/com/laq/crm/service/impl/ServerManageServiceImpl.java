package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laq.common.util.JsonUtil;
import com.laq.common.util.Result;
import com.laq.common.util.StringUtil;
import com.laq.common.util.VerificationLoginUtil;
import com.laq.crm.dao.YgCustomerServeDao;
import com.laq.crm.dao.YgDataDicDao;
import com.laq.crm.model.YgCustomerServe;
import com.laq.crm.model.YgDataDic;
import com.laq.crm.model.YgUser;
import com.laq.crm.service.IServerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServerManageServiceImpl implements IServerManageService {

    @Autowired
    private YgDataDicDao dataDicDao;

    @Autowired
    private YgCustomerServeDao customerServeDao;

    @Autowired
    private HttpServletRequest request;


    //在字典中查询服务类型
    @Override
    public List<YgDataDic> queryDataDicValueByDataDicName(String dicName) {
        if (StringUtil.isNotEmpty(dicName)) {
            return dataDicDao.queryDataDicValueByDataDicName(dicName);
        }
        return null;
    }

    @Override
    @Transactional
    public Result insertCustomerServeCreate(YgCustomerServe customerServe) {
        customerServe.setState("1");
        customerServe.setCreateDate(new Date());
        customerServe.setUpdateDate(new Date());
        customerServe.setIsValid(1);

        //获取用户信息
        String json = VerificationLoginUtil.checkLoginUser(request);
        //json转化为对象
        YgUser user = JsonUtil.parseJsonWithGson(json, YgUser.class);
        //存入创建人
        customerServe.setCreatePeople(user.getUserName());

        long ste = customerServeDao.saveSte(customerServe);
        if (ste == 1) {
            return Result.success("添加服务成功");
        }

        return Result.fail("添加服务失败");

    }

    @Override
    public Map<String, Object> queryCustomerServesByParams(Integer state, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Map<String, Object> params = new HashMap<>();
        params.put("state", state);
        params.put("isValid", 1);
        List<YgCustomerServe> list = customerServeDao.find(params);

        PageInfo<YgCustomerServe> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());

        return map;

    }

    @Override
    @Transactional
    public Result updateCustomerServes(YgCustomerServe customerServe) {
        /*customerServe.setState("2");*/
        customerServe.setUpdateDate(new Date());
        customerServe.setAssignTime(new Date());

        long ste = customerServeDao.updateSte(customerServe);
        if (ste == 1) {
            return Result.success("分配成功");
        }
        return Result.fail("分配失败");
    }




}
