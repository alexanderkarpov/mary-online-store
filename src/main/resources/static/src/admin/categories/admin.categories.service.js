(function () {
    "use strict";

    angular.module('admin')
        .service('AdminCategoriesService', AdminCategoriesService);

    AdminCategoriesService.$inject = ['$http'];

    function AdminCategoriesService($http) {
        var service = this;
        service.getData = function () {
            return $http({
                method: "GET",
                url: ("/admin/category/all")
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });

            // return $http.get('/admin/category/all');
        }
    }

})();