(function () {

    'use strict';

    angular.module('admin')
        .component('adminAnswersList', {
            templateUrl: 'src/admin/questionnaire/answers/admin.answers.list.template.html',
            bindings: {
                question: '<',
                onRemove: '&'
            }
        });

})();