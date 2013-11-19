package LiVEZer.Medicine.WebApp;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public final class AppManager
{
    private static AppManager instance;

    public static AppManager GetInstance()
    {
        if (instance == null)
        {
            synchronized (AppManager.class)
            {
                instance = new AppManager();
            }
        }
        return instance;
    }

    private AppManager()
    {
        configured = false;
    }

    private ServletContext context;
    private boolean configured;
    private Logger logger = LogManager.getLogger(AppManager.class);

    public ServletContext getContext()
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context isn't set");
        }
        return context;
    }

    public void setContext(ServletContext context)
    {
        this.context = context;
    }

    public boolean Configure()
    {
        if (!configured && context != null)
        {
            try
            {
                configured &= configureLog4j();
            }
            catch (Exception e)
            {
                configured = false;
            }
        }
        return configured;
    }
    
    private boolean configureLog4j()
    {
        String log4jFile = context.getRealPath("/")
                + context.getInitParameter("log4jConfiguration");
        DOMConfigurator.configure(log4jFile);
        logger.info("Configuration Loaded: " + log4jFile);
        return true;
    }
}
