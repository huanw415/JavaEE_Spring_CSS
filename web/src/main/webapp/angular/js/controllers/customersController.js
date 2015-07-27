'use strict';

angular.module('users_management')
    .controller('customersController', function ($scope, $http) {

        $http.get('/web/api/customers').success(function (customers) {
            console.log(customers);
            $scope.customerObjects = customers;
        });
    });