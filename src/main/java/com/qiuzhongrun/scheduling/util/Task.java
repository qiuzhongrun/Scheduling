package com.qiuzhongrun.scheduling.util;


import java.lang.reflect.Method;

public class Task {
    private Method method;
    private Cron cron;

    public Task(){}

    public Task(Method method, Cron cron) {
        this.method = method;
        this.cron = cron;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Cron getCron() {
        return cron;
    }

    public void setCron(Cron cron) {
        this.cron = cron;
    }
}
