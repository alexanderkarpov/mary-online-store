(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminCategoriesController', AdminCategoriesController);

    AdminCategoriesController.$inject = ['AdminCategoriesService', 'categories'];

    function AdminCategoriesController(AdminCategoriesService, categories) {
        var controller = this;
        controller.items = categories;

        controller.remove = function (id) {
            console.log("remove!!!", id);
        };
    }

})();