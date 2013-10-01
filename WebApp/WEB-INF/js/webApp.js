/*******************************************************************************
 * ********** Main JavaScript File
 ******************************************************************************/

// when Document loaded
$(document).ready(function() {
    // TO DO:

    $('.btn').button();

    createMainMenu();
});

// when Window loaded
$(window).load(function() {
    // TO DO:
});

/*******************************************************************************
 * ********** Functions
 ******************************************************************************/

function createMainMenu() {
    $.ajax({
        url : 'do',
        type : 'POST',
        dataType : 'json',
        data : {
            method : "getMenuItems"
        }
    }).done(function(data) {
        var htmlText = "<ul>";
        $.each(data.items, function(index, value) {
            htmlText += addMenuItem(value);
        });
        htmlText += "</ul>";
        $('.dock').html(htmlText);
    }).fail(function() {
        alert("error");
    });
}

function addMenuItem(item) {
    // $('.dock ul').append();
    return "<li id=\"" + item.itemId + "\"><a dhref=\"#" + item.itemId
            + "\" onmouseup=\"" + item.action + "\">" + "<em><span>"
            + item.title + "</span></em><img src=\"" + item.file + "\" alt=\""
            + item.title + "\"/></a></li>";
    /*
     * item.file
     * item.itemId
     * item.selected
     * item.action
     * item.title
     */
}

function openUserInformation() {
    alert("User menu Opened");
}
function loginToSystem() {
    $('#container').html(createHtmlTag());
}

function createHtmlTag() {
    return "<div style=\"text-align:center\">In center</div>";
}
