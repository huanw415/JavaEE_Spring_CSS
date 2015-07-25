'use strict';

angular.module('users_management')
    .controller('usersController', function($scope, $http, $location, $route){

        $http.get('/web/api/users').success(function(users){
            $scope.users = users;
        });


        $scope.deleteUser = function(id){
            $http.delete('/web/api/users/' + id)
                .success(function(){
                    $route.reload();
                });
        }
    });