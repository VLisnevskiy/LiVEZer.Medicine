package LiVEZer.Medicine.WebApp.Services.Methods;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import LiVEZer.Medicine.WebApp.DBManager;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Users.Item;

public class SimpMet implements IServiceMethod
{
    @SuppressWarnings("unchecked")
    @Override
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
    {
        Item item = new Item();
        item.setSuccess(true);
        item.setName("List of Elements");
        String query = "SELECT Name FROM ITEMS";

        Session session = DBManager.getSessionFactory().openSession();
        List<String> collection = session.createSQLQuery(query).list();

        item.setItems(collection);

        DBManager.CloseSession(session);
        return item;
    }

}
