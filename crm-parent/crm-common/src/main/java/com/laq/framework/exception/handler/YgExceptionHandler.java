package com.laq.framework.exception.handler;

import com.laq.common.util.JsonUtil;
import com.laq.common.util.Result;
import com.laq.common.util.StringUtil;
import com.laq.framework.constant.ExceptionConstant;
import com.laq.framework.constant.HttpConstant;
import com.laq.framework.exception.YgException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常层
 *
 * @author Mr.YongGan.Zhang
 * <p>
 * 1. 判断异常 ----》 异常信息 ----》 result ----》 返回出去
 */
public class YgExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(YgExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        ModelAndView mv = new ModelAndView();

        Result result = null;
        if (ex instanceof YgException) {// 自定义异常
            YgException ygException = (YgException) ex;
            result = Result.fail(ygException.getCode(), ygException.getMessage());
        } else {// 系统异常
            if (LOGGER.isDebugEnabled()) { // 判断是否可以打印日志
                LOGGER.debug(" 未知错误 : {} ", ex.getMessage());
            }
            result = Result.fail(ExceptionConstant.DEFUALT_FAIL_CODE, ExceptionConstant.DEFUALT_FAIL_MSG);
        }

        // 根据前端请求的种类  响应
        String requestType = request.getHeader(HttpConstant.HTTP_HEADE);
        // 判断是ajax请求
        boolean flag = StringUtil.isNotEmpty(requestType) && HttpConstant.AJAX_HTTPREQUEST_TYPE.equals(requestType);

        if (flag) { //将返回json
            String json = JsonUtil.parseObjectToString(result);
            JsonUtil.write(response, json);
        } else {
            mv.setViewName("500");
            mv.addObject("result", result);
        }
        return mv;
    }

}
