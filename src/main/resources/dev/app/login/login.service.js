angular
    .module('em.employee')
    .service('loginService', loginService);

function loginService($rootScope, $http, $filter, $q, authService) {
    var vm = this;

    vm.login = login;
    vm.hasAnyRoles = hasAnyRoles;
    vm.isAuthenticated = isAuthenticated;
    vm.logout = logout;
    vm.changeUserPassword = changeUserPassword;

    vm.user = {
        login: null,
        roles: null
    };
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
                vm.user.login = userName;
                vm.user.roles = data;
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
        if(vm.user.roles) {
            angular.forEach(roles, function (value) {
                if (vm.user.roles.indexOf(value) !== -1) {
                    hasRole = true;
                }
            })
        }
        return hasRole;
    }

    function isAuthenticated() {
        $http.get('/employee-manager/user').success(function (data) {
            vm.user.login = data.login;
            vm.user.roles = data.authorities;
            authService.loginConfirmed(data);
        });
    }

    function logout() {
        $http.get('logout').then(function (value) {
            $rootScope.authenticated = false;
            vm.user = {login: null, roles: null};
            authService.loginCancelled();
        });
    }

    function changeUserPassword(login, newPassword, oldPassword) {
        var data = {
            login: login,
            newPassword: newPassword,
            oldPassword: oldPassword
        };
        return $http({
            method: 'POST',
            url: '/employee-manager/user/changePassword',
            headers: {'Content-Type': 'application/json'},
            params: data
        });
    }
}