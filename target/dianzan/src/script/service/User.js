app
    .factory('UserService', function($http) {

        var userService = {};
        var serviceUrl = "http://127.0.0.1:8082/service/";

        userService.getUserById = function(id) {
            return $http({
                method: 'get',
                url: serviceUrl + 'user/' + id
            });
        };

        userService.auth = function(userName, password) {
            return $http({
                method: 'get',
                url: serviceUrl + 'user/auth?userName=' + userName + '&password=' + password
            });
        };

        userService.register = function(user) {
            return $http({
                method: 'post',
                url: serviceUrl + 'user',
                data: user
            });
        }

        return userService;
    });