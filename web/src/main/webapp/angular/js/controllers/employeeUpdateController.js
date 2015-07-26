'use strict';

angular.module('users_management')
    .controller('employeeUpdateController', function($scope, $routeParams, $http, $location){

        var updateId = $routeParams.id;

        function judgeGender(gender){

            if(gender === 'male'){
                $scope.male = true;
            }else{
                $scope.female = true;
            }
        }

        function judgeRole(role){
            if(role === 'OPs'){
                $scope.OPs = true;
            }
            if(role === 'Coach'){
                $scope.Coach = true;
            }
            if(role === 'HR'){
                $scope.HR = true;
            }
        }

        $http.get('/web/api/employees/' + updateId).success(function (employee) {
            judgeGender(employee.gender);
            judgeRole(employee.role);

            $scope.employee = employee;
        });

        $scope.updateUser = function(employee){
            $http.put('/web/api/employees/' + updateId,
                {id: employee.id, name: employee.name, role: employee.role, gender: employee.gender, email: employee.email, age: employee.age})
                .success(function () {
                    $location.path('/employees');
                })

        }
    });