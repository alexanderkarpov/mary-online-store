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

        service.getById = function (id) {
            return $http({
                method: "GET",
                url: ("/admin/questionnaire/question"),
                params: {id: id}
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.add = function (question) {
            return $http({
                method: "POST",
                url: ("/admin/questionnaire/question"),
                data: question
            })
        };

        service.update = function (question) {
            return $http({
                method: "PUT",
                url: ("/admin/questionnaire/question"),
                data: question
            })
        };

        service.delete = function (id) {
            return $http({
                method: "DELETE",
                url: ("/admin/questionnaire/question"),
                params: {id: id}
            })
        }


    }

})();