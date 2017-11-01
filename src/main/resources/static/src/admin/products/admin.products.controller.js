(function () {
    "use strict";

    angular.module('admin')
        .controller('AdminProductsController', AdminProductsController);

    AdminProductsController.$inject = ['products', 'AdminProductsService', '$stateParams'];

    function AdminProductsController(products, AdminProductsService, $stateParams) {
        var controller = this;
        controller.items = products;

        controller.categoryId = $stateParams.categoryId;
    }

})();