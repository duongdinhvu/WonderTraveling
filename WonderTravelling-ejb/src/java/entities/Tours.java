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
import javax.persistence.Lob;
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
 * @author vahu
 */
@Entity
@Table(name = "Tours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tours.findAll", query = "SELECT t FROM Tours t"),
    @NamedQuery(name = "Tours.findByTourID", query = "SELECT t FROM Tours t WHERE t.tourID = :tourID"),
    @NamedQuery(name = "Tours.findByTourTitle", query = "SELECT t FROM Tours t WHERE t.tourTitle = :tourTitle"),
    @NamedQuery(name = "Tours.findByEvenTourPrice", query = "SELECT t FROM Tours t WHERE t.evenTourPrice = :evenTourPrice"),
    @NamedQuery(name = "Tours.findByOddTourPrice", query = "SELECT t FROM Tours t WHERE t.oddTourPrice = :oddTourPrice"),
    @NamedQuery(name = "Tours.findByHotelRank", query = "SELECT t FROM Tours t WHERE t.hotelRank = :hotelRank"),
    @NamedQuery(name = "Tours.findByDepaturePoint", query = "SELECT t FROM Tours t WHERE t.depaturePoint = :depaturePoint"),
    @NamedQuery(name = "Tours.findByHeadingTo", query = "SELECT t FROM Tours t WHERE t.headingTo = :headingTo"),
    @NamedQuery(name = "Tours.findByTransportation", query = "SELECT t FROM Tours t WHERE t.transportation = :transportation"),
    @NamedQuery(name = "Tours.findByDuration", query = "SELECT t FROM Tours t WHERE t.duration = :duration"),
    @NamedQuery(name = "Tours.findByTickets", query = "SELECT t FROM Tours t WHERE t.tickets = :tickets"),
    @NamedQuery(name = "Tours.findByStatus", query = "SELECT t FROM Tours t WHERE t.status = :status"),
    @NamedQuery(name = "Tours.findByImage", query = "SELECT t FROM Tours t WHERE t.image = :image"),
    @NamedQuery(name = "Tours.findByCreatedDate", query = "SELECT t FROM Tours t WHERE t.createdDate = :createdDate")})
