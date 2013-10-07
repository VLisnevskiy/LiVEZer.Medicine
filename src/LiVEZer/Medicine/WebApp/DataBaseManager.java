package LiVEZer.Medicine.WebApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class for create session factory
 * 
 * @author Vyacheslav Lisnevsyi
 */
public final class DataBaseManager
{
    /**
     * Session factory
     */
    private static SessionFactory SESSION_FACTORY;
    private static ServiceRegistry SERVICE_REGISTRY;

    /**
     * Method for create session factory
     * 
     * @return SessionFactory
     */
    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration config = new Configuration();
            config.configure("config/hibernate.cfg.xml");
            SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(config.getProperties())
                    .buildServiceRegistry();
            SESSION_FACTORY = config.buildSessionFactory(SERVICE_REGISTRY);
            return SESSION_FACTORY;
        }
        catch (Throwable e)
        {
            System.err.println("Can't create session!!!\nError: " + e);
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Getter method for field SessionFactory
     * 
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory()
    {
        return (SESSION_FACTORY != null) ? SESSION_FACTORY
                : (SESSION_FACTORY = buildSessionFactory());
    }

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