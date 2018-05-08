package com.laq.crm.controller.index;

import com.laq.framework.constant.VerifyType;
import com.laq.framework.context.BaseController;
import com.laq.framework.permission.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexSiteController extends BaseController {

    @GetMapping("index.shtml")
    private String index() {
        return "index";
    }

    @GetMapping("main.shtml")
    @Permission(verifyType = VerifyType.LOGIN, verifyValue = "")
    public String main() {
        return "main";
    }


}
