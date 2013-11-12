Ext.define('LiVEZer.Medicine.view.stock.StockPanel', {
    extend : 'Ext.form.Panel',
    alias : 'widget.stockpanel',

    frame : true,
    title : 'Company Data',
    margin : '40 40 40 40',
    bodyPadding : 5,
    layout : 'column', // Specifies that the items will now be arranged in
                        // columns

    fieldDefaults : {
        labelAlign : 'left',
        msgTarget : 'side'
    },

    items : [ {
        xtype : 'stockgrid',
        columnWidth : .60
    }, {
        xtype : 'stockform',
        columnWidth : .40
    } ]

});
