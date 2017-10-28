(function () {
    "use strict";

    angular.module('admin')
        .service('AdminCategoriesService', AdminCategoriesService);

    AdminCategoriesService.$inject = ['$http', 'FileUploadService'];

    function AdminCategoriesService($http, FileUploadService) {
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
        };
        
        service.add = function (category, imageFile) {
            console.log("category", category);
            return FileUploadService.uploadFile(imageFile, category, "/admin/category/create");
        }
    }

})();