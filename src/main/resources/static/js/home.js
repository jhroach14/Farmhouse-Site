/**
 * Created by User on 8/3/2017.
 */


app.controller('homeCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
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