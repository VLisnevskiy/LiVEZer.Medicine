/*******************************************************************************
 * ********** Main JavaScript File
 ******************************************************************************/
// Globals
var menuCreator = new MenuCreatoClass();

// when Document loaded
$(document).ready(function() {
    // TO DO:
    menuCreator.createMainMenu();

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
            return "<li id=\""
                    + e.itemId
                    + "\"><a id=\"executed\" onmouseup=\"selectTarget(this)\" onclick=\""
                    + e.action + "\"><em><span>" + e.title
                    + "</span></em><img src=\"" + e.file + "\" alt=\""
                    + e.title + "\"/></a><span id=\"indic\"></span></li>";
        } else {
            return "<li id=\"" + e.itemId
                    + "\"><a onmouseup=\"selectTarget(this)\" onclick=\""
                    + e.action + "\"><em><span>" + e.title
                    + "</span></em><img src=\"" + e.file + "\" alt=\""
                    + e.title + "\"/></a><span></span></li>";
        }
    }
}

/*******************************************************************************
 * Functions
 ******************************************************************************/

/*
  function require(script) {
    $.ajax({
        url: script,
        dataType: "script",
        async: false,           // <-- This is the key
        success: function () {
            // all good...
        },
        error: function () {
            throw new Error("Could not load script " + script);
        }
    });
}
  */

/*
 * item.file
 * item.itemId
 * item.selected
 * item.action
 * item.title
 */

function selectTarget(e) {
    $('#executed').removeAttr('id');
    $(e).attr('id', 'executed');
    $('#indic').removeAttr('id');
    $(e).next().attr('id', 'indic');
}

function openUserInformation() {
    $(document).attr('title', 'LiVEZer - Medical [User]');
    alert("User menu Opened");
}
function loginToSystem() {
    $(document).attr('title', 'LiVEZer - Medical :: Main');
    $('#container').html(createHtmlTag());
}

function showSom() {
    $(document).attr('title', 'LiVEZer - Medical :: User');
    $('#container').append(createHtmlTag());
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}
