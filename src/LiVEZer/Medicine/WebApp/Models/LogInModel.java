package LiVEZer.Medicine.WebApp.Models;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import LiVEZer.Medicine.WebApp.DBTools;
import LiVEZer.Medicine.WebApp.Globals.Tables.AP_USERS;

public class LogInModel
{
    private String login;
    private String passw;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassw()
    {
        return passw;
    }

    public void setPassw(String passw)
    {
        this.passw = passw;
    }

    public Criterion getSearchCriteria()
    {
        Criterion cr = Restrictions.sqlRestriction(
                String.format("%s = %s AND %s = %s",
                        AP_USERS.AP_USER_LOGIN, DBTools.EscapeSQL(login.toUpperCase()),
                        AP_USERS.AP_USER_PASSW, DBTools.EscapeSQL(passw.toUpperCase())));
        return cr;
    }
}
