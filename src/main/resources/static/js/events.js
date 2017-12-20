/**
 * Created by jo809 on 8/23/2017.
 */
app.controller('eventsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.events = null;
        $scope.newPhoto = null;
        $scope.currentEvent = null;
        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+":8080/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
            url = "http://"+window.location.hostname+":8080/admin/Events";
            $http.get(url).success(
                function (response) {
                    $scope.events = response;
                }
            );
        };
        //add event
        //delete event
        //add photo to event
        //delete photo from event

        $scope.addEvent = function () {
            var url = "http://"+window.location.hostname+":8080/admin/addEvent";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url).success(
                    function () {
                        alert("Your changes to events have gone live");
                        window.location.reload();
                    }
                );
            }

        };
        $scope.deleteEvent = function (event) {
            var url = "http://"+window.location.hostname+":8080/admin/deleteEvent";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url, event).success(
                    function () {
                        alert("Your changes to the event have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.selectPhoto = function (eventName, photo, index) {
            for(var e in $scope.events){
                if(eventName == e.name){
                    e.photos[index] = photo;
                    break;
                }
            }
        };
        $scope.selectNewPhoto = function (event, photo) {
            $scope.newPhoto = photo;
            $scope.currentEvent = event;
        };
        $scope.addPhoto = function () {
            var url = "http://"+window.location.hostname+":8080/admin/addEventPhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.currentEvent,$scope.newPhoto).success(
                    function () {
                        alert("Your changes to the event have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.deletePhoto = function (event, photo) {
            var url = "http://"+window.location.hostname+":8080/admin/deleteEventPhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.get(url, event, photo).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.eventsEdit = function () {
            var url = "http://"+window.location.hostname+":8080/admin/eventsEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.events).success(
                    function () {
                        alert("Your changes to events page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        var mq = window.matchMedia('(min-width: 800px)');
        var currentSlider;
        var internalLightSliderInitiated = false;

        resizeCallBack = function () {
            $(window).delay(1000).trigger('resize');
        };
        $(document).ready(function() {
            $("#myModal").on('shown.bs.modal',function () {
                if(!internalLightSliderInitiated){
                    $('.lightSlider-internal').lightSlider({
                        gallery: true,
                        item: 1,
                        loop: true,
                        slideMargin: 0,
                        thumbItem: 7
                    });

                }
                const mySiema = new Siema({onInit: () => resizeCallBack()});
                document.querySelector('.prev').addEventListener('click', () => mySiema.prev());
                document.querySelector('.next').addEventListener('click', () => mySiema.next());

                //need some sort of call back to prevent the behavior you see
                //when the carousel first opens
                internalLightSliderInitiated = true;
            });
            if( mq.matches){
                currentSlider =
                    $('.lightSlider').lightSlider({
                    item: 3,
                    thumbItem: 7

                });
            }
            else{
                currentSlider = $('.lightSlider').lightSlider({
                    item: 1,
                    thumbItem: 7

                });
            }
        });
    }
]);