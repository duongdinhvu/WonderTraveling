/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author dieut
 */
public class CustomerListHasAge {
    private Integer cusID;
    private String fullName;
    private Boolean sex;
    private Date dateOfBirth;
    private TourBooked tourBookedID;
    private CustomerUser customerID;
    private int age;

    
    public CustomerListHasAge() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
