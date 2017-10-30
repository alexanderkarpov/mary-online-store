(function () {
    "use strict";

    angular.module('admin')
        .controller('AdminProductsController', AdminProductsController);

    AdminProductsController.$inject = ['products', 'AdminProductsService'];

    function AdminProductsController(products, AdminProductsService) {
        var controller = this;
        controller.items = products;
    }

})();