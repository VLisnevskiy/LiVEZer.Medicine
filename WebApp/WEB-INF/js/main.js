/*******************************************************************************
 * ********** Main JavaScript File
 ******************************************************************************/
// Globals
var menuCreator;
var logInProvider;
var loadingVisualization;
var confirmBeforeExit;

// when Document loaded
$(document).ready(function() {
    // Loading Required Scripts
    loadScript('js/func/GlobalFunctions.js');
    loadScript('js/func/LogInProvider.js');
    loadScript('js/func/LoadingVisualization.js');
    loadScript('js/func/MenuCreatoClass.js');

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

function confirmExit() {
    if (confirmBeforeExit) { return "You have made unsaved changes.\r\n"; }
}
