'use strict';

angular.module('users_management', ['ngRoute'])
    .config(function($routeProvider){
        $routeProvider
            .when('/users', {
                templateUrl: 'views/users.html',
                controller: 'usersController'
            })
            .when('/users/creation', {
                templateUrl: 'views/userCreation.html',
                controller: 'userCreationController'
            })
            .when('/users/update/:id', {
                templateUrl: 'views/userUpdate.html',
                controller: 'userUpdateController'
            })
            .when('/employees', {
                templateUrl: 'views/employees.html',
                controller: 'employeesController'
            })
            .when('/employees/creation', {
                templateUrl: 'views/employeeCreation.html',
                controller: 'employeeCreationController'
            })
            .when('/employees/update/:id', {
                templateUrl: 'views/employeeUpdate.html',
                controller: 'employeeUpdateController'
            });
    });