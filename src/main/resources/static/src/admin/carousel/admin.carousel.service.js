(() => {

    'use strict';

    angular.module('admin')
        .service('AdminCarouselService', AdminCarouselService);

    AdminCarouselService.$inject = ['$http', 'FileUploadService'];

    function AdminCarouselService($http, FileUploadService) {
        const service = this;

        service.get = (itemType) =>
            $http({
                method: "GET",
                url: ("/admin/carousel/" + itemType)
            }).then(function (response) {
                return response.data;
            }).catch(function (error) {
                console.log("something went terribly wrong", error);
            });


        service.update = (itemType, item, imageFile) =>
        {
            if(imageFile) {
                console.log("update with file");
                return FileUploadService.uploadFile(imageFile, item, "/admin/carousel/" + itemType + "/file");
            } else {
                console.log("update without file");
                return $http({
                    method: "POST",
                    url: ("/admin/carousel/" + itemType),
                    data: item
                });
            }


        };


    }

})();