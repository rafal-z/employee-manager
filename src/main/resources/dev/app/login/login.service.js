angular
    .module('em.employee')
    .service('loginService', loginService);

function loginService($rootScope, $http, $filter, authService) {
    var vm = this;

    vm.login = login;
    vm.hasAnyRoles = hasAnyRoles;
    vm.isAuthenticated = isAuthenticated;

    vm.roles = null;
    vm.errorMessage = null;

    function login(userName, password) {
        var config = {
            ignoreAuthModule: 'ignoreAuthModule',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        };
        var param = 'username=' + userName + '&password=' + password + '&rememberme=' + true;
        return $http.post('authenticate', param, config)
            .success(function (data) {
                vm.errorMessage = null;
                vm.roles = data;
                authService.loginConfirmed(data);
            })
            .error(function (data) {
                var filter = $filter('translate');
                var message = data.message;
                switch (message) {
                    case 'Bad credentials':
                        vm.errorMessage = filter('login.error.badCredentials');
                        break;
                    case 'User was not active':
                        vm.errorMessage = filter('login.error.notActiveUser');
                        break;
                    case 'Password expired':
                        vm.errorMessage = filter('login.error.expiredPassword');
                        break;
                }
            });
    }

    function hasAnyRoles(roles) {
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

    function isAuthenticated() {
        return $http.get('/employee-manager/roles').success(function (data) {
            if (data === null)
                return false;

            vm.roles = data;
            return true;
        });
    }
}