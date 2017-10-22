(function () {
    'use strict';

    angular.module('public')
        .service('ProductsService', ProductsService);

    ProductsService.$inject = ['$http'];

    function ProductsService($http) {
        var service = this;
        service.getData = function () {
            return $http.get('/products/');
        }
    }
})();