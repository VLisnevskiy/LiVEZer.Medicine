package LiVEZer.Medicine.WebApp.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name="COMPANYS")
public class Stock
{
    private String company;
    private float price;
    private float change;
    private float pctChange;
    private Date lastChange;

    @Id
    @Column(name="COMPANY")
    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    @Column(name="PRICE", nullable=false)
    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Column(name="CHANGE", nullable=false)
    public float getChange()
    {
        return change;
    }

    public void setChange(float change)
    {
        this.change = change;
    }

    @Column(name="PCT_CHANGE", nullable=false)
    public float getPctChange()
    {
        return pctChange;
    }

    public void setPctChange(float pctChange)
    {
        this.pctChange = pctChange;
    }

    @Column(name="LAST_CHANGE", nullable=false)
    public Date getLastChange()
    {
        return lastChange;
    }

    public void setLastChange(Date lastChange)
    {
        this.lastChange = lastChange;
    }
}