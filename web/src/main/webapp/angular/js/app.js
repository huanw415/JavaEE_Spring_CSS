'use strict';

angular.module('users_management', [
    //'ngResource',
    'ngRoute'
    //'checklist-model'
    ])
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
