(function () {
    "use strict";

    angular.module('admin')
        .controller('AdminQuestionsListController', AdminQuestionsListController);

    AdminQuestionsListController.$inject = ['questions', 'AdminQuestionsService'];

    function AdminQuestionsListController(questions, AdminQuestionsService) {
        var controller = this;
        controller.items = questions;

        controller.remove = function (id) {
            console.log('remove question', id);
        };
    }

})();