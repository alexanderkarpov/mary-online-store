(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersListController', AdminAnswersListController);

    AdminAnswersListController.$inject = ['question', 'AdminQuestionsService', 'AdminAnswersService'];

    function AdminAnswersListController(question, AdminQuestionsService, AdminAnswersService) {
        var controller = this;

        controller.question = question;

        controller.remove = function (id) {
            console.log("remove", id);
        }
    }


})();