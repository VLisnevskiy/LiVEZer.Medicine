Ext.Loader.setConfig({
    enabled : true
});

var patientAppMainWindow;

var patientApp = Ext.application({
    name : 'LiVEZer.Medicine',
    appFolder : 'js/apps',

    //controllers : [ 'Users' ],

    launch : function() {
        patientAppMainWindow = Ext.create('Ext.window.Window', {
            title : 'Список Пацієнтів',
            height : 400,
            width : 600,
            layout : 'fit',
            closeAction : 'hide',
            maximizable: true/*,
            items : {
                xtype : 'userlist',
                border : false
            }*/
        });
        patientAppMainWindow.show();
    }
});