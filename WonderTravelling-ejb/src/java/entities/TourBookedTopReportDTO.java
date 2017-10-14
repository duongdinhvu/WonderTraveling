/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

public class TourBookedTopReportDTO implements Serializable {

    String tourID, tourtitle;
    int numOfbooked;
    double revenue;

    public TourBookedTopReportDTO(String tourID, String tourtitle, int numOfbooked) {
        this.tourID = tourID;
        this.tourtitle = tourtitle;
        this.numOfbooked = numOfbooked;
    }

    public TourBookedTopReportDTO(String tourID, String tourtitle, double revenue) {
        this.tourID = tourID;
        this.tourtitle = tourtitle;
        this.revenue = revenue;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getTourtitle() {
        return tourtitle;
    }

    public void setTourtitle(String tourtitle) {
        this.tourtitle = tourtitle;
    }

    public int getNumOfbooked() {
        return numOfbooked;
    }

    public void setNumOfbooked(int numOfbooked) {
        this.numOfbooked = numOfbooked;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
