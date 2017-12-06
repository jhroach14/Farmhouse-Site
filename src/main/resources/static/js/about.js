/**
 * Created by User on 8/3/2017.
 */
app.controller('aboutCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.photos = null;

        $scope.aboutInfo = null;

        $scope.loadEditData = function () {
                var url = "http://"+window.location.hostname+":8080/admin/photoList";
                $http.get(url).success(
                    function (response) {
                        $scope.photos = response;
                    }
                );
                url = "http://"+window.location.hostname+":8080/admin/aboutInfo";
                $http.get(url).success(
                    function (response) {
                        $scope.aboutInfo = response;
                    }
                );
        };

        $scope.selectPhoto = function (photo) {
            $scope.aboutInfo.primary_photo = photo;
        };
        $scope.selectPhoto2 = function (photo) {
            $scope.aboutInfo.secondary_photo = photo;
        };

        $scope.aboutEdit = function () {
            var url = "http://"+window.location.hostname+":8080/admin/aboutEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.aboutInfo).success(
                    function () {
                        alert("Your changes to about page have gone live");
                        window.location.reload();
                    }
                );
            }
        }

    }
]);