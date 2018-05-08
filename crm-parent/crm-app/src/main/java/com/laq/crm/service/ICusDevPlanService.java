package com.laq.crm.service;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCusDevPlan;

import java.util.Map;

public interface ICusDevPlanService {
    Map<String, Object> queryCusDevPlansBySaleChanceId(YgCusDevPlan cusDevPlan);

    Result insertCusDevPlan(YgCusDevPlan cusDevPlan);

    Result delCusDevPlan(Integer id);
}
