Ext.Loader.setConfig({
    enabled : true
});

var userAppMainWindow;

var userApp = Ext.application({
    name : 'LiVEZer.Medicine',
    appFolder : 'js/app',

    controllers : [ 'Users' ],

    launch : function() {
        userAppMainWindow = Ext.create('Ext.window.Window', {
            title : 'Список користувачів',
            height : 400,
            width : 600,
            layout : 'fit',
            closeAction : 'hide',
            maximizable: true,
            items : {
                xtype : 'userlist',
                border : false
            }
        });
        userAppMainWindow.show();
    }
});