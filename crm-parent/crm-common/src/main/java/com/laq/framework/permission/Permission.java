package com.laq.framework.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.laq.framework.constant.VerifyType;
import com.laq.framework.constant.VerifyType;

/**
 * 权限 拦截
 *
 * @author MR.YongGan.Zhang
 */

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {

    VerifyType verifyType() default VerifyType.LOGIN; // 注解的属性

    String[] verifyValue();

}
