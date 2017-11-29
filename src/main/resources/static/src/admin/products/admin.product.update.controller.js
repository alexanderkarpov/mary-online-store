(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminProductUpdateController', AdminProductUpdateController);

    AdminProductUpdateController.$inject = ['AdminProductsService', '$stateParams', '$state'];

    function AdminProductUpdateController(AdminProductsService, $stateParams, $state) {
        const controller = this;

        controller.productId = $stateParams.productId;

        controller.product = {};
        controller.product.category = {};
        controller.files = {};

        controller.product.category.id = $stateParams.categoryId;

        if(controller.productId) {
            AdminProductsService.getById(controller.productId)
                .then(product => controller.product = product)
                .catch(error => console.error("something went terribly wrong", error));
        }

        controller.add = function () {
            console.log("upload", controller.product);

            AdminProductsService.add(controller.product, controller.files.image)
                .then(function (response) {
                    console.log("successfully uploaded", response);
                    $state.reload();
                })
                .catch(function (error) {
                    console.error("something went terribly wrong", error);
                });
        };
    }

})();