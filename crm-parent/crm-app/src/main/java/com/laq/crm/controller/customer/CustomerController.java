package com.laq.crm.controller.customer;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomer;
import com.laq.crm.model.YgDataDic;
import com.laq.crm.service.ICustomerService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/index.shtml")
    public String index() {
        return "customer";
    }

    /*
    营销机会管理：添加营销机会 - 客户查询
     */
    @PostMapping("/queryAllCustomers")
    @ResponseBody
    public List<YgCustomer> queryAllCustomers() {
        return customerService.queryAllCustomers();
    }


    //客户管理，客户信息管理
    @PostMapping("/queryCustomersByParams")
    @ResponseBody
    public Map<String, Object> queryCustomersByParams(YgCustomer customer) {
        return customerService.queryCustomersByParams(customer);

    }

    //添加客户信息
    @PostMapping("/insert")
    @ResponseBody
    public Result insertCustomerInfo(YgCustomer customer) {
        return customerService.insertCustomerInfo(customer);
    }

    @PostMapping("update")
    @ResponseBody
    public Result updateCustomerInfo(YgCustomer customer) {
        return customerService.updateCustomerInfo(customer);
    }

    //添加客户信息时,查询客户重要程度,返回list
    @PostMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<YgDataDic> queryDataDicValueByDataDicName(String dicName) {
        return customerService.queryDataDicValueByDataDicName(dicName);
    }


    /*
    多选删除,ids
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result deleteCustomerInfo(Integer[] ids) {
        return customerService.deleteCustomerInfo(ids);
    }

    /*
    页面跳转:
    1. id = 1 --> 联系人管理
    2. id = 2 --> 过往记录管理
    3. id = 3 --> 历史订单查看
     */
    @GetMapping("/toOtherPage/{type}/{id}")
    public ModelAndView toOtherPage(@PathVariable("type") Integer type, @PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        switch (type) {
            //case 1, 2 暂无视图
            case 1:
                //返回view
                modelAndView.setViewName("customer_linkman");
                break;
            case 2:
                modelAndView.setViewName("customer_contact");
                break;
            case 3:
                //通过customer id查找customer_order,故先需要customer
                YgCustomer customer = customerService.get(id);
                modelAndView.addObject("customer", customer);
                modelAndView.setViewName("customer_order");
                break;
            default:
                modelAndView.setViewName("500");

        }
        return modelAndView;
    }


}
