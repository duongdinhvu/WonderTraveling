/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourBooked;
import entities.TourBookedTopReportDTO;
import entities.Tours;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface TourBookedFacadeLocal {

    void create(TourBooked tourBooked);

    void edit(TourBooked tourBooked);

    void remove(TourBooked tourBooked);

    TourBooked find(Object id);

    List<TourBooked> findAll();

    List<TourBooked> findRange(int[] range);

    int count();

    List<TourBooked> getBookedQuantity(String tourId);

    String getTourBookedID();

    ////////////////TOAN////////////////////////
    List<TourBooked> selectOddTourBooked();

    TourBooked searchByTourBookID(String tourBookedID);

    boolean cancelTourBooked(String tourBooedId);

    boolean editTourBooked(TourBooked tb);

    public List<TourBookedTopReportDTO> top05TourBookedMost(Date from, Date to);

    public List<TourBookedTopReportDTO> top05HighestRevenueOfTour(Date from, Date to);

    List<Tours> listTours();

    List<TourBooked> searchByTourBookedIDAndStatus(String bookedId, Short status);

    List<TourBooked> searchLikeTourIDAndStatus(String tourId, Short status);

    List<TourBooked> searchLikeDepartureDateAndStatus(Date departureDate, Short status);

    List<TourBooked> searchLikeBookedDateAndStatus(Date bookedDate, Short status);

    List<TourBooked> searchByMultiCondition_Toan(int bookedId, String tourId, boolean isGroup, Date departureDate, Date createdDate, int representative);

    List<TourBooked> isGenerated(String destination);

    List<TourBooked> isGeneratedOfDate(Date departureDate, String tourID);

    List<TourBooked> selectTourBooked_PendingStatus();

    List<TourBooked> selectTourBooked_DepartingStatus();

    List<TourBooked> selectTourBooked_CompletedStatus();

    List<TourBooked> selectTourBooked_CancelStatus();

    void setIsNew_Toan(String tourBookedid, boolean isNew);
    ///////////////TOAN END////////////////////
}
