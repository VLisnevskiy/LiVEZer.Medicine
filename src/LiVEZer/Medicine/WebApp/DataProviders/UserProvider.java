package LiVEZer.Medicine.WebApp.DataProviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
*/
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import LiVEZer.Medicine.WebApp.DBManager;
import LiVEZer.Medicine.WebApp.SessionManager;
import LiVEZer.Medicine.WebApp.DAO.CRUD;
import LiVEZer.Medicine.WebApp.DAO.ICRUD;
import LiVEZer.Medicine.WebApp.DAO.Models.User;
import LiVEZer.Medicine.WebApp.Models.LogInModel;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Common.WebUserSession;

public class UserProvider extends BaseDataProvider
{
    private static final Logger logger = Logger.getLogger(UserProvider.class);

    private ICRUD<User, Long> userDAO;

    public UserProvider()
    {
        super();
        this.userDAO = new CRUD<User, Long>(User.class);
    }

    public UserProvider(boolean autoCloseSession)
    {
        this();
        this.autoCloseSession = autoCloseSession;
    }

    public void CloseSession()
    {
        userDAO.Close();
    }

    public WebUserSession LogIn(String data) throws Exception
    {
        if (!userDAO.isOpen())
            userDAO.Refresh();

        WebUserSession userSession = null;
        try
        {
            LogInModel model = getLogInModel(data);
            List<User> users = userDAO.Read(model.getSearchCriteria());
            if (users.size() > 0)
            {
                userSession = SessionManager.GetInstance().CreateSession(users.get(0));
            }
        }
        catch (Exception e)
        {
            logger.error("Can't perform LogIn", e);
            throw new Exception("Can't perform LogIn", e);
        }
        finally
        {
            if (this.autoCloseSession)
                userDAO.Close();
        }

        return userSession;
    }

    public List<User> ReadAllUsers() throws Exception
    {
        if (!userDAO.isOpen())
            userDAO.Refresh();
        
        List<User> users = new ArrayList<User>();
        try
        {
            /*EntityManagerFactory r = Persistence.createEntityManagerFactory("Some");
            CriteriaBuilder builder = r.createEntityManager().getCriteriaBuilder();
            CriteriaQuery<User> cr = builder.createQuery(User.class);
            Root<User> entityRoot = cr.from(User.class);
            cr.select(entityRoot);
            Order order = ascending ? builder.asc(entityRoot.get(orderBy))
                : builder.desc(entityRoot.get(orderBy));
            
            org.hibernate.criterion.Order order = ascending ? org.hibernate.criterion.Order.asc(orderBy)
                    : org.hibernate.criterion.Order.desc(orderBy);*/                    
            
            users = userDAO.Read();
        }
        catch (Exception e)
        {
            logger.error("Can't read users", e);
            throw new Exception("Can't read users", e);
        }

        return users;
    }

    public boolean CreateUser(User user)
    {
        boolean bRes = true;
        if (!userDAO.isOpen())
            userDAO.Refresh();
        try
        {
            bRes = userDAO.Save(user);
        }
        catch(Exception e)
        {
            bRes = false;
        }
        
        return bRes;
    }
    
    public boolean UpdateUser(User user)
    {
        boolean bRes = true;
        if (!userDAO.isOpen())
            userDAO.Refresh();
        try
        {
            bRes = userDAO.Save(user);
        }
        catch(Exception e)
        {
            bRes = false;
        }
        
        return bRes;
    }
    
    public boolean DeleteUser(long id)
    {
        boolean bRes = true;
        if (!userDAO.isOpen())
            userDAO.Refresh();
        try
        {
            User user = userDAO.Read(id);
            bRes = userDAO.Delete(user);
        }
        catch(Exception e)
        {
            bRes = false;
        }
        
        return bRes;
    }

    private LogInModel getLogInModel(String data) throws JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        LogInModel model = mapper.readValue(data, LogInModel.class);
        return model;
    }

    protected void finalize() throws Throwable
    {
        logger.info("UserProvider - finalize()");

        if (userDAO != null)
        {
            if (userDAO.getSession().isOpen())
            {
                DBManager.CloseSession(userDAO.getSession());
            }
            userDAO = null;
        }

        super.finalize();
    }
}
