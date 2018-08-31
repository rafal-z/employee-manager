angular
    .module('employee-manager')
    .directive('employeeList', employeeList);

function employeeList() {
    var directive = {
        bindToController: true,
        controller: employeeListController,
        controllerAs: 'vm',
        restrict: 'EA',
        scope: {
        },
        templateUrl: 'app/employeeList/employeeList.html'
    };
    return directive;
}

function employeeListController() {
    var vm = this;
    vm.text = 'tekst z dyrektywy';
}