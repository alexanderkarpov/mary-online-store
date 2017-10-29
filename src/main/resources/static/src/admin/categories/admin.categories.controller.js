(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminCategoriesController', AdminCategoriesController);

    AdminCategoriesController.$inject = ['AdminCategoriesService', 'categories', '$state'];

    function AdminCategoriesController(AdminCategoriesService, categories, $state) {
        var controller = this;
        controller.items = categories;

        controller.remove = function (id) {
            console.log("remove!!!", id);
            AdminCategoriesService.delete(id)
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