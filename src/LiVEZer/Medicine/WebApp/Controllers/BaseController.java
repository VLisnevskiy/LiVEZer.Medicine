package LiVEZer.Medicine.WebApp.Controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

@Controller
public abstract class BaseController
{
    protected abstract String GetPathName();

    public String ReturnPageWay(String pageName)
    {
        if (StringUtils.isNotBlank(GetPathName()))
        {
            return GetPathName() + pageName;
        }
        else
        {
            return pageName;
        }
    }
}
