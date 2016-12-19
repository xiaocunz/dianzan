app.controller('newBlogCtrl', ['$scope', '$rootScope', 'BlogService', 'UserService', '$http' , '$location', function($scope, $rootScope, BlogService, UserService, $http, $location) {
    var blog = $scope.blog = {};

    $scope.post = function() {
        if ($rootScope.indexIsLogin == false) {
            $location.path('login');
            return;
        }
        blog.userName = $rootScope.indexUserName;
        BlogService.postBlog(blog).then(function successCallback(response) {
            var result = response.data;
            if (result != true) {
                $location.path('blog');
            } else {

            }
        }, function errorCallback(error){

        });
    }

}]);
