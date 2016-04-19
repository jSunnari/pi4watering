package com.sunnari.pi4watering.beans;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;

/**
 * Created by Jonas on 2016-04-14.
 */


public class Weather {

    private ForecastIO fio;
    private FIODaily daily;

    public Weather() {
        fio = new ForecastIO("ef4e2a6e50214c95bbeeb5ddb0c88df0");
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("57.721107", "11.934564");
        daily = new FIODaily(fio);
    }

    public String clouds(){
        return daily.getDay(0).cloudCover().toString();
    }

    public String minTemperature(){
        return daily.getDay(0).temperatureMin().toString();
    }
    public String maxTemperature(){
        return daily.getDay(0).temperatureMax().toString();
    }

    public String summary(){
        return daily.getDay(0).summary();
    }

    public double getCloud(){
        return daily.getDay(0).cloudCover();
    }

}
