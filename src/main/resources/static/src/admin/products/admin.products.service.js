(function () {
    "use strict";

    angular.module('admin')
        .service('AdminProductsService', AdminProductsService);

    AdminProductsService.$inject = ['$http', 'FileUploadService'];

    function AdminProductsService($http, FileUploadService) {
        var service = this;

        service.getByCategoryId = function (categoryId) {
            return $http({
                method: "GET",
                url: ("/admin/product/get"),
                params: {categoryId: categoryId}
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.getAll = function (){
            return $http({
                method: "GET",
                url: ("/admin/product/getall")
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });
        };

        service.add = function (product, imageFile) {
            return FileUploadService.uploadFile(imageFile, product, "/admin/product/create");
        };

        service.delete = function (id) {
            return $http({
                method: "DELETE",
                url: ("/admin/product/delete/" + id)
            })
        };
    }

})();