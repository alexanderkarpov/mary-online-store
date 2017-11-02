(function () {
    "use strict";

    angular.module('public')
        .config(routeConfig);


    routeConfig.$inject = ['$stateProvider'];

    function routeConfig($stateProvider) {
        // Routes
        $stateProvider
            .state('public', {
                abstract: true,
                templateUrl: 'src/public/public.html'
            })
            .state('public.home', {
                url: '/home',
                templateUrl: 'src/public/home/home.html'
            })
            .state('public.category', {
                url: '/category/{categoryId}',
                templateUrl: 'src/public/categories/category.html'
            });
    }
})();
