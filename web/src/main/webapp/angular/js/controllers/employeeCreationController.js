'user strict';

angular.module('users_management')
    .controller('employeeCreationController', function ($scope, $http, $location) {
        $scope.createEmployee = function (employee) {
            $http.post('/web/api/employees',
                { name: employee.name, role: employee.role, gender: employee.gender, email: employee.email, age: employee.age})
                .success(function(){
                   $location.path('/employees');
                });
        }
    });