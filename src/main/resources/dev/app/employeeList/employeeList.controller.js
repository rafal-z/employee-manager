angular
    .module('em.employee')
    .controller('employeeListController', employeeListController);

function employeeListController($scope, $http, $location, employeeService) {
    var vm = this;

    vm.search = search;
    vm.goToDetails = goToDetails;

    vm.employeeDS = [];

    function search(str) {
        employeeService.getEmployees(preparateCriteria(str))
            .then(function (value) {
                vm.employeeDS = value.data;
            })
    }

    function preparateCriteria(str) {
        var crit = {};
        if(!isNaN(str)){
            if(str.length !== 11){
                crit.personId = str;
            } else {
                crit.nationalNo = str;
            }
        } else {
            var res = str.split(" ");
            crit.lastName = res[0];
            if(res[1]){ crit.firstName = res[1];}
        }
        return crit;
    }

    function goToDetails(personId) {
        employeeService.setPersonId(personId);
        $location.url('/employeeDetails');
    }
}