package LiVEZer.Medicine.WebApp;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class AppContextListener extends ContextLoaderListener
{
    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        super.contextDestroyed(event);
    }

    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        AppManager.GetInstance().setContext(event.getServletContext());
        AppManager.GetInstance().Configure(true);
        super.contextInitialized(event);
    }
}
