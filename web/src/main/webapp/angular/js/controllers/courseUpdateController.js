'use strict';

angular.module('users_management')
    .controller('courseUpdateController', function ($scope, $http, $routeParams, $location) {

        var updateId = $routeParams.id;

        $http.get('/web/api/courses/' + updateId).success(function (course) {
            $scope.course = course;
            console.log($scope.course );
        });

        $http.get('/web/api/coaches').success(function (coaches) {
            $scope.coaches = coaches;
        });

        $scope.updateCourse = function(course){
            $http({
                method: 'POST',
                url: '/web/api/courses/' + course.id,
                params: {
                    coachName: course.employee.name,
                    courseName: course.name
                }
            }).success(function () {
               $location.path('/courses');
            });
        }
    });