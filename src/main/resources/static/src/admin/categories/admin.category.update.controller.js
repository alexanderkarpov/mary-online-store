(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminCategoryUpdateController', AdminCategoryUpdateController);

    AdminCategoryUpdateController.$inject = ['AdminCategoriesService'];

    function AdminCategoryUpdateController(AdminCategoriesService) {
        var controller = this;

        controller.category = [];

        controller.add = function () {
            console.log("upload", controller.category);

            AdminCategoriesService.uploadImage(controller.category.image)
                .then(function (response) {
                    console.log("successfully uploaded", response);
                })
                .catch(function (error) {
                    console.error("something went terribly wrong", error);
                    // controller.categories = [];
                });
        }

    }

})();