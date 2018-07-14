'use strict';

var token = localStorage.getItem('token');

if (token != null){
    window.location.pathname = "/home";
}

/* Controllers */
myApp.controller('AuthCtrl', function($scope, $http){

$scope.getAction = function(){

    var email = $scope.email;
    var pass = $scope.password;
    var confPass = $scope.confPass;

    if (email == '' || pass == '' || confPass == ''){
        alert("Fields must be filled!!!");
        return false;
    }
    if (pass != confPass){
        alert('Password and confirm must be the same!!');
        return false;
    }

    $scope.url = '/addUser';
    $scope.path = "/";
    $scope.errorMessage = "Такой пользователь уже существует";

    sendUser(email, pass);
};

$scope.getToken = function(){

    var email = $scope.email;
    var pass = $scope.password;

    var confPass = $scope.confPass;

    if (email == '' || pass == ''){
        alert("Fields must be filled!!!");
        return false;
    }

    $scope.url = '/login';
    $scope.path = "/home";
    $scope.errorMessage = "Нет такого пользователя";

    sendUser(email, pass)
};

function sendUser(email, pass){

     $http({
       method: 'POST',
       url: $scope.url,
       headers: {
         'Content-Type': 'application/json'
       },
       data:{
        "username": email,
        "password": pass
       }
     }).then(function successCallback(response) {

         localStorage.setItem('token', response.headers('Authorization'));
         window.location.pathname = $scope.path;

       }, function errorCallback(response) {
         alert($scope.errorMessage);
       });
}

});