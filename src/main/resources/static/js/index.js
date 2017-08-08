/**
 * Created by James Roach on 8/3/2017.
 */

var app = angular.module("indexApp",[]); //declare angular app

//sidebar js
function w3_open() {
    document.getElementById("mySidebar").style.display = "table";
    document.getElementById("sidebar-btn").style.display = "none";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("sidebar-btn").style.display = "inline-block";
}
$(function () {
    $(window).on("resize", function () {
        if (window.matchMedia("(min-width: 481px)").matches) {
            document.getElementById("sidebar-btn").style.display = "none";
            document.getElementById("mySidebar").style.display = "none";
        }
        else {
            document.getElementById("sidebar-btn").style.display = "inline-block";
        }
    })
    $(document).ready(function(){
        $(".main", "footer").hide().fadeIn(750, "swing");

    })
});