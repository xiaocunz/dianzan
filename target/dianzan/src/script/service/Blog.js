app
    .factory('BlogService', function($http) {

        var blogService = {};
        var serviceUrl = "http://127.0.0.1:8082/service/";

        blogService.getBlogsByUserName = function(categoryId, str, page, pageSize, userName) {
            return $http({
                method: 'get',
                url: serviceUrl + 'blog?userName=' + userName + '&categoryId=' + categoryId + '&str=' + str + "&page=" + page + "&pageSize=" + pageSize,
            });
        };

        blogService.getBlogs = function(categoryId, str, page, pageSize) {
            return $http({
                method: 'get',
                url: serviceUrl + 'blog?categoryId=' + categoryId + '&str=' + str + "&page=" + page + "&pageSize=" + pageSize,
            });
        }

        blogService.getBlogById = function(id) {
            return $http({
                method: 'get',
                url: serviceUrl + 'blog/' + id
            });
        }

        blogService.postBlog = function(blog) {
            return $http({
                method: 'post',
                url: serviceUrl + 'blog',
                data: blog
            });
        }

        return blogService;
    });