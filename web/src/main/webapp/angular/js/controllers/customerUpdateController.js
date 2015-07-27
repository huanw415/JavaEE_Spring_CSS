'use strict';

angular.module('users_management')
    .controller('customerUpdateController', function ($scope, $routeParams, $http, $location) {
        var updateId = $routeParams.id;

        $http.get('/web/api/customers/' + updateId).success(function (customer) {
           $scope.customer =  customer;
        });

        $scope.updateCustomer = function (customer) {

            $http({
                method: 'PUT',
                url: '/web/api/customers/' + updateId,
                params: {name: customer.name}
            }).success(function () {
                $location.path('/customers');
            });
        }
    });