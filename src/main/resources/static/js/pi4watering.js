/**
 * Created by Jonas on 2016-04-12.
 */

$(document).ready(function() {

    var weatherIcon = null;
    setWeatherIcon("clear-day");


    $.ajax("/api/weatherIcon", {
        dataType: "text",
        success: function(data, textStatus) {
            weatherIcon = data;
            setWeatherIcon(weatherIcon);
        }
    });

    $.ajax("/api/minTemperature", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#minTemperature").text("Min temperatur: " + data);
        }
    });

    $.ajax("/api/maxTemperature", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#maxTemperature").text("Max temperatur: " + data);
        }
    });

    $.ajax("/api/clouds", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#clouds").text("Molnighet: " + data);
        }
    });

    $.ajax("/api/summary", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#summary").text(data);
        }
    });

    $.ajax("/api/uptime", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#uptime").text("Uptime: + " + data);
        }
    });

    $("#pump1On").click(function () {

        $.ajax("/api/pump1On", {
            dataType: "text",
            success: function(data, textStatus) {
            }
        });
    });

    $("#pump1Off").click(function () {

        $.ajax("/api/pump1Off", {
            dataType: "text",
            success: function(data, textStatus) {

            }
        });
    });

    $("#pump2On").click(function () {

        $.ajax("/api/pump2On", {
            dataType: "text",
            success: function(data, textStatus) {

            }
        });
    });

    $("#pump2Off").click(function () {

        $.ajax("/api/pump2Off", {
            dataType: "text",
            success: function(data, textStatus) {

            }
        });
    });

    function setWeatherIcon(weather){
        var skycons = new Skycons();
        skycons.add("weather-icon", weather);
        console.log(skycons);
        console.log(weather);
        skycons.play();
    }

});