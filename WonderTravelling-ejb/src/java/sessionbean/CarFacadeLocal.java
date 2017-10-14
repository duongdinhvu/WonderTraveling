/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.Car;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface CarFacadeLocal {

    void create(Car car);

    void edit(Car car);

    void remove(Car car);

    Car find(Object id);

    List<Car> findAll();

    List<Car> findRange(int[] range);

    int count();
    
    List<Car> findListCarOnPage(String keys);

    List<String> GetAllKeys();

    List<Car> searchCarBySubmit(Short seatFrom, Short seatTo);

    List<Car> searchCarByPrice(Short seatFrom, Short seatTo, double priceFrom, double priceTo);
    
}
