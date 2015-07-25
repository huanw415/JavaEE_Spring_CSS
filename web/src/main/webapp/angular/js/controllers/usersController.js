'use strict';

angular.module('users_management')
    .controller('usersController', function($scope, $http, $location){

        var currentUrl = $location.path();

        if(currentUrl === '/users'){
            $http.get('/web/api/users').success(function(users){
                $scope.users = users;
            });
        }else{
            $http.get('/web/api/employees').success(function(employees){

                $scope.employees = employees;
            });
        }

        $scope.jumpToUsers = function(){

            $http({
                method: 'POST',
                url: '/web/api/users',
                params: {
                    'name': $scope.user.name,
                    'password': $scope.user.password,
                    'employeeName': $scope.user.coach
                }
            }).success(function(){
                $location.path('/users');
            });
        };

        $scope.jumpToUpdate = function(user){
            $scope.updatedUser = user;
        };
    });