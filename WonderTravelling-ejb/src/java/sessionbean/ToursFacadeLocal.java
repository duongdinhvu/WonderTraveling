/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourSearchDTO;
import entities.Tours;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface ToursFacadeLocal {

    void create(Tours tours);

    void edit(Tours tours);

    void remove(Tours tours);

    Tours find(Object id);

    List<Tours> findAll();

    List<Tours> findRange(int[] range);

    int count();

    List<Tours> findListToursOnPage(String keys);

    List<String> GetAllKeys();

    List<Tours> searchToursBySubmit(String depature, String arrival, String depatureDate);

    List<Tours> searchToursByPrice(String depature, String arrival, String depatureDate, double priceFrom, double priceTo);

    ////////////////TOAN/////////////////////////
    List<Tours> tourList();

    boolean insertTour(Tours t);

    Tours searchByTourID(String id);

    boolean updateTour(Tours t);

    void updateDuration(String tourID, Short duration);

    Tours findByheadingTo(String h);

    void updateStatus(String tourID, boolean status);

    List<String> searchLikeTourID(String id);

    // Defining For Search Page
    List<Tours> findListToursOnPage_Toan(String keys);

    List<String> GetAllKeys_Toan();

    List<TourSearchDTO> searchToursBySubmit_Toan(String depature, String arrival, String depatureDate);

    List<Tours> searchToursByPrice_Toan(String depature, String arrival, String depatureDate, double priceFrom, double priceTo);

    List<Tours> searchByTourCategoryId(int tourCategoryId);
    /////////////////////TOAN END////////////////////////////
}
