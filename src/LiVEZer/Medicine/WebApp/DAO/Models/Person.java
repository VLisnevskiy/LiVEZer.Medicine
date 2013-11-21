package LiVEZer.Medicine.WebApp.DAO.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AP_PERSONS")
public class Person
{
    @Id
    @Column(name = "AP_PERSON_ID")
    @GeneratedValue
    private long id;
    
    @Column(name = "AP_PERSON_L_NAME")
    private String lastName;
    
    @Column(name = "AP_PERSON_F_NAME")
    private String firstName;
    
    @Column(name = "AP_PERSON_M_NAME")
    private String middleName;
    
    @Column(name = "AP_PERSON_INFORM", columnDefinition = "VARCHAR(MAX)")
    private String information;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getInformation()
    {
        return information;
    }

    public void setInformation(String information)
    {
        this.information = information;
    }
}
