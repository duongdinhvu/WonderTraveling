/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vahu
 */
@Entity
@Table(name = "ReviewDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewDetail.findAll", query = "SELECT r FROM ReviewDetail r"),
    @NamedQuery(name = "ReviewDetail.findByReviewDetailID", query = "SELECT r FROM ReviewDetail r WHERE r.reviewDetailID = :reviewDetailID"),
    @NamedQuery(name = "ReviewDetail.findByContent", query = "SELECT r FROM ReviewDetail r WHERE r.content = :content"),
    @NamedQuery(name = "ReviewDetail.findByRating", query = "SELECT r FROM ReviewDetail r WHERE r.rating = :rating")})
public class ReviewDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewDetailID")
    private Integer reviewDetailID;
    @Size(max = 300)
    @Column(name = "Content")
    private String content;
    @Column(name = "Rating")
    private Short rating;
    @JoinColumn(name = "TourID", referencedColumnName = "TourID")
    @ManyToOne
    private Tours tourID;
    @JoinColumn(name = "ReviewID", referencedColumnName = "ReviewID")
    @ManyToOne
    private Review reviewID;
    @JoinColumn(name = "CarID", referencedColumnName = "CarID")
    @ManyToOne
    private Car carID;

    public ReviewDetail() {
    }

    public ReviewDetail(Integer reviewDetailID) {
        this.reviewDetailID = reviewDetailID;
    }

    public ReviewDetail(Short rating) {
        this.rating = rating;
    }
   
    public Integer getReviewDetailID() {
        return reviewDetailID;
    }

    public void setReviewDetailID(Integer reviewDetailID) {
        this.reviewDetailID = reviewDetailID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public Tours getTourID() {
        return tourID;
    }

    public void setTourID(Tours tourID) {
        this.tourID = tourID;
    }

    public Review getReviewID() {
        return reviewID;
    }

    public void setReviewID(Review reviewID) {
        this.reviewID = reviewID;
    }

    public Car getCarID() {
        return carID;
    }

    public void setCarID(Car carID) {
        this.carID = carID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewDetailID != null ? reviewDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewDetail)) {
            return false;
        }
        ReviewDetail other = (ReviewDetail) object;
        if ((this.reviewDetailID == null && other.reviewDetailID != null) || (this.reviewDetailID != null && !this.reviewDetailID.equals(other.reviewDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReviewDetail[ reviewDetailID=" + reviewDetailID + " ]";
    }

}
