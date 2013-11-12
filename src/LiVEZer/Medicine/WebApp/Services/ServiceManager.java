package LiVEZer.Medicine.WebApp.Services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.Methods.*;

public final class ServiceManager
{
    private static final Logger logger = Logger.getLogger(ServiceManager.class);

    private static ServiceManager instance;

    private Map<String, Class<?>> methodMap;

    private ServiceManager()
    {
        InitializeMethodsMap();
    }

    private final static ServiceManager GetInstance()
    {
        if (instance == null)
        {
            synchronized (ServiceManager.class)
            {
                instance = new ServiceManager();
            }
        }
        return instance;
    }

    /**
     * Execute Service Method.
     * 
     * @param method
     *            - Name of Service method.
     * 
     * @param request
     *            - Service request.
     * 
     * @param response
     *            - Service response.
     * 
     * @return Return Service JSON Response.
     **/
    public static JSONResponse doWithResponse(String method, HttpServletRequest request,
            HttpServletResponse response)
    {
        JSONResponse jsonResponse;
        if (StringUtils.isNotBlank(method) && GetInstance().methodMap.containsKey(method))
        {
            try
            {
                IServiceMethod imetod = (IServiceMethod) GetInstance().methodMap.get(method)
                        .newInstance();
                jsonResponse = imetod.doMethod(request, response);
            }
            catch (Exception ex)
            {
                Error error = new Error();
                error.setSuccess(false);
                error.setCode(1);
                error.setMessage(String.format("Can't execute \"%s\" method", method));
                jsonResponse = error;
                logger.error(String.format("Can't execute \"%s\" method", method), ex);
            }
        }
        else
        {
            Error error = new Error();
            error.setSuccess(false);
            error.setCode(0);
            error.setMessage(String.format("Method %s doesn't exist in system!",
                    method == null ? "\"null\"" : method));
            jsonResponse = error;
        }

        return jsonResponse;
    }

    /**
     * Execute Service Method.
     * 
     * @param method
     *            - Name of Service method.
     * 
     * @param request
     *            - Service request.
     * 
     * @param response
     *            - Service response.
     **/
    public static void doWithoutResponse(String method, HttpServletRequest request,
            HttpServletResponse response) throws IOException
    {
        JSONResponse jsonResponse = doWithResponse(method, request, response);
        Write(response, jsonResponse);
    }

    private static void Write(HttpServletResponse response, JSONResponse json)
            throws IOException
    {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());
    }

    private void InitializeMethodsMap()
    {
        methodMap = new HashMap<String, Class<?>>();
        methodMap.put("getItems", SimpMet.class);
        methodMap.put("getMainMenu", GetMainMenuMethod.class);
        methodMap.put("logIn", LogInMethod.class);
    }
}
