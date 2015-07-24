'use strict';

angular.module('users_management')
    .controller('usersController', function($scope, $http, $location){

        $http.get('/web/api/users').success(function(users){
            $scope.users = users;
        });

        $scope.jumpToCreation = function(){

            $location.path('/userCreation');
        };

    });