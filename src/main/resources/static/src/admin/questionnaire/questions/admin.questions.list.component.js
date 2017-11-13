(function () {
    'use strict';

    angular.module('admin')
        .component('adminQuestionsList', {
            templateUrl: 'src/admin/questionnaire/questions/questions.list.template.html',
            bindings: {
                items: '<',
                onRemove: '&'
            }
        });
})();