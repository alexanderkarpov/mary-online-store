(() => {

    'use strict';

    angular.module('admin')
        .controller('AdminCarouselItemUpdateFormController', AdminCarouselItemUpdateFormController);

    AdminCarouselItemUpdateFormController.$inject = ['$stateParams', 'carouselItem', 'AdminCarouselService'];

    function AdminCarouselItemUpdateFormController($stateParams, carouselItem, AdminCarouselService) {
        const controller = this;
        controller.itemType = $stateParams.carouselItemType;
        controller.item = carouselItem;
    }

})();