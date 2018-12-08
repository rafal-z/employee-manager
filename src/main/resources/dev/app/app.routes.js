var app = angular.module('employee-manager');

app.config(config);

function config($routeProvider) {
    $routeProvider
        .when('/employeeList', {
            controller: 'employeeListController',
            controllerAs: 'employeeListController',
            templateUrl: 'app/employeeList/employeeList.html',
            access: {
                loginRequired: true,
                authorizedRoles: ["user"]
            }
        })
        .when('/employeeDetails', {
            template: '<employee-details></employee-details>',
            access: {
                loginRequired: true,
                authorizedRoles: ["technical"]
            }
        })
        .when('/editEmployee', {
            template: '<edit-employee></edit-employee>',
            access: {
                loginRequired: true,
                authorizedRoles: ["admin"]
            }
        })
        .when('/login', {
            controller: 'loginController',
            controllerAs: 'loginController',
            templateUrl: 'app/login/login.html'
        })
        .when('/error403', {
            template: '<h4>Forbidden - 403</h4><a href="#/employeeList">home</a>'
        })
        .otherwise({redirectTo: '/employeeList'})
}
