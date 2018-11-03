angular
    .module('em.common')
    .directive('inputField', inputField);

function inputField() {
    var directive = {
        restrict: 'EA',
        template: '<label for="inputField">{{label}}</label>\n' +
                    '<input type=' + '{{type}} ' + 'ng-model="ngModel"  class="form-control" id="inputField">',
        scope: {
            label: '=',
            ngModel: '=',
            type: '='
        }
    };
    return directive;
}