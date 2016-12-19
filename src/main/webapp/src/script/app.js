var app = angular.module('app', [
    'ngRoute', 'ngCookies'
]);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/blog', {
            templateUrl: 'html/blog.html',
            controller: 'blogCtrl'
        })
        .when('/newBlog', {
            templateUrl: 'html/new-blog.html',
            controller: 'newBlogCtrl'
        })
        .when('/services', {
            templateUrl: 'html/services.html',
            controller: 'servicesCtrl'
        })
        .when('/contact', {
            templateUrl: 'html/contact.html',
            controller: 'contactCtrl'
        })
        .when('/faq', {
            templateUrl: 'html/faq.html',
            controller: 'faqCtrl'
        })
        .when('/about', {
            templateUrl: 'html/about.html',
            controller: 'aboutCtrl'
        })
        .when('/blogPost/:id', {
           templateUrl: 'html/blog-post.html',
           controller: 'blogPostCtrl'
        })
        .when('/login', {
            templateUrl: 'html/login.html',
            controller: 'loginCtrl'
        })
        .when('/userProfile', {
            templateUrl: 'html/user-profile.html',
            controller: 'userProfileCtrl'
        })
        .when('/myBlogs', {
            templateUrl: 'html/my-blogs.html',
            controller: 'myBlogsCtrl'
        })
        .otherwise({
            redirectTo: '/blog'
        });
});