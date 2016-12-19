app.controller('indexCtrl', ['$scope', '$rootScope', '$cookies', function($scope, $rootScope, $cookies) {

    $rootScope.indexUserName = $cookies.get("dianzan-userName");
    $rootScope.indexIsLogin = $scope.userName != null ? true : false;

    $scope.logout = function(){
        $rootScope.indexIsLogin = false;
        $rootScope.indexUserName = null;
        $cookies.put("dianzan-userName", null);
        $cookies.put("dianzan-userId", null);
    };
}]);
