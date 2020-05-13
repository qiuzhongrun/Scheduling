package com.qiuzhongrun.scheduling.annotation;

import com.qiuzhongrun.scheduling.util.ScheduleMonitor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ScheduleMonitor.class)
@Documented
public @interface SchedulingEnabled {
}
