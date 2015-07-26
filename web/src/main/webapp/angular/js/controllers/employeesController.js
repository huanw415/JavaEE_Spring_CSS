'use strict';

angular.module('users_management')
    .controller('employeesController', function($scope, $http){

        $http.get('/web/api/employees').success(function (employees) {
            $scope.employees = employees;
        });
    });