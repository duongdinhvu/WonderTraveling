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
 * @author REY
 */
@Entity
@Table(name = "CarBooked")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarBooked.findAll", query = "SELECT c FROM CarBooked c"),
    @NamedQuery(name = "CarBooked.findByCarBookedID", query = "SELECT c FROM CarBooked c WHERE c.carBookedID = :carBookedID"),
    @NamedQuery(name = "CarBooked.findByCreatedDate", query = "SELECT c FROM CarBooked c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CarBooked.findByPromotionCode", query = "SELECT c FROM CarBooked c WHERE c.promotionCode = :promotionCode"),
    @NamedQuery(name = "CarBooked.findByCarRecieveDate", query = "SELECT c FROM CarBooked c WHERE c.carRecieveDate = :carRecieveDate"),
    @NamedQuery(name = "CarBooked.findByCarReturnCaDate", query = "SELECT c FROM CarBooked c WHERE c.carReturnCaDate = :carReturnCaDate"),
    @NamedQuery(name = "CarBooked.findByCarRealityDate", query = "SELECT c FROM CarBooked c WHERE c.carRealityDate = :carRealityDate"),
    @NamedQuery(name = "CarBooked.findByPrice", query = "SELECT c FROM CarBooked c WHERE c.price = :price"),
    @NamedQuery(name = "CarBooked.findByExtra", query = "SELECT c FROM CarBooked c WHERE c.extra = :extra"),
    @NamedQuery(name = "CarBooked.findByCode", query = "SELECT c FROM CarBooked c WHERE c.code = :code"),
    @NamedQuery(name = "CarBooked.findByPayment", query = "SELECT c FROM CarBooked c WHERE c.payment = :payment"),
    @NamedQuery(name = "CarBooked.findByQuantity", query = "SELECT c FROM CarBooked c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CarBooked.findByDeposit", query = "SELECT c FROM CarBooked c WHERE c.deposit = :deposit"),
    @NamedQuery(name = "CarBooked.findByCarBookedStatus", query = "SELECT c FROM CarBooked c WHERE c.carBookedStatus = :carBookedStatus")})
public class CarBooked implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarBookedID")
    private Integer carBookedID;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 20)
    @Column(name = "PromotionCode")
    private String promotionCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CarRecieveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carRecieveDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CarReturnCaDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carReturnCaDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CarRealityDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carRealityDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Column(name = "Extra")
    private Double extra;
    @Size(max = 20)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Payment")
    private short payment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Deposit")
    private double deposit;
    @Column(name = "CarBookedStatus")
    private Short carBookedStatus;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne
    private CustomerUser customerID;
    @JoinColumn(name = "CarID", referencedColumnName = "CarID")
    @ManyToOne
    private Car carID;

    public CarBooked() {
    }

    public CarBooked(Integer carBookedID) {
        this.carBookedID = carBookedID;
    }

    public CarBooked(Integer carBookedID, Date carRecieveDate, Date carReturnCaDate, Date carRealityDate) {
        this.carBookedID = carBookedID;
        this.carRecieveDate = carRecieveDate;
        this.carReturnCaDate = carReturnCaDate;
        this.carRealityDate = carRealityDate;
    }

    public CarBooked(Date createdDate, Date carRecieveDate, Date carReturnCaDate, Date carRealityDate, Double price, Short carBookedStatus, String promotionCode, CustomerUser customerID, Car carID, double extra, String code, Short payment, int quantity, double deposit) {
        this.createdDate = createdDate;
        this.carRecieveDate = carRecieveDate;
        this.carReturnCaDate = carReturnCaDate;
        this.carRealityDate = carRealityDate;
        this.price = price;
        this.carBookedStatus = carBookedStatus;
        this.promotionCode = promotionCode;
        this.customerID = customerID;
        this.carID = carID;
        this.extra = extra;
        this.code = code;
        this.payment = payment;
        this.quantity = quantity;
        this.deposit = deposit;
    }

    public CarBooked(Integer carBookedID, Date carRecieveDate, Date carReturnCaDate, Date carRealityDate, short payment) {
        this.carBookedID = carBookedID;
        this.carRecieveDate = carRecieveDate;
        this.carReturnCaDate = carReturnCaDate;
        this.carRealityDate = carRealityDate;
        this.payment = payment;
    }

    public CarBooked(Integer carBookedID, Date carRecieveDate, Date carReturnCaDate, Date carRealityDate, short payment, int quantity, double deposit) {
        this.carBookedID = carBookedID;
        this.carRecieveDate = carRecieveDate;
        this.carReturnCaDate = carReturnCaDate;
        this.carRealityDate = carRealityDate;
        this.payment = payment;
        this.quantity = quantity;
        this.deposit = deposit;
    }

    public Integer getCarBookedID() {
        return carBookedID;
    }

    public void setCarBookedID(Integer carBookedID) {
        this.carBookedID = carBookedID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Date getCarRecieveDate() {
        return carRecieveDate;
    }

    public void setCarRecieveDate(Date carRecieveDate) {
        this.carRecieveDate = carRecieveDate;
    }

    public Date getCarReturnCaDate() {
        return carReturnCaDate;
    }

    public void setCarReturnCaDate(Date carReturnCaDate) {
        this.carReturnCaDate = carReturnCaDate;
    }

    public Date getCarRealityDate() {
        return carRealityDate;
    }

    public void setCarRealityDate(Date carRealityDate) {
        this.carRealityDate = carRealityDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getPayment() {
        return payment;
    }

    public void setPayment(short payment) {
        this.payment = payment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Short getCarBookedStatus() {
        return carBookedStatus;
    }

    public void setCarBookedStatus(Short carBookedStatus) {
        this.carBookedStatus = carBookedStatus;
    }

    public CustomerUser getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerUser customerID) {
        this.customerID = customerID;
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
        hash += (carBookedID != null ? carBookedID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarBooked)) {
            return false;
        }
        CarBooked other = (CarBooked) object;
        if ((this.carBookedID == null && other.carBookedID != null) || (this.carBookedID != null && !this.carBookedID.equals(other.carBookedID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CarBooked[ carBookedID=" + carBookedID + " ]";
    }

}
