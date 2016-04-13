/**
 * Created by Jonas on 2016-04-12.
 */
$(document).ready(function() {

    $("#button1").click(function () {

        $.ajax("/api/togglePump1", {
            dataType: "text",
            success: function(data, textStatus) {
                //alert(data);
            }
        });
    });

    $("#button2").click(function () {

        $.ajax("/api/togglePump2", {
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
                //alert(data);
            }
        });
    });


});