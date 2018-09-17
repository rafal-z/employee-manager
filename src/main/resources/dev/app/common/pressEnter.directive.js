angular
    .module('employee-manager')
    .directive('pressEnter', pressEnter);

function pressEnter() {
    var directive = {
        bindToController: true,
        restrict: 'A',
        link: link
    };
    return directive;
}

function link(scope, element, attr) {
    element.bind('keydown', function(event) {
        var code = event.keyCode || event.which;
        if (code === 13) {
            if (!event.shiftKey) {
                event.preventDefault();
                scope.$apply(attr.pressEnter);
            }
        }
    });
}