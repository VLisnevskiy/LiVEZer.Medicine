package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import LiVEZer.Medicine.WebApp.Models.Stock;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Collection;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Error;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

@Controller
public class StockController extends BaseAjaxController
{

    public static List<Stock> contacts = new ArrayList<>();

    @RequestMapping(value = "/stock/view.action")
    @ResponseBody
    public JSONResponse view() throws Exception
    {

        try
        {
            Stock st = new Stock();
            st.setChange(12);
            st.setCompany("Illis");
            st.setLastChange(new Date());
            st.setPctChange(152);
            st.setPrice(5555);
            contacts.add(st);

            Collection response = new Collection();
            response.setData(contacts);
            response.setTotal(contacts.size());
            response.setSuccess(true);

            return response;

        }
        catch (Exception e)
        {
            Error response = new Error();
            response.setSuccess(false);
            response.setCode(2);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/stock/create.action")
    @ResponseBody
    public JSONResponse create(@RequestParam Object data) throws Exception
    {

        try
        {

            contacts.add((Stock) data);

            Collection response = new Collection();
            response.setData(contacts);
            response.setTotal(contacts.size());
            response.setSuccess(true);

            return response;

        }
        catch (Exception e)
        {

            Error response = new Error();
            response.setSuccess(false);
            response.setCode(2);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/stock/update.action")
    @ResponseBody
    public JSONResponse update(@RequestParam Object data) throws Exception
    {
        /*
         * try{
         * 
         * List<Stock> contacts = contactService.update(data);
         * 
         * return getMap(contacts);
         * 
         * } catch (Exception e) {
         * 
         * return getModelMapError("Error trying to update contact."); }
         */return null;
    }

    @RequestMapping(value = "/stock/delete.action")
    @ResponseBody
    public JSONResponse delete(@RequestParam Object data) throws Exception
    {

        /*
         * try{
         * 
         * contactService.delete(data);
         * 
         * Map<String,Object> modelMap = new HashMap<String,Object>(3);
         * modelMap.put("success", true);
         * 
         * return modelMap;
         * 
         * } catch (Exception e) {
         * 
         * return getModelMapError("Error trying to delete contact."); }
         */return null;
    }

}