(function () {
    'use strict';

    angular.module('admin')
        .component('adminProductsList', {
            templateUrl: 'src/admin/products/products.template.html',
            bindings: {
                items: '<'
            }
        });
})();