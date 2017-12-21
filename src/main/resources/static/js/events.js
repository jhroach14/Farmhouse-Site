/**
 * Created by jo809 on 8/23/2017.
 */
app.controller('eventsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.events = null;
        $scope.newPhoto = null;
        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+"/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
            url = "http://"+window.location.hostname+"/admin/Events";
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
            var url = "http://"+window.location.hostname+"/admin/addEvent";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.get(url).success(
                    function () {
                        alert("Your changes to events have gone live");
                        window.location.reload();
                    }
                );
            }

        };
        $scope.deleteEvent = function (event) {
            var url = "http://"+window.location.hostname+"/admin/deleteEvent";
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
        $scope.selectPhoto = function (event, photo, index) {
            event.photos[index] = photo;
        };
        $scope.selectNewPhoto = function (photo) {
            $scope.newPhoto = photo;
        };
        $scope.addPhoto = function (event) {
            var url = "http://"+window.location.hostname+"/admin/addEventPhoto?photo=" + $scope.newPhoto.id + "&event=" + event.id;
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url).success(
                    function () {
                        alert("Your changes to the event have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.deletePhoto = function (event, id) {
            var url = "http://"+window.location.hostname+"/admin/deleteEventPhoto?photo=" + id + "&event=" + event.id;
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.eventsEdit = function () {
            var url = "http://"+window.location.hostname+"/admin/eventsEdit";
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
            $('.lightSlider').lightSlider({
                item: 4,
                loop: false,
                slideMove: 2,
                responsive : [
                    {
                        breakpoint: 800,
                        settings: {
                            item: 3,
                            slideMove: 1
                        }
                    },
                    {
                        breakpoint: 540,
                        settings:{
                            item: 1,
                            slideMove: 1
                        }
                    }
                ]
            });

        });
    }
]);
