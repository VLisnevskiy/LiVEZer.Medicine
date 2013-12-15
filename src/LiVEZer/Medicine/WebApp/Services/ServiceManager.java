package LiVEZer.Medicine.WebApp.Services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

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

    public static void Initialize()
    {
        GetInstance();
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
    public static JSONResponse Do(String method, String data)
    {
        logger.info(String.format("Begin execute method {\"%s\"} data = {\"%s\"}", method, data));

        JSONResponse jsonResponse;
        if (StringUtils.isNotBlank(method) && GetInstance().methodMap.containsKey(method))
        {
            try
            {
                IServiceMethod imetod = (IServiceMethod) GetInstance().methodMap.get(method)
                        .newInstance();
                jsonResponse = imetod.Do(data);
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

        logger.debug("Response: " + jsonResponse.toString());
        return jsonResponse;
    }

    private void InitializeMethodsMap()
    {
        logger.info("ServiceManager.InitializeMethodsMap()");

        methodMap = new HashMap<String, Class<?>>();
        String packageName = "LiVEZer.Medicine.WebApp.Services.Methods";
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(IServiceMethod.class));
        for (BeanDefinition bd : scanner.findCandidateComponents(packageName))
        {
            String name = bd.getBeanClassName();
            try
            {
                IServiceMethod method = (IServiceMethod) Class.forName(name).newInstance();
                methodMap.put(method.getMethodName(), method.getClass());

                logger.debug(String.format("Method {\"%s\"} added", method.getMethodName()));
            }
            catch (Exception e)
            {
                logger.error("Can't add: " + name, e);
            }
        }
    }
}
