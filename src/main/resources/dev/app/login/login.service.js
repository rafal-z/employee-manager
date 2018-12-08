angular
    .module('em.employee')
    .service('loginService', loginService);

function loginService($rootScope, $http, authService) {
    var vm = this;

    vm.login = login;
    vm.isAuthorized = isAuthorized;

    vm.roles = null;

    function login(userName, password) {
        var config = {
            ignoreAuthModule: 'ignoreAuthModule',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        };
        var param = 'username=' + userName + '&password=' + password + '&rememberme=' + true;
        $http.post('authenticate', param, config)
            .success(function (data) {
                vm.roles = data;
                authService.loginConfirmed(data);
            })
            .error(function (data) {

            });
    }

    function isAuthorized(roles) {
        var hasRole = false;
        if(vm.roles) {
            angular.forEach(roles, function (value) {
                if (vm.roles.indexOf(value) !== -1) {
                    hasRole = true;
                }
            })
        }
        return hasRole;
    }
}