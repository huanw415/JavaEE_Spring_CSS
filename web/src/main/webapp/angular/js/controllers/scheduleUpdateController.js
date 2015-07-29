'use strict';

angular.module('users_management')
    .controller('scheduleUpdateController', function ($scope, $location, $http, $routeParams, $filter) {

        var updateId = $routeParams.id;
        $http.get('/web/api/schedules/' + updateId).success(function (schedule) {

            schedule.time = new Date(schedule.time);
            $scope.schedule = schedule;
        });

        $scope.updateSchedule = function (time) {


            $http({
                method: 'POST',
                url: '/web/api/schedules/' + updateId,
                params:{time: $filter('date')(time, 'yyyy-MM-dd')}
            }).success(function () {
                $location.path('/schedules');
            })
        }
    });