app.controller('blogCtrl', ['$scope', 'UserService', function($scope, UserService) {
    UserService.getUsers().success(function(response){
        $scope.users = response;
    });
}]);
