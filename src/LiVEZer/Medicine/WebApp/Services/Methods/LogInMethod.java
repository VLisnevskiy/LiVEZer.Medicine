package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.DataProviders.UserProvider;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.Common.WebUserSession;

public class LogInMethod implements IServiceMethod
{

    @Override
    public GenericJSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
    {
        UserProvider userProvider = new UserProvider();
        WebUserSession session = userProvider.LogIn(request.getParameterMap());
        return session;
    }

}
