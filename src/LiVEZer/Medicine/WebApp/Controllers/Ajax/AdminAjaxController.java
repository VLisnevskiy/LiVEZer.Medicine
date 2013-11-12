package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminAjaxController extends BaseAjaxController
{
    private static final Logger logger = Logger.getLogger(AdminAjaxController.class);

    @RequestMapping(value = "/ajax.index")
    @ResponseBody
    public Error Index() throws IOException
    {
        logger.info("Invoking \"~/user/\"");

        Error response = new Error();
        response.setSuccess(false);
        response.setCode(1);
        response.setMessage("No permissions");
        return response;
    }
}
