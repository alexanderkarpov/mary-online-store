(function () {
    "use strict";

    angular.module('admin')
        .controller('AdminProductsController', AdminProductsController);

    AdminProductsController.$inject = ['products', 'AdminProductsService', '$stateParams', '$state'];

    function AdminProductsController(products, AdminProductsService, $stateParams, $state) {
        var controller = this;
        controller.items = products;

        controller.categoryId = $stateParams.categoryId;

        controller.remove = function (id) {
            AdminProductsService.delete(id)
                .then(function (response) {
                    console.log("successfully deleted", response);
                    $state.reload();
                })
                .catch(function (error) {
                    console.error("something went terribly wrong", error);
                    $state.reload();
                });
        };
    }

})();