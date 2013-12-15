/*******************************************************************************
 * ********** JavaScript using JQuery. LogInProvider.
 ******************************************************************************/

function LogInProvider() {

    var isCreated = false;

    this.isCreated = function() {
        return isCreated;
    };

    this.createLogInForm = function() {
        createLogInForm();
    };

    this.closeLogInForm = function() {
        closeLogInForm();
    };

    this.logInToSystem = function() {
        $('#login-in-box-title').html("LogIn");
        var val = $('#passw').val();
        if ((val != "") && ($('#login').val() != "")) {
            $('#passw').val($.md5(val));
            var params = $('#login-in-form').serializeToObject();
            $('#passw').val(val);
            performLogIn(params);
        } else {
            wrangCredentials(null);
        }
    };

    function createLogInForm() {
        if (!isCreated) {
            $('#main').append("<div id=\"login-in-box\"></div>");
            generateForm();
            setEventHandler();
            isCreated = true;
        }
    }

    function closeLogInForm() {
        if (isCreated) {
            $('#login-in-box').remove();
            removeSelection();
            isCreated = false;
        }
    }
    
    function hideLogInForm() {
        if (isCreated) {
            $('#login-in-box').hide();
        }
    }
    
    function showLogInForm() {
        if (isCreated) {
            $('#login-in-box').show();
        }
    }

    function generateForm() {
        var element = "<div id=\"login-in-box-title\">Авторизація</div><form id=\"login-in-form\" autocomplete=\"off\">"
                + "<input type=\"text\" name=\"login\" id=\"login\" placeholder=\"Ім'я користувача\" />"
                + "<input type=\"password\" name=\"passw\" id=\"passw\" placeholder=\"Пароль\" />"
                + "<input type=\"submit\" value=\"Увійти\" /></form>";
        $('#login-in-box').html(element);
    }

    function wrangCredentials(message) {
        if (message == null)
            message = "Incorrect credentials";
        $('#login-in-box-title').html(message);
        $("#login-in-box").effect("bounce", {
            times : 3
        }, "slow");
    }

    function performLogIn(params) {
        var bOk = true;
        params = { method: 'logIn', data : params};
        $.ajax({
            url : 'do',
            type : 'POST',
            dataType : 'json',
            async : true,
            data : params,
            success : function(data) {
                bOk = checkSession(data);
                if (bOk) {
                    // TODO: If LogIn success
                    closeLogInForm();
                    setMainPageTitle('LiVEZer - Medical :: Welcome ' + userSession.userName);
                    loadingVisualization.showMmainLoading();
                    bOk = menuCreator.createMainMenu();
                    if (!bOk) {
                        // TODO: Warning
                    } else {
                        // confirmBeforeExit = true;
                    }
                    loadingVisualization.closeMmainLoading();
                }
                    
                loadingVisualization.closeMmainLoading();
                closeLogInForm();
            },
            error : function() {
                bOk = false;
                showLogInForm();
                loadingVisualization.closeMmainLoading();
                wrangCredentials("Error: Try again");
                throw new Error("Error, during connection to WebServer!");
            }
        });
        
        hideLogInForm();
        loadingVisualization.showMmainLoading();
    }

    function checkSession(data) {
        if (data.success) {
            userSession = data;
            return true;
        } else {
            // TODO:
            wrangCredentials(data.message);
            return false;
        }
    }
}

// Additional Global Function

function setEventHandler() {
    $('#login-in-form').submit(function() {
        logInProvider.logInToSystem();
        return false;
    });
};