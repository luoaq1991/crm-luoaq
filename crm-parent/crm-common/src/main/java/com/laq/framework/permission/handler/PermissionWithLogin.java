package com.laq.framework.permission.handler;

import javax.servlet.http.HttpServletRequest;

import com.laq.common.util.VerificationLoginUtil;
import com.laq.framework.constant.VerifyType;

/**
 *  登陆校验
 * @author Mr.YongGan.Zhang
 *
 */
public class PermissionWithLogin extends PermissionAbstractHandlerChain {

	@Override
	public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType, String[] verifyValue) {

		if (verifyType == VerifyType.LOGIN) {
			// 完成登陆 校验
			return 	VerificationLoginUtil.isLongin(request);
		}
		// 设置下一级的 处理对象
		setSuccessor(PermissionHandlerChainStaticFactory.createPermissionWithRole());
		return successor.cherkPermissionHandleChain(request, verifyType, verifyValue);
	}

}
