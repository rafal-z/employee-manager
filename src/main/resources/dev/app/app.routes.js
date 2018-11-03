var app = angular.module('employee-manager');

app.config(config);

function config($routeProvider) {
    $routeProvider
        .when('/employeeList', {
            controller: 'employeeListController',
            controllerAs: 'employeeListController',
            templateUrl: 'app/employeeList/employeeList.html'
        })
        .when('/employeeDetails', {
            template: '<employee-details></employee-details>'
        })
        .when('/editEmployee', {
            template: '<edit-employee></edit-employee>'
        })
        .otherwise({redirectTo: '/employeeList'})
}
