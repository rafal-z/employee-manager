angular
    .module('em.common')
    .directive('detailsDataContentPanel', detailsDataContentPanel);

function detailsDataContentPanel() {
    var directive = {
        bindToController: true,
        restrict: 'E',
        controller: detailsDataContentPanelController,
        controllerAs: 'vm',
        templateUrl: 'app/common/detailsDataContentPanel.html',
        scope: {
            employee: '='
        }
    };
    return directive;
}

function detailsDataContentPanelController() {
    var vm = this;
    vm.getOnlineStr = getOnlineStr;
    vm.getOnlineCss = getOnlineCss;

    function getOnlineStr(online) {
        return online ? "Online" : "Offline";
    }

    function getOnlineCss(online) {
        return online ? "circle-green" : "circle-red";
    }
}