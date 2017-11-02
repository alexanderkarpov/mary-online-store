(function () {
    'use strict';

    angular.module('public')
        .component('productPreview', {
            templateUrl: 'src/public/products/product.preview.template.html',
            bindings: {
                product: '<'
            }
        });

})();
