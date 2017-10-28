(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminCategoryUpdateController', AdminCategoryUpdateController);

    AdminCategoryUpdateController.$inject = ['AdminCategoriesService'];

    function AdminCategoryUpdateController(AdminCategoriesService) {
        var controller = this;

        controller.add = function () {
            console.log("add", null);
        }

    }

})();