angular
    .module('em.employee')
    .directive('employeeDetails', employeeDetails);

function employeeDetails() {
    var directive = {
        bindToController: true,
        restrict: 'E',
        controller: employeeDetailsController,
        controllerAs: 'vm',
        templateUrl: 'app/employeeDetails/employeeDetails.html'
    };
    return directive;
}

function employeeDetailsController($http, employeeService) {
    var vm = this;
    vm.personId = employeeService.getPersonId();
    employeeService.getEmployeeById(vm.personId)
        .then(function (value) {
            vm.employeeFullDS = value.data;
        })
}