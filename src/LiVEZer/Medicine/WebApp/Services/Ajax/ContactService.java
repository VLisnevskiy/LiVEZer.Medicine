package LiVEZer.Medicine.WebApp.Services.Ajax;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import LiVEZer.Medicine.WebApp.DAO.ContactDAO;
import LiVEZer.Medicine.WebApp.Models.Contact;
import LiVEZer.Medicine.WebApp.Utils.Utils;

@Service
public class ContactService {

    private ContactDAO contactDAO;
    private Utils util;

    @Transactional(readOnly=true)
    public List<Contact> getContactList(){

        return contactDAO.getContacts();
    }

    @Transactional
    public List<Contact> create(Object data){

        List<Contact> newContacts = new ArrayList<Contact>();

        List<Contact> list = util.getContactsFromRequest(data);

        for (Contact contact : list){
            newContacts.add(contactDAO.saveContact(contact));
        }

        return newContacts;
    }

    @Transactional
    public List<Contact> update(Object data){

        List<Contact> returnContacts = new ArrayList<Contact>();

        List<Contact> updatedContacts = util.getContactsFromRequest(data);

        for (Contact contact : updatedContacts){
            returnContacts.add(contactDAO.saveContact(contact));
        }

        return returnContacts;
    }

    @Transactional
    public void delete(Object data){

        //it is an array - have to cast to array object
        if (data.toString().indexOf('[') > -1){

            List<Integer> deleteContacts = util.getListIdFromJSON(data);

            for (Integer id : deleteContacts){
                contactDAO.deleteContact(id);
            }

        } else { //it is only one object - cast to object/bean

            Integer id = Integer.parseInt(data.toString());

            contactDAO.deleteContact(id);
        }
    }

    @Autowired
    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Autowired
    public void setUtil(Utils util) {
        this.util = util;
    }
}