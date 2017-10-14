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
@Table(name = "Schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleID", query = "SELECT s FROM Schedule s WHERE s.scheduleID = :scheduleID"),
    @NamedQuery(name = "Schedule.findBySummary", query = "SELECT s FROM Schedule s WHERE s.summary = :summary"),
    @NamedQuery(name = "Schedule.findByContent", query = "SELECT s FROM Schedule s WHERE s.content = :content"),
    @NamedQuery(name = "Schedule.findByImage1", query = "SELECT s FROM Schedule s WHERE s.image1 = :image1"),
    @NamedQuery(name = "Schedule.findByImage2", query = "SELECT s FROM Schedule s WHERE s.image2 = :image2"),
    @NamedQuery(name = "Schedule.findByImage3", query = "SELECT s FROM Schedule s WHERE s.image3 = :image3"),
    @NamedQuery(name = "Schedule.findByImage4", query = "SELECT s FROM Schedule s WHERE s.image4 = :image4"),
    @NamedQuery(name = "Schedule.findByImage5", query = "SELECT s FROM Schedule s WHERE s.image5 = :image5")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScheduleID")
    private Integer scheduleID;
    @Size(max = 300)
    @Column(name = "Summary")
    private String summary;
    @Size(max = 1073741823)
    @Column(name = "Content")
    private String content;
    @Size(max = 200)
    @Column(name = "Image1")
    private String image1;
    @Size(max = 200)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 200)
    @Column(name = "Image3")
    private String image3;
    @Size(max = 200)
    @Column(name = "Image4")
    private String image4;
    @Size(max = 200)
    @Column(name = "Image5")
    private String image5;
    @JoinColumn(name = "TourID", referencedColumnName = "TourID")
    @ManyToOne
    private Tours tourID;

    public Schedule() {
    }

    public Schedule(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public Tours getTourID() {
        return tourID;
    }

    public void setTourID(Tours tourID) {
        this.tourID = tourID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleID != null ? scheduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleID == null && other.scheduleID != null) || (this.scheduleID != null && !this.scheduleID.equals(other.scheduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Schedule[ scheduleID=" + scheduleID + " ]";
    }

}
