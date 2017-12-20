app.controller('interiorsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.interiors = null;
        $scope.newPhoto = null;
        $scope.currentInterior = null;
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
        $scope.addInterior = function () {
            var url = "http://"+window.location.hostname+":8080/admin/addInterior";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.deleteInterior = function (interior) {
            var url = "http://"+window.location.hostname+":8080/admin/deleteInterior";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,interior).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.selectPhoto = function (interiorAddress, photo, index) {
            for(var i in $scope.interiors){
                if(interiorAddress == i.address){
                    i.photos[index] = photo;
                    break;
                }
            }
        };
        $scope.selectNewPhoto = function (interior, photo) {
            $scope.newPhoto = photo;
            $scope.currentInterior = interior;

        };
        $scope.addPhoto = function () {
            var url = "http://"+window.location.hostname+":8080/admin/addInteriorPhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.currentInterior, $scope.newPhoto).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.deletePhoto = function (interior, photo) {
            var url = "http://"+window.location.hostname+":8080/admin/deleteInteriorPhoto";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,interior, photo).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.interiorsEdit = function () {
            var url = "http://"+window.location.hostname+":8080/admin/interiorsEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.interiors).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

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