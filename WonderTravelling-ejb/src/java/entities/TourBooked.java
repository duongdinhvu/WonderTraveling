/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dieut
 */
@Entity
@Table(name = "TourBooked")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourBooked.findAll", query = "SELECT t FROM TourBooked t"),
    @NamedQuery(name = "TourBooked.findByTourBookedID", query = "SELECT t FROM TourBooked t WHERE t.tourBookedID = :tourBookedID"),
    @NamedQuery(name = "TourBooked.findByISGroup", query = "SELECT t FROM TourBooked t WHERE t.iSGroup = :iSGroup"),
    @NamedQuery(name = "TourBooked.findByDepartureDate", query = "SELECT t FROM TourBooked t WHERE t.departureDate = :departureDate"),
    @NamedQuery(name = "TourBooked.findByNumberOfAdult", query = "SELECT t FROM TourBooked t WHERE t.numberOfAdult = :numberOfAdult"),
    @NamedQuery(name = "TourBooked.findByNumberOfKid", query = "SELECT t FROM TourBooked t WHERE t.numberOfKid = :numberOfKid"),
    @NamedQuery(name = "TourBooked.findByNumberOfBaby", query = "SELECT t FROM TourBooked t WHERE t.numberOfBaby = :numberOfBaby"),
    @NamedQuery(name = "TourBooked.findByNumberOfPeople", query = "SELECT t FROM TourBooked t WHERE t.numberOfPeople = :numberOfPeople"),
    @NamedQuery(name = "TourBooked.findByIndividualRoom", query = "SELECT t FROM TourBooked t WHERE t.individualRoom = :individualRoom"),
    @NamedQuery(name = "TourBooked.findByTransportation", query = "SELECT t FROM TourBooked t WHERE t.transportation = :transportation"),
    @NamedQuery(name = "TourBooked.findByStatus", query = "SELECT t FROM TourBooked t WHERE t.status = :status"),
    @NamedQuery(name = "TourBooked.findByCreatedDate", query = "SELECT t FROM TourBooked t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TourBooked.findByIsNew", query = "SELECT t FROM TourBooked t WHERE t.isNew = :isNew")})
public class TourBooked implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TourBookedID")
    private String tourBookedID;
    @Column(name = "ISGroup")
    private Boolean iSGroup;
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
    @OneToMany(mappedBy = "tourBookedID")
    private Collection<TourBookedSub> tourBookedSubCollection;
    @JoinColumn(name = "TourID", referencedColumnName = "TourID")
    @ManyToOne
    private Tours tourID;
    @JoinColumn(name = "PromotionID", referencedColumnName = "PromotionID")
    @ManyToOne
    private Promotion promotionID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne
    private CustomerUser customerID;
    @OneToMany(mappedBy = "tourBookedID")
    private Collection<CustomerList> customerListCollection;

    public TourBooked() {
    }

    public TourBooked(String tourBookedID, Boolean iSGroup, Date departureDate, Short numberOfAdult, Short numberOfKid, Short numberOfBaby, Short numberOfPeople, Short individualRoom, Short transportation, Short status, Date createdDate, Boolean isNew, Tours tourID, Promotion promotionID, CustomerUser customerID) {
        this.tourBookedID = tourBookedID;
        this.iSGroup = iSGroup;
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
        this.promotionID = promotionID;
        this.customerID = customerID;
    }

    public TourBooked(String tourBookedID) {
        this.tourBookedID = tourBookedID;
    }

    public String getTourBookedID() {
        return tourBookedID;
    }

    public void setTourBookedID(String tourBookedID) {
        this.tourBookedID = tourBookedID;
    }

    public Boolean getISGroup() {
        return iSGroup;
    }

    public void setISGroup(Boolean iSGroup) {
        this.iSGroup = iSGroup;
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

    @XmlTransient
    public Collection<TourBookedSub> getTourBookedSubCollection() {
        return tourBookedSubCollection;
    }

    public void setTourBookedSubCollection(Collection<TourBookedSub> tourBookedSubCollection) {
        this.tourBookedSubCollection = tourBookedSubCollection;
    }

    public Tours getTourID() {
        return tourID;
    }

    public void setTourID(Tours tourID) {
        this.tourID = tourID;
    }

    public Promotion getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Promotion promotionID) {
        this.promotionID = promotionID;
    }

    public CustomerUser getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerUser customerID) {
        this.customerID = customerID;
    }

    @XmlTransient
    public Collection<CustomerList> getCustomerListCollection() {
        return customerListCollection;
    }

    public void setCustomerListCollection(Collection<CustomerList> customerListCollection) {
        this.customerListCollection = customerListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourBookedID != null ? tourBookedID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourBooked)) {
            return false;
        }
        TourBooked other = (TourBooked) object;
        if ((this.tourBookedID == null && other.tourBookedID != null) || (this.tourBookedID != null && !this.tourBookedID.equals(other.tourBookedID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TourBooked[ tourBookedID=" + tourBookedID + " ]";
    }
    
}
