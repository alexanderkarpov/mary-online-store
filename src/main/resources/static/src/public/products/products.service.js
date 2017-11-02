(function () {
    'use strict';

    angular.module('public')
        .service('ProductsService', ProductsService);

    ProductsService.$inject = ['$http'];

    function ProductsService($http) {
        var service = this;
        service.getData = function () {
            return $http.get('/user/product/all');
        };

        service.getByCategoryId = function (categoryId) {
            return $http({
                method: "GET",
                url: ("/user/product/get-by-category"),
                params: {categoryId: categoryId}
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };
    }


})();