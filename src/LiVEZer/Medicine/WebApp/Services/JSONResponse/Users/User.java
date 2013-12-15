package LiVEZer.Medicine.WebApp.Services.JSONResponse.Users;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class User
{
    private int id;
    private String name;
    private String role;
    private String email;
    private boolean active;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

}
