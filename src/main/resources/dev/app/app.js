'use strict';

angular.module('employee-manager', [
    'ngRoute',
    'pascalprecht.translate',
    'em.search',
    'em.employee',
    'em.common',
    'em.main',
    'http-auth-interceptor',
    'ui.bootstrap',
    'angularjsToast'
]);
