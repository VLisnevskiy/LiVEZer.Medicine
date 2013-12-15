package LiVEZer.Medicine.WebApp.Services.Methods;

import LiVEZer.Medicine.WebApp.DataProviders.UserProvider;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;

public class LogInMethod implements IServiceMethod
{
    @Override
    public JSONResponse Do(String data)
            throws Exception
    {
        JSONResponse res = (new UserProvider()).LogIn(data);
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
