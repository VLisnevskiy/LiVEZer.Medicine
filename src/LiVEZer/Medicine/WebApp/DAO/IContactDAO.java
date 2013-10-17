package LiVEZer.Medicine.WebApp.DAO;

import java.util.List;

import LiVEZer.Medicine.WebApp.Models.Contact;

public interface IContactDAO
{
    List<Contact> getContacts();

    void deleteContact(int id);

    Contact saveContact(Contact contact);
}
