/**
 * Created by User on 8/3/2017.
 */
app.controller('registryCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function($scope, $http) {

    }
]);
$(function(){
    $(document).ready(function(){
        $(".subpage").hide();
        $(".main").hide().fadeIn(750, "swing");
    })

});
function redirectSubpage() {
    $(".main").hide();
    $(".subpage").hide().fadeIn(750, "swing");
}