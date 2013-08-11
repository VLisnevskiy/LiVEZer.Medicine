package LiVEZer.Medicine.WebApp.Controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminController extends BaseController
{
    public final static String ControllerFolder = "admin/";

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Override
    protected final String GetPathName()
    {
        return ControllerFolder;
    }

    @RequestMapping("/")
    public String Index(Locale locale, Model model)
    {
        logger.info("Invoking \"~/admin/\"");

        return ReturnPageWay("index");
    }
}
