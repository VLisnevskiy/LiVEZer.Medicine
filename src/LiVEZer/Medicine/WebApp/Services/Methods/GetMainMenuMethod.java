package LiVEZer.Medicine.WebApp.Services.Methods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.Globals;
import LiVEZer.Medicine.WebApp.Models.MenuItem;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Common.MainMenu;

public class GetMainMenuMethod implements IServiceMethod
{
    private String GenereteMenuId(long id)
    {
        return String.format("%s%03d", Globals.MenuId, id);
    }

    @Override
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response)
    {
        MainMenu items = new MainMenu();
        List<MenuItem> itemsList = new ArrayList<MenuItem>();
        MenuItem item = new MenuItem();
        item.setAction("showSom()");
        item.setFile("img/icon-idisk.png");
        item.setItemId(GenereteMenuId(2));
        item.setSelected(false);
        item.setTitle("Disk");
        itemsList.add(item);
        
        item = new MenuItem();
        item.setAction("openUserInformation()");
        item.setFile("img/icon-ical.png");
        item.setItemId(GenereteMenuId(3));
        item.setSelected(false);
        item.setTitle("Calendar");
        itemsList.add(item);
        
        items.setSuccess(true);
        items.setItems(itemsList);
        return items;
    }

}
