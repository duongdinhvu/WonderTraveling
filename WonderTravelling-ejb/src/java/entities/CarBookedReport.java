/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;

/**
 *
 * @author REY
 */
public class CarBookedReport implements Serializable{
    int carID;
    String carName;
    Double revenue;
    int numOfBooked;

    public CarBookedReport(int carID, String carName, Double revenue) {
        this.carID = carID;
        this.carName = carName;
        this.revenue = revenue;
    }

    public CarBookedReport(int carID, String carName, int numOfBooked) {
        this.carID = carID;
        this.carName = carName;
        this.numOfBooked = numOfBooked;
    }

    public CarBookedReport(int numOfBooked) {
        this.numOfBooked = numOfBooked;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public int getNumOfBooked() {
        return numOfBooked;
    }

    public void setNumOfBooked(int numOfBooked) {
        this.numOfBooked = numOfBooked;
    }
    
    

}
