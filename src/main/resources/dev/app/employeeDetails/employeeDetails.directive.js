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

function employeeDetailsController($http, $location, employeeService, editType) {
    var vm = this;
    vm.editEmployee = editEmployee;
    vm.addEmployee = addEmployee;
    vm.toBack = toBack;

    vm.personId = employeeService.getPersonId();
    employeeService.getEmployeeById(vm.personId)
        .then(function (value) {
            vm.employeeFullDS = value.data;
        });

    function editEmployee() {
        employeeService.setPersonId(vm.employeeFullDS.personId);
        $location.url('/editEmployee?type=' + editType.EDIT);
    }

    function addEmployee() {
        employeeService.setPersonId(vm.employeeFullDS.personId);
        $location.url('/editEmployee?type=' + editType.ADD);
    }

    function toBack() {
        window.history.back();
    }
}