/**
 * The main application viewport, which displays the whole application
 * 
 * @extends Ext.Viewport
 */
Ext.define('LiVEZer.Medicine.view.Viewport', {
    extend : 'Ext.Viewport',
    layout : 'fit',

    requires : [ 'LiVEZer.Medicine.view.stock.StockGrid', 'LiVEZer.Medicine.view.stock.StockForm' ],

    initComponent : function() {
        var me = this;

        Ext.apply(me, {
            items : [ {
                xtype : 'stockpanel'
            } ]
        });

        me.callParent(arguments);
    }
});
