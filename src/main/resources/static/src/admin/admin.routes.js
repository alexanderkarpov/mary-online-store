(function () {
    "use strict";

    angular.module('admin')
        .config(routeConfig);


    routeConfig.$inject = ['$stateProvider'];

    function routeConfig($stateProvider) {
        // Routes
        $stateProvider
            .state('admin', {
                abstract: true,
                templateUrl: 'src/admin/admin.html'
            })
            .state('admin.main', {
                url: '/admin',
                templateUrl: 'src/admin/main/main.html'
            })
            .state('admin.main.categories', {
                url: '/admin/categories',
                templateUrl: 'src/admin/categories/categories.html',
                controller: 'AdminCategoriesController as categoriesList',
                resolve: {
                    categories: ['AdminCategoriesService', function (AdminCategoriesService) {
                        return AdminCategoriesService.getData();
                    }]
                }
            })
            .state('admin.main.products', {
                url: '/admin/products',
                templateUrl: 'src/admin/products/products.html'
            });
    }
})();
