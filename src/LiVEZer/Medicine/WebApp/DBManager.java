package LiVEZer.Medicine.WebApp;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

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

    private static Configuration addAnnotatedClasses(Configuration config) throws Exception
    {
        logger.info("DBManager.addAnnotatedClasses()");

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        // the following will detect all classes that are annotated as @Entity
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(
                (Class<? extends Annotation>) Entity.class));
        // only register classes within "LiVEZer.Medicine.WebApp.DAO.Models"
        // package
        for (BeanDefinition bd : scanner
                .findCandidateComponents("LiVEZer.Medicine.WebApp.DAO.Models"))
        {
            String name = bd.getBeanClassName();
            try
            {
                classes.add(Class.forName(name));
            }
            catch (Exception e)
            {
                logger.error("Can't add Entities", e);
                throw new Exception("Can't add Entities", e);
            }
        }

        // register detected classes with AnnotationSessionFactoryBean
        for (Class<?> c : classes)
        {
            config.addAnnotatedClass(c);

            logger.debug(String.format("Entity {\"%s\"} added", c.getName()));
        }
        return config;
    }

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
            SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(
                    addAnnotatedClasses(config).getProperties())
                    .buildServiceRegistry();
            SESSION_FACTORY = config.buildSessionFactory(SERVICE_REGISTRY);

            logger.info("DBManager.buildSessionFactory() - Session Factory Created");

            return SESSION_FACTORY;
        }
        catch (Exception e)
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
        synchronized (DBManager.class)
        {
            return (SESSION_FACTORY != null) ? SESSION_FACTORY
                    : (SESSION_FACTORY = buildSessionFactory());
        }
    }

    /**
     * Method for Refresh Hibernate Connection
     * 
     **/
    public static void RefreshSessionFactory()
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
            logger.error("Error when close session", e);
        }

        logger.info("Session closed!");
        return closed;
    }

}