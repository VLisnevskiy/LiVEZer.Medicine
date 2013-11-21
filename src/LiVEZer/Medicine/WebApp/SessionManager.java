package LiVEZer.Medicine.WebApp;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import LiVEZer.Medicine.WebApp.DAO.Models.User;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.Common.WebUserSession;

public class SessionManager
{
    private static final Logger logger = Logger.getLogger(SessionManager.class);

    private static SessionManager instance;

    private SessionManager()
    {
        initializeSessions();
    }

    public static SessionManager GetInstance()
    {
        synchronized (SessionManager.class)
        {
            return (instance != null) ? instance : (instance = new SessionManager());
        }
    }

    public static void InitializeSessions()
    {
        GetInstance();
    }

    private HashMap<String, WebUserSession> sessions;

    private void initializeSessions()
    {
        logger.info("SessionManager.initializeSessions()");

        if (sessions == null)
            sessions = new HashMap<String, WebUserSession>();

        logger.info("SessionManager.initializeSessions() - Initialized");
    }

    private String generateSessionId(HttpServletRequest request, User user)
    {
        String key = request.getSession().getId() + "/" + user.getLogin() + "/"
                + Calendar.getInstance().getTime().toString();
        key = convertBytesToString(DigestUtils.md5(key));
        return key;
    }

    private String generateSecurityKey(String sessionId, User user)
    {
        String key = sessionId + "/" + user.getLogin() + "/" + user.getPassword() + "/"
                + Calendar.getInstance().getTime().toString();
        key = convertBytesToString(DigestUtils.md5(key));
        return key;
    }

    private String convertBytesToString(byte[] bytes)
    {
        String sRes = "";
        for (byte b : bytes)
        {
            sRes += String.format("%02X", b);
        }

        return sRes;
    }

    public WebUserSession CreateSession(HttpServletRequest request, User user)
    {
        String sessionId = generateSessionId(request, user);
        WebUserSession session = new WebUserSession();
        session.setSessionId(sessionId);
        session.setRoleId(user.getRole().getRoleId());
        session.setRoleDescription(user.getRole().getDescription());
        session.setSecurityKey(generateSecurityKey(sessionId, user));
        session.setStatus(Globals.Session.Opened);
        session.setUserId(user.getId());
        session.setUserName(user.getLogin());
        session.setUserFirstName(user.getPerson().getFirstName());
        session.setUserLastName(user.getPerson().getLastName());
        session.setUserMiddleName(user.getPerson().getMiddleName());
        session.setSuccess(true);

        this.sessions.put(session.getSessionId(), session);

        return session;
    }

    public WebUserSession GetSession(String sessionId)
    {
        WebUserSession session = null;
        if (this.sessions.containsKey(sessionId))
        {
            session = this.sessions.get(sessionId);
        }

        return session;
    }
}
