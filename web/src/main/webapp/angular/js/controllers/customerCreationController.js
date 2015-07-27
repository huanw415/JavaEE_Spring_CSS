'use strict';

angular.module('users_management')
    .controller('customerCreationController', function ($scope, $location, $http) {

        $scope.createCustomer = function (customer) {

            $http.post('/web/api/customers', {name: customer.name}).success(function () {
                $location.path('/customers');
            })
        }
    });