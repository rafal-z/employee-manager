var app = angular.module('employee-manager');

app.constant('httpInterceptorEvent', {
    INTERNAL_ERROR_EVENT: 'internalServerError'
});

app.factory('httpInterceptor', function ($rootScope, $q, httpInterceptorEvent) {
    return {
        'responseError': function (response) {
            if(response.status === 500){
                $rootScope.$broadcast(httpInterceptorEvent.INTERNAL_ERROR_EVENT);
            }
            return $q.reject(response);
        }
    }
});

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');
}]);