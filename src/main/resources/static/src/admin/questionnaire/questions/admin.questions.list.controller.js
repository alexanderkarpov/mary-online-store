(function () {
    "use strict";

    angular.module('admin')
        .controller('AdminQuestionsListController', AdminQuestionsListController);

    AdminQuestionsListController.$inject = ['questions', 'AdminQuestionsService', '$state'];

    function AdminQuestionsListController(questions, AdminQuestionsService, $state) {
        var controller = this;
        controller.items = questions;

        controller.remove = function (id) {
            AdminQuestionsService.delete(id)
                .then(function (response) {
                    console.log("successfully deleted", response);
                    $state.reload();
                })
                .catch(function (error) {
                    console.error("something went terribly wrong", error);
                    $state.reload();
                });
        };
    }

})();