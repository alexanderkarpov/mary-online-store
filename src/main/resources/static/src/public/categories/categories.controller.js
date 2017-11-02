(function () {
    'use strict';

    angular.module('public')
        .controller('CategoriesController', CategoriesController);

    CategoriesController.$inject = ['CategoriesService', '$stateParams'];

    function CategoriesController(CategoriesService, $stateParams) {
        var controller = this;

        controller.categories = [];

        controller.categoryId = $stateParams.categoryId;

        CategoriesService.getData()
            .then(function (response) {
                controller.categories = response.data;
            })
            .catch(function (error) {
                console.error("something went terribly wrong", error);
                controller.categories = [];
            });

    }
})();