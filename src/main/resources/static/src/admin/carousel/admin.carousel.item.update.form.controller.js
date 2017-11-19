(() => {

    'use strict';

    angular.module('admin')
        .controller('AdminCarouselItemUpdateFormController', AdminCarouselItemUpdateFormController);

    AdminCarouselItemUpdateFormController.$inject = ['$stateParams', 'carouselItem', 'AdminCarouselService', '$state'];

    function AdminCarouselItemUpdateFormController($stateParams, carouselItem, AdminCarouselService, $state) {
        const controller = this;
        controller.itemType = $stateParams.carouselItemType;
        controller.item = carouselItem;
        controller.files = {};

        controller.imageUrl =
            "/admin/carousel/" + (new Date()).getTime() +
            "/" + controller.itemType + ".jpg";


        controller.submit = function () {
            AdminCarouselService.update(controller.itemType, controller.item, controller.files.image)
                .then(response => {
                    console.log("successfully uploaded", response);
                    $state.reload();
                })
                .catch(error =>
                    console.error("something went terribly wrong", error)
                );
        }
    }

})();