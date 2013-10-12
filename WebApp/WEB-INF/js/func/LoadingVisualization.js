/*******************************************************************************
 * ********** JavaScript using JQuery. LoadingVisualization.
 ******************************************************************************/

function LoadingVisualization() {

    var isMmainLoadingVisible = false;

    this.showMmainLoading = function() {
        if (!isMmainLoadingVisible) {
            $('#main').append(
                    "<div class='main-loading'><div id='b'></div><div id='m'></div>" + "<span>Loading...</span></div>");
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