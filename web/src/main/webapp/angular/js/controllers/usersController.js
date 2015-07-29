'use strict';

angular.module('users_management')
    .controller('usersController', function($scope, $http, $location, $route, $filter){

        $http.get('/web/api/users').success(function(users){
            $scope.users = $filter('orderBy')(users, 'name');
        });

        $scope.deleteUser = function(id){
            $http.delete('/web/api/users/' + id)
                .success(function(){
                    $route.reload();
                });
        }
    });