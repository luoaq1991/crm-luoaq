package com.laq.crm.controller.servermanager;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomerServe;
import com.laq.crm.model.YgDataDic;
import com.laq.crm.service.IServerManageService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/server")
public class ServerManageController extends BaseController {

    @Autowired
    private IServerManageService serverManageService;


    @GetMapping("/{page}/index.shtml")
    public String index(@PathVariable("page") Integer page) {
        switch (page) {
            case 1:
                return "customer_serve_create";
            case 2:
                return "customer_serve_assign";
            case 3:
                return "customer_serve_proceed";
            case 4:
                return "customer_serve_feed_back";
            case 5:
                return "customer_serve_archive";
            default:
                return "500";

        }

    }

    //查询服务类别
    @PostMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<YgDataDic> queryDataDicValueByDataDicName(String dicName) {

        return serverManageService.queryDataDicValueByDataDicName(dicName);

    }

    /*
    添加服务请求:state 1
     */
    @PostMapping("/insert")
    @ResponseBody
    public Result insertCustomerServeCreate(YgCustomerServe customerServe) {
        return serverManageService.insertCustomerServeCreate(customerServe);
    }


    /*
    服务分配,查询state = 1 的服务
     */
    @PostMapping("/queryCustomerServesByParams")
    @ResponseBody
    public Map<String, Object> queryCustomerServesByParams(Integer state,
                                                           @RequestParam(defaultValue = "1") Integer pageNum,
                                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        return serverManageService.queryCustomerServesByParams(state, pageNum, pageSize);

    }

    //保存处理人
    @PostMapping("/update")
    @ResponseBody
    public Result updateCustomerServes(YgCustomerServe customerServe) {
        return serverManageService.updateCustomerServes(customerServe);
    }


}
