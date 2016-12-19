app.controller('blogPostCtrl', ['$scope', '$rootScope', 'BlogService', 'UserService', 'CommentService', '$routeParams', '$http', '$location', function($scope, $rootScope, BlogService, UserService, CommentService,  $routeParams, $http, $location) {
    var serviceUrl = "http://127.0.0.1:8080/service/";

    var blogId = $routeParams.id;
    var blog = $scope.blog = {};
    var commentPosted = $scope.commentPosted = {};
    var commentsPageResult = $scope.commentsPageResult = {};
    BlogService.getBlogById(blogId).then(function successCallback(response) {
        blog = $scope.blog = response.data;
    }, function errorCallback(error){

    });

    CommentService.getComments(blogId, 1, 10).then(function successCallback (response) {
        $scope.commentsPageResult = response.data;
    });

    $scope.postComment = function () {
        if ($rootScope.indexIsLogin == false) {
            $location.path('login');
            return;
        }
        commentPosted.userName = $rootScope.indexUserName;
        commentPosted.blogId = blogId;
        CommentService.postComment(commentPosted).then(function successCallback (response) {
            commentPosted.content = '';
            CommentService.getComments(blogId, 1, 10).then(function successCallback (response) {
                $scope.commentsPageResult = response.data;
            });
        });
    }
}]);
