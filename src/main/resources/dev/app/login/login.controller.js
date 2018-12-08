angular
    .module('em.employee')
    .controller('loginController', loginController);

function loginController(loginService) {
    var vm = this;

    vm.login = login;

    function login() {
        loginService.login(vm.userName, vm.password);
    }
}