'use strict';

angular.module('users_management')
    .controller('employeesController', function($scope, $http, $filter){

        $http.get('/web/api/employees').success(function (employees) {
            //$scope.employees = employees;
            $scope.employees = $filter('orderBy')(employees, 'name');
        });
    });