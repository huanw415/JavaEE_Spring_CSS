'use strict';

var app = angular.module('users_management', [], angular.noop);
app.filter('privateCourse', function(){
    var filter = function(input){
        var commonCourses = [];
        for(var i=0; i<input.length; i++){
            if(input[i].name != 'private'){
                commonCourses.add(input[i]);
            }
        }
        return commonCourses;
    };
    return filter;
});