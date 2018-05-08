package com.laq.crm.controller.customer;

import com.laq.crm.model.YgCustomerLoss;
import com.laq.crm.service.ICustomerLossService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/customer_loss")
public class CustomerLossController extends BaseController {

    @Autowired
    private ICustomerLossService customerLossService;

    @GetMapping("/index.shtml")
    public String index() {
        return "customer_loss";
    }


    @PostMapping("/queryCustomerLossesByParams")
    @ResponseBody
    public Map<String, Object> queryCustomerLossesByParams(YgCustomerLoss customerLoss) {
        return customerLossService.queryCustomerLossesByParams(customerLoss);

    }


}
