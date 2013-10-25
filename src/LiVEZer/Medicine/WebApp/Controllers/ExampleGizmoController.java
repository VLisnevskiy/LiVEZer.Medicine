package LiVEZer.Medicine.WebApp.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleGizmoController
{
    private static final Logger logger = Logger.getLogger(ExampleGizmoController.class);

    @RequestMapping(value = "/gizmos/{gizmoId}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public SingleGizmoResponse getFact(@PathVariable Long gizmoId) throws IOException
    {
        logger.info("gizmo");
        System.out.println("Gizmo retrieved.");
        return new SingleGizmoResponse(true, new Gizmo(1L, "HELLO"));
    }

    @RequestMapping(value = "/gizmos", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ManyGizmoResponse getFacts() throws IOException
    {
        logger.info("gizmo");
        System.out.println("Gizmo search.");
        List<Gizmo> gizmos = new ArrayList<Gizmo>();
        gizmos.add(new Gizmo(1L, "HELLO"));
        gizmos.add(new Gizmo(2L, "WORLD"));
        return new ManyGizmoResponse(true, gizmos);
    }

    @RequestMapping(value = "/gizmos",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public SingleGizmoResponse createGizmo(@RequestBody Gizmo gizmo) throws IOException
    {
        logger.info("gizmo");
        System.out.println("Gizmo created.");
        return new SingleGizmoResponse(true, new Gizmo(1L, "NEW GIZMO"));
    }

    @RequestMapping(value = "/gizmos/{gizmoId}",
            method = RequestMethod.PUT,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public SingleGizmoResponse updateGizmo(@PathVariable Long gizmoId, @RequestBody Gizmo gizmo)
            throws IOException
    {
        logger.info("gizmo");
        System.out.println("Gizmo updated.");
        return new SingleGizmoResponse(true, new Gizmo(1L, "UPDATED GIZMO"));
    }

    @RequestMapping(value = "/gizmos{gizmoId}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @ResponseBody
    public SingleGizmoResponse deleteGizmo(@PathVariable Long gizmoId) throws IOException
    {
        logger.info("gizmo");
        System.out.println("Gizmo deleted.");
        return new SingleGizmoResponse(true, new Gizmo(gizmoId, null));
    }
}
