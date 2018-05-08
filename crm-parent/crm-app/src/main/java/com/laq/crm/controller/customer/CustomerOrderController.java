package com.laq.crm.controller.customer;

import com.laq.common.util.Result;
import com.laq.crm.model.YgCustomerOrder;
import com.laq.crm.service.ICustomerOrderService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/customer_order")
@Controller
public class CustomerOrderController extends BaseController {

    @Autowired
    private ICustomerOrderService customerOrderService;


    //客户订单中的客户信息
    @PostMapping("/queryOrdersByCid")
    @ResponseBody
    public Map<String, Object> queryOrdersByCid(Integer cid, @RequestParam(defaultValue = "1") Integer page,
                                                @RequestParam(defaultValue = "10") Integer rows) {

        return customerOrderService.queryOrdersByCid(cid, page, rows);

    }


    //订单列表 - 查询用户订单(查看详情)
    @RequestMapping("/queryCustomerOrderByOrderId")
    @ResponseBody
    public Result<YgCustomerOrder> queryCustomerOrderByOrderId(@RequestParam("orderId") Integer orderId) {
        return customerOrderService.queryCustomerOrderByOrderId(orderId);

    }


    //查询客户订单

    @PostMapping("/queryOrderDetailsByOrderId")
    @ResponseBody
    public Map<String, Object> queryOrderDetailsByOrderId(@RequestParam("orderId") Integer orderId,
                                                          @RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer rows) {
        return customerOrderService.queryOrderDetailsByOrderId(orderId, page, rows);

    }


}
