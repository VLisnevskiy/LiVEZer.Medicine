package LiVEZer.Medicine.WebApp.Services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import LiVEZer.Medicine.WebApp.Services.JSONRespons.ErrorResponse;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;
import LiVEZer.Medicine.WebApp.Services.Methods.GetMenuItems;
import LiVEZer.Medicine.WebApp.Services.Methods.IServiceMethod;
import LiVEZer.Medicine.WebApp.Services.Methods.SimpMet;

public final class ServiceManager
{
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

    public static GenericJSONResponse doWithResponse(String method, HttpServletRequest request,
            HttpServletResponse response) throws IOException
    {
        GenericJSONResponse jsonResponse;
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
                ErrorResponse error = new ErrorResponse();
                error.setSuccess(false);
                error.setCode(1);
                error.setMessage(String.format("Can't execute \"%s\" method", method));
                jsonResponse = error;
            }
        }
        else
        {
            ErrorResponse error = new ErrorResponse();
            error.setSuccess(false);
            error.setCode(0);
            error.setMessage(String.format("Method %s doesn't exist in system!",
                    method == null ? "\"null\"" : method));
            jsonResponse = error;
        }

        return jsonResponse;
    }

    public static void doWithoutResponse(String method, HttpServletRequest request,
            HttpServletResponse response) throws IOException
    {
        GenericJSONResponse jsonResponse;
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
                ErrorResponse error = new ErrorResponse();
                error.setCode(1);
                error.setMessage(String.format("Can't execute \"%s\" method", method));
                jsonResponse = error;
            }
        }
        else
        {
            ErrorResponse error = new ErrorResponse();
            error.setCode(0);
            error.setMessage(String.format("Method %s doesn't exist in system!",
                    method == null ? "\"null\"" : method));
            jsonResponse = error;
        }

        Write(response, jsonResponse);
    }

    private static void Write(HttpServletResponse response, GenericJSONResponse json)
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
        methodMap.put("getMenuItems", GetMenuItems.class);
    }
}
