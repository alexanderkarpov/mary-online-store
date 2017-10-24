(function () {
    "use strict";

    angular.module('admin')
        .config(routeConfig);


    routeConfig.$inject = ['$stateProvider'];

    function routeConfig($stateProvider) {
        // Routes
        $stateProvider
            .state('admin', {
                abstract: true,
                templateUrl: 'src/admin/admin.html'
            })
            .state('admin.main', {
                url: '/admin',
                templateUrl: 'src/admin/main/main.html'
            });
    }
})();
