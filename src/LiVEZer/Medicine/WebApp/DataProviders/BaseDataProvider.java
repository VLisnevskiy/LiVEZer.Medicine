package LiVEZer.Medicine.WebApp.DataProviders;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import LiVEZer.Medicine.WebApp.Globals;

public abstract class BaseDataProvider
{
    protected boolean autoCloseSession;

    protected HashMap<String, String> prepareLogInParam(Map<String, String[]> parameters)
    {
        HashMap<String, String> params = new HashMap<String, String>();

        for (Entry<String, String[]> p : parameters.entrySet())
        {
            if (!p.getKey().equals(Globals.Method))
            {
                params.put(p.getKey(), p.getValue()[0]);
            }
        }

        return params;
    }
    
    protected BaseDataProvider()
    {
        this.autoCloseSession = true;
    }

    public void setAutoCloseSession(boolean autoCloseSession)
    {
        this.autoCloseSession = autoCloseSession;
    }

    public abstract void CloseSession();
}
