angular
    .module('em.search')
    .directive('searchEmployee', searchEmployee);

function searchEmployee() {
    var directive = {
        bindToController: true,
        restrict: 'E',
        controller: searchEmployeeController,
        controllerAs: 'vm',
        templateUrl: 'app/searchEmployee/searchEmployee.html',
        scope: {
            searchFunction: '&'
        }
    };
    return directive
}

function searchEmployeeController($scope) {
    var vm = this;
    vm.search = search;

    function search() {
        vm.searchFunction()(vm.searchCriteria);
    }
}