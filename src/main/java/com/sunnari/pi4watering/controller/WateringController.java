package com.sunnari.pi4watering.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jonas on 2016-04-12.
 */

@RestController
public class WateringController {

    private static GpioController gpioController = GpioFactory.getInstance();
    private static GpioPinDigitalOutput pump1;
    private static GpioPinDigitalOutput pump2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pump2", PinState.LOW);


    //When the application runs on the raspberry pi, send a message (to be sure everything is OK):
    @RequestMapping("/")
    public String greeting(){
        return "Hello world!";
    }

    @RequestMapping("/pumpOn")
    public String powerOnPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.high();
        return "All good!";
    }
    @RequestMapping("/pumpOff")
    public String powerOffPump1(){
        if (pump1 == null){
            pump1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pump1", PinState.LOW);
        }
        pump1.low();
        return "All good!";
    }
}
