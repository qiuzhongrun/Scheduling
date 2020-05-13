package com.qiuzhongrun.scheduling.util;

import java.util.Date;

public class Cron {
    private String cron;
    private Date nextExecDate;

    public Cron() {}

    public Cron(String cron) {
        this.cron = cron;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }


    public Date getNextExecDate() {
        return nextExecDate;
    }

    public void setNextExecDate(Date nextExecDate) {
        this.nextExecDate = nextExecDate;
    }
}
