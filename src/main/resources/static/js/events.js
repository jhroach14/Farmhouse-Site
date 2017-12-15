/**
 * Created by jo809 on 8/23/2017.
 */
app.controller('eventsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.events = null;
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

        };
        $scope.deleteEvent = function () {

        };
        $scope.addPhoto = function () {

        };
        $scope.deletePhoto = function () {

        };
        $scope.editName = function () {

        };
        $scope.editDescriptions = function () {

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
        //reinstantiating lightSlider on resize is very buggy
        //user will have to reload page if they want the look to
        //be appropriate once they change the screen

    }
]);