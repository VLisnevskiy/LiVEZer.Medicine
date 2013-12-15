/*******************************************************************************
 * ********** JavaScript using JQuery. MenuCreatoClass.
 ******************************************************************************/

function MenuCreatoClass() {

    this.createMainMenu = function() {
        var bRes = false;
        $.ajax({
            url : 'do',
            type : 'POST',
            dataType : 'json',
            async : false,
            data : {
                method : "getMainMenu",
                data : JSON.stringify(userSession)
            },
            success : function(data) {
                buildMainMenu(data);
                bRes = true;
            },
            error : function() {
                bRes = false;
                throw new Error("Error, during connection to WebServer!");
            }// , complete : function() {}
        });
        return bRes;
    };

    function buildMainMenu(data) {
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

// Additional Global Function

function selectTarget(e) {
    removeSelection();
    $(e).attr('id', 'executed');
    $(e).next().attr('id', 'indic');
}

function removeSelection() {
    $('#executed').removeAttr('id');
    $('#indic').removeAttr('id');
}