/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vahu
 */
@Entity
@Table(name = "TourCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourCategory.findAll", query = "SELECT t FROM TourCategory t"),
    @NamedQuery(name = "TourCategory.findByTourCategoryID", query = "SELECT t FROM TourCategory t WHERE t.tourCategoryID = :tourCategoryID"),
    @NamedQuery(name = "TourCategory.findByTourCategoryName", query = "SELECT t FROM TourCategory t WHERE t.tourCategoryName = :tourCategoryName"),
    @NamedQuery(name = "TourCategory.findByDestination", query = "SELECT t FROM TourCategory t WHERE t.destination = :destination")})
public class TourCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TourCategoryID")
    private Integer tourCategoryID;
    @Size(max = 50)
    @Column(name = "TourCategoryName")
    private String tourCategoryName;
    @Size(max = 1073741823)
    @Column(name = "Destination")
    private String destination;
    @OneToMany(mappedBy = "tourCategoryID")
    private Collection<Tours> toursCollection;

    public TourCategory() {
    }

    public TourCategory(Integer tourCategoryID) {
        this.tourCategoryID = tourCategoryID;
    }

    public TourCategory(Integer tourCategoryID, String tourCategoryName, String destination) {
        this.tourCategoryID = tourCategoryID;
        this.tourCategoryName = tourCategoryName;
        this.destination = destination;
    }

    public Integer getTourCategoryID() {
        return tourCategoryID;
    }

    public void setTourCategoryID(Integer tourCategoryID) {
        this.tourCategoryID = tourCategoryID;
    }

    public String getTourCategoryName() {
        return tourCategoryName;
    }

    public void setTourCategoryName(String tourCategoryName) {
        this.tourCategoryName = tourCategoryName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @XmlTransient
    public Collection<Tours> getToursCollection() {
        return toursCollection;
    }

    public void setToursCollection(Collection<Tours> toursCollection) {
        this.toursCollection = toursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourCategoryID != null ? tourCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourCategory)) {
            return false;
        }
        TourCategory other = (TourCategory) object;
        if ((this.tourCategoryID == null && other.tourCategoryID != null) || (this.tourCategoryID != null && !this.tourCategoryID.equals(other.tourCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TourCategory[ tourCategoryID=" + tourCategoryID + " ]";
    }

}
