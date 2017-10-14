/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourBooked;
import entities.TourBookedSub;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vahu
 */
@Stateless
public class TourBookedSubFacade extends AbstractFacade<TourBookedSub> implements TourBookedSubFacadeLocal {
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourBookedSubFacade() {
        super(TourBookedSub.class);
    }

    //////////////////////////TOAN///////////////////////
    @Override
    public List<TourBookedSub> searchlistTourBookedSub_ByTourBookedAndStatus(TourBooked tourBookedId, Short status) {
        List<TourBookedSub> list = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.tourBookedID = :tourBookedID and t.status = :status");
            query.setParameter("tourBookedID", tourBookedId);
            query.setParameter("status", status);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<TourBookedSub> searchlistTourBookedSub_ByTourBookedIdAndStatus(String tourBookedId, Short status) {
        List<TourBookedSub> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.tourBookedID.tourBookedID = :tourBookedID and t.status = :status");
            query.setParameter("tourBookedID", tourBookedId);
            query.setParameter("status", status);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public TourBookedSub searchByBookedIdAndRepresentativeId(String bookedID, int representativeId) {
        TourBookedSub result = null;

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.tourBookedID.tourBookedID = :tourBookedID and t.customerID.customerID = :customerID");
            query.setParameter("tourBookedID", bookedID);
            query.setParameter("customerID", representativeId);
            result = (TourBookedSub) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean cancelTourBookedSub(int tourBookedSubId) {
        boolean check = false;

        try {
            TourBookedSub tourBookedSub = em.find(TourBookedSub.class, tourBookedSubId);
            tourBookedSub.setStatus(Short.valueOf(4 + ""));
            
            TourBooked tourBooked = tourBookedSub.getTourBookedID();
            Short adaultChanged = Short.valueOf(tourBooked.getNumberOfAdult() - tourBookedSub.getNumberOfAdult()+"");
            Short kidChanged = Short.valueOf(tourBooked.getNumberOfKid() - tourBookedSub.getNumberOfKid()+"");
            Short babyChanged = Short.valueOf(tourBooked.getNumberOfBaby() - tourBookedSub.getNumberOfBaby()+"");
            tourBooked.setNumberOfAdult(Short.valueOf(adaultChanged));
            tourBooked.setNumberOfKid(Short.valueOf(kidChanged));
            tourBooked.setNumberOfBaby(Short.valueOf(babyChanged));
            tourBookedFacade.editTourBooked(tourBooked);
            
            
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean update(TourBookedSub tourSub) {
        boolean check = false;

        try {
            em.merge(tourSub);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public List<TourBookedSub> searchListByStatus(Short status) {
        List<TourBookedSub> listSearch = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("TourBookedSub.findByStatus");
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public TourBookedSub searchByiD(int id) {
        TourBookedSub tourBookedSub = null;

        try {
            Query query = em.createNamedQuery("TourBookedSub.findByTourBookedSubID");
            query.setParameter("tourBookedSubID", id);
            tourBookedSub = (TourBookedSub) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tourBookedSub;
    }

    @Override
    public List<TourBookedSub> searchlikeTourIDAndStatus_Toan(String tourID, Short status) {
        List<TourBookedSub> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.tourID.tourID like :tourID and t.status = :status");
            query.setParameter("tourID", "%" + tourID + "%");
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBookedSub> searchlikeDerpartureDateAndStatus_Toan(Date departureDate, Short status) {
        List<TourBookedSub> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.departureDate like :departureDate and t.status = :status");
            query.setParameter("departureDate", departureDate);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBookedSub> searchlikeBookedDateAndStatus_Toan(Date bookedDate, Short status) {
        List<TourBookedSub> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.createdDate like :createdDate and t.status = :status");
            query.setParameter("createdDate", bookedDate);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBookedSub> searchlikeTourBookedSubIdAndStatus_Toan(int bookedID, Short status) {
        List<TourBookedSub> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBookedSub t WHERE t.tourBookedSubID like :tourBookedSubID and t.status = :status");
            query.setParameter("tourBookedSubID", bookedID);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBookedSub> getAll() {
        List<TourBookedSub> listAll = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("TourBookedSub.findAll");
            listAll = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<TourBookedSub> selectListByStatus(Short status) {
        List<TourBookedSub> listSub = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("TourBookedSub.findByStatus");
            query.setParameter("status", status);
            listSub = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSub;
    }

    @Override
    public void setIsNew(int tourBookedSubId, boolean isNew) {
        TourBookedSub tourBookedSub = searchByiD(tourBookedSubId);
        tourBookedSub.setIsNew(isNew);
        em.merge(tourBookedSub);
    }
    //////////////////////////TOAN END///////////////////////
}
