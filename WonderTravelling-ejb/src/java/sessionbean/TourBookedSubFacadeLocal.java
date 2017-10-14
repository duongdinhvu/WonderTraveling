/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourBooked;
import entities.TourBookedSub;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface TourBookedSubFacadeLocal {

    void create(TourBookedSub tourBookedSub);

    void edit(TourBookedSub tourBookedSub);

    void remove(TourBookedSub tourBookedSub);

    TourBookedSub find(Object id);

    List<TourBookedSub> findAll();

    List<TourBookedSub> findRange(int[] range);

    int count();

    ////////////////////TOAN/////////////////////
    List<TourBookedSub> searchlistTourBookedSub_ByTourBookedAndStatus(TourBooked tourBooked, Short status);

    List<TourBookedSub> searchlistTourBookedSub_ByTourBookedIdAndStatus(String tourBookedId, Short status);

    TourBookedSub searchByBookedIdAndRepresentativeId(String bookedID, int representativeId);

    boolean cancelTourBookedSub(int tourBookedSubId);

    boolean update(TourBookedSub tourSub);

    List<TourBookedSub> searchListByStatus(Short status);

    TourBookedSub searchByiD(int id);

    List<TourBookedSub> searchlikeTourIDAndStatus_Toan(String tourID, Short status);

    List<TourBookedSub> searchlikeDerpartureDateAndStatus_Toan(Date departureDate, Short status);

    List<TourBookedSub> searchlikeBookedDateAndStatus_Toan(Date bookedDate, Short status);

    List<TourBookedSub> searchlikeTourBookedSubIdAndStatus_Toan(int bookedID, Short status);

    List<TourBookedSub> getAll();

    List<TourBookedSub> selectListByStatus(Short status);

    void setIsNew(int tourBookedSubId, boolean isNew);
    //////////////////////TOAN END///////////////////////
}
