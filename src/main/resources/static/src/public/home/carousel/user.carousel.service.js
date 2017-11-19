(() => {

    'use strict';

    angular.module('public')
        .service('UserCarouselService', UserCarouselService);

    UserCarouselService.$inject = ['$http'];

    function UserCarouselService($http) {
        const service = this;

        service.get = (itemType) =>
            $http({
                method: "GET",
                url: ("/admin/carousel/" + itemType)
            });
    }

})();