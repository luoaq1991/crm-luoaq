package com.laq.crm.service.impl;

import com.laq.common.util.*;
import com.laq.crm.dao.YgPermissionDao;
import com.laq.crm.dao.YgUserDao;
import com.laq.crm.dao.YgUserRoleDao;
import com.laq.crm.model.YgPermission;
import com.laq.crm.model.YgUser;
import com.laq.crm.model.YgUserRole;
import com.laq.crm.service.IUserService;
import com.laq.framework.constant.CrmConstant;
import com.laq.framework.constant.ExceptionConstant;
import com.laq.framework.exception.YgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired(required = false)
    private HttpSession session;

    @Autowired(required = false)
    private HttpServletResponse response;

    @Autowired
    YgUserDao userDao;

    @Autowired
    YgPermissionDao permissionDao;

    @Autowired
    YgUserRoleDao userRoleDao;

    @Override
    public Result userLogin(String userName, String userPwd) {
        //判断非空
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(userPwd)) {
            throw new YgException(ExceptionConstant.EXU001, ExceptionConstant.EXU001);
        }

        //封装参数，查询
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        YgUser user = userDao.findOne(params);

        //判断,用户非空，密码正确，
        if (null != user && Md5Util.encode(userPwd).equals(user.getUserPwd())) {
            //存储登录数据
            VerificationLoginUtil.ULoginTools(response, session, JsonUtil.parseObjectToString(user));
            //将用户信息存入session
            session.setAttribute("userInfo", user.getUserName());
            //查询用户权限
            queryUserPermission(user.getId());

        } else {
            throw new YgException(ExceptionConstant.CODEEXU002, ExceptionConstant.EXU002);
        }
        return Result.success("登录成功");


    }

    @Override
    public List<YgUser> queryAllCustomerManager() {
        return userDao.queryAllCustomerManager();
    }

    //通过userId查询用户权限
    private void queryUserPermission(Integer userId) {
        //组装map
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        //根据userid查询角色，通过角色的roleId查询permission权限。
        YgUserRole userRole = userRoleDao.findOne(params);

        //查询permission权限
        Map<String, Object> permissionParams = new HashMap<>();
        permissionParams.put("roleId", userRole.getRoleId());
        //权限较多，使用list
        List<YgPermission> permissions = permissionDao.find(permissionParams);

        //取acl值
        Iterator<YgPermission> iterator = permissions.iterator();
        List<String> permissionList = new ArrayList<>();

        while (iterator.hasNext()) {
            YgPermission permission = iterator.next();
            permissionList.add(permission.getAclValue());

        }

        //设置session值
        session.setAttribute(CrmConstant.USER_PERMISSIONS, permissionList);


    }
}
