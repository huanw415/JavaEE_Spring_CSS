'use strict';

angular.module('users_management', ['ngRoute'])
    .config(function($routeProvider){
        $routeProvider
            .when('/users', {
                templateUrl: 'views/users.html',
                controller: 'usersController'
            });
    });