public class Tours implements Serializable {
    @OneToMany(mappedBy = "tourID")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "tourID")
    private Collection<ReviewDetail> reviewDetailCollection;
    @OneToMany(mappedBy = "tourID")
    private Collection<Review> reviewCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TourID")
    private String tourID;
    @Size(max = 50)
    @Column(name = "TourTitle")
    private String tourTitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EvenTourPrice")
    private Double evenTourPrice;
    @Column(name = "OddTourPrice")
    private Double oddTourPrice;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DepatureDay")
    private String depatureDay;
    @Column(name = "HotelRank")
    private Short hotelRank;
    @Size(max = 100)
    @Column(name = "DepaturePoint")
    private String depaturePoint;
    @Size(max = 50)
    @Column(name = "HeadingTo")
    private String headingTo;
    @Column(name = "Transportation")
    private Short transportation;
    @Column(name = "Duration")
    private Short duration;
    @Column(name = "Tickets")
    private Short tickets;
    @Column(name = "Status")
    private Boolean status;
    @Size(max = 100)
    @Column(name = "Image")
    private String image;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "TourCategoryID", referencedColumnName = "TourCategoryID")
    @ManyToOne
    private TourCategory tourCategoryID;
    @OneToMany(mappedBy = "tourID")
    private Collection<Schedule> scheduleCollection;
    @OneToMany(mappedBy = "tourID")
    private Collection<TourBookedSub> tourBookedSubCollection;
    @OneToMany(mappedBy = "tourID")
    private Collection<TourBooked> tourBookedCollection;

    public Tours() {
    }

    public Tours(String tourID) {
        this.tourID = tourID;
    }

    public Tours(Double evenTourPrice, Double oddTourPrice) {
        this.evenTourPrice = evenTourPrice;
        this.oddTourPrice = oddTourPrice;
    }

    public Tours(String tourID, String tourTitle, Double oddTourPrice, String depatureDay, String depaturePoint, String headingTo, Short transportation, Short duration, Short tickets, String image) {
        this.tourID = tourID;
        this.tourTitle = tourTitle;
        this.oddTourPrice = oddTourPrice;
        this.depatureDay = depatureDay;
        this.depaturePoint = depaturePoint;
        this.headingTo = headingTo;
        this.transportation = transportation;
        this.duration = duration;
        this.tickets = tickets;
        this.image = image;

    }

    public Tours(String tourID, String tourTitle) {
        this.tourID = tourID;
        this.tourTitle = tourTitle;
    }

    public Tours(String tourID, String tourTitle, Double evenTourPrice, Double oddTourPrice, String depatureDay, String depaturePoint, String headingTo, Short transportation, Short duration, Short tickets, String image, Short hotelRank, Boolean status, Date createdDate) {
        this.tourID = tourID;
        this.tourTitle = tourTitle;
        this.evenTourPrice = evenTourPrice;
        this.oddTourPrice = oddTourPrice;
        this.depatureDay = depatureDay;
        this.hotelRank = hotelRank;
        this.depaturePoint = depaturePoint;
        this.headingTo = headingTo;
        this.transportation = transportation;
        this.duration = duration;
        this.tickets = tickets;
        this.status = status;
        this.image = image;
        this.createdDate = createdDate;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public Double getEvenTourPrice() {
        return evenTourPrice;
    }

    public void setEvenTourPrice(Double evenTourPrice) {
        this.evenTourPrice = evenTourPrice;
    }

    public Double getOddTourPrice() {
        return oddTourPrice;
    }

    public void setOddTourPrice(Double oddTourPrice) {
        this.oddTourPrice = oddTourPrice;
    }

    public String getDepatureDay() {
        return depatureDay;
    }

    public void setDepatureDay(String depatureDay) {
        this.depatureDay = depatureDay;
    }

    public Short getHotelRank() {
        return hotelRank;
    }

    public void setHotelRank(Short hotelRank) {
        this.hotelRank = hotelRank;
    }

    public String getDepaturePoint() {
        return depaturePoint;
    }

    public void setDepaturePoint(String depaturePoint) {
        this.depaturePoint = depaturePoint;
    }

    public String getHeadingTo() {
        return headingTo;
    }

    public void setHeadingTo(String headingTo) {
        this.headingTo = headingTo;
    }

    public Short getTransportation() {
        return transportation;
    }

    public void setTransportation(Short transportation) {
        this.transportation = transportation;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public Short getTickets() {
        return tickets;
    }

    public void setTickets(Short tickets) {
        this.tickets = tickets;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public TourCategory getTourCategoryID() {
        return tourCategoryID;
    }

    public void setTourCategoryID(TourCategory tourCategoryID) {
        this.tourCategoryID = tourCategoryID;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @XmlTransient
    public Collection<TourBookedSub> getTourBookedSubCollection() {
        return tourBookedSubCollection;
    }

    public void setTourBookedSubCollection(Collection<TourBookedSub> tourBookedSubCollection) {
        this.tourBookedSubCollection = tourBookedSubCollection;
    }

    @XmlTransient
    public Collection<TourBooked> getTourBookedCollection() {
        return tourBookedCollection;
    }

    public void setTourBookedCollection(Collection<TourBooked> tourBookedCollection) {
        this.tourBookedCollection = tourBookedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourID != null ? tourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tours)) {
            return false;
        }
        Tours other = (Tours) object;
        if ((this.tourID == null && other.tourID != null) || (this.tourID != null && !this.tourID.equals(other.tourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tours[ tourID=" + tourID + " ]";
    }

    @XmlTransient
    public Collection<ReviewDetail> getReviewDetailCollection() {
        return reviewDetailCollection;
    }

    public void setReviewDetailCollection(Collection<ReviewDetail> reviewDetailCollection) {
        this.reviewDetailCollection = reviewDetailCollection;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

}
