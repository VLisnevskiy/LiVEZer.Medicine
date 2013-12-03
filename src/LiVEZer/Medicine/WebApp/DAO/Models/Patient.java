package LiVEZer.Medicine.WebApp.DAO.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AP_PATIENTS")
public class Patient
{
    @Id
    @Column(name = "AP_PATIENT_ID")
    @GeneratedValue
    private long id;

    @Column(name = "AP_PATIENT_")
    private String firstName;

    @Column(name = "AP_PATIENT_LNAME")
    private String lastName;

    @Column(name = "AP_PATIENT_FNAME")
    private String middleName;

    @Column(name = "AP_PATIENT_MNAME")
    private Date birthDate;

    @Column(name = "AP_PATIENT_ADDR")
    private String address;

    @Column(name = "AP_PATIENT_PHONE")
    private String phone;

    @Column(name = "AP_PATIENT_PHONET")
    private String phoneType;

    @Column(name = "AP_PATIENT_WPHONE")
    private String phoneWork;

    @Column(name = "AP_PATIENT_WPHONET")
    private String phoneWorkType;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhoneType()
    {
        return phoneType;
    }

    public void setPhoneType(String phoneType)
    {
        this.phoneType = phoneType;
    }

    public String getPhoneWork()
    {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork)
    {
        this.phoneWork = phoneWork;
    }

    public String getPhoneWorkType()
    {
        return phoneWorkType;
    }

    public void setPhoneWorkType(String phoneWorkType)
    {
        this.phoneWorkType = phoneWorkType;
    }

}
