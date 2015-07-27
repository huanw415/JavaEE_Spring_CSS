'use strict';

angular.module('users_management')
    .controller('coursesController', function ($scope, $http) {

        $http.get('/web/api/courses').success(function (courses) {
            $scope.courses = courses;
        })
    });