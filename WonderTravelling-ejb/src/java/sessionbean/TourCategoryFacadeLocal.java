/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface TourCategoryFacadeLocal {

    void create(TourCategory tourCategory);

    void edit(TourCategory tourCategory);

    void remove(TourCategory tourCategory);

    TourCategory find(Object id);

    List<TourCategory> findAll();

    List<TourCategory> findRange(int[] range);

    int count();

    /////////////////TOAN/////////////////
    boolean updateTourCategory(TourCategory tc);

    TourCategory findById(int id);

    List<TourCategory> listAll();

    TourCategory findByDestination(String d);

    TourCategory findByTitle(String tt);

    List<String> listdestinationAll_Toan();
    //////////////////TOAN END//////////////
}
