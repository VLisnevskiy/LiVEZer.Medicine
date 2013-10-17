Ext.Loader.setConfig({
    enabled : true
});

Ext.application({
    name : 'LiVEZer.Medicine',

    paths : {
        'LiVEZer.Medicine' : 'js/apps'
    },

    controllers : [ 'Stocks' ],

    autoCreateViewport : true
});
