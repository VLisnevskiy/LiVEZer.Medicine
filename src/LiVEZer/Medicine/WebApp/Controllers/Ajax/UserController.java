package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import LiVEZer.Medicine.WebApp.Services.JSONRespons.ErrorResponse;

@Controller
@RequestMapping(value = "/user/**")
public class UserController
{
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ErrorResponse Index() throws IOException
    {
        logger.info("Invoking \"~/user/\"");

        ErrorResponse response = new ErrorResponse();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("No permissions");
        return response;
    }
}
