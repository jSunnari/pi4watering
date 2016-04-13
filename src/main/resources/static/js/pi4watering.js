/**
 * Created by Jonas on 2016-04-12.
 */
$(document).ready(function() {

    $("#button1").click(function () {

        $.ajax("/api/pump1On", {
            dataType: "text",
            success: function(data, textStatus) {
                //alert(data);
            }
        });
    });

    $("#button2").click(function () {

        $.ajax("/api/pump1Off", {
            dataType: "text",
            success: function(data, textStatus) {
                //alert(data);
            }
        });
    });

    $("#button3").click(function () {

        $.ajax("/api/runTwoSec", {
            dataType: "text",
            success: function(data, textStatus) {
                $("#latest").text(data);
            }
        });
    });


});