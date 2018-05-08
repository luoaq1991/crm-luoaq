package com.laq.framework.permission.handler;

import com.laq.framework.constant.VerifyType;

import javax.servlet.http.HttpServletRequest;

/**
 * 不做任何校验
 *
 * @author Mr.YongGan.Zhang
 */
public class PermissionWithNone extends PermissionAbstractHandlerChain {

    @Override
    public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType, String[] verifyValue) {

        if (verifyType == VerifyType.NONE) {
            return true;
        }
        // 设置下一级的 处理对象
        setSuccessor(PermissionHandlerChainStaticFactory.createPermissionWithLogin());// 多态 ---》 父类引用指向子类对象
        return successor.cherkPermissionHandleChain(request, verifyType, verifyValue);
    }

}
