package com.laq.framework.interceptor;

import com.laq.framework.constant.VerifyType;
import com.laq.framework.permission.Permission;
import com.laq.framework.permission.handler.PermissionAbstractHandlerChain;
import com.laq.framework.permission.handler.PermissionHandlerChainStaticFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限拦截器
 * 
 * @author Mr.YongGan.Zhang
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler instanceof HandlerMethod) {// 判断是否是拦截的方法
			HandlerMethod hm = (HandlerMethod) handler;
			Method method = hm.getMethod();// 获取到拦截的方法
			// 获取方法上的注解
			Permission permission = method.getAnnotation(Permission.class);
			if (permission != null) {// 进入权限判断

				VerifyType verifyType = permission.verifyType(); // 获取校验类型

				String[] verifyValue = permission.verifyValue(); // 权限操作值
				// 创建权限处理链
				PermissionAbstractHandlerChain chain = PermissionHandlerChainStaticFactory.createPermissionWithNone();
				boolean handleChain = chain.cherkPermissionHandleChain(request, verifyType, verifyValue);// 权限校验
				if (!handleChain) {
					request.getRequestDispatcher("/index.shtml").forward(request, response);
				}
				return handleChain;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
