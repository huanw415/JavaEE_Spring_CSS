'use strict';

angular.module('users_management')
    .controller('usersController', function($scope, $http, $location){

        $http.get('/web/api/users').success(function(users){
            $scope.users = users;
        });

        $scope.addNewUser = function(){

            $http.get('/web/api/employees').success(function(employees){

                $scope.employees = employees;
                $location.path('/userCreation');
            });
        };
    });