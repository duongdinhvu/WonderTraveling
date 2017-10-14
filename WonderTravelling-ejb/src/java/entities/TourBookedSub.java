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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dieut
 */
@Entity
@Table(name = "TourBookedSub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourBookedSub.findAll", query = "SELECT t FROM TourBookedSub t"),
    @NamedQuery(name = "TourBookedSub.findByTourBookedSubID", query = "SELECT t FROM TourBookedSub t WHERE t.tourBookedSubID = :tourBookedSubID"),
    @NamedQuery(name = "TourBookedSub.findByDepartureDate", query = "SELECT t FROM TourBookedSub t WHERE t.departureDate = :departureDate"),
    @NamedQuery(name = "TourBookedSub.findByNumberOfAdult", query = "SELECT t FROM TourBookedSub t WHERE t.numberOfAdult = :numberOfAdult"),
    @NamedQuery(name = "TourBookedSub.findByNumberOfKid", query = "SELECT t FROM TourBookedSub t WHERE t.numberOfKid = :numberOfKid"),
    @NamedQuery(name = "TourBookedSub.findByNumberOfBaby", query = "SELECT t FROM TourBookedSub t WHERE t.numberOfBaby = :numberOfBaby"),
    @NamedQuery(name = "TourBookedSub.findByNumberOfPeople", query = "SELECT t FROM TourBookedSub t WHERE t.numberOfPeople = :numberOfPeople"),
    @NamedQuery(name = "TourBookedSub.findByIndividualRoom", query = "SELECT t FROM TourBookedSub t WHERE t.individualRoom = :individualRoom"),
    @NamedQuery(name = "TourBookedSub.findByTransportation", query = "SELECT t FROM TourBookedSub t WHERE t.transportation = :transportation"),
    @NamedQuery(name = "TourBookedSub.findByStatus", query = "SELECT t FROM TourBookedSub t WHERE t.status = :status"),
    @NamedQuery(name = "TourBookedSub.findByCreatedDate", query = "SELECT t FROM TourBookedSub t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TourBookedSub.findByIsNew", query = "SELECT t FROM TourBookedSub t WHERE t.isNew = :isNew")})
public class TourBookedSub implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "TourBookedSubID")
    private Integer tourBookedSubID;
    @Column(name = "DepartureDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Column(name = "NumberOfAdult")
    private Short numberOfAdult;
    @Column(name = "NumberOfKid")
    private Short numberOfKid;
    @Column(name = "NumberOfBaby")
    private Short numberOfBaby;
    @Column(name = "NumberOfPeople")
    private Short numberOfPeople;
    @Column(name = "IndividualRoom")
    private Short individualRoom;
    @Column(name = "Transportation")
    private Short transportation;
    @Column(name = "Status")
    private Short status;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "IsNew")
    private Boolean isNew;
    @JoinColumn(name = "TourID", referencedColumnName = "TourID")
    @ManyToOne
    private Tours tourID;
    @JoinColumn(name = "TourBookedID", referencedColumnName = "TourBookedID")
    @ManyToOne
    private TourBooked tourBookedID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne
    private CustomerUser customerID;

    public TourBookedSub() {
    }

    public TourBookedSub(Date departureDate, Short numberOfAdult, Short numberOfKid, Short numberOfBaby, Short numberOfPeople, Short individualRoom, Short transportation, Short status, Date createdDate, Boolean isNew, Tours tourID, TourBooked tourBookedID, CustomerUser customerID) {
        this.departureDate = departureDate;
        this.numberOfAdult = numberOfAdult;
        this.numberOfKid = numberOfKid;
        this.numberOfBaby = numberOfBaby;
        this.numberOfPeople = numberOfPeople;
        this.individualRoom = individualRoom;
        this.transportation = transportation;
        this.status = status;
        this.createdDate = createdDate;
        this.isNew = isNew;
        this.tourID = tourID;
        this.tourBookedID = tourBookedID;
        this.customerID = customerID;
    }

    public TourBookedSub(Integer tourBookedSubID) {
        this.tourBookedSubID = tourBookedSubID;
    }

    public Integer getTourBookedSubID() {
        return tourBookedSubID;
    }

    public void setTourBookedSubID(Integer tourBookedSubID) {
        this.tourBookedSubID = tourBookedSubID;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Short getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Short numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Short getNumberOfKid() {
        return numberOfKid;
    }

    public void setNumberOfKid(Short numberOfKid) {
        this.numberOfKid = numberOfKid;
    }

    public Short getNumberOfBaby() {
        return numberOfBaby;
    }

    public void setNumberOfBaby(Short numberOfBaby) {
        this.numberOfBaby = numberOfBaby;
    }

    public Short getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Short numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Short getIndividualRoom() {
        return individualRoom;
    }

    public void setIndividualRoom(Short individualRoom) {
        this.individualRoom = individualRoom;
    }

    public Short getTransportation() {
        return transportation;
    }

    public void setTransportation(Short transportation) {
        this.transportation = transportation;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Tours getTourID() {
        return tourID;
    }

    public void setTourID(Tours tourID) {
        this.tourID = tourID;
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
        hash += (tourBookedSubID != null ? tourBookedSubID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourBookedSub)) {
            return false;
        }
        TourBookedSub other = (TourBookedSub) object;
        if ((this.tourBookedSubID == null && other.tourBookedSubID != null) || (this.tourBookedSubID != null && !this.tourBookedSubID.equals(other.tourBookedSubID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TourBookedSub[ tourBookedSubID=" + tourBookedSubID + " ]";
    }
    
}
