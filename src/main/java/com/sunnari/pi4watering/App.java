package com.sunnari.pi4watering;

import org.h2.tools.Server;
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
public class App {

    public static void main(String[] args) {
        TimeZone tzone = TimeZone.getTimeZone("Europe/Stockholm");
        TimeZone.setDefault(tzone);

        try {
            Server webServer = Server.createWebServer("-web,-webAllowOthers,-webPort,8082").start();
            Server server = Server.createTcpServer("-tcp,-tcpAllowOthers,-tcpPort,9092").start();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        SpringApplication.run(App.class, args);

    }
}
