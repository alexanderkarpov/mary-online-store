(() => {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersAddFormController', AdminAnswersAddFormController);

    AdminAnswersAddFormController.$inject =
        ['AdminAnswersService', 'AdminProductsService', '$stateParams', '$state'];

    function AdminAnswersAddFormController(AdminAnswersService, AdminProductsService, $stateParams, $state) {
        const controller = this;

        controller.answerId = $stateParams.answerId;

        console.log("controller.answerId", controller.answerId);

        controller.answer = {};
        controller.answer.questionId = $stateParams.questionId;
        controller.productsIndices = [];
        controller.products = [];

        AdminProductsService.getAll()
            .then(data => {
                controller.products = data;
                controller.productsIndices = data.map(p => false);
                console.log("products loaded", data);

                if (controller.answerId) {
                    const answerId = controller.answerId;
                    console.log("load answer to update", answerId);
                    AdminAnswersService.getById(answerId)
                        .then(answerData => {
                            console.log("answer loaded", answerData);
                            controller.answer.text = answerData.text;
                            console.log("answerData", answerData);
                            const productIds = answerData.products.map(p => p.id);

                            // answer.productIds //array.includes
                            controller.productsIndices = controller.products.map(p => productIds.includes(p.id));

                        })
                        .catch(error => console.log("something went terribly wrong", error));
                }
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


            if(controller.answerId) {
                const updateAnswerReq = {
                    answerId: controller.answerId,
                    text: controller.answer.text,
                    productIds: controller.answer.productIds
                };

                AdminAnswersService.update(updateAnswerReq)
                    .then(response => {
                        console.log("successfully created", response);
                        $state.reload();
                    })
                    .catch(error => {
                        console.error("something went terribly wrong", error);
                        $state.reload();
                    });

            } else {
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

    }

})();