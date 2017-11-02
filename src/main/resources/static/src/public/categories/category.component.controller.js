(function () {

    "use strict";

    angular.module('public')
        .controller('CategoryComponentController', CategoryComponentController);

    CategoryComponentController.$inject = ['currentUserCategory', 'currentUserProductsByCategory',
        'CategoriesService', 'ProductsService'];

    function CategoryComponentController(currentUserCategory, currentUserProductsByCategory,
                                         CategoriesService, ProductsService) {
        var controller = this;
        controller.category = currentUserCategory;
        controller.products = currentUserProductsByCategory;

    }



})();