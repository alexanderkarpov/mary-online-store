(function () {

    'use strict';

    angular.module('admin')
        .component('adminAnswersList', {
            templateUrl: 'src/admin/questionnaire/answers/answers.list.template.html',
            bindings: {
                items: '<',
                onRemove: '&'
            }
        });

})();