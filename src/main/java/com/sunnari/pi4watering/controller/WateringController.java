package com.sunnari.pi4watering.controller;

import com.pi4j.io.gpio.*;
import com.sunnari.pi4watering.beans.Weather;
import com.sunnari.pi4watering.domain.PumpRun;
import com.sunnari.pi4watering.domain.PumpRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Jonas on 2016-04-12.
 */

@RestController
@RequestMapping("/api")
public class WateringController {

    private static GpioController gpioController = GpioFactory.getInstance();
    private static GpioPinDigitalOutput pump1;
    private static GpioPinDigitalOutput pump2;
    private int badWeatherCounter = 0;

    @Autowired
    private PumpRunRepository repository;

    //Start pump 1:
    @RequestMapping("/pump1On")
    public String powerOnPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.low();
        repository.save(new PumpRun(false, "Pump1"));
        return "All good!";
    }

    //Stop pump 1:
    @RequestMapping("/pump1Off")
    public String powerOffPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.high();
        return "All good!";
    }

    //Start pump 2:
    @RequestMapping("/pump2On")
    public String powerOnPump2(){
        if (pump2 == null){
            pump2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pump2", PinState.LOW);
        }
        pump2.low();
        repository.save(new PumpRun(false, "Pump2"));
        return "All good!";
    }

    //Stop pump 2:
    @RequestMapping("/pump2Off")
    public String powerOffPump2(){
        if (pump2 == null){
            pump2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pump2", PinState.LOW);
        }
        pump2.high();
        return "All good!";
    }

    /**
     * Scheduled to run only odd days, this is the regular watering day.
     * Will water for 11 seconds 7.40.
     */
    @Scheduled(cron = "0 40 7 1-31/2 * *")
    public void pump1Cron(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        try {
            pump1.low();
            Thread.sleep(11000);
            pump1.high();
            repository.save(new PumpRun(true, "Vardagsrummet"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Scheduled to run every day, this is the regular watering day.
     * Will water for 10 seconds 7.40.

    @Scheduled(cron = "0 40 7 * * *")
    public void pump2Cron(){
        //If it has been cloudy in three days, don't water.
        if (badWeatherCounter <= 3) {
            if (pump2 == null) {
                pump2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pump2", PinState.LOW);
            }
            try {
                pump2.low();
                Thread.sleep(13000);
                pump2.high();
                repository.save(new PumpRun(true, "Balkongen"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            badWeatherCounter = 0;
        }
    }
    */

    //************************ WEATHER ************************
    //Only for summer
    /*
    /**
     * Scheduled to run only even days.
     * Checks clouds, if there is under 50% of clouds, it will water pump1.
     * Waters 15.00.

    @Scheduled(cron = "0 00 15 2-30/2 * *")
    public void pump1CheckWeather(){
        Weather weather = new Weather();
        double clouds = weather.getCloud();

        if (clouds <= 0.50){
            pump1Cron();
        }
    }

    /**
     * Scheduled to run every day.
     * Checks clouds, if there is under 50% of clouds, it will water pump2.
     * if it's cloudy, increase the counter.
     * Waters 15.00.

    @Scheduled(cron = "0 00 15 * * *")
    public void pump2CheckWeather(){
        Weather weather = new Weather();
        double clouds = weather.getCloud();

        //If the weather is cloudy, increase counter:
        if (clouds >= 0.60){
            badWeatherCounter++;
        }

        if (clouds <= 0.50){
            pump2Cron();
            badWeatherCounter = 0;
        }

    }

    */

    @RequestMapping(value = "/minTemperature", method = RequestMethod.GET)
    public String getMinTemperature() {
        Weather weather = new Weather();
        return weather.minTemperature();
    }

    @RequestMapping(value = "/maxTemperature", method = RequestMethod.GET)
    public String getMaxTemperature() {
        Weather weather = new Weather();
        return weather.maxTemperature();
    }

    @RequestMapping(value = "/clouds", method = RequestMethod.GET)
    public String getClouds() {
        Weather weather = new Weather();
        return weather.clouds();
    }

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String getSummary() {
        Weather weather = new Weather();
        return weather.summary();
    }

    @RequestMapping(value = "/weatherIcon", method = RequestMethod.GET)
    public String getIcon() {
        Weather weather = new Weather();
        return weather.getIcon();
    }

    @RequestMapping(value = "/uptime", method = RequestMethod.GET)
    public String getUptime(){
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();

        DateFormat dateFormat = new SimpleDateFormat("HH'h' mm'm' ss's'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        long uptime = mxBean.getUptime();
        String uptimeStr = uptime / (3600 * 1000 * 24) + "d " + dateFormat.format(uptime);

        return uptimeStr;
    }

}
