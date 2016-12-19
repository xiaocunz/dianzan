app.controller('myBlogsCtrl', ['$scope', '$rootScope', 'BlogService', 'CategoryService', 'UserService', '$http', function($scope, $rootScope, BlogService,CategoryService, UserService, $http) {
    var pageBlogResult = $scope.pageBlogResult = {};
    var pageCategoryResult = $scope.pageCategoryResult = {};
    var search = $scope.search = {};
    search.page = 1;
    search.pageSize = 10;
    search.title = "";
    search.categoryId = 0;
    search.userName = $rootScope.indexUserName;

    CategoryService.getCategorys().then(function successCallback(response) {
        pageCategoryResult = $scope.pageCategoryResult = response.data;
    }, function errorCallback(error){

    });
    $scope.chooseCategory = function(categoryId) {
        $scope.search.categoryId = categoryId;
        initBlogs(search);
    }

    function initBlogs(search) {
        BlogService.getBlogsByUserName(search.categoryId, search.title, search.page, search.pageSize, search.userName).then(function successCallback(response) {
            pageBlogResult = $scope.pageBlogResult = response.data;
        }, function errorCallback(error){

        });
    }

    $scope.prepage = function() {
        search.page = search.page > 1 ? search.page - 1 : 1;
        initBlogs(search);
    }

    $scope.nextpage = function() {
        search.page = search.page + 1;
        initBlogs(search);
    }

    $scope.searchByTitle = function() {
        initBlogs(search);
    }
    initBlogs(search);
}]);
