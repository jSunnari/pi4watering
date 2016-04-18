/**
 * Created by Jonas on 2016-04-12.
 */
$(document).ready(function() {

    $.ajax("/api/temperature", {
        dataType: "text",
        success: function(data, textStatus) {
            $("#temperature").text("Temperatur: " + data);
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

    $("#button1").click(function () {

        $.ajax("/api/pump1On", {
            dataType: "text",
            success: function(data, textStatus) {
                appendLatestRun();
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
                appendLatestRun();

            }
        });
    });

    function getCurrDateTime () {
        return $.format.date(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    function appendLatestRun () {
        $("#latestRuns").prepend("<li>" + getCurrDateTime() +"</li>");
        if ($("#latestRuns").children().length > 7){
            $("#latestRuns").children().last().remove();
        }
    }


});