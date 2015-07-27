'use strict';

angular.module('users_management')
    .controller('customerUpdateController', function ($scope, $routeParams, $http, $location) {
        var updateId = $routeParams.id;

        $http.get('/web/api/customers/' + updateId).success(function (customer) {
           $scope.customer =  customer;
        });
    });