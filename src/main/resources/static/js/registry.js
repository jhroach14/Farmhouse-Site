/**
 * Created by User on 8/3/2017.
 */

app.controller('registryCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

        $scope.regCode = null;
        $scope.entry = null;
        $scope.cartItems = [];

        $scope.photos = null;

        $scope.registryInfo = null;

        $scope.loadEditData = function () {
            var url = "http://"+window.location.hostname+":8080/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photos = response;
                }
            );
            url = "http://"+window.location.hostname+":8080/admin/registryInfo";
            $http.get(url).success(
                function (response) {
                    $scope.registryInfo = response;
                }
            );
        };

        $scope.selectPhoto = function (photo) {
            $scope.registryInfo.main_photo = photo;
        };

        $scope.registryEdit = function () {
            var url = "http://"+window.location.hostname+":8080/admin/registryEdit";
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if(result){
                $http.post(url,$scope.registryInfo).success(
                    function () {
                        alert("Your changes to about page have gone live");
                        window.location.reload();
                    }
                );
            }
        }

        $(function () {
            $('.registry-request').submit(function(e) {
                e.preventDefault();
                var nameInput = document.getElementById('recipient').value;
                var phoneInput = document.getElementById('phnumber').value;
                var eventDate = document.getElementById('event-date').value;
                var email = document.getElementById('email').value;
                var event = document.getElementById('event').value;
                var formattedInput = "";
                var mailto = "mailto:example@farmhouse.com";
                formattedInput += "Email contact: %20" + email + "%0D%0A";
                if (phoneInput.length != 0) {
                    formattedInput += "Phone contact: %20" + phoneInput + "%0D%0A";
                }
                formattedInput += "Event date: %20" + eventDate + "%0D%0A%0D%0A";
                if (event.length != 0) {
                    formattedInput += "Event Details: %0D%0A" + event + "%0D%0A%0D%0A";
                }
                window.location.href = (mailto + "?subject=" + nameInput + "'s registry request" + "&body=" + formattedInput);
            });
        });

        $(document).ready(function(){
            $(".subpage").hide();
            $(".main").hide().fadeIn(750, "swing");

        });

        function redirectSubpage() {
            $(".main").hide();
            $(".subpage").hide().fadeIn(750, "swing");
        }

        $scope.submitRegCode = function () {
            var url = "http://"+window.location.hostname+":8080/validateCode?code="+$scope.regCode;
            $http.get(url).success(
                function (response) {
                    if(response != null){
                        redirectSubpage();
                        $scope.entry = response;
                    }else{
                        alert("invalid code");
                    }
                }
            );
        }
        $scope.addItem = function (item){
            $scope.cartItems.push(item);
        }
        $scope.deleteItem = function(item){
            var index = $scope.cartItems.indexOf(item);
            if(index > -1){
                $scope.cartItems.splice(index,1);
            }
        }
    }
]);
