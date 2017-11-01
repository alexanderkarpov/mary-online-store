(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminProductUpdateController', AdminProductUpdateController);

    AdminProductUpdateController.$inject = ['AdminProductsService', '$stateParams', '$state'];

    function AdminProductUpdateController(AdminProductsService, $stateParams, $state) {
        var controller = this;

        controller.product = {};
        controller.product.category = {};
        controller.files = {};

        controller.product.category.id = $stateParams.categoryId;

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