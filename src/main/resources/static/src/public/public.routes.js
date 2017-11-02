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
                templateUrl: 'src/public/categories/category.html',
                controller: 'CategoryComponentController as controller',
                resolve: {
                    currentUserCategory: ['$stateParams', 'CategoriesService', function ($stateParams, CategoriesService) {
                        return CategoriesService.getById($stateParams.categoryId);
                    }],
                    currentUserProductsByCategory: ['$stateParams', 'ProductsService', function ($stateParams, ProductsService) {
                        return ProductsService.getByCategoryId($stateParams.categoryId);
                    }]
                }
            });
    }
})();
