var app = angular.module('employee-manager')
    .config(['$translateProvider', function ($translateProvider) {
    $translateProvider.useStaticFilesLoader({
        prefix: 'app/locale-',
        suffix: '.json'
    });

    // $translateProvider.preferredLanguage('en_US');
    $translateProvider.determinePreferredLanguage(); //język pobierany z właściwości przglądarki
    $translateProvider.fallbackLanguage('en_US'); // język zastępczy
}]);

app.run(function ($rootScope, $location, $http, loginService) {

    $rootScope.$on('$routeChangeStart', function (event, next) {
        if (next.access && next.access.loginRequired && !$rootScope.authenticated) {
            event.preventDefault();
            $rootScope.$broadcast("event:auth-loginRequired", {});
        } else if(next.access && !loginService.isAuthorized(next.access.authorizedRoles)){
            event.preventDefault();
            $rootScope.$broadcast("event:auth-forbidden", {});
        }
    });

    $rootScope.$on('event:auth-loginRequired', function (event, data) {
        $rootScope.requestedUrl = $location.path();
        $location.path('/login');
    });

    $rootScope.$on('event:auth-loginConfirmed', function (event, data) {
        $rootScope.authenticated = true;
        var nextLocation = $rootScope.requestedUrl ? $rootScope.requestedUrl : "/employeeList";
        $location.path(nextLocation).replace();
    });

    $rootScope.$on('event:auth-forbidden', function (event, data) {
        $location.path("/error403");
    })
});