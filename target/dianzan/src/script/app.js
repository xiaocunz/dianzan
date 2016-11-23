var app = angular.module('app', [
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/blog', {
            templateUrl: 'blog.html',
            controller: 'blogCtrl'
        })
        .when('/services', {
            templateUrl: 'services.html',
            controller: 'servicesCtrl'
        })
        .when('/contact', {
            templateUrl: 'contact.html',
            controller: 'contactCtrl'
        })
        .when('/faq', {
            templateUrl: 'faq.html',
            controller: 'faqCtrl'
        })
        .when('/about', {
            templateUrl: 'about.html',
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