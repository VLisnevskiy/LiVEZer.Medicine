package LiVEZer.Medicine.WebApp.DAO;

import java.io.Serializable;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import LiVEZer.Medicine.WebApp.DBManager;

/**
 * Class that implement interface ICRUD
 * 
 * @param <T>
 *            - Type of entity
 * @param <pK>
 *            - Type of primary key (type of id)
 */
public class CRUD<T, pK extends Serializable> implements ICRUD<T, pK>
{
    private Class<T> type;
    private Session session;
    private int first = 1;
    private int max = 10;

    public CRUD(Class<T> type)
    {
        this.type = type;
        this.session = DBManager.getSessionFactory().openSession();
    }

    public CRUD(Class<T> type, int first, int max)
    {
        this(type);
        this.first = first;
        this.max = max;
    }

    public boolean Save(T row) throws SQLDataException
    {
        boolean result = false;
        try
        {
            // session = DBManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(row);
            session.getTransaction().commit();
            result = true;
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }

        return result;
    }

    public boolean Delete(T row) throws SQLDataException
    {
        boolean result = false;
        try
        {
            // session = DBManager.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(row);
            session.getTransaction().commit();
            result = true;
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public T Read(pK id) throws SQLDataException
    {
        T row;
        try
        {
            // session = DBManager.getSessionFactory().openSession();
            row = (T) session.get(this.type, id);
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }

        return row;
    }

    public List<T> Read() throws SQLDataException
    {
        return Read((Criterion) null);
    }

    public List<T> Read(Criterion criterion) throws SQLDataException
    {
        return Read(criterion, (Order) null, this.first, this.max);
    }

    public List<T> Read(Criterion criterion, Order order) throws SQLDataException
    {
        return Read(criterion, order, this.first, this.max);
    }

    public List<T> Read(Order order, int first, int max) throws SQLDataException
    {
        return Read((Criterion)null, order, this.first, this.max);
    }

    @SuppressWarnings("unchecked")
    public List<T> Read(Criterion criterion, Order order, int first, int max) throws SQLDataException
    {
        List<T> rows = new ArrayList<T>();
        try
        {
            // session = DBManager.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(this.type);
            if (criterion != null)
            {
                criteria.add(criterion);
            }
            if (order != null)
            {
                criteria.addOrder(order);
                if (max != 0)
                {
                    criteria.setFirstResult(first);
                    criteria.setMaxResults(max);
                }
            }

            rows = criteria.list();
        }
        catch (Throwable e)
        {
            throw new SQLDataException(e);
        }

        return rows;
    }

    public void setFirst(int first)
    {
        this.first = first;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public Session getSession()
    {
        return session;
    }

    public void setSession(Session session)
    {
        if (this.session.isOpen())
        {
            DBManager.CloseSession(this.session);
        }

        this.session = session;
    }

    public void Refresh()
    {
        if (this.session.isOpen())
        {
            DBManager.CloseSession(this.session);
        }

        this.session = DBManager.getSessionFactory().openSession();
    }

    public void Close()
    {
        if (this.session.isOpen())
        {
            DBManager.CloseSession(this.session);
        }
    }

    public boolean isOpen()
    {
        return this.session.isOpen();
    }
}
