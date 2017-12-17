(function() {
    var exec = require('cordova/exec');
    (function(){
        cordova.exec(function(result){
            window.isTablet = !!result;
        }, function(){
            console.error("Error calling IsTablet plugin");
        }, 'IsTablet', 'isTabletDevice', []);
    })();
})();
