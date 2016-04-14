package com.sunnari.pi4watering.beans;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jonas on 2016-04-14.
 */

public class Weather {

    ForecastIO fio = new ForecastIO("ef4e2a6e50214c95bbeeb5ddb0c88df0");
    FIODaily daily = new FIODaily(fio);
    private double clouds;

    public Weather() {
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("57.721107", "11.934564");
    }

    public void clouds(){
        clouds = daily.getDay(0).cloudCover();
    }

}
