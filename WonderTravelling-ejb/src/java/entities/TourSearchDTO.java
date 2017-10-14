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
public class TourSearchDTO {
    private String tourID;
    private String tourTitle;
    private Double evenTourPrice;
    private Double oddTourPrice;
    private String depatureDay;
    private Short hotelRank;
    private String depaturePoint;
    private String headingTo;
    private Short transportation;
    private Short duration;
    private Short tickets;
    private Boolean status;
    private String image;
    private Date createdDate;
    private Integer tourCategoryID;
    private String tourCategoryName;
    private String destination;

    public TourSearchDTO() {
    }

    public TourSearchDTO(String tourID, String tourTitle, Double evenTourPrice, Double oddTourPrice, String depatureDay, Short hotelRank, String depaturePoint, String headingTo, Short transportation, Short duration, Short tickets, Boolean status, String image, Date createdDate, Integer tourCategoryID, String tourCategoryName, String destination) {
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
        this.tourCategoryID = tourCategoryID;
        this.tourCategoryName = tourCategoryName;
        this.destination = destination;
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
    
    
}
