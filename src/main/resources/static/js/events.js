/**
 * Created by jo809 on 8/23/2017.
 */
app.controller('eventsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $(document).ready(function() {
            var mq = window.matchMedia('(min-width: 800px)');
            if( mq.matches){
                $('.lightSlider').lightSlider({
                    item: 3

                });
            }
            else{
                $('.lightSlider').lightSlider({
                    item: 1

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
        const mySiema = new Siema();
        document.querySelector('.prev').addEventListener('click', () => mySiema.prev());
        document.querySelector('.next').addEventListener('click', () => mySiema.next());
    }
]);