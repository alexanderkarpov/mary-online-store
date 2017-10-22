(function () {
    'use strict';

    angular.module('public')
        .controller('CategoriesController', CategoriesController);

    CategoriesController.$inject = ['CategoriesService'];

    function CategoriesController(CategoriesService) {
        var controller = this;

        controller.categories = [];

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