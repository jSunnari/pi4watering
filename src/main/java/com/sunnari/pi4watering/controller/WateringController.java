package com.sunnari.pi4watering.controller;

import com.pi4j.io.gpio.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jonas on 2016-04-12.
 */

@RestController
@RequestMapping("/api")
public class WateringController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static GpioController gpioController = GpioFactory.getInstance();
    private static GpioPinDigitalOutput pump1;
    private static GpioPinDigitalOutput pump2;

/*
    //When the application runs on the raspberry pi, send a message (to be sure everything is OK):
    @RequestMapping("/")
    public String greeting(){
        return "index.html";
    }
*/

    //Start pump 1:
    @RequestMapping("/pump1On")
    public String powerOnPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.low();
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

    //Run pump for 2sec:
    @RequestMapping("/runTwoSec")
    @Scheduled(cron = "00 36 21 * * *")
    public void powerOn2sec(){
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

}
