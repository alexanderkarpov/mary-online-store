(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersListController', AdminAnswersListController);

    AdminAnswersListController.$inject = ['question', 'AdminQuestionsService', 'AdminAnswersService', '$state'];

    function AdminAnswersListController(question, AdminQuestionsService, AdminAnswersService, $state) {
        const controller = this;

        controller.question = question;

        controller.remove = function (id) {
            AdminAnswersService.delete(id)
                .then(response => $state.reload())
                .catch(error => {
                    console.error("something went terribly wrong", error);
                    $state.reload();
                })
        }
    }


})();