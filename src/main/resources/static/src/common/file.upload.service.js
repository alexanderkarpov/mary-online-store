(function () {

    'use strict';

    angular.module('common')
        .service('FileUploadService', FileUploadService)
        .directive('fileModel', ['$parse', function ($parse) {
            return {
                restrict: 'A',
                link: function(scope, element, attrs) {
                    var model = $parse(attrs.fileModel);
                    var modelSetter = model.assign;

                    element.bind('change', function(){
                        scope.$apply(function(){
                            modelSetter(scope, element[0].files[0]);
                        });
                    });
                }
            };
        }]);

    FileUploadService.$inject = ['$http'];

    function FileUploadService($http) {
        var service = this;

        service.uploadFile = function (file, metadata, uploadUrl) {
            var fd = new FormData();
            fd.append('file', file);
            fd.append('metadata', new Blob([angular.toJson(metadata)], {
                type: "application/json"
            }));
            return $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            });
        }

    }

})();