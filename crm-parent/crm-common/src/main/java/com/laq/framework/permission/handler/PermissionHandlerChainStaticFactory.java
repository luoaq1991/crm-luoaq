package com.laq.framework.permission.handler;

/**
 * 责任链 对象 工厂
 * 
 * @author Mr.YongGan.Zhang
 *
 */
public class PermissionHandlerChainStaticFactory {

	public static PermissionAbstractHandlerChain createPermissionWithNone() {
		return new PermissionWithNone();
	}

	public static PermissionAbstractHandlerChain createPermissionWithLogin() {
		return new PermissionWithLogin();
	}

	public static PermissionAbstractHandlerChain createPermissionWithRole() {
		return new PermissionWithRole();
	}

}
