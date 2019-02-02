var app = angular.module('em.main');

app.controller('mainController', mainController);

function mainController($rootScope, $filter, toastService, httpInterceptorEvent) {
    registerEventHandlers();
    
    function registerEventHandlers() {
        $rootScope.$on(httpInterceptorEvent.INTERNAL_ERROR_EVENT, handleServerError);
    }
    
    function handleServerError() {
        toastService.showErrorToast($filter('translate')('internalServerError'));
    }
}