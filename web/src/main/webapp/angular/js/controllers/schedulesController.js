'use strict';

angular.module('users_management')
    .controller('schedulesController', function ($scope, $http, $route, $filter) {

        $http.get('/web/api/schedules').success(function (schedules) {

            $scope.schedules = $filter('orderBy')(schedules, 'time');
        });

        $scope.deleteSchedule = function (deleteId) {
            $http.delete('/web/api/schedules/' + deleteId).success(function () {

                $route.reload();
            })
        }
    });