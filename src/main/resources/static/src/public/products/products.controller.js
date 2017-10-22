(function () {
    'use strict';

    angular.module('public')
        .controller('ProductsController', ProductsController);

    ProductsController.$inject = ['ProductsService'];

    function ProductsController(ProductsService) {
        var controller = this;

        controller.products = [];

        ProductsService.getData()
            .then(function (response) {
                controller.products = response.data;
            })
            .catch(function (error) {
                console.error("something went terribly wrong", error);
                controller.products = [];
            });

    }
})();