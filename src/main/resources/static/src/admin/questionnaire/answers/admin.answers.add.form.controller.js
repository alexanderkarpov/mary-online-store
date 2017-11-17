(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersAddFormController', AdminAnswersAddFormController);

    AdminAnswersAddFormController.$inject =
        ['AdminAnswersService', 'AdminProductsService', '$stateParams', '$state'];

    function AdminAnswersAddFormController(AdminAnswersService, AdminProductsService, $stateParams, $state) {
        var controller = this;

        controller.answer = {};
        controller.answer.questionId = $stateParams.questionId;
        controller.answer.products = [];
        controller.products = [];

        AdminProductsService.getAll()
            .then(function (data) {
                controller.products = data;
                console.log("products loaded", data);
                // $state.reload();
            })
            .catch(function (error) {
                console.log("something went terribly wrong", error);
            });

        controller.add = function () {
            console.log("answer", controller.answer);
            console.log("answer.products", controller.answer.products);

            console.log("controller.answer.products.length",  controller.answer.products.length);
            for (var i = 0; i < controller.answer.products.length; i++) {
                console.log("i=" + i, controller.answer.products[i]);
            }
        }

    }

})();