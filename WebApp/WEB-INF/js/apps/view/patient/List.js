Ext.define('LiVEZer.Medicine.view.user.List', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.patientlist',
    header : false,
    title : 'Список пацієнтів',
    store : 'PatientStore',
    
    dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'PatientStore',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],

    initComponent : function() {

        this.tbar = [ {
            text : 'Додати',
            icon : USER_ADD,
            action : 'create'
        }, {
            text : 'Редагувати',
            icon : USER_EDIT/*,
            disabled: true*/
        }, {
            text : 'Видалити',
            icon : USER_DELETE/*,
            disabled: true*/
        } ];

        this.columns = [
        {
            header : 'Ім\'я користувача',
            dataIndex : 'fName',
            width : 80,
            flex : 1
        },
        {
            header : 'Роль',
            dataIndex : 'mName',
            width : 50,
            flex : 1
        }, {
            header : 'Електронна адреса',
            dataIndex : 'mName',
            flex : 1
        } ];

        this.addEvents('removeitem');

        this.actions = {
            removeitem : Ext.create('Ext.Action', {
                text : 'Remove item',
                handler : function() {
                    this.fireEvent('removeitem', this.getSelected());
                },
                scope : this
            })
        };

        var contextMenu = Ext.create('Ext.menu.Menu', {
            items : [ this.actions.removeitem ],
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
    getSelected : function() {
        var sm = this.getSelectionModel();
        var rs = sm.getSelection();
        if (rs.length) { return rs[0]; }
        return null;
    }
});