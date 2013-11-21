package LiVEZer.Medicine.WebApp.DAO.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AP_USER_SESSIONS")
public class UserSession
{
    @Id
    @Column(name = "AP_SESSION_ID")
    @GeneratedValue
    private long id;

    @Column(name = "AP_SESSION_USER_ID")
    private long userId;

    @Column(name = "AP_SESSION_SESS_ID", unique = true)
    private String sessionId;

    @Column(name = "AP_SESSION_STATUS")
    private String status;

    @Column(name = "AP_SESSION_SEC_KEY", unique = true)
    private String securityKey;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getSecurityKey()
    {
        return securityKey;
    }

    public void setSecurityKey(String securityKey)
    {
        this.securityKey = securityKey;
    }
}
