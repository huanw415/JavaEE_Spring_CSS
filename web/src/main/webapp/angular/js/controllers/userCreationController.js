'use strict';

angular.module('users_management')
    .controller('userCreationController', function($scope, $http, $location){

        $http.get('/web/api/employees').success(function(employees){

            $scope.employees = employees;
        });

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
});