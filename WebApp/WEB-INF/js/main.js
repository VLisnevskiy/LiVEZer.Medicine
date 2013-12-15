/*******************************************************************************
 * ********** Main JavaScript File
 ******************************************************************************/
// Globals
var menuCreator;
var logInProvider;
var loadingVisualization;
var confirmBeforeExit;
var userSession = {};

var isUserAppLoaded = false;
var isPatientAppLoaded = false;
var isVisitAppLoaded = false;
var isOrderAppLoaded = false;
var isCalendarAppLoaded = false;
var isSettingsAppLoaded = false;

// when Document loaded
$(document).ready(function() {
    // Loading Required Scripts
    loadScript('js/func/Constants.js');
    loadScript('js/func/GlobalFunctions.js');
    //loadScript('js/func/LogInProvider.js');
    loadScript('js/func/LoadingVisualization.js');
    //loadScript('js/func/MenuCreatoClass.js');

    // Initialization
    menuCreator = new MenuCreatoClass();
    logInProvider = new LogInProvider();
    loadingVisualization = new LoadingVisualization();
    confirmBeforeExit = false;

    // Executing
    logInProvider.createLogInForm();
    window.onbeforeunload = confirmExit;
});

// when Window loaded
$(window).load(function() {
    // TODO:
});

/*******************************************************************************
 * Functions
 ******************************************************************************/

function loadScript(script) {
    $.ajax({
        url : script,
        dataType : "script",
        async : false, // <-- This is the key
        success : function() { // all good...
        },
        error : function() {
            throw new Error("Could not load script " + script);
        }
    });
}

$.fn.serializeToObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return JSON.stringify(o);
};

function confirmExit() {
    if (confirmBeforeExit) { return "You have made unsaved changes.\r\n"; }
}
