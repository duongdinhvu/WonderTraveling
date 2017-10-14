/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourSearchDTO;
import entities.Tours;
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
public class ToursFacade extends AbstractFacade<Tours> implements ToursFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ToursFacade() {
        super(Tours.class);
    }

    @Override
    public List<Tours> findListToursOnPage(String keys) {
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.tourID in (" + keys + ")";
            Query query = em.createQuery(jpql);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<String> GetAllKeys() {
        List<Tours> tours = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("Tours.findAll", Tours.class);
            tours = query.getResultList();
            if (tours != null) {
                for (Tours tour : tours) {
                    list.add(tour.getTourID());
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Tours> searchToursBySubmit(String depature, String arrival, String depatureDate) {
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.depaturePoint like :depaturePoint "
                    + "and t.headingTo like :headingTo "
                    + "and t.depatureDay like :depatureDay";

            Query query = em.createQuery(jpql);
            query.setParameter("depaturePoint", "%" + depature + "%");
            query.setParameter("headingTo", "%" + arrival + "%");
            query.setParameter("depatureDay", "%" + depatureDate + "%");
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Tours> searchToursByPrice(String depature, String arrival, String depatureDate, double priceFrom, double priceTo) {
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.depaturePoint like :depaturePoint "
                    + "and t.headingTo like :headingTo "
                    + "and t.depatureDay like :depatureDay "
                    + "and (t.oddTourPrice between :priceFrom and :priceTo)";

            Query query = em.createQuery(jpql);
            query.setParameter("depaturePoint", "%" + depature + "%");
            query.setParameter("headingTo", "%" + arrival + "%");
            query.setParameter("depatureDay", "%" + depatureDate + "%");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    ///TOAN//////////////
    @Override
    public List<Tours> tourList() {
        List<Tours> listAll = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("Tours.findAll");
            listAll = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public Tours searchByTourID(String id) {
        Tours t = null;
        try {
            t = em.find(Tours.class, id);
        } catch (Exception e) {
            t = null;
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean updateTour(Tours t) {
        boolean check = false;
        try {
            em.merge(t);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean insertTour(Tours t) {
        boolean check = false;
        try {
            em.persist(t);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Tours findByheadingTo(String h) {
        Tours tour = null;
        try {
            Query query = em.createNamedQuery("Tours.findByHeadingTo");
            query.setParameter("headingTo", h);
            tour = (Tours) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tour;
    }

    @Override
    public void updateDuration(String tourID, Short duration) {
        try {
            Tours tour = em.find(Tours.class, tourID);
            tour.setDuration(duration);
            em.merge(tour);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(String tourID, boolean status) {
        try {
            Tours tour = em.find(Tours.class, tourID);
            tour.setStatus(status);
            em.merge(tour);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> searchLikeTourID(String id) {
        List<String> listID = new ArrayList<>();
        List<Tours> listTour = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t FROM Tours t WHERE t.tourID LIKE :tourID");
            query.setParameter("tourID", id + "%");
            listTour = query.getResultList();
            for (Tours tours : listTour) {
                listID.add(tours.getTourID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listID;
    }

    // Defining For Search Page
    @Override
    public List<Tours> findListToursOnPage_Toan(String keys) {
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.tourID in (" + keys + ")";
            Query query = em.createQuery(jpql);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<String> GetAllKeys_Toan() {
        List<Tours> tours = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("Tours.findAll", Tours.class);
            tours = query.getResultList();
            if (tours != null) {
                for (Tours tour : tours) {
                    list.add(tour.getTourID());
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<TourSearchDTO> searchToursBySubmit_Toan(String depature, String arrival, String depatureDate) {
        List<TourSearchDTO> listReturn = new ArrayList<>();
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.depaturePoint like :depaturePoint "
                    + "and t.headingTo like :headingTo "
                    + "and t.depatureDay like :depatureDay";

            Query query = em.createQuery(jpql);
            query.setParameter("depaturePoint", "%" + depature + "%");
            query.setParameter("headingTo", "%" + arrival + "%");
            query.setParameter("depatureDay", "%" + depatureDate + "%");
            list = query.getResultList();

            for (Tours tour : list) {
                TourSearchDTO dto = new TourSearchDTO();
                dto.setTourID(tour.getTourID());
                dto.setTourTitle(tour.getTourTitle());
                dto.setEvenTourPrice(tour.getEvenTourPrice());
                dto.setOddTourPrice(tour.getOddTourPrice());
                dto.setDepatureDay(tour.getDepatureDay());
                dto.setHotelRank(tour.getHotelRank());
                dto.setDepaturePoint(tour.getDepaturePoint());
                dto.setHeadingTo(tour.getHeadingTo());
                dto.setTransportation(tour.getTransportation());
                dto.setDuration(tour.getDuration());
                dto.setTickets(tour.getTickets());
                dto.setStatus(tour.getStatus());
                dto.setImage(tour.getImage());
                dto.setCreatedDate(tour.getCreatedDate());
                dto.setTourCategoryID(tour.getTourCategoryID().getTourCategoryID());
                dto.setTourCategoryName(tour.getTourCategoryID().getTourCategoryName());
                dto.setDestination(tour.getTourCategoryID().getDestination());

                listReturn.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listReturn;
    }

    @Override
    public List<Tours> searchToursByPrice_Toan(String depature, String arrival, String depatureDate, double priceFrom, double priceTo) {
        List<Tours> list = new ArrayList<>();
        try {
            String jpql = "SELECT t FROM Tours t WHERE t.depaturePoint like :depaturePoint "
                    + "and t.headingTo like :headingTo "
                    + "and t.depatureDay like :depatureDay "
                    + "and (t.oddTourPrice between :priceFrom and :priceTo)";

            Query query = em.createQuery(jpql);
            query.setParameter("depaturePoint", "%" + depature + "%");
            query.setParameter("headingTo", "%" + arrival + "%");
            query.setParameter("depatureDay", "%" + depatureDate + "%");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Tours> searchByTourCategoryId(int tourCategoryId) {
        List<Tours> listTour = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t FROM Tours t WHERE t.tourCategoryID.tourCategoryID = :tourCategoryID");
            query.setParameter("tourCategoryID", tourCategoryId);
            listTour = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTour;
    }
    //////////////TOAN END/////////////
}
