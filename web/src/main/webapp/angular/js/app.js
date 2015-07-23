'use strict';

angular.module('users_management', ['ngRoute'])
    .config(function($routeProvider){
        $routeProvider
            .when('/', {
                templateUrl: 'views/users.html',
                controller: 'usersController'
            })
            .when('/users', {
                templateUrl: 'views/users.html',
                controller: 'usersController'
            });
    });
