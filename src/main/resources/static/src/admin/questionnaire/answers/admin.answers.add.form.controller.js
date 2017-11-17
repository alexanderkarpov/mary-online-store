(function () {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersAddFormController', AdminAnswersAddFormController);

    AdminAnswersAddFormController.$inject =
        ['AdminAnswersService', 'AdminProductsService', '$stateParams', '$state'];

    function AdminAnswersAddFormController(AdminAnswersService, AdminProductsService, $stateParams, $state) {
        var controller = this;

        controller.answer = {};
        controller.answer.questionId = $stateParams.questionId;
        controller.products = [];

        AdminProductsService.getAll()
            .then(function (data) {
                controller.products = data;
                console.log("products loaded", data);
                // $state.reload();
            })
            .catch(function (error) {
                console.log("something went terribly wrong", error);
            });


    }

})();