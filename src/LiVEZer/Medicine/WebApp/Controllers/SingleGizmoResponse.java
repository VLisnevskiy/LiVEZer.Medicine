package LiVEZer.Medicine.WebApp.Controllers;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SingleGizmoResponse implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6634818042917485496L;

    private boolean success;
    private Gizmo gizmo;

    public SingleGizmoResponse(boolean success, Gizmo gizmo)
    {
        this.success = success;
        this.gizmo = gizmo;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public Gizmo getGizmo()
    {
        return gizmo;
    }
}
