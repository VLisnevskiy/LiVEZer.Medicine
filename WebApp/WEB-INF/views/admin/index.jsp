<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Admin</title>
<link type="image/ico" rel="icon" href="favicon.ico" />
<!-- Link CSS files -->
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/ext/css/ext-all.css"/>
<!-- Link JavaScript files-->
<script type="text/javascript" src="js/LAB.min.js"></script>

<script type="text/javascript" src="js/ext/ext-all-debug.js"></script>
<script type="text/javascript" src="js/apps/UsersApp.js"></script>
<!--
<script type="text/javascript" src="js/ext/ext-all.js"></script>
<script type="text/javascript" src="js/apps/first_app.js"></script>-->
<!-- 
<script type="text/javascript">
Ext.onReady(function(){

    Ext.BLANK_IMAGE_URL = 'css/ext/s.gif';
    
    var Contact = Ext.data.Record.create([
    {name: 'id'},
    {
        name: 'name',
        type: 'string'
    }, {
        name: 'phone',
        type: 'string'
    }, {
        name: 'email',
        type: 'string'
    }]);
    
    var proxy = new Ext.data.HttpProxy({
        api: {
            read : 'contact/view.action',
            create : 'contact/create.action',
            update: 'contact/update.action',
            destroy: 'contact/delete.action'
        }
    });
    
    var reader = new Ext.data.JsonReader({
        totalProperty: 'total',
        successProperty: 'success',
        idProperty: 'id',
        root: 'data',
        messageProperty: 'message'  // <-- New "messageProperty" meta-data
    }, 
    Contact);

 // The new DataWriter component.
    var writer = new Ext.data.JsonWriter({
        encode: true,
        writeAllFields: true
    });
    
 // Typical Store collecting the Proxy, Reader and Writer together.
    var store = new Ext.data.Store({
        id: 'user',
        proxy: proxy,
        reader: reader,
        writer: writer,  // <-- plug a DataWriter into the store just as you would a Reader
        autoSave: false // <-- false would delay executing create, update, destroy requests until specifically told to do so with some [save] buton.
    });

    //read the data from simple array
    store.load();
    
    Ext.data.DataProxy.addListener('exception', function(proxy, type, action, options, res) {
        Ext.Msg.show({
            title: 'ERROR',
            msg: res.message,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    });

    
    var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
    });
    

    // create grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "NAME",
             width: 170,
             sortable: true,
             dataIndex: 'name',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }},
            {header: "PHONE #",
             width: 160,
             sortable: true,
             dataIndex: 'phone',
             editor: {
                 xtype: 'textfield',
                 allowBlank: false
            }},
            {header: "EMAIL",
             width: 170,
             sortable: true,
             dataIndex: 'email',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }}
        ],
        viewConfig:{forcefit:true},
        plugins: [editor],
        title: 'My Contacts',
        height: 300,
        width:535,
        frame:true,
        tbar: [{
            iconCls: 'icon-user-add',
            text: 'Add Contact',
            handler: function(){
                var e = new Contact({
                    name: 'New Guy',
                    phone: '(000) 000-0000',
                    email: 'new@loianetest.com'
                });
                editor.stopEditing();
                store.insert(0, e);
                grid.getView().refresh();
                grid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },{
            iconCls: 'icon-user-delete',
            text: 'Remove Contact',
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        },{
            iconCls: 'icon-user-save',
            text: 'Save All Modifications',
            handler: function(){
                store.save();
            }
        }]
    });

    //render to DIV
    grid.render('crud-grid');
});
</script>
-->
</head>
<body>
    <!-- 
    <div id="main">
        <div id="crud-grid"></div>
        <!-- Begin: CSS Dock Code - ->
        <div class="dock"></div>
        <!-- End: CSS Dock Code - ->
    </div>
    <script type="text/javascript">
    /*$LAB.script("js/jquery/jquery-1.10.2.min.js").wait()
    .script("js/jquery/jquery-ui-1.10.3.min.js").wait()
    .script("js/jquery/jquery.md5.js").wait();*/
    //.script("js/main.js").wait();
    </script>
    -->
</body>
</html>