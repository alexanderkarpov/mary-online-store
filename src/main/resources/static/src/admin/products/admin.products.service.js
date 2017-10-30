(function () {
    "use strict";

    angular.module('admin')
        .service('AdminProductsService', AdminProductsService);

    AdminProductsService.$inject = ['$http', 'FileUploadService'];

    function AdminProductsService($http, FileUploadService) {
        var service = this;

        service.getAll = function () {
            return $http({
                method: "GET",
                url: ("/admin/product/get")
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.getByCategoryId = function (categoryId) {
            return $http({
                method: "GET",
                url: ("/admin/product/get" + categoryId)
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.add = function (product, imageFile) {
            return FileUploadService.uploadFile(imageFile, category, "/admin/product/create");
        };

        service.delete = function (id) {
            return $http({
                method: "DELETE",
                url: ("/admin/product/delete/" + id)
            })
        };
    }

})();