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
        controller.productsIndices = [];
        controller.products = [];

        AdminProductsService.getAll()
            .then(function (data) {
                controller.products = data;
                controller.productsIndices = data.map(p => false);
                console.log("products loaded", data);
                // $state.reload();
            })
            .catch(function (error) {
                console.log("something went terribly wrong", error);
            });

        controller.add = function () {
            console.log("answer", controller.answer);
            console.log("controller.productsIndices",  controller.productsIndices.length);

            controller.answer.products = [];
            for (var i = 0; i < controller.productsIndices.length; i++) {

                if(controller.productsIndices[i]) {
                    controller.answer.products.push(controller.products[i].id);
                }
            }

            console.log("answer.products", controller.answer.products);
        }

    }

})();