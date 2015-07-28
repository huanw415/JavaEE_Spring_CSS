'use strict';

angular.module('users_management')
    .controller('coursesController', function ($scope, $http, $route) {

        $http.get('/web/api/courses').success(function (courses) {
            $scope.courses = courses;
        });

        $scope.deleteCourseById = function (deleteId) {
            $http.delete('/web/api/courses/' + deleteId).success(function () {
                $route.reload();
            });
        }
    });