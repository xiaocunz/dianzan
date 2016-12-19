app
    .factory('CommentService', function($http) {

        var commentService = {};
        var serviceUrl = "http://127.0.0.1:8082/service/";

        commentService.getComments = function(blogId, page, pageSize) {
            return $http({
                method: 'get',
                url: serviceUrl + 'comment?blogId=' + blogId + "&page=" + page + "&pageSize=" + pageSize
            });
        };

        commentService.postComment = function(comment) {
            return $http({
                method: 'post',
                url: serviceUrl + 'comment',
                data: comment
            });
        }

        return commentService;
    });