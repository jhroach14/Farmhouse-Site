app.controller('interiorsCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photoList = null;
        $scope.interiors = null;
        $scope.newPhoto = null;
        var newInteriorPhoto = null;

        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+"/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
            url = "http://"+window.location.hostname+"/admin/Interiors";
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
            var url = "http://"+window.location.hostname+"/admin/addInterior";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.get(url).success(
                    function () {
                        alert("Your changes to interiors page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.deleteInterior = function (interior) {
            var url = "http://"+window.location.hostname+"/admin/deleteInterior";
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

        $scope.selectPhoto = function (interior, photo, index) {
            interior.photos[index] = photo;
        };
        $scope.selectNewPhoto = function (photo) {
            newInteriorPhoto = photo;
        };
	
	$scope.addPhoto = function (interior) {
            interior.photos.push(newInteriorPhoto);

        };
        $scope.deletePhoto = function (interior, photo) {
            var index = interior.photos.indexOf(photo);
            if (index > -1) {
                interior.photos.splice(index, 1);
            }
	};

        $scope.saveInterior = function (interior) {
            var url = "http://" + window.location.hostname + "/admin/saveInterior";
            $http.post(url, interior).success(
                function () {
                    window.location.reload();
                }
            );
        };


        $scope.interiorsEdit = function () {
            var url = "http://"+window.location.hostname+"/admin/interiorsEdit";
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
                thumbItem: 7,
                adaptiveHeight: true
            });

        });
    }
]);
