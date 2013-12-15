Ext.define('LiVEZer.Medicine.store.Users', {
	extend: 'Ext.data.Store',
	model: 'LiVEZer.Medicine.model.User',
	autoLoad: true,
	autoSync: true,
	pageSize: 10,
	proxy: {
		type: 'ajax',
		limitParam: 'size',
		startParam: 'page',
		api: {
			create: 'admin/ajax.user.add',
			read: 'admin/ajax.user.read',
			update: 'admin/ajax.user.update',
			destroy: 'admin/ajax.user.delete'
		},
		reader: {
			type: 'json',
			root: 'data',
			successProperty: 'success',
			totalProperty: 'total'
		},
		writer: {
			type: 'json',
			writeAllFields: false
		},
		sorters: [{
            property: 'name',
            direction: 'ASC'
        }],
		listeners: {
            exception: function(proxy, response, operation){
                var data = Ext.decode(response.responseText);
                
                Ext.MessageBox.show({
                    title: 'Error: Code - ' + data.code,
                    msg: data.message, //operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
	}
});