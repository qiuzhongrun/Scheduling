package com.qiuzhongrun.scheduling.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SchedulingArr {
	Scheduling[] value();

}
