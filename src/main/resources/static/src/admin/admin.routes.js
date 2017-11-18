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

            //categories
            .state('admin.main.categories', {
                url: '/categories/list',
                templateUrl: 'src/admin/categories/categories.html',
                controller: 'AdminCategoriesController as categoriesList',
                resolve: {
                    categories: ['AdminCategoriesService', function (AdminCategoriesService) {
                        return AdminCategoriesService.getData();
                    }]
                }
            })
            .state('admin.main.addcategory', {
                url: '/categories/add',
                templateUrl: 'src/admin/categories/category.add.form.html'
            })

            //products
            .state('admin.main.products', {
                url: '/products/category/{categoryId}',
                templateUrl: 'src/admin/products/products.html',
                controller: 'AdminProductsController as productsList',
                resolve: {
                    products: ['$stateParams', 'AdminProductsService', function ($stateParams, AdminProductsService) {
                        return AdminProductsService.getByCategoryId($stateParams.categoryId);
                    }]
                }
            })
            .state('admin.main.addproduct', {
                url: '/products/category/{categoryId}/add',
                templateUrl: 'src/admin/products/product.add.form.html'
            })

            //questionnaire
            .state('admin.main.questions', {
                url: '/questions',
                templateUrl: 'src/admin/questionnaire/questions/questions.html',
                controller: 'AdminQuestionsListController as questionsList',
                resolve: {
                    questions: ['AdminQuestionsService', function (AdminQuestionsService) {
                        return AdminQuestionsService.getAll();
                    }]
                }
            })
            .state('admin.main.addquestion', {
                url: '/questions/add',
                templateUrl: 'src/admin/questionnaire/questions/question.add.form.html'
            })
            .state('admin.main.answers', {
                url: '/answers/{questionId}',
                templateUrl: 'src/admin/questionnaire/answers/admin.answers.html',
                controller: 'AdminAnswersListController as answersList',
                resolve: {
                    question: ['$stateParams', 'AdminQuestionsService', function ($stateParams, AdminQuestionsService) {
                        return AdminQuestionsService.getById($stateParams.questionId);
                    }]
                }
            })
            .state('admin.main.answers.addbutton', {
                url: '/list',
                templateUrl: 'src/admin/questionnaire/answers/admin.answers.add.button.html'
            })
            .state('admin.main.answers.addanswer', {
                url: '/add',
                templateUrl: 'src/admin/questionnaire/answers/admin.answers.add.form.html'
            })

            //Carousel
            .state('admin.main.carousel', {
                url: '/carousel',
                templateUrl: 'src/admin/carousel/admin.carousel.html'
            });

    }
})();
