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