package com.laq.crm.controller.user;

import com.laq.common.util.Result;
import com.laq.crm.model.YgUser;
import com.laq.crm.service.IUserService;
import com.laq.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    //@RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @PostMapping("/userLogin")
    @ResponseBody
    public Result userLogin(@RequestParam(defaultValue = "") String userName, @RequestParam(defaultValue = "") String userPwd) {
        return userService.userLogin(userName, userPwd);
    }

    /*
    营销机会管理：分配人：查询所有项目经理
     */

    @PostMapping("/queryAllCustomerManager")
    @ResponseBody
    public List<YgUser> queryAllCustomerManager() {
        return userService.queryAllCustomerManager();

    }


}
