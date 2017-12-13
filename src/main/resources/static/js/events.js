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


        var mq = window.matchMedia('(min-width: 800px)');
        var currentSlider;
        var newSlider;
        $(document).ready(function() {
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
            $('.lightSlider-internal').lightSlider({
                gallery: true,
                item: 1,
                loop: true,
                slideMargin: 0,
                thumbItem: 7
            });
        });
        //reinstantiating lightSlider on resize is very buggy
        //user will have to reload page if they want the look to
        //be appropriate once they change the screen
        const mySiema = new Siema();
        document.querySelector('.prev').addEventListener('click', () => mySiema.prev());
        document.querySelector('.next').addEventListener('click', () => mySiema.next());
    }
]);