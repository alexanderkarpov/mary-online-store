(() => {

    'use strict';

    angular.module('public')
        .controller('UserCarouselService', UserCarouselService);

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