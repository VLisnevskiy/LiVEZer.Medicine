package LiVEZer.Medicine.WebApp.Controllers.Ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import LiVEZer.Medicine.WebApp.Models.Stock;


@Controller
public class StockController {

    public static List<Stock> contacts = new ArrayList<>();
    
    @RequestMapping(value="/stock/view.action")
    public @ResponseBody Map<String,? extends Object> view() throws Exception {

        try{
            Stock st = new Stock();
            st.setChange(12);
            st.setCompany("Illis");
            st.setLastChange(new Date());
            st.setPctChange(152);
            st.setPrice(5555);
            contacts.add(st);

            return getMap(contacts);

        } catch (Exception e) {

            return getModelMapError("Error retrieving Contacts from database.");
        }
    }

    @RequestMapping(value="/stock/create.action")
    public @ResponseBody Map<String,? extends Object> create(@RequestParam Object data) throws Exception {

        try{

            contacts.add((Stock)data);

            return getMap(contacts);

        } catch (Exception e) {

            return getModelMapError("Error trying to create contact.");
        }
    }

    @RequestMapping(value="/stock/update.action")
    public @ResponseBody Map<String,? extends Object> update(@RequestParam Object data) throws Exception {
        /*try{

            List<Stock> contacts = contactService.update(data);

            return getMap(contacts);

        } catch (Exception e) {

            return getModelMapError("Error trying to update contact.");
        }*/ return null;
    }

    @RequestMapping(value="/stock/delete.action")
    public @ResponseBody Map<String,? extends Object> delete(@RequestParam Object data) throws Exception {

        /*try{

            contactService.delete(data);

            Map<String,Object> modelMap = new HashMap<String,Object>(3);
            modelMap.put("success", true);

            return modelMap;

        } catch (Exception e) {

            return getModelMapError("Error trying to delete contact.");
        }*/return null;
    }

    private Map<String,Object> getMap(List<Stock> contacts){

        Map<String,Object> modelMap = new HashMap<String,Object>(3);
        modelMap.put("total", contacts.size());
        modelMap.put("data", contacts);
        modelMap.put("success", true);

        return modelMap;
    }

    private Map<String,Object> getModelMapError(String msg){

        Map<String,Object> modelMap = new HashMap<String,Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap;
    }

}