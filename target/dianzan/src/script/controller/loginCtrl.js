app.controller('loginCtrl', ['$scope', '$rootScope', '$location', '$cookies', 'UserService', function($scope, $rootScope, $location, $cookies, UserService) {
    $scope.page = "login";
    var loginModel = $scope.loginModel = {};
    var registerModel = $scope.registerModel = {};
    $scope.goRegister = function() {
        $scope.page = "register";
    }
    $scope.goLogin = function() {
        $scope.page = "login";
    }
    $scope.login = function() {
        UserService.auth(loginModel.userName, loginModel.password).then(function successCallback(response) {
            var result = response.data;
            if (result != null) {
                setUserInfo(result);

                $location.path('blog');
            } else {
                $scope.errorMessage = "UserName or password incorrect.";
            }
        }, function errorCallback(error){

        });
    };
    $scope.register = function() {
        UserService.register(registerModel).then(function successCallback(response) {
            var result = response.data;
            if (result != null) {
                setUserInfo(result);
                $location.path('blog');
            } else {
                $scope.errorMessage = "Register failed.";
            }
        }, function errorCallback(error){

        });
    }

    function setUserInfo(user) {
        $cookies.put("dianzan-userId", user.id);
        $cookies.put("dianzan-userName", user.userName);
        $cookies.put("dianzan-userId", user.id);
        $rootScope.indexIsLogin = true;
        $rootScope.indexUserName = user.userName;
        $rootScope.indexUserId = user.id;
    }

}]);
