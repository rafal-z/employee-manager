var app = angular.module('employee-manager');

app.factory('httpInterceptor', function ($q) {
    return {
        'responseError': function (response) {
            if(response.status === 500){
                // TODO broadcast z eventem
            }
            return $q.reject(response);
        }
    }
});

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');
}]);