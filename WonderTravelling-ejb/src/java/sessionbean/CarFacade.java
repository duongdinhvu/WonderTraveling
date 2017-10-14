/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.Car;
//import entities.Tours;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vahu
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> implements CarFacadeLocal {
    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }

    @Override
    public List<Car> findListCarOnPage(String keys) {
        List<Car> list = new ArrayList<>();
        try {
            String jpql = "SELECT c FROM Car c WHERE c.carID in (" + keys + ") and c.carStatus = 1";
            Query query = em.createQuery(jpql);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<String> GetAllKeys() {
        List<Car> cars = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
//            Query query = em.createNamedQuery("Car.findAll", Car.class);
            String jpql = "SELECT c FROM Car c WHERE c.carStatus = 1";
            Query query = em.createQuery(jpql);
            cars = query.getResultList();
//            cars = query.getResultList();
            if (cars != null) {
                for (Car car : cars) {
                    list.add(car.getCarID().toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }        
        return list;
    }

    @Override
    public List<Car> searchCarBySubmit(Short seatFrom, Short seatTo) {
        List<Car> list = new ArrayList<>();
        try {
            String sql = "SELECT c FROM Car c WHERE c.carSeats between :seatFrom and :seatTo";

            Query query = em.createQuery(sql);
            query.setParameter("seatFrom", seatFrom);
            query.setParameter("seatTo", seatTo);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Car> searchCarByPrice(Short seatFrom, Short seatTo, double priceFrom, double priceTo) {
        List<Car> list = new ArrayList<>();
        try {
//            String jpql = "SELECT t FROM Tours t WHERE t.depaturePoint like :depaturePoint "
//                    + "and t.headingTo like :headingTo "
//                    + "and t.depatureDay like :depatureDay "
//                    + "and (t.oddTourPrice between :priceFrom and :priceTo)";

            String sql = "SELECT c FROM Car c WHERE (c.carSeats between :seatFrom and :seatTo) "
                    + "and (c.carPrice between :priceFrom and :priceTo)";
            
            Query query = em.createQuery(sql);
            query.setParameter("seatFrom", seatFrom);
            query.setParameter("seatTo", seatTo);
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }
    
}
