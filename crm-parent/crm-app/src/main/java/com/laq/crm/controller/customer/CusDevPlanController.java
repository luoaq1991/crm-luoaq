package com.laq.crm.controller.customer;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCusDevPlan;
import com.laq.crm.model.YgSaleChance;
import com.laq.crm.service.ICusDevPlanService;
import com.laq.crm.service.IMarketingService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/*
客户开发计划
 */
@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController extends BaseController {

    @Autowired
    private IMarketingService marketingService;

    @Autowired
    private ICusDevPlanService cusDevPlanService;


    //根据sid展示页面
    @RequestMapping("/index.shtml")
    public ModelAndView index(@RequestParam("sid") Integer sid) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cus_dev_plan_detail");
        //根据sale_chance_id 查询该机会
        YgSaleChance saleChance = marketingService.querySaleChanceBySid(sid);
        //查询后组装
        modelAndView.addObject("saleChance", saleChance);
        return modelAndView;

    }

    //查询客户开发计划，返回map
    //为何传入cusDevPlan，继承baseModel,其中内涵page属性
    @PostMapping("/queryCusDevPlansByParams")
    @ResponseBody
    public Map<String, Object> queryCusDevPlansBySaleChanceId(YgCusDevPlan cusDevPlan) {
        return cusDevPlanService.queryCusDevPlansBySaleChanceId(cusDevPlan);
    }

    //添加开发计划
    @PostMapping("/insert")
    @ResponseBody
    public Result insertCusDevPlan(YgCusDevPlan cusDevPlan) {
        return cusDevPlanService.insertCusDevPlan(cusDevPlan);
    }

    //删除开发计划
    @PostMapping("/delete")
    @ResponseBody
    public Result delCusDevPlan(Integer id) {
        return cusDevPlanService.delCusDevPlan(id);
    }

}
