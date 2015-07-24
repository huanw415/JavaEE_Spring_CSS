'use strict';

angular.module('users_management', ['ngRoute'])
    .config(function($routeProvider){
        $routeProvider
            .when('/users', {
                templateUrl: 'views/users.html',
                controller: 'usersController'
            })
            .when('/userCreation', {
                templateUrl: 'views/usersCreation.html',
                controller: 'usersController'
            })
            .when('/employees', {
                templateUrl: 'views/employees.html',
                controller: 'employeesController'
            });
    });