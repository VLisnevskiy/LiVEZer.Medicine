package LiVEZer.Medicine.WebApp.Services.JSONRespons.Users;

import java.util.List;

import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;

public class Item extends GenericJSONResponse
{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private List<String> items;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getItems()
    {
        return items;
    }

    public void setItems(List<String> items)
    {
        this.items = items;
    }
}
