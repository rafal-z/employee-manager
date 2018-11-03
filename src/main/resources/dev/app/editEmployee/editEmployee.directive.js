angular
    .module('em.employee')
    .directive('editEmployee', editEmployee)
    .constant('editType', {
        EDIT: "edit",
        ADD: "add"
    });

function editEmployee() {
    var directive = {
        bindToController: true,
        restrict: 'AE',
        controller: editEmployeeController,
        controllerAs: 'vm',
        templateUrl: 'app/editEmployee/editEmployee.html'
    };
    return directive;
}

function editEmployeeController($http, $routeParams, employeeService, editType) {
    var vm = this;
    vm.submit = submit;
    vm.cancel = cancel;

    activate();

    function activate() {
        var type = $routeParams.type;
        vm.title = type == editType.EDIT ? 'title.edit' : 'title.add';

        if(type === editType.EDIT){
            loadEmployee();
        }
    }

    function loadEmployee() {
        var personId = employeeService.getPersonId();
        employeeService.getEmployeeById(personId)
            .then(function (value) {
                vm.employeeDS = value.data;
                convertDates();
            });
    }

    function submit() {
        employeeService.saveEmployee(vm.employeeDS);
        cancel();
    }
    
    function cancel() {
        window.history.back();
    }

    function convertDates() {
        vm.employeeDS.dob = vm.employeeDS.dob != null ? new Date(vm.employeeDS.dob) : null;
        vm.employeeDS.dateHired = vm.employeeDS.dateHired != null ? new Date(vm.employeeDS.dateHired) : null;
        vm.employeeDS.dateDismissal = vm.employeeDS.dateDismissal != null ? new Date(vm.employeeDS.dateDismissal) : null;
    }
}