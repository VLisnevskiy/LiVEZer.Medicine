package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import LiVEZer.Medicine.WebApp.DBManager;
import LiVEZer.Medicine.WebApp.DAO.CRUD;
import LiVEZer.Medicine.WebApp.DAO.Models.User;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Users.Item;

public class SimpMet implements IServiceMethod
{

    @Override
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
    {
        Item item = new Item();
        item.setSuccess(true);
        item.setName("List of Elements");

        Session session = DBManager.getSessionFactory().openSession();

        DBManager.CloseSession(session);

        CRUD<User, Long> usersC = new CRUD<User, Long>(User.class);

        try
        {
            User us = usersC.Read((long) 1);
            us.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return item;
    }

    /**
     * Criteria cr = session.createCriteria(Employee.class);
     * 
     * Criterion salary = Restrictions.gt("salary", 2000); Criterion name =
     * Restrictions.ilike("firstNname","zara%");
     * 
     * // To get records matching with OR condistions LogicalExpression orExp =
     * Restrictions.or(salary, name); cr.add( orExp );
     * 
     * 
     * // To get records matching with AND condistions LogicalExpression andExp
     * = Restrictions.and(salary, name); cr.add( andExp );
     * 
     * List results = cr.list();
     **/

    @Override
    public String getMethodName()
    {
        return "getItems";
    }
}
