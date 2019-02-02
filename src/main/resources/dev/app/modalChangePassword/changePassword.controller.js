angular
    .module('em.employee')
    .controller('changePasswordController', changePasswordController);

function changePasswordController($uibModalInstance, $filter, loginService, contextLogin) {
    var vm = this;
    vm.submit = submit;
    vm.close = close;
    vm.oldPassword = null;
    vm.newPassword = null;
    vm.confirmedPassword = null;
    vm.login = null;
    vm.errorMessage = null;
    vm.contextLogin = contextLogin;

    function changePassword() {
        if(loginService.user.login){
            vm.login = loginService.user.login;
        }

        if(vm.newPassword !== vm.confirmedPassword) {
            vm.errorMessage = $filter('translate')('differentPassword');
        } else {
            loginService.changeUserPassword(vm.login, vm.newPassword, vm.oldPassword).then(success, error);
            vm.errorMessage = null;
        }
    }

    function success() {
        $uibModalInstance.dismiss('success');
        // TODO toast o powodzeniu zmiany hasła
    }

    function error(error) {
        console.log(error);
        switch (error.data.reason){
            case 'PASSWORD_NOT_MEETS_REQUIREMENTS':
                vm.errorMessage = $filter('translate')('changePassword.notMeetsRequirements');
                break;
            case 'INVALID_OLD_PASSWORD':
                vm.errorMessage = $filter('translate')('changePassword.invalidOldPassword');
                break;
            case 'PASSWORDS_CAN_NOT_BE_EQUAL':
                vm.errorMessage = $filter('translate')('changePassword.canNotBeEqual');
                break;
        }
    }

    function submit() {
        changePassword();
    }

    function close() {
        $uibModalInstance.dismiss('cancel');
    }
}