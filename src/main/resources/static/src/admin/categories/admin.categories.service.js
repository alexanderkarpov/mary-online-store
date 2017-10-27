(function () {
    "use strict";

    angular.module('admin')
        .service('AdminCategoriesService', AdminCategoriesService);

    AdminCategoriesService.$inject = ['$http'];

    function AdminCategoriesService($http) {
        var service = this;
        service.getData = function () {
            return $http.get('/admin/category/all');
        }
    }

})();