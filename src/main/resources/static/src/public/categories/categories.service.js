(function () {
    'use strict';

    angular.module('public')
        .service('CategoriesService', CategoriesService);

    CategoriesService.$inject = ['$http'];

    function CategoriesService($http) {
        var service = this;
        service.getData = function () {
            return $http.get('/user/category/all');
        }
    }
})();