package LiVEZer.Medicine.WebApp.Services.Methods;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import LiVEZer.Medicine.WebApp.DataBaseManager;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.Users.Item;

public class SimpMet implements IServiceMethod
{
    @SuppressWarnings("unchecked")
    @Override
    public GenericJSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
    {
        Item item = new Item();
        item.setSuccess(true);
        item.setName("List of Elements");
        String query = "SELECT Name FROM ITEMS";

        Session session = DataBaseManager.getSessionFactory().openSession();
        List<String> collection = session.createSQLQuery(query).list();

        item.setItems(collection);

        DataBaseManager.CloseSession(session);
        return item;
    }

}
