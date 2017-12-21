app.controller('inspireCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {
        $scope.inspireInfo = null;
        $scope.photos = null;
        $scope.selectedPost = null;
        $scope.deletedPost = null;
        $scope.newPost = null;

        $scope.loadEditData = function () {
            url = "http://"+window.location.hostname+"/admin/inspireInfo";
            $http.get(url).success(
                function (response) {
                    $scope.inspireInfo = response;
                }
            );
        };

        modifyPost = function (id) {
            url = "http://"+window.location.hostname+"/admin/getPost?post="+id;
            $http.get(url).success(
                function (response) {
                    $scope.selectedPost = response;
                }
            );
        };

        deletePost = function (id) {
            var url = "http://"+window.location.hostname+"/admin/deletePost?post="+id;
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.get(url).success(
                    function () {
                        alert("Your changes to home page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.loadPostData = function () {
            url = "http://"+window.location.hostname+"/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photos = response;
                }
            );
        };

        $scope.inspireEdit = function () {
            var url = "http://"+window.location.hostname+"/admin/inspireEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.inspireInfo).success(
                    function () {
                        alert("Your changes to Inspire page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.selectEditPhoto = function (photo) {
            $scope.selectedPost.photo = photo;
        };
        $scope.selectPhoto = function (photo) {
            $scope.newPost.photo = photo;
        };

        $scope.savePost = function () {
            var url = "http://"+window.location.hostname+"/admin/postEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.selectedPost).success(
                    function () {
                        alert("Your changes to Inspire page have gone live");
                        window.location.reload();
                    }
                );
            }
        };
        $scope.postType = function (type) {
            $scope.newPost.post_type = type;
        };

        $scope.saveNewPost = function () {
            var url = "http://"+window.location.hostname+"/admin/newPost";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.newPost).success(
                    function () {
                        alert("Your changes to Inspire page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

    }
]);
