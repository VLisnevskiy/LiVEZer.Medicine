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

function showSom() {
    setMainPageTitle('LiVEZer - Medical :: User');
    $('#container').append(createHtmlTag());
    loadScript('js/apps/userForm_app.js');
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}