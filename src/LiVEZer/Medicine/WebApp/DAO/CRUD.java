package LiVEZer.Medicine.WebApp.DAO;

import java.io.Serializable;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import LiVEZer.Medicine.WebApp.DBManager;

/**
 * Class that implement interface ICRUD
 * 
 * @param <T>
 *            - Type of entity
 * @param <pK>
 *            - Type of primary key (type of id)
 */
public class CRUD<T, pK extends Serializable>
        implements ICRUD<T, pK>
{
    public boolean Save(T row) throws SQLDataException
    {
        boolean result = false;
        Session session = null;
        try
        {
            session = DBManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(row);
            session.getTransaction().commit();
            result = true;
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }
        finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }

        return result;
    }

    public boolean Delete(T row) throws SQLDataException
    {
        boolean result = false;
        Session session = null;
        try
        {
            session = DBManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(row);
            session.getTransaction().commit();
            result = true;
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }
        finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public T Read(Class<T> clas, pK id) throws SQLDataException
    {
        T row;
        Session session = null;
        try
        {
            session = DBManager.getSessionFactory().openSession();
            row = (T) session.get(clas, id);
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }
        finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }

        return row;
    }

    @SuppressWarnings("unchecked")
    public List<T> Read(Class<T> clas) throws SQLDataException
    {
        List<T> rows = new ArrayList<T>();
        Session session = null;
        try
        {
            session = DBManager.getSessionFactory().openSession();
            rows = session.createCriteria(clas).list();
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }
        finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }

        return rows;
    }
}
