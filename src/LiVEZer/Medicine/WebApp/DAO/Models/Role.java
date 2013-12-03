package LiVEZer.Medicine.WebApp.DAO.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AP_ROLES")
public class Role
{
    @Id
    @Column(name = "AP_ROLE_ID")
    @GeneratedValue
    private long id;

    @Column(name = "AP_ROLE_ROL_ID", unique = true)
    private String roleId;

    @Column(name = "AP_ROLE_SEC_OPT", columnDefinition = "VARCHAR(MAX)")
    private String secOptions;

    @Column(name = "AP_ROLE_DESCR")
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,
            targetEntity = MenuItem.class)
    @JoinTable(name = "AP_MENU_ITEMS_LINK",
            joinColumns = { @JoinColumn(name = "AP_ROLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "AS_MENU_ITEM_ID") })
    private Set<MenuItem> menuItems;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public String getSecOptions()
    {
        return secOptions;
    }

    public void setSecOptions(String secOptions)
    {
        this.secOptions = secOptions;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Set<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }
}
