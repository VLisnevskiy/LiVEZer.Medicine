package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

@Controller
@RequestMapping(value = "/browser/**")
public class BrowserController extends BaseAjaxController
{
    private static final Logger logger = Logger.getLogger(BrowserController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public JSONResponse Index() throws IOException
    {
        logger.info("Invoking \"~/browser/\"");

        Error response = new Error();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("No permissions");
        return response;
    }
}
