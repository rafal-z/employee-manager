angular
    .module('em.employee')
    .service('employeeService', employeeService);

function employeeService($http) {
    var vm = this;
    vm.getEmployees = getEmployees;
    vm.getEmployeeById = getEmployeeById;
    vm.setPersonId = setPersonId;
    vm.getPersonId = getPersonId;

    vm.personId = null;

    function getEmployees(crit) {
        return $http.post('/employee-manager/application/employee', crit);
    }

    function getEmployeeById(personId) {
        return $http.get('/employee-manager/application/employee/' + personId);
    }

    function setPersonId(personId) {
        vm.personId = personId;
    }

    function getPersonId() {
        return vm.personId;
    }
}