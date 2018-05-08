package com.laq.crm.service;


import com.laq.common.util.Result;
import com.laq.crm.model.YgUser;

import java.util.List;

public interface IUserService {

    //用户登录
    public Result userLogin(String userName,String userPwd);


    List<YgUser> queryAllCustomerManager();
}
