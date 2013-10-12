package LiVEZer.Medicine.WebApp.Services.JSONRespons.Common;

import java.util.List;

import LiVEZer.Medicine.WebApp.DAO.Models.MenuItem;
import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;

public class MainMenu extends GenericJSONResponse
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<MenuItem> items;

    public List<MenuItem> getItems()
    {
        return items;
    }

    public void setItems(List<MenuItem> items)
    {
        this.items = items;
    }
}
