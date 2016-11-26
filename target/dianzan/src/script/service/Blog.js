app
    .factory('BlogService', function($http) {

        var blogService = {};
        var serviceUrl = "http://127.0.0.1:8080/service/";

        blogService.getBlogs = function() {
            return $http({
                method: 'get',
                url: serviceUrl + 'blog?page=1&pageSize=10'
            });
        }

        blogService.getBlogById = function(id) {
            return $http({
                method: 'get',
                url: serviceUrl + 'blog/' + id
            });
        }

        return blogService;
    });