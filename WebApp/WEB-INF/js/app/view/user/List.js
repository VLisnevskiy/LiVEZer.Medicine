Ext.define('LiVEZer.Medicine.view.user.List', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.userlist',
    header : false,
    title : 'Список користувачів',
    store : 'Users',
    id : 'UserListId',
	
    dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'Users',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],

	tbar: [{
        text : 'Додати',
        icon : USER_ADD,
        action : 'createUser'
    },{
        text : 'Редагувати',
        icon : USER_EDIT,
		action : 'editUser',
        disabled: true,
		itemId: 'editUser'
    },{
        text : 'Видалити',
        icon : USER_DELETE,
		action: 'deleteUser',
        disabled: true,
		itemId: 'deleteUser'
    }],

	columns: [{
            header : 'Ім\'я користувача',
            dataIndex : 'name',
            //width : 60,
            flex : 4
        },{
            header : 'Роль',
            dataIndex : 'role',
            //width : 50,
            flex : 2
        }, {
            header : 'Електронна адреса',
            dataIndex : 'email',
			//width : 50,
            flex : 3
        },  {
            header : 'Активний',
            dataIndex : 'active',
            flex : 1,
			width: 25,
            renderer: function (value, meta, record) {
                return '<center><input type="checkbox" onclick="return false" name="active"' + (value ? 'checked' : '') + '/></center>';
                //+ ' onclick="var s = Ext.getCmp(\'button-grid\').store; s.getAt(s.findExact(\'id\',\'' + record.get('id') + '\')).set(\'isFull\', this.value)"';
            }
        }  ],
	
    initComponent : function() {
        
        this.addEvents('removeitem');
		this.addEvents('addItem');
		this.addEvents('editUser');

        this.actions = {
            removeitem : Ext.create('Ext.Action', {
                text : 'Видалити',
				icon : USER_DELETE,
                handler : function() {
                    this.fireEvent('removeitem', this.getSelected());
                },
                scope : this
            }),
			addItem : Ext.create('Ext.Action', {
                text : 'Додати',
				icon : USER_ADD,
                handler : function() {
                    this.fireEvent('addItem');
                },
                scope : this
            }),
			editUser : Ext.create('Ext.Action', {
                text : 'Редагувати',
				icon : USER_EDIT,
                handler : function() {
                    this.fireEvent('editUser', this, this.getSelected());
                },
                scope : this
            })
        };

        var contextMenu = Ext.create('Ext.menu.Menu', {
            items : [
				this.actions.addItem,
				'-',
				this.actions.editUser,
				this.actions.removeitem
			],
            listeners : {
                beforeshow : function() {

                },
                scope : this
            }
        });

        this.on({
            itemcontextmenu : function(view, rec, node, index, e) {
                e.stopEvent();
                contextMenu.showAt(e.getXY());
                return false;
            }
        });

        this.callParent(arguments);
    },
	
	/*listeners: {
        select: {
            //element: 'el', //bind to the underlying el property on the panel
            fn: function(){ /*alert('clicked');/ }
        }/*,
        dblclick: {
            //element: 'body', //bind to the underlying body property on the panel
            fn: function(){ console.log('dblclick body'); }
        }/
    }*/
	
    getSelected : function() {
        var sm = this.getSelectionModel();
        var rs = sm.getSelection();
        if (rs.length) { return rs[0]; }
        return null;
    }
});