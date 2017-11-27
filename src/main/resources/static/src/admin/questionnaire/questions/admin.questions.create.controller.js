(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminQuestionsCreateController', AdminQuestionsCreateController);

    AdminQuestionsCreateController.$inject = ['AdminQuestionsService', '$state', '$stateParams'];

    function AdminQuestionsCreateController(AdminQuestionsService, $state, $stateParams) {
        const controller = this;
        controller.questionId = $stateParams.questionId;
        controller.question = {};

        if(controller.questionId) {
            AdminQuestionsService.getById(controller.questionId)
                .then(response => controller.question.text = response.text)
                .catch(error => console.error("something went terribly wrong", error))
        }

        controller.update = function () {

            if(controller.questionId) {
                controller.question.questionId = controller.questionId;
                AdminQuestionsService.update(controller.question)
                    .then(function (response) {
                        console.log("successfully updated", response);
                        $state.reload();
                    })
                    .catch(function (error) {
                        console.error("something went terribly wrong", error);
                        $state.reload();
                    });
            } else {
                AdminQuestionsService.add(controller.question)
                    .then(function (response) {
                        console.log("successfully created", response);
                        $state.reload();
                    })
                    .catch(function (error) {
                        console.error("something went terribly wrong", error);
                        $state.reload();
                    });
            }


        };
    }

})();