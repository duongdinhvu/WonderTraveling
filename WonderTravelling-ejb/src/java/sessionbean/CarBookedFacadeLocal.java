/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.Car;
import entities.CarBooked;
import entities.CarBookedReport;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface CarBookedFacadeLocal {

    void create(CarBooked carBooked);

    void edit(CarBooked carBooked);

    void remove(CarBooked carBooked);

    CarBooked find(Object id);

    List<CarBooked> findAll();

    List<CarBooked> findRange(int[] range);

    int count();
    
    public List<CarBookedReport> top05HighestRevenue(Date from, Date to);

    List<Car> listCar();

    public List<CarBookedReport> top05CarBook(Date from, Date to);
    
}
