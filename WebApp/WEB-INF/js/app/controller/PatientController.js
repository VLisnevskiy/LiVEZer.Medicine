Ext.define('LiVEZer.Medicine.controller.PatientControler', {
    extend: 'Ext.app.Controller',

    stores: [
        'PatientStore'
    ],

    models: [
        'Patient'
    ],

    views: [
        'patient.List',
        'patient.Add',
        'patient.Edit'
    ],

    init: function () {
        this.control({
            'patientlist': {
                itemdblclick: this.editUser,
                removeitem: this.removeUser
            },
            'patientlist > toolbar > button[action=create]': {
                click: this.onCreateUser
            },
            'patientadd button[action=save]': {
                click: this.doCreateUser
            },
            'patientedit button[action=save]': {
                click: this.updateUser
            }
        });
        //this.getUsersStore().loadPage(1);
    },

    editUser: function (grid, record) {
        var view = Ext.widget('patientedit');
        view.down('form').loadRecord(record);
    },

    removeUser: function (user) {
        Ext.Msg.confirm('Delete Patient', 'Are you sure?', function (button) {
            if (button == 'yes') {
                this.getUsersStore().remove(user);
            }
        }, this);
    },

    onCreateUser: function () {
        var view = Ext.widget('patientadd');
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