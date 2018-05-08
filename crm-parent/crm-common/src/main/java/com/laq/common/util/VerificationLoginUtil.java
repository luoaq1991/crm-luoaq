package com.laq.common.util;

import com.laq.framework.constant.CrmConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登陆 校验 实现用户登陆 与 检查 用户
 *
 * @author MR.YongGan.Zhang
 */
public final class VerificationLoginUtil {

    private VerificationLoginUtil() {
    }

    /**
     * 实现用户登陆
     *
     * @param response
     * @param session
     * @param json
     */

    public static synchronized void ULoginTools(HttpServletResponse response, HttpSession session, String json) {

        // 登陆令牌
        String authCustomerCode = GeneratePrimaryKeyStrategy.authCustomerCode();
        // 存放 用户信息
        session.setAttribute(authCustomerCode, json);
        // 将令牌 存到
        CookieUtil.addCookie(response, CrmConstant.SESSION_ID, authCustomerCode, 30 * 60);
    }

    /**
     * 检测用户是否登录 过程： 用户令牌： 从cookie 获取登陆令牌 ----> session 中获取用户信息 -- {获取到 说明已经登陆 否则为登陆
     * }
     *
     * @param request
     * @return true 表示用户已经登陆 false 表示用户未登录
     */
    public static synchronized boolean isLongin(HttpServletRequest request) {
        String user = checkLoginUser(request);
        if (StringUtil.isNotEmpty(user)) {
            return true;
        }
        return false;
    }

    /**
     * 获取用户信息
     *
     * @return String
     */
    public static String checkLoginUser(HttpServletRequest request) {
        String sessionId = CookieUtil.getUid(request, CrmConstant.SESSION_ID);
        if (StringUtil.isNotEmpty(sessionId)) {
            Object obj = request.getSession().getAttribute(sessionId);
            String json = String.valueOf(obj);
            if (json != null || !"".equals(json)) {
                return json;
            }
        }
        return null;
    }

}
