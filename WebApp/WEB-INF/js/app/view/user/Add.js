Ext.define('LiVEZer.Medicine.view.user.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.useradd',

	title: 'Додати користувача',
	layout: {
		type: 'fit',
        align: 'stretch'
    },
	autoShow: true,

	initComponent: function () {
		this.items = [
			{
				xtype: 'form',
				bodyStyle: {
					background: 'none',
					padding: '5px',
					border: '0'
				},
				items: [
					{
						xtype: 'textfield',
						name: 'name',
						allowBlank: false,
						fieldLabel: 'Name'
					},
					{
						xtype: 'textfield',
						name: 'role',
						allowBlank: false,
						fieldLabel: 'Role'
					},
					{
						xtype: 'textfield',
						name: 'email',
						allowBlank: false,
						vtype: 'email',
						fieldLabel: 'Email'
					},{xtype: 'tbfill'},
					{
						xtype: 'checkboxfield',
						boxLabel  : 'Active',
						name: 'active',
						allowBlank: false,
						inputValue: 'true'
						//vtype: 'email',
						//fieldLabel: 'Active'
					}
				]
			}
		];

		this.buttons = [
			{
				text: 'Save',
				action: 'save'
			},
			{
				text: 'Cancel',
				scope: this,
				handler: this.close
			}
		];

		this.callParent(arguments);
	}
});