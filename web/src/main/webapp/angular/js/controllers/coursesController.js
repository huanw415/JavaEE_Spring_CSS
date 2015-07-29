'use strict';

angular.module('users_management')
    .controller('coursesController', function ($scope, $http, $route, $filter) {

        $http.get('/web/api/courses').success(function (courses) {
            $scope.courses =  $filter('orderBy')(courses, 'name');
        });

        $scope.deleteCourseById = function (deleteId) {
            $http.delete('/web/api/courses/' + deleteId).success(function () {
                $route.reload();
            });
        }
    });