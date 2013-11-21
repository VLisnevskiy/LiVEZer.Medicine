package LiVEZer.Medicine.WebApp.DAO;

import java.sql.SQLDataException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Generic interface for realization main DAO function
 * 
 * @param <T>
 *            - Type of entity
 * @param <pK>
 *            - Type of primary key (type of id)
 */
public interface ICRUD<T, pK>
{
    /**
     * Method that save some row to database
     * 
     * @param row
     *            - Some row of class <T> that will be save to database
     * @return Return true if save succeeded
     * @throws SQLDataException
     */
    public boolean Save(T row) throws SQLDataException;

    /**
     * Method that delete some row from database
     * 
     * @param row
     *            - Some row of class <T> that will be delete from database
     * @return Return true if delete succeeded
     * @throws SQLDataException
     */
    public boolean Delete(T row) throws SQLDataException;

    /**
     * Method that read one row from database
     * 
     * @param id
     *            - The id of records, that will be read from database
     * @return Return a row from of some table
     * @throws SQLDataException
     */
    public T Read(pK id) throws SQLDataException;

    /**
     * Method that read some rows from database
     * 
     * @return Return a rows from some tables
     * @throws SQLDataException
     */
    public List<T> Read() throws SQLDataException;

    /**
     * Method that read rows according criteria from database
     * 
     * @param criterion
     *            - Criteria for search
     * @return Return a rows from some tables
     * @throws SQLDataException
     */
    public List<T> Read(Criterion criterion) throws SQLDataException;

    /**
     * @param criterion
     * @param order
     * @return
     * @throws SQLDataException
     */
    public List<T> Read(Criterion criterion, Order order) throws SQLDataException;

    /**
     * @param criterion
     * @param order
     * @param first
     * @param max
     * @return
     * @throws SQLDataException
     */
    public List<T> Read(Criterion criterion, Order order, int first, int max)
            throws SQLDataException;

    /**
     * @param first
     */
    public void setFirst(int first);

    /**
     * @param max
     */
    public void setMax(int max);

    public Session getSession();

    public void setSession(Session session);

    public void Refresh();

    public void Close();

    public boolean isOpen();
}
