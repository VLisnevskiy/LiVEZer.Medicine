/*******************************************************************************
 * ********** JavaScript using JQuery. GlobalFunctions.
 ******************************************************************************/

function setMainPageTitle(title) {
    $(document).attr('title', title);
}

function showErrorCode(error) {
    alert("Error with code:" + error.code + "\r\nMessage: " + error.message);
}

function openUserInformation() {
    setMainPageTitle('LiVEZer - Medical [User]');
    loadingVisualization.closeMmainLoading();
}

function loginToSystem() {
    setMainPageTitle('LiVEZer - Medical :: LogIn');
    logInProvider.createLogInForm();
}

function openUsersApp() {
    if (!isUserAppLoaded) {
        loadScript('js/app/Users.js');
        isUserAppLoaded = true;
    } else {
        userAppMainWindow.show();
    }
}

function openPatientsApp() {
    if (!isPatientAppLoaded) {
        loadScript('js/apps/PatientsApp.js');
        isPatientAppLoaded = true;
    } else {
        //userAppMainWindow.show();
    }
}

function openVisitsApp() {
    if (!isVisitAppLoaded) {
        loadScript('js/apps/PatientsApp.js');
        isVisitAppLoaded = true;
    } else {
        //userAppMainWindow.show();
    }
}

function openOrdersApp() {
    if (!isOrderAppLoaded) {
        loadScript('js/apps/PatientsApp.js');
        isOrderAppLoaded = true;
    } else {
        //userAppMainWindow.show();
    }
}

function openCalendarApp() {
    if (!isCalendarAppLoaded) {
        loadScript('js/apps/PatientsApp.js');
        isCalendarAppLoaded = true;
    } else {
        //userAppMainWindow.show();
    }
}

function openSettingsApp() {
    if (!isSettingsAppLoaded) {
        loadScript('js/apps/PatientsApp.js');
        isSettingsAppLoaded = true;
    } else {
        //isSettingsAppLoaded.show();
    }
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}