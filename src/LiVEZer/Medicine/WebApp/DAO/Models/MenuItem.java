package LiVEZer.Medicine.WebApp.DAO.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AP_MENU_ITEMS", uniqueConstraints = 
        @UniqueConstraint(columnNames = "AP_MENU_ITEM_ACTI"))
public class MenuItem
{
    @Id
    @Column(name = "AP_MENU_ITEM_ID")
    @GeneratedValue
    private long id;
    
    @Column(name = "AP_MENU_ITEM_FILE")
    private String file;
    
    @Column(name = "AP_MENU_ITEM_ACTI")
    private String action;
    
    @Column(name = "AP_MENU_ITEM_TITL")
    private String title;

    public String getFile()
    {
        return file;
    }

    public void setFile(String file)
    {
        this.file = file;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
