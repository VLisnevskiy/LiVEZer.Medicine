package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import LiVEZer.Medicine.WebApp.DataProviders.UserProvider;
//import LiVEZer.Medicine.WebApp.DAO.Models.User;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.*;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Users.*;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminAjaxController
{
    private static final Logger logger = Logger.getLogger(AdminAjaxController.class);


    public AdminAjaxController()
    {
    }

    @RequestMapping(value = "/ajax.index")
    @ResponseBody
    public JSONResponse Index() throws IOException
    {
        logger.info("Invoking \"~/user/\"");

        Error response = new Error();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("No permissions");
        return response;
    }

    @RequestMapping(value = "/ajax.user.add")
    @ResponseBody
    public JSONResponse AddNewUser(@RequestBody User user)
    {
        logger.info("Invoking \"~/user/ajax.user.add\"");
        JSONResponse response = new JSONResponse();
        /*try
        {
            if (user != null)
            {
                response = new Collection();
                user.setId(++id);
                users.add(user);
                ((Collection) response).setData(user);
                response.setSuccess(true);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response = new Error();
            ((Error) response).setCode(4);
            ((Error) response).setMessage("Can't create new User");
        }*/

        return response;
    }

    @RequestMapping(value = "/ajax.user.read")
    @ResponseBody
    public JSONResponse ReadUsers(@RequestParam int page, @RequestParam int size)
    {
        logger.info("Invoking \"~/user/ajax.user.read\" (page = " + page + " size = " + size + ")");

        List<User> usr = new ArrayList<User>();
        List<LiVEZer.Medicine.WebApp.DAO.Models.User> users = null; 
        try
        {
            users = (new UserProvider()).ReadAllUsers();
            for (int i = page; i < page + size && i < users.size(); i++)
            {
                User user = new User();
                user.setActive(users.get(i).isActive());
                user.setEmail(users.get(i).getWorkEmail());
                user.setId((int) users.get(i).getId());
                user.setName(users.get(i).getPerson().getFirstName() + " "
                        + users.get(i).getPerson().getLastName());
                user.setRole(users.get(i).getRole().getRoleId());
                usr.add(user);
            }
        }
        catch (Exception e)
        {

        }

        Collection response = new Collection();
        response.setData(usr);
        response.setTotal(users != null ? users.size() : 0);
        response.setSuccess(true);

        logger.info(response);
        return response;
    }

    @RequestMapping(value = "/ajax.user.update")
    @ResponseBody
    public JSONResponse UpdateUser(@RequestBody User user)
    {
        logger.info("Invoking \"~/user/ajax.user.update\"");

        Error response = new Error();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("ajax.user.update");
        return response;
    }

    @RequestMapping(value = "/ajax.user.delete")
    @ResponseBody
    public JSONResponse DeleteUser(@RequestBody User user)
    {
        logger.info("Invoking \"~/user/ajax.user.delete\"");

        Collection coll = new Collection();
        coll.setData(user);
        logger.info(coll);

        Error response = new Error();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("ajax.user.delete");
        return response;
    }
}
