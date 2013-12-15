Ext.define('LiVEZer.Medicine.controller.Users', {
	extend: 'Ext.app.Controller',

	stores: [
		'Users'
	],

	models: [
		'User'
	],

	views: [
		'user.List',
		'user.Add',
		'user.Edit'
	],
	
	refs: [{
        selector: 'userlist > toolbar',
        ref: 'userListToolbar'}
    ],

	init: function () {
		this.control({
			'userlist': {
				itemdblclick: this.editUser,
				removeitem: this.removeUser,
				addItem: this.onCreateUser,
				select: this.selectedRow,
				editUser: this.editUser
			},
			'userlist > toolbar > button[action=createUser]': {
				click: this.onCreateUser
			},
			'userlist > toolbar > button[action=editUser]': {
				click: this.editSelectedRow
			},
			'userlist > toolbar > button[action=deleteUser]': {
				click: this.deleteSelectedRow
			},
			'useradd button[action=save]': {
				click: this.doCreateUser
			},
			'useredit button[action=save]': {
				click: this.updateUser
			}
		});
		//this.getUsersStore().loadPage(1);
	},

	editUser: function (grid, record) {
		var view = Ext.widget('useredit');
		view.down('form').loadRecord(record);
	},

	removeUser: function (user) {
		Ext.Msg.confirm('Delete User', 'Are you sure?', function (button) {
			if (button == 'yes') {
				this.getUsersStore().remove(user);
			}
		}, this);
	},
	
	selectedRecord: null,
	
	editSelectedRow: function()	{
		if (this.selectedRecord != null)
		{
			var view = Ext.widget('useredit');
			view.down('form').loadRecord(this.selectedRecord);
		}
	},
	
	deleteSelectedRow: function() {
		if (this.selectedRecord != null)
			this.removeUser(this.selectedRecord);
	},
	
	selectedRow: function(rowModel, record, index) {
		this.selectedRecord = record;
		var bar = this.getUserListToolbar();
		bar.getComponent('editUser').setDisabled(false);
		bar.getComponent('deleteUser').setDisabled(false);
	},

	onCreateUser: function () {
		var view = Ext.widget('useradd');
	},

	doCreateUser: function (button) {
		var win = button.up('window'),
			form = win.down('form'),
			values = form.getValues(),
			store = this.getUsersStore();

		if (form.getForm().isValid()) {
			store.add(values);
			win.close();
		}
	},

	updateUser: function (button) {
		var win = button.up('window'),
			form = win.down('form'),
			record = form.getRecord(),
			values = form.getValues(),
			store = this.getUsersStore();

		record.set(values);
		win.close();
	}
});