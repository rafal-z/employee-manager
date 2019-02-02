/**
 * https://github.com/sibiraj-s/angularjs-toast
 */

var app = angular.module('em.common')
    .service('toastService', toastService);

function toastService(toast) {
    var vm = this;
    vm.showSuccessToast = showSuccessToast;
    vm.showErrorToast = showErrorToast;
    vm.showWarningToast = showWarningToast;
    vm.showInfoToast = showInfoToast;

    function showSuccessToast(msg, params) {
        showToast(msg, "alert-success", params);
    }
    
    function showErrorToast(msg, params) {
        showToast(msg, "alert-danger", params);
    }
    
    function showWarningToast(msg, params) {
        showToast(msg, "alert-warning", params);
    }
    
    function showInfoToast(msg, params) {
        showToast(msg, "alert-info", params);
    }

    function showToast(msg, className, params) {
        if(!params){
            params = {};
        }
        toast({
            message   : msg,
            className : className,
            duration  : params.duration,
            position  : params.position,
            container : params.container,
            dismissible : params.dismissible,
            maxToast  : params.maxToast,
            insertFromTop : params.insertFromTop,
            removeFromTop : params.removeFromTop,
            masterClass : params.masterClass
        });
    }
}