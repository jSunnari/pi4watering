package com.sunnari.pi4watering;

import com.sunnari.pi4watering.domain.PumpRun;
import com.sunnari.pi4watering.domain.PumpRunRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;
import java.util.TimeZone;

/**
 * Created by Jonas on 2016-04-12.
 */

@SpringBootApplication
@EnableScheduling
public class App implements CommandLineRunner{

    @Autowired
    private PumpRunRepository repository;

    public static void main(String[] args){
        TimeZone tzone = TimeZone.getTimeZone("Europe/Stockholm");
        TimeZone.setDefault(tzone);

        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new PumpRun(false));

    }
}
