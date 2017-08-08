/**
 * Created by User on 8/3/2017.
 */
app.controller('servicesCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

    }
]);

$(function(){
    $(document).ready(function(){
        $('.nested-carousel.item.first-child').addClass('active');
        $('.picture.item.first-child').addClass('active');


    })

});
// Carousel within Carousel hack
$('.carousel').on('slide', function() {
    $('.active.nested-carousel > .picture.item.first-child').addClass('active');
});