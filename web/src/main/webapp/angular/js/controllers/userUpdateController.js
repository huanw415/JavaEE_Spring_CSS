'use strict';

angular.module('users_management')
    .controller('userUpdateController', function ($scope, $routeParams, $http, $location) {

        var userId = $routeParams.id;
        $http.get('/web/api/users/' + userId).success(function(user){
            $scope.user = user;
        });

        $scope.jumpToUsers = function(user){
            $http.put('/web/api/users/' + userId, {name : user.name, password: user.password})
                .success(function(){

                    $location.path('/users');
            });
        }
    });