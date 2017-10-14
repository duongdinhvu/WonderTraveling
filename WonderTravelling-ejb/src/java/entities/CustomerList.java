/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vahu
 */
@Entity
@Table(name = "CustomerList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerList.findAll", query = "SELECT c FROM CustomerList c"),
    @NamedQuery(name = "CustomerList.findByCusID", query = "SELECT c FROM CustomerList c WHERE c.cusID = :cusID"),
    @NamedQuery(name = "CustomerList.findByFullName", query = "SELECT c FROM CustomerList c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "CustomerList.findBySex", query = "SELECT c FROM CustomerList c WHERE c.sex = :sex"),
    @NamedQuery(name = "CustomerList.findByDateOfBirth", query = "SELECT c FROM CustomerList c WHERE c.dateOfBirth = :dateOfBirth")})
public class CustomerList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CusID")
    private Integer cusID;
    @Size(max = 50)
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Sex")
    private Boolean sex;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @JoinColumn(name = "TourBookedID", referencedColumnName = "TourBookedID")
    @ManyToOne
    private TourBooked tourBookedID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne
    private CustomerUser customerID;

    public CustomerList() {
    }

    public CustomerList(Integer cusID) {
        this.cusID = cusID;
    }

    public CustomerList(String fullName, Boolean sex, Date dateOfBirth, TourBooked tourBookedID, CustomerUser customerID) {
        this.fullName = fullName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.tourBookedID = tourBookedID;
        this.customerID = customerID;
    }

    public Integer getCusID() {
        return cusID;
    }

    public void setCusID(Integer cusID) {
        this.cusID = cusID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public TourBooked getTourBookedID() {
        return tourBookedID;
    }

    public void setTourBookedID(TourBooked tourBookedID) {
        this.tourBookedID = tourBookedID;
    }

    public CustomerUser getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerUser customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusID != null ? cusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerList)) {
            return false;
        }
        CustomerList other = (CustomerList) object;
        if ((this.cusID == null && other.cusID != null) || (this.cusID != null && !this.cusID.equals(other.cusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerList[ cusID=" + cusID + " ]";
    }

}
