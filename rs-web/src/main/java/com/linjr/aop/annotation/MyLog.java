package com.linjr.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {

    //记录用户操作了那个模块
    String title() default "";

    //记录用户操作的动作
    String action() default "";

}
