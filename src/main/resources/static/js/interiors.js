app.controller('interiorsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

        $(document).ready(function() {

            $('.lightSlider').lightSlider({
                gallery: true,
                item: 1,
                loop: true,
                slideMargin: 0,
                thumbItem: 7
            });
        });
    }
]);