angular
    .module('em.common')
    .directive('inputField', inputField);

function inputField() {
    var directive = {
        restrict: 'EA',
        template: '<label for="inputField">{{label}}</label>\n' +
                    '<input type=' + '{{type}} ' + 'ng-model="ngModel"  class="form-control" id="{{vm.id}}" ng-required="required">',
        scope: {
            label: '=',
            ngModel: '=',
            type: '=',
            required: '='
        },
        controller: inputFieldController,
        controllerAs: 'vm'
    };
    return directive;
}

function inputFieldController() {
    this.id = 'inputField_' + Math.random();
}