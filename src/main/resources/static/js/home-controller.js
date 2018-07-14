'use strict';

/* Controllers */
myApp.controller('HomeCtrl', function($scope, $http){

     $http({
       method: 'GET',
       url: '/getName',
       headers: {
         'Authorization': localStorage.getItem('token')
       }
     }).then(function successCallback(response) {

        console.log(response.data);
        console.log(response.data.username);
        $scope.email = response.data.username;

       }, function errorCallback(response) {

          localStorage.removeItem("token");
          window.location.pathname = "/";

          alert("Что-то пошло не так");
       });

$scope.logout = function(){
    localStorage.removeItem("token");
    window.location.pathname = "/";
}

});

myApp.controller('TimeCtrl', function($scope, $http){

$scope.sendTime = function(action){

     $http({
       method: 'GET',
       url: '/timestamps/' + action,
       headers: {
         'Authorization': localStorage.getItem('token')
       }
     }).then(function successCallback(response) {

        if(action == 'STOP'){

            var body = response.data;
            $scope.timeStr = "Твое время: " + body.hours + "ч " + body.minutes + "м " + body.seconds + "с";
        }

       }, function errorCallback(response) {

            console.log("ERROR!");

               if(response.status == 401){
                   localStorage.removeItem("token");
                   window.location.pathname = "/";
                   return;
               }

               if(response.status != 200){
                   alert("Что-то пошло не так");
                   return;
               }
       });

};

});