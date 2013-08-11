package LiVEZer.Medicine.WebApp.DAO.Models;

public class Item
{
    private long id;
    
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
