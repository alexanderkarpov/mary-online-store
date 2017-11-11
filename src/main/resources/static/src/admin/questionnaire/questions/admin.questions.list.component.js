(function () {
    'use strict';

    angular.module('admin')
        .component('adminQuestionsList', {
            templateUrl: 'src/admin/questionnaire/questions/questions.template.html',
            bindings: {
                items: '<',
                onRemove: '&'
            }
        });
})();