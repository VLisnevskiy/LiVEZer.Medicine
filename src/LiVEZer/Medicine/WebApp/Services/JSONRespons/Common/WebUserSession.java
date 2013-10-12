package LiVEZer.Medicine.WebApp.Services.JSONRespons.Common;

import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;

public class WebUserSession extends GenericJSONResponse
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String sessionId;
    private long userId;
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userMiddleName;
    private long roleId;
    private String roleName;
    private String securityKey;
    private String status;

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserFirstName()
    {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName()
    {
        return userLastName;
    }

    public void setUserLastName(String userLastName)
    {
        this.userLastName = userLastName;
    }

    public String getUserMiddleName()
    {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName)
    {
        this.userMiddleName = userMiddleName;
    }

    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getSecurityKey()
    {
        return securityKey;
    }

    public void setSecurityKey(String securityKey)
    {
        this.securityKey = securityKey;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
