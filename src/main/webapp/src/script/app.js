var app = angular.module('app', [
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/blog', {
            templateUrl: 'html/blog.html',
            controller: 'blogCtrl'
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
        //.when('/inbox/email/:id', {
        //    templateUrl: 'views/email.html',
        //    controller: 'EmailCtrl',
        //    controllerAs: 'email'
        //})
        .otherwise({
            redirectTo: '/blog'
        });
});