'use strict';

angular.module('users_management')
    .controller('schedulesController', function ($scope, $http) {

        $http.get('/web/api/schedules').success(function (schedules) {
            $scope.schedules = schedules;
        })
    });