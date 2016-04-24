/**
 * Created by Jonas on 2016-04-12.
 */
$(document).ready(function() {

    $.ajax("/api/weatherIcon", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#weather-icon").attr('id', data);
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

    $("#button1").click(function () {

        $.ajax("/api/pump1On", {
            dataType: "text",
            success: function(data, textStatus) {
            }
        });
    });

    $("#button2").click(function () {

        $.ajax("/api/pump1Off", {
            dataType: "text",
            success: function(data, textStatus) {

            }
        });
    });

    $("#button3").click(function () {

        $.ajax("/api/runFourSec", {
            dataType: "text",
            success: function(data, textStatus) {

            }
        });
    });

});