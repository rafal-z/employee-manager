var app = angular.module('employee-manager');

app.config(config);

function config($routeProvider) {
    $routeProvider
        .when('/employeeList', {
            controller: 'employeeListController',
            controllerAs: 'employeeListController',
            templateUrl: 'app/employeeList/employeeList.html'
        })
        .otherwise({redirectTo: '/employeeList'})
}
