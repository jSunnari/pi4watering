package com.sunnari.pi4watering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

/**
 * Created by Jonas on 2016-04-12.
 */

@SpringBootApplication
@EnableScheduling
public class App {

    public static void main(String[] args) {
        TimeZone tzone = TimeZone.getTimeZone("Europe/Stockholm");
        TimeZone.setDefault(tzone);

        SpringApplication.run(App.class, args);

    }
}
