/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Car;
import entities.CarBooked;
import entities.CarBookedReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
public class CarBookedFacade extends AbstractFacade<CarBooked> implements CarBookedFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarBookedFacade() {
        super(CarBooked.class);
    }

    @Override
    public List<Car> listCar() {
        List<Car> listAll = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("Car.findAll");
            listAll = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<CarBookedReport> top05HighestRevenue(Date from, Date to) {
        List<CarBookedReport> listReport = new ArrayList<>();
        List<CarBookedReport> listReportShowed = new ArrayList<>();
        try {
            List<Car> carList = listCar();
            for (Car car : carList) {
                double revenue = 0.0;
                Query query = em.createQuery("SELECT c FROM CarBooked c WHERE c.createdDate BETWEEN :from and :to and c.carID.carID = :carID").setParameter("from", from).setParameter("to", to).setParameter("carID", car.getCarID());
                List<CarBooked> listCarBooked = query.getResultList();
                if (!listCarBooked.isEmpty()) {
                    for (CarBooked carBooked : listCarBooked) {
                        if (carBooked.getCarBookedStatus() == 3 && carBooked.getCarBookedStatus() != 1 && carBooked.getCarBookedStatus() != 2 && carBooked.getCarBookedStatus() != 4) {
                            revenue += (carBooked.getPrice() + carBooked.getExtra());
                        }

                    }
                    CarBookedReport carTop = new CarBookedReport(car.getCarID(), car.getCarName(), revenue);
                    listReport.add(carTop);
                }
            }

            Collections.sort(listReport, new Comparator<CarBookedReport>() {
                @Override
                public int compare(CarBookedReport ca1, CarBookedReport car2) {
                    if (ca1.getRevenue() > car2.getRevenue()) {
                        return -1;
                    }
                    if (ca1.getRevenue() < car2.getRevenue()) {
                        return 1;
                    }
                    return 0;
                }
            });

            for (int i = 0; i < 5; i++) {
                listReportShowed.add(listReport.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listReportShowed;
    }

    @Override
    public List<CarBookedReport> top05CarBook(Date from, Date to) {
        List<CarBookedReport> listReport = new ArrayList<>();
        List<CarBookedReport> listReportShowed = new ArrayList<>();
        try {
            List<Car> carList = listCar();
            for (Car car : carList) {
                int numberOfbooked = 0;
                Query query = em.createQuery("SELECT c FROM CarBooked c WHERE c.createdDate BETWEEN :from and :to and c.carID.carID = :carID").setParameter("from", from).setParameter("to", to).setParameter("carID", car.getCarID());
                List<CarBooked> listCarBooked = query.getResultList();
                if (!listCarBooked.isEmpty()) {
                    for (CarBooked carBooked : listCarBooked) {
                        numberOfbooked += (carBooked.getQuantity());

                    }
                    CarBookedReport carTop = new CarBookedReport(car.getCarID(), car.getCarName(), numberOfbooked);
                    listReport.add(carTop);
                }
            }

            Collections.sort(listReport, new Comparator<CarBookedReport>() {
                @Override
                public int compare(CarBookedReport car1, CarBookedReport car2) {
                    if (car1.getNumOfBooked() > car2.getNumOfBooked()) {
                        return -1;
                    }
                    if (car1.getNumOfBooked() < car2.getNumOfBooked()) {
                        return 1;
                    }
                    return 0;
                }
            });

            for (int i = 0; i < 5; i++) {
                listReportShowed.add(listReport.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listReportShowed;
    }

}