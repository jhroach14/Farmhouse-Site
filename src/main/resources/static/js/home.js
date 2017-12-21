/**
 * Created by User on 8/3/2017.
 */


app.controller('homeCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

        $scope.photoList = null;
        $scope.photos = null;
        $scope.newPhoto = null;

        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+"/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
            url = "http://"+window.location.hostname+"/admin/homePhotos";
            $http.get(url).success(
                function (response) {
                    $scope.photos = response;
                }
            );
        };

        $scope.selectPhoto = function (photo,index) {
            $scope.photos[index].photo = photo;

        };


        $scope.selectNewPhoto = function (photo) {
            $scope.newPhoto = photo;


        };

        $scope.addHomePhoto = function (){
            var url = "http://"+window.location.hostname+"/admin/addNewHomePhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.newPhoto).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.deletePhoto = function (photo) {
            var url = "http://"+window.location.hostname+"/admin/deletePhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url, photo).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.homeEdit = function () {
            var url = "http://"+window.location.hostname+"/admin/homeEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.photos).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $(document).ready(function(){
            $('#playButton').hide();
            $('#pauseButton').show();
        });
        $(function(){
            $('#playButton').click(function () {
                $('#carousel').carousel({interval: 5250});//value must be equal to the data-interval="" in home.html
                $('#playButton').hide();
                $('#pauseButton').show();
            });
            $('#pauseButton').click(function () {
                $('#carousel').carousel('pause');
                $('#pauseButton').hide();
                $('#playButton').show();
            });
        });

    }
]);
