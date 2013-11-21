package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.DataProviders.UserProvider;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;

public class LogInMethod implements IServiceMethod
{
    @Override
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        JSONResponse res = (new UserProvider()).LogIn(request, response);
        if (res == null)
        {
            res = new Error();
            res.setSuccess(false);
            ((Error) res).setCode(2);
            ((Error) res).setMessage("Incorrect credentials");
        }

        return res;
    }

    @Override
    public String getMethodName()
    {
        return "logIn";
    }
}
