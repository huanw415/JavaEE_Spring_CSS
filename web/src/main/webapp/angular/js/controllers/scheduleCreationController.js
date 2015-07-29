'use strict';

angular.module('users_management')
    .controller('scheduleCreationController', function ($scope, $http, $location) {

        //$scope.course;
        $http.get('/web/api/courses').success(function (courses) {

            var commonCourses = [];
            for(var i=0; i<courses.length; i++){
                if(courses[i].name != 'private'){
                    commonCourses.push(courses[i]);
                }
            }

            $scope.courses = commonCourses;
        });

        $http.get('/web/api/coaches/privateCoaches').success(function (privateCoaches) {
            $scope.privateCoaches = privateCoaches;
        });

        $http.get('/web/api/customers').success(function (customers) {
            $scope.customers = customers;
        });

        $scope.savePrivateCourse = function (coachName, customerName, commonTime) {

         //   (coach.name, customer.name, privateTime)
         console.log(coachName + "============");
         console.log(customerName + "============");
         console.log(commonTime + "============");
            $http({
                method: 'POST',
                url: '/web/api/schedules/privateCreation',
                params: {
                    coachName: coachName,
                    time: commonTime,
                    customerName: customerName
                }
            }).success(function (result) {
                if(result == 'coach is busy'){
                    $scope.privateTimeStyle = {'background-color':'pink'};
                }else{
                    $location.path('/schedules');
                }
            });
        }

    });