/**
 * Created by jo809 on 8/23/2017.
 */
app.controller('eventsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $(document).ready(function() {

            $('.lightSlider').lightSlider({
                item: 3
            });
        });
    }
]);