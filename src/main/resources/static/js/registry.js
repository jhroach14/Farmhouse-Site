/**
 * Created by User on 8/3/2017.
 */
app.controller('registryCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

        $scope.regCode = null;
        $scope.entry = null;
        $scope.cartItems = [];

        $(document).ready(function(){
            $(".subpage").hide();
            $(".main").hide().fadeIn(750, "swing");
        });

        function redirectSubpage() {
            $(".main").hide();
            $(".subpage").hide().fadeIn(750, "swing");
        }

        $scope.submitRegCode = function () {
            var url = "http://localhost:8080/validateCode?code="+$scope.regCode;
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
        };
    }
]);

