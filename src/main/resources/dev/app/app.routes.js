var app = angular.module('employee-manager');

app.config(config);

function config($routeProvider) {
    $routeProvider
        .when('/employeeList', {
            templateUrl: 'app/employeeList/mainTestView.html'
        })
        .otherwise({redirectTo: '/employeeList'})
}
