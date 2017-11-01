(function () {
    "use strict";

    angular.module('admin')
        .config(routeConfig);


    routeConfig.$inject = ['$stateProvider'];

    function routeConfig($stateProvider) {
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
                url: '/admin/categories/list',
                templateUrl: 'src/admin/categories/categories.html',
                controller: 'AdminCategoriesController as categoriesList',
                resolve: {
                    categories: ['AdminCategoriesService', function (AdminCategoriesService) {
                        return AdminCategoriesService.getData();
                    }]
                }
            })
            .state('admin.main.addcategory', {
                url: '/admin/categories/add',
                templateUrl: 'src/admin/categories/category.add.form.html'
            })

            .state('admin.main.products', {
                url: '/admin/products/category/{categoryId}',
                templateUrl: 'src/admin/products/products.html',
                controller: 'AdminProductsController as productsList',
                resolve: {
                    products: ['$stateParams', 'AdminProductsService', function ($stateParams, AdminProductsService) {
                        console.log("categoryId", $stateParams.categoryId);
                        return AdminProductsService.getByCategoryId($stateParams.categoryId);
                    }]
                }
            })
            .state('admin.main.addproduct', {
                url: '/admin/products/add',
                templateUrl: 'src/admin/products/product.add.form.html'
            });
    }
})();
