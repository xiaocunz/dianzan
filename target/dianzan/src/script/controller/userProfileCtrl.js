app.controller('userProfileCtrl', ['$scope', '$rootScope', '$location', '$cookies', 'UserService', function($scope, $rootScope, $location, $cookies, UserService) {
    var userProfileModel = $scope.userProfileModel = {};
    UserService.getUserById($rootScope.indexUserId).then(function successCallback(response) {
        $scope.userProfileModel = response.data;
    }, function errorCallback(error){

    });
}]);
