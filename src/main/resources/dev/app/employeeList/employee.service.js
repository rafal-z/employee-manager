angular
    .module('em.employee')
    .service('employeeService', employeeService);

function employeeService($http) {
    var vm = this;
    vm.getEmployees = getEmployees;

    function getEmployees(crit) {
        return $http.post('/employee-manager/application/employee', crit);
    }
}