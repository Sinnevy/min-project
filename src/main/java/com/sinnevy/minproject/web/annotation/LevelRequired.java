package com.sinnevy.minproject.web.annotation;


import com.sinnevy.minproject.constant.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LevelRequired {

    // 该接口需要的权限列表
    Permission[] level() default { Permission.ADMIN };

}
