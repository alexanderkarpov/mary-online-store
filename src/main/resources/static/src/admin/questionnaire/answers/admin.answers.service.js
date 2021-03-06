(function () {

    'use strict';

    angular.module('admin')
        .service('AdminAnswersService', AdminAnswersService);

    AdminAnswersService.$inject = ['$http'];

    function AdminAnswersService($http) {

        const service = this;

        service.getByQuestionId = questionId =>
            $http({
                method: "GET",
                url: ("/admin/questionnaire/answers"),
                params: {questionId: questionId}
            })
                .then(response => response.data)
                .catch(error => console.log("something went terribly wrong", error));

        service.getById = answerId =>
            $http({
                method: "GET",
                url: ("/admin/questionnaire/answer"),
                params: {id: answerId}
            })
                .then(response => response.data)
                .catch(error => console.log("something went terribly wrong", error));


        service.add = createAnswerReq => $http({
            method: "POST",
            url: ("/admin/questionnaire/answer"),
            data: createAnswerReq
        });

        service.update = updateAnswerReq => $http({
            method: "PUT",
            url: ("/admin/questionnaire/answer"),
            data: updateAnswerReq
        });

        service.delete = answerId => $http({
            method: "DELETE",
            url: ("/admin/questionnaire/answer"),
            params: {id: answerId}
        });


    }


})();