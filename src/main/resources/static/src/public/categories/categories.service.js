(function () {
    'use strict';

    angular.module('public')
        .service('CategoriesService', CategoriesService);

    CategoriesService.$inject = ['$http'];

    function CategoriesService($http) {
        var service = this;

        service.getData = function () {
            return $http.get('/user/category/all');
        };

        service.getById = function (categoryId) {
            return $http({
                method: "GET",
                url: ("/user/category/get"),
                params: {categoryId: categoryId}
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };
    }
})();