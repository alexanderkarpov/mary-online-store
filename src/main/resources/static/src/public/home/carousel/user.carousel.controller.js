(() => {

    'use strict';

    angular.module('public')
        .controller('UserCarouselController', UserCarouselController);

    UserCarouselController.$inject = ['UserCarouselService'];

    function UserCarouselController(UserCarouselService) {

        const controller = this;

        controller.questionnaire = {};
        controller.catalog = {};
        controller.warranty = {};

        controller.questionnaireImgUrl = "/admin/carousel/" + (new Date()).getTime() +
            "/questionnaire.jpg";
        controller.catalogImgUrl = "/admin/carousel/" + (new Date()).getTime() +
            "/catalog.jpg";
        controller.warrantyImgUrl = "/admin/carousel/" + (new Date()).getTime() +
            "/warranty.jpg";


        UserCarouselService.get("questionnaire")
            .then(response => controller.questionnaire = response.data)
            .catch(error => console.error("something went terribly wrong", error));

        UserCarouselService.get("catalog")
            .then(response => controller.catalog = response.data)
            .catch(error => console.error("something went terribly wrong", error));

        UserCarouselService.get("warranty")
            .then(response => controller.warranty = response.data)
            .catch(error => console.error("something went terribly wrong", error));
    }

})();