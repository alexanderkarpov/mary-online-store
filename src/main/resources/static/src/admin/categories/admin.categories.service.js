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

        service.add = function (category) {
          console.log("add category", category);
        };
        
        service.uploadImage = function (file) {
            return FileUploadService.uploadFile(file, "/admin/category/create");
        }
    }

})();