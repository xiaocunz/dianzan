app.controller('blogCtrl', ['$scope', 'BlogService', '$http', function($scope, BlogService, $http) {
    var serviceUrl = "http://127.0.0.1:8080/service/";
    var pageBlogResult = $scope.pageBlogResult = {};
    BlogService.getBlogs().then(function successCallback(response) {
        pageBlogResult = $scope.pageBlogResult = response.data;
    }, function errorCallback(error){

    });
}]);
