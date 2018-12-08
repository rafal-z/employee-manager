angular
    .module('em.employee')
    .service('employeeService', employeeService);

function employeeService($http) {
    var vm = this;
    vm.getEmployees = getEmployees;
    vm.getEmployeeById = getEmployeeById;
    vm.setPersonId = setPersonId;
    vm.getPersonId = getPersonId;
    vm.saveEmployee = saveEmployee;

    vm.personId = null;

    function setPersonId(personId) {
        vm.personId = personId;
    }

    function getPersonId() {
        return vm.personId;
    }

    function getEmployees(crit) {
        return $http.post('/employee-manager/employee', crit);
    }

    function getEmployeeById(personId) {
        return $http.get('/employee-manager/employee/' + personId);
    }

    function saveEmployee(employee) {
        return $http.post('/employee-manager/saveEmployee', employee);
    }
}