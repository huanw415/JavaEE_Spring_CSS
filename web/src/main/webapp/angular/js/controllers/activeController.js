'use strict';

angular.module('users_management')
    .controller('activeController', function ($scope, $location) {

        function inactiveAll(){
            $scope.homeIsActive = false;
            $scope.usersIsActive = false;
            $scope.employeesIsActive = false;
            $scope.customersIsActive = false;
            $scope.coursesIsActive = false;
            $scope.schedulesIsActive = false;
        }
        //var path = $location.path();

        //console.log(path)

        inactiveAll();

        $scope.activeHome = function () {
            inactiveAll();
            $scope.homeIsActive = true;
        };

        $scope.activeUsers = function () {
            inactiveAll();
            $scope.usersIsActive = true;
        };

        $scope.activeEmployees = function () {
            inactiveAll();
            $scope.employeesIsActive = true;
        };

        $scope.activeCourses = function () {
            inactiveAll();
            $scope.coursesIsActive = true;
        };

        $scope.activeCustomers = function () {

            inactiveAll();
            $scope.customersIsActive = true;
        };

        $scope.activeSchedules = function () {

            inactiveAll();
            $scope.schedulesIsActive = true;
        };

        //if(path == ""){
        //    inactiveAll();
        //    $scope.homeIsActive = true;
        //}
        //if(path = "users"){
        //    inactiveAll();
        //    $scope.usersIsActive = true;
        //}
        //else{
        //    inactiveAll();
        //    var variable = path + 'IsActive';
        //    $scope.variable = true;
        //}

    });