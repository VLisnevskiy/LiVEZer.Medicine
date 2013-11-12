package LiVEZer.Medicine.WebApp.Services.JSONResponse.Common;

import java.util.List;

import LiVEZer.Medicine.WebApp.DAO.Models.MenuItem;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

public class MainMenu extends JSONResponse
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
