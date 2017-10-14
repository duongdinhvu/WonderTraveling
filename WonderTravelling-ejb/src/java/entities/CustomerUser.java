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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CustomerUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerUser.findAll", query = "SELECT c FROM CustomerUser c"),
    @NamedQuery(name = "CustomerUser.findByCustomerID", query = "SELECT c FROM CustomerUser c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "CustomerUser.findByFullName", query = "SELECT c FROM CustomerUser c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "CustomerUser.findByPassword", query = "SELECT c FROM CustomerUser c WHERE c.password = :password"),
    @NamedQuery(name = "CustomerUser.findByCustomerUsername", query = "SELECT c FROM CustomerUser c WHERE c.customerUsername = :customerUsername"),
    @NamedQuery(name = "CustomerUser.findByPhone", query = "SELECT c FROM CustomerUser c WHERE c.phone = :phone"),
    @NamedQuery(name = "CustomerUser.findByEmail", query = "SELECT c FROM CustomerUser c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerUser.findByStatus", query = "SELECT c FROM CustomerUser c WHERE c.status = :status")})
public class CustomerUser implements Serializable {
    @OneToMany(mappedBy = "customerID")
    private Collection<Comment> commentCollection;
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Size(max = 50)
    @Column(name = "FullName")
    private String fullName;
    @Size(max = 20)
    @Column(name = "Password")
    private String password;
    @Size(max = 50)
    @Column(name = "CustomerUsername")
    private String customerUsername;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private boolean status;
    @OneToMany(mappedBy = "customerID")
    private Collection<Review> reviewCollection;
    @OneToMany(mappedBy = "customerID")
    private Collection<CarBooked> carBookedCollection;
    @OneToMany(mappedBy = "customerID")
    private Collection<TourBookedSub> tourBookedSubCollection;
    @OneToMany(mappedBy = "customerID")
    private Collection<TourBooked> tourBookedCollection;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne
    private Role roleID;
    @OneToMany(mappedBy = "customerID")
    private Collection<CustomerList> customerListCollection;

    public CustomerUser() {
    }

    public CustomerUser(Integer customerID) {
        this.customerID = customerID;
    }

    public CustomerUser(Integer customerID, boolean status) {
        this.customerID = customerID;
        this.status = status;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @XmlTransient
    public Collection<CarBooked> getCarBookedCollection() {
        return carBookedCollection;
    }

    public void setCarBookedCollection(Collection<CarBooked> carBookedCollection) {
        this.carBookedCollection = carBookedCollection;
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

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
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
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerUser)) {
            return false;
        }
        CustomerUser other = (CustomerUser) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerUser[ customerID=" + customerID + " ]";
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
    
}
