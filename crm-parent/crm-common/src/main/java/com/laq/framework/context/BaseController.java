package com.laq.framework.context;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 系统上下文
 *
 * @author Mr.YongGan.Zhang
 */
public class BaseController {

    /**
     * 获取上下文路径
     *
     * @param request
     */
    @ModelAttribute
    public void preMethod(HttpServletRequest request) {
        request.setAttribute("ctx", request.getContextPath());
    }


}
