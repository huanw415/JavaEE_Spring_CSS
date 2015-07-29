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
            })
            .when('/customers', {
                templateUrl: 'views/customers.html',
                controller: 'customersController'
            })
            .when('/customers/update/:id', {
                templateUrl: 'views/customerUpdate.html',
                controller: 'customerUpdateController'
            })
            .when('/customers/creation', {
                templateUrl: 'views/customerCreation.html',
                controller: 'customerCreationController'
            })
            .when('/courses', {
                templateUrl: 'views/courses.html',
                controller: 'coursesController'
            })
            .when('/courses/creation', {
                templateUrl: 'views/courseCreation.html',
                controller: 'courseCreationController'
            })
            .when('/courses/update/:id', {
                templateUrl: 'views/courseUpdate.html',
                controller: 'courseUpdateController'
            })
            .when('/schedules', {
                templateUrl: 'views/schedules.html',
                controller: 'schedulesController'
            })
            .when('/schedules/creation', {
                templateUrl: 'views/scheduleCreation.html',
                controller: 'scheduleCreationController'
            })
            .when('/schedules/update/:id', {
                templateUrl: 'views/scheduleUpdate.html',
                controller: 'scheduleUpdateController'
            });
    });