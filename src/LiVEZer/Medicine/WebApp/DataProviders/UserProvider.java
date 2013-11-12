package LiVEZer.Medicine.WebApp.DataProviders;

import java.util.HashMap;
import java.util.Map;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.Common.WebUserSession;


public class UserProvider
{
    public WebUserSession LogIn(Map<String, String[]> parameters)
    {
        HashMap<String, String> params = prepareLogInParam(parameters);
        
        WebUserSession session = new WebUserSession();
        
        params.clear();
        session.setSuccess(true);
        return session;
    }
    
    private HashMap<String, String> prepareLogInParam(Map<String, String[]> parameters)
    {
        HashMap<String, String> params = new HashMap<String, String>();
        
        return params;
    }
}
