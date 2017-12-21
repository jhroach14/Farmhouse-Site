/**
 * Created by James Roach on 8/3/2017.
 */

var app = angular.module("indexApp",[]); //declare angular app

app.controller('indexCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

        $scope.allPhotos = null;

        $scope.loadPhotoData = function () {
            var url = "http://"+window.location.hostname+"/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.allPhotos = response;
                }
            );
        };

        $scope.deletePhoto= function (photo) {
            var url = "http://"+window.location.hostname+"/admin/delete/img/";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,photo).success(
                    function () {
                        alert("Your changes to photos have gone live");
                        window.location.reload();
                    }
                );
            }
        };

    }
]);
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
