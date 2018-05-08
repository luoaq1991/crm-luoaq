package com.laq.framework.permission.handler;

import javax.servlet.http.HttpServletRequest;

import com.laq.framework.constant.VerifyType;

/**
 * 权限处理链
 *
 * @author Mr.YongGan.Zhang
 * <p>
 * 任务 1、 完成登陆校验 2、 完成角色校验
 */
public abstract class PermissionAbstractHandlerChain {

    protected PermissionAbstractHandlerChain successor;

    /**
     * 设置处理链对象
     *
     * @param successor
     */
    public void setSuccessor(PermissionAbstractHandlerChain successor) {
        this.successor = successor;
    }

    /**
     * 权限校验链
     *
     * @param request
     * @param verifyType  校验类型
     * @param verifyValue 模块操作值
     * @return
     */
    public abstract boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType, String[] verifyValue);
}
