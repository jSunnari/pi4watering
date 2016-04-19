package com.sunnari.pi4watering.controller;

import com.pi4j.io.gpio.*;
import com.sunnari.pi4watering.beans.Weather;
import com.sunnari.pi4watering.domain.PumpRun;
import com.sunnari.pi4watering.domain.PumpRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created by Jonas on 2016-04-12.
 */

@RestController
@RequestMapping("/api")
public class WateringController {

    private static GpioController gpioController = GpioFactory.getInstance();
    private static GpioPinDigitalOutput pump1;
    private static GpioPinDigitalOutput pump2;

    public WateringController() {
        repository.save(new PumpRun(false));
    }

    @Autowired
    private PumpRunRepository repository;

    @RequestMapping(value="/pumpruns", method=RequestMethod.GET)
    public String listPumpRuns(Model model) {
        model.addAttribute("pumpruns", repository.findAll());
        return "pumpruns/list";
    }

    //Start pump 1:
    @RequestMapping("/pump1On")
    public String powerOnPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.low();
        repository.save(new PumpRun(false));
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
     * Will water for 4 seconds 7.40.
     */
    @Scheduled(cron = "0 40 7 1-31/2 * *")
    public void powerOn4sec(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        try {
            pump1.low();
            Thread.sleep(4000);
            pump1.high();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //************************ WEATHER ************************

    /**
     * Scheduled to run only even days.
     * Checks clouds, if there is a small amount of clouds on the day that's not the "watering-day":
     * Water for 4 seconds 17.00.
     */
    @Scheduled(cron = "0 00 17 2-30/2 * *")
    public void getTodaysClouds(){
        Weather weather = new Weather();
        double clouds = weather.getCloud();

        if (clouds <= 0.50){
            powerOn4sec();
        }
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.GET)
    public String getTemperature() {
        Weather weather = new Weather();
        return weather.temperature();
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

    @RequestMapping(value = "/uptime", method = RequestMethod.GET)
    public String getUptime(){
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        return String.valueOf(rb.getUptime());
    }

}
