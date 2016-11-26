app.controller('blogPostCtrl', ['$scope', 'BlogService', '$routeParams', '$http', function($scope, BlogService, $routeParams, $http) {
    var serviceUrl = "http://127.0.0.1:8080/service/";

    var blogId = $routeParams.id;
    var blog = $scope.blog = {};
    BlogService.getBlogById(blogId).then(function successCallback(response) {
        blog = $scope.blog = response.data;
    }, function errorCallback(error){

    });
}]);
