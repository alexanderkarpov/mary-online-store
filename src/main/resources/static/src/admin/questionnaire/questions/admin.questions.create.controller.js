(function () {
    'use strict';

    angular.module('admin')
        .controller('AdminQuestionsCreateController', AdminQuestionsCreateController);

    AdminQuestionsCreateController.$inject = ['AdminQuestionsService', '$state'];

    function AdminQuestionsCreateController(AdminQuestionsService, $state) {
        var controller = this;

        controller.question = {};

        controller.add = function () {
            console.log("upload", controller.product);

            AdminQuestionsService.add(controller.question)
                .then(function (response) {
                    console.log("successfully created", response);
                    $state.reload();
                })
                .catch(function (error) {
                    console.error("something went terribly wrong", error);
                    $state.reload();
                });
        };
    }

})();