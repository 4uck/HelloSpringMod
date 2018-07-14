'use strict';

/* Controllers */
myApp.controller('RegistryCtrl', function($scope, $http){

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

    sendUser(email, pass);
};

function sendUser(email, pass){

     $http({
       method: 'POST',
       url: '/addUser',
       headers: {
         'Content-Type': 'application/json'
       },
       data:{
        "username": email,
        "password": pass
       }
     }).then(function successCallback(response) {

         alert("Пользователь добавлен");
         window.location.pathname = "/";

       }, function errorCallback(response) {
         alert("Такой пользователь уже существует");
       });
}

});