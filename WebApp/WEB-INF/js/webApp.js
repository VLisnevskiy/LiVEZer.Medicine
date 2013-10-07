/*******************************************************************************
 * ********** Main JavaScript File
 ******************************************************************************/
// Globals
var menuCreator = new MenuCreatoClass();
var logInProvider = new LogInProvider();

// when Document loaded
$(document).ready(function() {
    // TO DO:
    menuCreator.createMainMenu();
    // logInProvider.createLogInForm();

});

// when Window loaded
$(window).load(function() {
    // TO DO:
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
            data : {
                method : "getMenuItems"
            }
        }).done(function(data) {
            if (data.success) {
                var htmlText = "<ul>";
                $.each(data.items, function(index, value) {
                    htmlText += addMenuItem(value);
                });
                htmlText += "</ul>";
                $('.dock').html(htmlText);
            } else {
                alert("Error with code:" + data.code + "\r\nMessage: " + data.message);
            }
        }).fail(function() {
            alert("Error, during connection to WebServer!");
        });
    };

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
    ;
}

function LogInProvider() {

    this.isCreated = false;

    this.createLogInForm = function() {
        if (this.isCreated === false) {
            $('#main').append("<div id=\"login-in-box\"></div>");
            generateForm();
            setEventHandler();
            this.isCreated = true;
        }
    };

    this.closeLogInForm = function() {
        if (this.isCreated === true) {
            $('#login-in-box').remove();
            removeSelection();
            this.isCreated = false;
        }
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
            $('#container').html($('#login-in-form').serialize());
            $('#passw').val(val);
            logInProvider.closeLogInForm();
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

/*
 * function require(script) { $.ajax({ url: script, dataType: "script", async:
 * false, // <-- This is the key success: function () { // all good... }, error:
 * function () { throw new Error("Could not load script " + script); } }); }
 */

/*
 * item.file item.itemId item.selected item.action item.title
 */

function selectTarget(e) {
    removeSelection();
    $(e).attr('id', 'executed');
    $(e).next().attr('id', 'indic');
}

function removeSelection() {
    $('#executed').removeAttr('id');
    $('#indic').removeAttr('id');
}

function openUserInformation() {
    $(document).attr('title', 'LiVEZer - Medical [User]');
    alert("User menu Opened");
}
function loginToSystem() {
    $(document).attr('title', 'LiVEZer - Medical :: LogIn');
    logInProvider.createLogInForm();
}

function showSom() {
    $(document).attr('title', 'LiVEZer - Medical :: User');
    $('#container').append(createHtmlTag());
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}
