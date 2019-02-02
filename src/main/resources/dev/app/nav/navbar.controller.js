angular
    .module('em.employee')
    .controller('navbarController', navbarController);

function navbarController($scope, $http, $uibModal, loginService) {
    var vm = this;
    vm.logout = logout;
    vm.openChangePasswordModal = openChangePasswordModal;

    vm.userInfos = null;
    $scope.login = loginService.user.login;
    $scope.$watch('login', getUser);

    function getUser(login) {
        if($scope.authenticated && login !== null && typeof login !== 'undefined') {
            $http.get('/employee-manager/users/' + login).then(function (value) {
                vm.userInfos = value.data;
            });
        }
    }

    function logout(){
        loginService.logout();
    }

    function openChangePasswordModal(contextLogin) {
        var modalInstance = $uibModal.open({
            templateUrl: 'app/modalChangePassword/modalChangePassword.html',
            controller: 'changePasswordController',
            controllerAs: 'cpc',
            resolve: {
                contextLogin: function () {
                    return contextLogin;
                }
            }
        });
    }
}