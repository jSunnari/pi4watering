package com.sunnari.pi4watering.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jonas on 2016-04-19.
 */

@Entity
public class PumpRun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    private String pump;
    private boolean scheduled;

    public PumpRun() {
    }

    public PumpRun(boolean scheduled, String pump) {
        this.pump = pump;
        this.date = new Date();
        this.scheduled = scheduled;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPump() {
        return pump;
    }

    public void setPump(String pump) {
        this.pump = pump;
    }

    public String getScheduled() {
        String scheduledStr;
        if (scheduled){
            scheduledStr = "JA";
        }
        else {
            scheduledStr = "NEJ";
        }
        return scheduledStr;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }
}
