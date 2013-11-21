package LiVEZer.Medicine.WebApp.DAO.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AP_ITEMS")
public class Item
{
    @Id
    @Column(name = "AP_ITEMS_ID")
    @GeneratedValue
    private long id;
    
    @Column(name = "AP_ITEMS_NAME")
    private String name;
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return String.format("[id=%d; name=%s]", id, name);
    }
}
