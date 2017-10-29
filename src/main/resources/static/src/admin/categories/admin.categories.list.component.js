(function () {
    'use strict';

    angular.module('admin')
        .component('adminCategoriesList', {
            templateUrl: 'src/admin/categories/categories.template.html',
            bindings: {
                items: '<',
                onRemove: '&'
            }
        });

})();
