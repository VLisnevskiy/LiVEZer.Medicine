package LiVEZer.Medicine.WebApp.DataProviders;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import LiVEZer.Medicine.WebApp.DBManager;
import LiVEZer.Medicine.WebApp.Globals.Models;
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

    public WebUserSession LogIn(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        if (!userDAO.isOpen())
            userDAO.Refresh();

        WebUserSession userSession = null;
        LogInModel model = getLogInModel(request);
        try
        {
            List<User> users = userDAO.Read(model.getSearchCriteria());
            if (users.size() > 0)
            {
                userSession = SessionManager.GetInstance().CreateSession(request, users.get(0));
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

    private LogInModel getLogInModel(HttpServletRequest request)
    {
        LogInModel model = new LogInModel();
        HashMap<String, String> params = prepareLogInParam(request.getParameterMap());
        model.setLogin(params.get(Models.LogInModel.Login));
        model.setPassw(params.get(Models.LogInModel.Password));
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
