Ext.Loader.setConfig({
    enabled : true
});

Ext.application({
    name : 'LiVEZer.Medicine',

    paths : {
        'LiVEZer.Medicine' : 'js/apps/first_app'
    },

    controllers : [ 'Stocks' ],

    autoCreateViewport : true
});
