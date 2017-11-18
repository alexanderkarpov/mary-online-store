(() => {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersAddFormController', AdminAnswersAddFormController);

    AdminAnswersAddFormController.$inject =
        ['AdminAnswersService', 'AdminProductsService', '$stateParams', '$state'];

    function AdminAnswersAddFormController(AdminAnswersService, AdminProductsService, $stateParams, $state) {
        const controller = this;

        controller.answer = {};
        controller.answer.questionId = $stateParams.questionId;
        controller.productsIndices = [];
        controller.products = [];

        AdminProductsService.getAll()
            .then(data => {
                controller.products = data;
                controller.productsIndices = data.map(p => false);
                console.log("products loaded", data);
            })
            .catch(error => console.log("something went terribly wrong", error));


        controller.add = () => {
            console.log("answer", controller.answer);
            console.log("controller.productsIndices", controller.productsIndices.length);

            controller.answer.productIds = [];
            for (let i = 0; i < controller.productsIndices.length; i++) {

                if (controller.productsIndices[i]) {
                    controller.answer.productIds.push(controller.products[i].id);
                }
            }

            console.log("answer.productIds", controller.answer.productIds);

            AdminAnswersService.add(controller.answer)
                .then(response => {
                    console.log("successfully created", response);
                    $state.reload();
                })
                .catch(error => {
                    console.error("something went terribly wrong", error);
                    $state.reload();
                });
        }

    }

})();