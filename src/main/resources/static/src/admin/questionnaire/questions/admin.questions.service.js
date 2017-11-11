(function () {
    "use strict";

    angular.module('admin')
        .service('AdminQuestionsService', AdminQuestionsService);

    AdminQuestionsService.$inject = ['$http'];

    function AdminQuestionsService($http) {
        var service = this;

        service.getAll = function () {
            return $http({
                method: "GET",
                url: ("/admin/questionnaire/all")
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.add = function (question) {
            return $http({
                method: "POST",
                url: ("/admin/questionnaire/question/create"),
                data: question
            })
        };


    }

})();