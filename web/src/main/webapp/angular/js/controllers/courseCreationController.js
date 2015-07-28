'use strict';

angular.module('users_management')
    .controller('courseCreationController', function ($scope, $http, $location) {

        $http.get('/web/api/coaches').success(function (coaches) {

            $scope.coaches = coaches;
        });

        $scope.createCourse = function (course) {

            $http({
                method: 'POST',
                url: '/web/api/courses',
                params: {courseName: course.name, coachName: course.employee}
            }).success(function (result) {

                if(result == 'the course has existed'){
                    $scope.inputStyle = {'background-color':'pink'};
                }else{
                    $location.path('/courses');
                }
            });

        }
    });