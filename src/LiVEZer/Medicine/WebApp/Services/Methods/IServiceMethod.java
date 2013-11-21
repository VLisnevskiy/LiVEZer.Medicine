package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

/**
 * @author vlisnevskiy
 *
 */
public interface IServiceMethod
{
    /**
     * @param request
     * @param response
     * @return
     */
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * @return
     */
    public String getMethodName();
}
