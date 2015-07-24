angular.module('users_management')
    .controller('userCreationController', function($scope, $http, $location){

        $http.get('/web/api/users').success(function(users){
            $scope.users = users;
        });

        $scope.addNewUser = function(){

            //$http.get('/web/api/employees').success(function(employees){
            //
            //    $scope.employees = employees;
            //    console.log($scope.employees);
            //    $location.path('/userCreation');
            //});
        };

    });