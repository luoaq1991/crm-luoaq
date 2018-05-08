package com.laq.crm.controller.marketing;

import com.laq.common.util.Result;
import com.laq.crm.model.YgSaleChance;
import com.laq.crm.service.IMarketingService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/*
营销管理：
    1. 营销机会管理
    2. 客户开发计划
 */

@Controller
@RequestMapping("/marketing")
public class MarketingController extends BaseController {

    @Autowired
    private IMarketingService marketingService;

    /*
    页面跳转state:
    1. 机会管理
    2. 开发计划
     */

    @RequestMapping("/{state}/index.shtml")
    public String index(@PathVariable("state") Integer state) {
        switch (state) {
            case 1:
                return "sale_chance";
            case 2:
                return "cus_dev_plan";
            default:
                return "500";

        }

    }

    /*
    查询营销机会, 返回map
     */

    @PostMapping(value = "/querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> querySaleChancesByParams(YgSaleChance saleChance) {
        return marketingService.querySaleChancesByParams(saleChance);

    }


    /*
    添加营销机会
     */

    @PostMapping("/insert")
    @ResponseBody
    public Result insertMarketingChance(YgSaleChance saleChance) {
        return marketingService.insertMarketingChance(saleChance);
    }


    @PostMapping("/update")
    @ResponseBody
    public Result updateMarketingChance(YgSaleChance saleChance) {
        return marketingService.updateMarketingChance(saleChance);
    }

    /*
    删除营销机会，可多选，故用ids
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result deleteMarketingChance(Integer[] ids) {
        return marketingService.deleteMarketingChance(ids);
    }

    /*
    客户开发计划，显示
     */



}
