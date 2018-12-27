angular
    .module('em.employee')
    .controller('loginController', loginController);

function loginController(loginService) {
    var vm = this;
    vm.errorMessage = null;

    vm.login = login;

    function login() {
        loginService.login(vm.userName, vm.password).error(function (reason) {
            vm.errorMessage = loginService.errorMessage;
        });
    }
}