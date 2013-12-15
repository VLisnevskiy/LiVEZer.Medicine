package LiVEZer.Medicine.WebApp.Services.Methods;

import java.util.ArrayList;
import java.util.List;

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
    public JSONResponse Do(String data)
    {
        MainMenu items = new MainMenu();
        List<MenuItem> itemsList = new ArrayList<MenuItem>();
        MenuItem item = new MenuItem();
        item.setAction("openUsersApp()");
        item.setFile("img/Users.png");
        item.setItemId(GenereteMenuId(1));
        item.setSelected(false);
        item.setTitle("Користувачі");
        itemsList.add(item);

        item = new MenuItem();
        item.setAction("openPatientsApp()");
        item.setFile("img/Patient.png");
        item.setItemId(GenereteMenuId(2));
        item.setSelected(false);
        item.setTitle("Пацієнти");
        itemsList.add(item);

        item = new MenuItem();
        item.setAction("openVisitsApp()");
        item.setFile("img/visit.png");
        item.setItemId(GenereteMenuId(3));
        item.setSelected(false);
        item.setTitle("Візити");
        itemsList.add(item);

        item = new MenuItem();
        item.setAction("openOrdersApp()");
        item.setFile("img/Order.png");
        item.setItemId(GenereteMenuId(4));
        item.setSelected(false);
        item.setTitle("Скерування");
        itemsList.add(item);

        item = new MenuItem();
        item.setAction("openCalendarApp()");
        item.setFile("img/Calendar.png");
        item.setItemId(GenereteMenuId(5));
        item.setSelected(false);
        item.setTitle("Календар");
        itemsList.add(item);

        item = new MenuItem();
        item.setAction("openSettingsApp()");
        item.setFile("img/Settings.png");
        item.setItemId(GenereteMenuId(6));
        item.setSelected(false);
        item.setTitle("Налаштування");
        itemsList.add(item);

        items.setSuccess(true);
        items.setItems(itemsList);
        return items;
    }

    @Override
    public String getMethodName()
    {
        return "getMainMenu";
    }
}
