app
    .factory('UserService', function($http) {

        var userService = {};

        userService.getUsers = function() {
            return $http({
                method: 'JSONP',
                url: 'http://loveqing.net/rest/users'
            });
        }

        //ergastAPI.getDriverDetails = function(id) {
        //    return $http({
        //        method: 'JSONP',
        //        url: 'http://ergast.com/api/f1/2013/drivers/'+ id +'/driverStandings.json?callback=JSON_CALLBACK'
        //    });
        //}
        //
        //ergastAPI.getDriverRaces = function(id) {
        //    return $http({
        //        method: 'JSONP',
        //        url: 'http://ergast.com/api/f1/2013/drivers/'+ id +'/results.json?callback=JSON_CALLBACK'
        //    });
        //}

        return userService;
    });