/**
 *
 */
package com.laq.framework.permission.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.laq.common.util.VerificationLoginUtil;
import com.laq.framework.constant.CrmConstant;
import com.laq.framework.constant.VerifyType;

/**
 * 角色校验
 * <p>
 * 1、 判断 登陆
 * <p>
 * 2、 判断角色 1.模块操作值 verifyValue 2.用户权限 permissionAcl
 *
 * @author Mr.YongGan.Zhang
 */
public class PermissionWithRole extends PermissionAbstractHandlerChain {

    @Override
    public boolean cherkPermissionHandleChain(HttpServletRequest request, VerifyType verifyType, String[] verifyValue) {
        if (verifyType == VerifyType.ROLE) {
            boolean isLogin = VerificationLoginUtil.isLongin(request);
            if (!isLogin) {
                return false;
            }
            // 用户操作权限
            List<String> permissionAcl = (List<String>) request.getSession().getAttribute(CrmConstant.USER_PERMISSIONS);
            // 替换算法
            for (String verify : verifyValue) {// 模块操作值
                if (!permissionAcl.contains(verify)) {// permissionAcl 是否具有操作权限
                    return false;
                }
            }
        }
        return true;
    }
}
