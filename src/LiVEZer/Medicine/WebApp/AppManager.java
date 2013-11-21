package LiVEZer.Medicine.WebApp;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import LiVEZer.Medicine.WebApp.Services.ServiceManager;

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
    }

    private ServletContext context;
    private static final Logger logger = LogManager.getLogger(AppManager.class);

    public ServletContext getContext()
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context isn't set");
        }
        return context;
    }

    /**
     * @param context
     */
    public void setContext(ServletContext context)
    {
        this.context = context;
    }

    /**
     * Configure Application
     */
    public void Configure(boolean async)
    {
        configureLog4j();
        if (async)
        {
            Runnable run = new Runnable()
            {
                @Override
                public void run()
                {
                    configure();
                }
            };
            new Thread(run).start();
        }
        else
        {
            configure();
        }
    }

    private void configure()
    {
        synchronized (instance)
        {
            try
            {
                ServiceManager.Initialize();
                DBManager.RefreshConnection();
                SessionManager.InitializeSessions();
            }
            catch (Exception e)
            {
                logger.error("Can't Configure Application", e);
            }
        }
    }

    private void configureLog4j()
    {
        String log4jFile = context.getRealPath("/")
                + context.getInitParameter("log4jConfiguration");
        DOMConfigurator.configure(log4jFile);
        logger.info("Configuration Loaded: " + log4jFile);
    }
}
