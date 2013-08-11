package LiVEZer.Medicine.WebApp.Controllers;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class Gizmo implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -5780153506335045227L;

    private Long id;
    private String description;

    public Gizmo()
    {
    }

    public Gizmo(Long id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
