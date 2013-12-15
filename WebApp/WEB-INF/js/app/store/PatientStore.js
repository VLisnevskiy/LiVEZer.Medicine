Ext.define('LiVEZer.Medicine.store.PatientStore', {
    extend: 'Ext.data.Store',
    model: 'LiVEZer.Medicine.model.Patient',
    autoLoad: true,
    autoSync: true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        limitParam: 'size',
        startParam: 'page',
        api: {
            create: 'admin/ajax.patient.add',
            read: 'admin/ajax.patient.read',
            update: 'admin/ajax.patient.update',
            destroy: 'admin/ajax.patient.delete'
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