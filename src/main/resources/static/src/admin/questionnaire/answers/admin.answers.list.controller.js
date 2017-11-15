(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersListController', AdminAnswersListController);

    AdminAnswersListController.$inject = ['question', 'AdminAnswersService'];

    function AdminAnswersListController(question, AdminAnswersService) {
        var controller = this;

        controller.question = question;

        controller.remove = function (id) {
            console.log("remove", id);
        }
    }


})();