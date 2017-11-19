(() => {

    'use strict';

    angular.module('admin')
        .service('AdminCarouselService', AdminCarouselService);

    AdminCarouselService.$inject = ['$http'];

    function AdminCarouselService($http) {
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

        service.update = (itemType, item) => $http({
            method: "POST",
            url: ("/admin/carousel/" + itemType),
            data: item
        });
    }

})();