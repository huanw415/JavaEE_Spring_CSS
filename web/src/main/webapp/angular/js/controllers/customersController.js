'use strict';

angular.module('users_management')
    .controller('customersController', function ($scope, $http, $route) {

        $http.get('/web/api/customers').success(function (customers) {

            for(var i=0; i<customers.length; i++){

                var courses = customers[i].courses;

                for(var j=0; j<courses.length; j++){

                    if(courses[j].name === 'private'){
                        customers[i].privateCoach = courses[j].employee.name;
                    }
                }
            }

            $scope.customerObjects = customers;
        });

        $scope.deleteCustomerById = function (id) {
            $http.delete('/web/api/customers/' + id).success(function () {
                $route.reload();
            });
        }
    });