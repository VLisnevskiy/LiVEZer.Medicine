package LiVEZer.Medicine.WebApp.Controllers;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ManyGizmoResponse implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -6081226086550753110L;

    private boolean success;
    private List<Gizmo> gizmos;

    public ManyGizmoResponse(boolean success, List<Gizmo> gizmos)
    {
        this.success = success;
        this.gizmos = gizmos;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public List<Gizmo> getGizmos()
    {
        return gizmos;
    }
}
