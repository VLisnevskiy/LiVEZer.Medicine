package LiVEZer.Medicine.WebApp.DAO.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import LiVEZer.Medicine.WebApp.Globals.Tables.AP_USERS;

@Entity
@Table(name = AP_USERS.TableName, uniqueConstraints = {
        @UniqueConstraint(columnNames = AP_USERS.AP_USER_LOGIN),
        @UniqueConstraint(columnNames = AP_USERS.AP_USER_WEMAIL) })
public class User
{
    @Id
    @Column(name = AP_USERS.AP_USER_ID)
    @GeneratedValue
    private long id;

    @Column(name = AP_USERS.AP_USER_LOGIN)
    private String login;

    @Column(name = AP_USERS.AP_USER_PASSW)
    private String password;

    @Column(name = AP_USERS.AP_USER_PERSON)
    private Long personId;

    @Column(name = AP_USERS.AP_USER_ROLE)
    private long roleId;

    @Column(name = AP_USERS.AP_USER_ACTV)
    private boolean active;

    @Column(name = AP_USERS.AP_USER_WEMAIL)
    private String workEmail;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinColumn(name = AP_USERS.AP_USER_ROLE, insertable = false, updatable = false)
    private Role role;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = AP_USERS.AP_USER_PERSON, insertable = false, updatable = false)
    private Person person;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        if (login != null)
            this.login = login.toUpperCase();
        else this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        if (password != null)
            this.password = password.toUpperCase();
        else this.password = password;
    }

    public Long getPersonId()
    {
        return personId;
    }

    public void setPersonId(Long personId)
    {
        this.personId = personId;
    }

    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getWorkEmail()
    {
        return workEmail;
    }

    public void setWorkEmail(String workEmail)
    {
        this.workEmail = workEmail;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
