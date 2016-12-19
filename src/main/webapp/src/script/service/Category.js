app
    .factory('CategoryService', function($http) {

        var categoryService = {};
        var serviceUrl = "http://127.0.0.1:8082/service/";

        categoryService.getCategorys = function() {
            return $http({
                method: 'get',
                url: serviceUrl + 'category?page=1&pageSize=10'
            });
        }

        categoryService.getCategoryById = function(id) {
            return $http({
                method: 'get',
                url: serviceUrl + 'category/' + id
            });
        }

        return categoryService;
    });