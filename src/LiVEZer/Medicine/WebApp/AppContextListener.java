package LiVEZer.Medicine.WebApp;

import javax.servlet.ServletContextEvent;

public class AppContextListener extends org.springframework.web.context.ContextLoaderListener
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
        AppManager.GetInstance().Configure();
        super.contextInitialized(event);
    }
}
