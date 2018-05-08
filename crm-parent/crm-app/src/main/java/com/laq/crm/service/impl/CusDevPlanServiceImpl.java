package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laq.common.util.Result;
import com.laq.crm.dao.YgCusDevPlanDao;
import com.laq.crm.model.YgCusDevPlan;
import com.laq.crm.service.ICusDevPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CusDevPlanServiceImpl implements ICusDevPlanService {

    @Autowired
    private YgCusDevPlanDao cusDevPlanDao;

    @Override
    public Map<String, Object> queryCusDevPlansBySaleChanceId(YgCusDevPlan cusDevPlan) {
        //组装page
        PageHelper.startPage(cusDevPlan.getPage(), cusDevPlan.getRows());

        Map<String, Object> params = new HashMap<>();

        params.put("saleChanceId", cusDevPlan.getSaleChanceId());
        params.put("isValid", 1);

        //查询
        List<YgCusDevPlan> list = cusDevPlanDao.find(params);
        PageInfo<YgCusDevPlan> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;

    }

    @Override
    @Transactional
    public Result insertCusDevPlan(YgCusDevPlan cusDevPlan) {
        //设置对象
        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        cusDevPlan.setIsValid(1);

        long ste = cusDevPlanDao.saveSte(cusDevPlan);
        if (ste == 1) {
            return Result.success("添加计划成功");
        }
        return Result.fail("添加计划失败");
    }

    @Override
    @Transactional
    public Result delCusDevPlan(Integer id) {
        //basedao中update方法存入对象，故需生成对象
        YgCusDevPlan cusDevPlan = new YgCusDevPlan();
        cusDevPlan.setId(id);
        cusDevPlan.setIsValid(0);
        cusDevPlan.setUpdateDate(new Date());

        long ste = cusDevPlanDao.updateSte(cusDevPlan);
        if (ste == 1) {
            return Result.success("删除计划成功");
        }
        return Result.fail("删除计划失败");
    }
}
