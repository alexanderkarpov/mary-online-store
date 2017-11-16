(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersListController', AdminAnswersListController);

    AdminAnswersListController.$inject = ['question', 'AdminQuestionsService'];

    function AdminAnswersListController(question, AdminQuestionsService) {
        var controller = this;

        controller.question = question;

        controller.remove = function (id) {
            console.log("remove", id);
        }
    }


})();