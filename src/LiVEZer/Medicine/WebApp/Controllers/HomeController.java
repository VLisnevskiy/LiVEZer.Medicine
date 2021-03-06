package LiVEZer.Medicine.WebApp.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/**")
public class HomeController extends BaseController
{
    public final static String ControllerFolder = "home/";

    private static final Logger logger = Logger.getLogger(HomeController.class);

    @Override
    protected final String GetPathName()
    {
        return ControllerFolder;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index(Locale locale, Model model)
    {
        logger.info("Welcome home! The client locale is {}."/*, locale*/);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return ReturnPageWay("index");
    }
}
