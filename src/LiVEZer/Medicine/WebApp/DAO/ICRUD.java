package LiVEZer.Medicine.WebApp.DAO;

import java.sql.SQLDataException;
import java.util.List;

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
     * @param clas
     *            - Type of entity, that will be read
     * @param id
     *            - The id of records, that will be read from database
     * @return Return a row from of some table
     * @throws SQLDataException
     */
    public T Read(Class<T> clas, pK id) throws SQLDataException;

    /**
     * Method that read some rows from database
     * 
     * @param clas
     *            - Type of entity, that will be read
     * @return Return a rows from some tables
     * @throws SQLDataException
     */
    public List<T> Read(Class<T> clas) throws SQLDataException;
}
