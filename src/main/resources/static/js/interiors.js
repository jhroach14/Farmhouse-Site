app.controller('interiorsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.interiors = null;
        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+":8080/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
            url = "http://"+window.location.hostname+":8080/admin/Interiors";
            $http.get(url).success(
                function (response) {
                    $scope.interiors = response;
                }
            );
        };
        //add interior
        //delete interior
        //add photo to interior
        //delete photo from interior

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