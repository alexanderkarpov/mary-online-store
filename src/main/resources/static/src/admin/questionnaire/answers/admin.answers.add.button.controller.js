(() => {

    'use strict';

    angular.module('admin')
        .controller('AdminAnswersAddButtonController', AdminAnswersAddButtonController);

    AdminAnswersAddButtonController.$inject = ['$stateParams'];

    function AdminAnswersAddButtonController($stateParams) {
        const controller = this;
        controller.questionId = $stateParams.questionId;
    }


})();