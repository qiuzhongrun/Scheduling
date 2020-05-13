package com.qiuzhongrun.scheduling.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(SchedulingArr.class)
public @interface Scheduling {

    /**
     * A cron-like expression
     */
    String cron() default "";

    /**
     * a distribute lock key, default is method path
     */
    String key() default "";
}
