package com.qiuzhongrun.scheduling.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class ScheduleMonitor {
    private final Log logger = LogFactory.getLog(ScheduleMonitor.class);
    private Map<String, Task> TASK_MAP = new ConcurrentHashMap<>();

    protected void put(String key, Method method, Cron cron) {
        notNullAssert(key, method, cron);

        if (TASK_MAP.containsKey(key)) {
            Task task = TASK_MAP.get(key);
            Method oldMethod = task.getMethod();
            String methodName0 = oldMethod.getName();
            String methodName1 = oldMethod.getName();
            String msg = "Duplicate key for scheduling task. " +
                            "key["+key+"],"+
                            "methodName0["+methodName0+"]"+
                            "methodName1["+methodName1+"]";

            logger.error(msg);
        } else {
            Task task = new Task(method, cron);
            TASK_MAP.put(key, task);
        }
    }

    private static void notNullAssert(String key, Method method, Cron cron) {
        Assert.notNull(key != null, "Key can be null.");
        Assert.notNull(method != null, "Method can be null.");
        Assert.notNull(cron != null, "Cron can be null.");
    }

    public void changeCron(String key, String newCron) {
        Task task = TASK_MAP.get(key);
        if (task==null) {
            logger.warn("Task for key["+key+"] not exist.");
        } else {
            task.getCron().setCron(newCron);
        }
    }

    @Bean(name = "com.qiuzhongrun.scheduling.bean.internalAnnotationProcessor")
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public AnnotationBeanPostProcessor annotationProcessor() {
        return new AnnotationBeanPostProcessor();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(100);
        return scheduler;
    }
}
