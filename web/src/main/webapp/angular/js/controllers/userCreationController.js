angular.module('users_management')
    .controller('userCreationController', function($scope, $http, $location){
        
        $http.get('/web/api/employees').success(function(employees){
            $scope.employees = employees;
        });
    });