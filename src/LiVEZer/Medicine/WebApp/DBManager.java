package LiVEZer.Medicine.WebApp;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class for create session factory
 * 
 * @author Vyacheslav Lisnevsyi
 **/
public final class DBManager
{
    private static final Logger logger = Logger.getLogger(DBManager.class);

    /**
     * Session Factory
     **/
    private static SessionFactory SESSION_FACTORY;

    /**
     * Service Registry
     **/
    private static ServiceRegistry SERVICE_REGISTRY;

    /**
     * Method for create session factory
     * 
     * @return SessionFactory
     **/
    private static SessionFactory buildSessionFactory()
    {
        logger.info("DBManager.buildSessionFactory()");

        try
        {
            Configuration config = new Configuration();
            config.configure("config/hibernate.cfg.xml");
            SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(config.getProperties())
                    .buildServiceRegistry();
            SESSION_FACTORY = config.buildSessionFactory(SERVICE_REGISTRY);

            logger.info("DBManager.buildSessionFactory() - Session Factory Created");

            return SESSION_FACTORY;
        }
        catch (Throwable e)
        {
            logger.error("Can't create session!!!", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Getter method for field SessionFactory
     * 
     * @return SessionFactory
     **/
    public static SessionFactory getSessionFactory()
    {
        logger.info("DBManager.getSessionFactory()");

        return (SESSION_FACTORY != null) ? SESSION_FACTORY
                : (SESSION_FACTORY = buildSessionFactory());
    }

    /**
     * Method for Refresh Hibernate Connection
     * 
     **/
    public static void RefreshConnection()
    {
        logger.info("DBManager.RefreshConnection() - Begin Invoke");

        if (SESSION_FACTORY != null)
        {
            if (!SESSION_FACTORY.isClosed())
            {
                SESSION_FACTORY.close();
            }
            SESSION_FACTORY = null;
        }

        getSessionFactory();

        logger.info("DBManager.RefreshConnection() - End Invoke");
    }

    /**
     * Method for close open session
     * 
     * @param session
     *            - Session to close.
     * 
     * @return Return true if session closed without any problems.
     **/
    public static boolean CloseSession(Session session)
    {
        boolean closed = false;
        try
        {
            session.close();
            closed = true;
        }
        catch (Exception e)
        {
            // TODO:
        }

        return closed;
    }

}