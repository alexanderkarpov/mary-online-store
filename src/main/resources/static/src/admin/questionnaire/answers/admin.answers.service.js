(function () {

    'use strict';

    angular.module('admin')
        .service('AdminAnswersService', AdminAnswersService);

    AdminAnswersService.$inject = ['$http'];

    function AdminAnswersService($http) {

        var service = this;

        service.getByQuestionId = function (questionId) {
            return $http({
                method: "GET",
                url: ("/admin/questionnaire/answers"),
                params: {questionId: questionId}
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        }

    }


})();