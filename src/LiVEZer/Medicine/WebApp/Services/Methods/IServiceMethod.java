package LiVEZer.Medicine.WebApp.Services.Methods;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

/**
 * @author vlisnevskiy
 * 
 */
public interface IServiceMethod
{
    /**
     * @param data
     * 
     * @return
     */
    public JSONResponse Do(String data) throws Exception;

    /**
     * @return
     */
    public String getMethodName();
}
