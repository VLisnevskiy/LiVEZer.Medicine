package LiVEZer.Medicine.WebApp;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AppMainListener
 * 
 */
@WebListener
public class AppMainListener implements ServletContextListener, ServletContextAttributeListener,
        ServletRequestListener, ServletRequestAttributeListener, HttpSessionBindingListener,
        HttpSessionActivationListener, HttpSessionAttributeListener, HttpSessionListener
{

    private final static Logger logger = Logger.getLogger(AppMainListener.class);

    /**
     * Default constructor.
     */
    public AppMainListener()
    {
        //logger.info("AppMainListener");
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent event)
    {
        //logger.info("attributeRemoved");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)
    {
        //logger.info("attributeReplaced");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)
    {
        //logger.info("requestInitialized");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)
    {
        //logger.info("contextDestroyed");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent event)
    {
        //logger.info("attributeReplaced");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent event)
    {
        //logger.info("attributeAdded");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent event)
    {
        //logger.info("sessionWillPassivate");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)
    {
        //logger.info("valueUnbound");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)
    {
        //logger.info("attributeRemoved");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)
    {
        //logger.info("sessionCreated");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)
    {
        //logger.info("attributeReplaced");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)
    {
        //logger.info("sessionDestroyed");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)
    {
        //logger.info("attributeRemoved");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)
    {
        //logger.info("attributeAdded");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent event)
    {
        //logger.info("sessionDidActivate");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)
    {
        AppManager.GetInstance().setContext(event.getServletContext());
        AppManager.GetInstance().Configure(true);
        
        logger.info("contextInitialized");
    }

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)
    {
        //logger.info("requestDestroyed");
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)
    {
        //logger.info("attributeAdded");
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)
    {
        //logger.info("valueBound");
        // TODO Auto-generated method stub
    }

}
