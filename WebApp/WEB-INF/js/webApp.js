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
    // Definition
    
    
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
    //TODO:
});

/*******************************************************************************
 * Classes Definition
 ******************************************************************************/
function MenuCreatoClass() {

    this.createMainMenu = function() {
        $.ajax({
            url : 'do',
            type : 'POST',
            dataType : 'json',
            async : true,
            data : {
                method : "getMenuItems"
            },
            success : function(data) {
                createMainMenu(data);
                loadingVisualization.closeMmainLoading();
                confirmBeforeExit = true;
            },
            error : function() {
                alert("Error, during connection to WebServer!");
                throw new Error("Error, during connection to WebServer!");
            },
            complete : function() {
                //loadingVisualization.closeMmainLoading();
            }
        });
    };

    function createMainMenu(data) {
        if (data.success) {
            var htmlText = "<ul>";
            $.each(data.items, function(index, value) {
                htmlText += addMenuItem(value);
            });
            htmlText += "</ul>";
            $('.dock').html(htmlText);
        } else {
            showErrorCode(data);
        }
    }

    function addMenuItem(e) {
        if (e.selected) {
            return "<li id=\"" + e.itemId + "\"><a id=\"executed\" onmouseup=\"selectTarget(this)\" onclick=\""
                    + e.action + "\"><em><span>" + e.title + "</span></em><img src=\"" + e.file
                    + "\" /></a><span id=\"indic\"></span></li>";
        } else {
            return "<li id=\"" + e.itemId + "\"><a onmouseup=\"selectTarget(this)\" onclick=\"" + e.action
                    + "\"><em><span>" + e.title + "</span></em><img src=\"" + e.file + "\" /></a><span></span></li>";
        }
    }
}

function LoadingVisualization() {

    var isMmainLoadingVisible = false;

    this.showMmainLoading = function() {
        if (!isMmainLoadingVisible) {
            $('#main').append("<div class='main-loading'><div id='b'></div><div id='m'></div>" +
                    "<span>Loading...</span></div>");
            isMmainLoadingVisible = true;
        }
    };

    this.closeMmainLoading = function() {
        if (isMmainLoadingVisible) {
            $('.main-loading').remove();
            isMmainLoadingVisible = false;
        }
    };
}

function LogInProvider() {

    this.isCreated = false;

    this.createLogInForm = function() {
        if (!this.isCreated) {
            $('#main').append("<div id=\"login-in-box\"></div>");
            generateForm();
            setEventHandler();
            this.isCreated = true;
        }
    };

    this.closeLogInForm = function() {
        if (this.isCreated) {
            $('#login-in-box').remove();
            removeSelection();
            this.isCreated = false;
        }
    };

    this.logInToSystem = function() {
        //TODO:
    };
    
    function generateForm() {
        var element = "<div id=\"login-in-box-title\">LogIn Form</div><form id=\"login-in-form\" autocomplete=\"on\">"
                + "<input type=\"text\" name=\"login\" id=\"login\" placeholder=\"Username\" />"
                + "<input type=\"password\" name=\"passw\" id=\"passw\" placeholder=\"Password\" />"
                + "<input type=\"submit\" value=\"LOG IN\" /></form>";
        $('#login-in-box').html(element);
    }
}

function setEventHandler() {
    $('#login-in-form').submit(function() {
        $('#login-in-box-title').html("LogIn Form");
        var val = $('#passw').val();
        if ((val != "") && ($('#login').val() != "")) {
            $('#passw').val($.md5(val));
            // $('#container').html($('#login-in-form').serialize());
            $('#passw').val(val);
            logInProvider.closeLogInForm();
            loadingVisualization.showMmainLoading();
            menuCreator.createMainMenu();
        } else {
            $('#login-in-box-title').html("Please enter credentials");
            $("#login-in-box").effect("bounce", {
                times : 3
            }, "slow");
        }
        return false;
    });
};

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

/*
 * item.file item.itemId item.selected item.action item.title
 */


function confirmExit() {
  if (confirmBeforeExit) {
      return "You have made unsaved changes.\r\n" +
      "Would you still like to leave this page?";
  }
}

function selectTarget(e) {
    removeSelection();
    $(e).attr('id', 'executed');
    $(e).next().attr('id', 'indic');
}

function removeSelection() {
    $('#executed').removeAttr('id');
    $('#indic').removeAttr('id');
}

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
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}
