'use strict';

angular.module('users_management')
    .controller('courseUpdateController', function ($scope, $http, $routeParams) {

        var updateId = $routeParams.id;
        $http.get('/web/api/courses/' + updateId).success(function (course) {
            $scope.course = course;
            console.log($scope.course );
        });

        $http.get('/web/api/coaches').success(function (coaches) {
            $scope.coaches = coaches;
        });
    });