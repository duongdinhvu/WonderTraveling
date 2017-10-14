/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourBooked;
import entities.TourBookedTopReportDTO;
import entities.Tours;
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
public class TourBookedFacade extends AbstractFacade<TourBooked> implements TourBookedFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourBookedFacade() {
        super(TourBooked.class);
    }

    @Override
    public List<TourBooked> getBookedQuantity(String tourId) {
        List<TourBooked> list = null;
        List<TourBooked> list1 = null;

        try {

            Tours tour = em.find(Tours.class, tourId);
            em.refresh(tour);
            list = (List<TourBooked>) tour.getTourBookedCollection();

            for (TourBooked items : list) {
                System.out.println(items.getTourBookedID());
            }

            list1 = getListBooked(list);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        return list1;
    }

    public List<TourBooked> getListBooked(List<TourBooked> list) {

        List<TourBooked> tmpList = new ArrayList<>();
        try {
            for (TourBooked tourBooked : list) {
                if (tourBooked.getISGroup() == false && tourBooked.getStatus() == 1) {
                    tmpList.add(tourBooked);
                }
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        return tmpList;
    }

    @Override
    public String getTourBookedID() {
        String str = "";
        try {
            String jpql = "SELECT t FROM TourBooked t WHERE t.createdDate = (SELECT MAX(t.createdDate) FROM TourBooked t)";
            Query query = em.createQuery(jpql);
            TourBooked tb = (TourBooked) query.getSingleResult();
            str = tb.getTourBookedID();
            System.out.println("Str:" + str);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return str;
    }

    ////////////////////////TOAN////////////////////
    @Override
    public List<TourBooked> selectOddTourBooked() {
        List<TourBooked> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourBooked.findByISGroup");
            query.setParameter("iSGroup", false);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TourBooked searchByTourBookID(String tourBookedID) {
        TourBooked tour = em.find(TourBooked.class, tourBookedID);

        return tour;
    }

    @Override
    public boolean editTourBooked(TourBooked tb) {
        //To change body of generated methods, choose Tools | Templates.
        boolean check = false;
        try {
            em.merge(tb);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean cancelTourBooked(String tourBooedId) {
        boolean check = false;
        try {
            TourBooked tourBooked = em.find(TourBooked.class, tourBooedId);
            tourBooked.setStatus(Short.valueOf(4 + ""));
            em.merge(tourBooked);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public List<Tours> listTours() {
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
    public List<TourBookedTopReportDTO> top05TourBookedMost(Date from, Date to) {
        List<TourBookedTopReportDTO> listReport = new ArrayList<>();
        List<TourBookedTopReportDTO> listReportShowed = new ArrayList<>();
        try {
            List<Tours> tourList = listTours();
            for (Tours tours : tourList) {
                int numberOfbooked = 0;
                Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.createdDate BETWEEN :from and :to and t.tourID.tourID = :tourID").setParameter("from", from).setParameter("to", to).setParameter("tourID", tours.getTourID());
                List<TourBooked> listTourBooked = query.getResultList();
                if (!listTourBooked.isEmpty()) {
                    for (TourBooked tourBooked : listTourBooked) {
                        numberOfbooked += (tourBooked.getNumberOfPeople() - tourBooked.getNumberOfBaby());

                    }
                    TourBookedTopReportDTO tourTop = new TourBookedTopReportDTO(tours.getTourID(), tours.getTourTitle(), numberOfbooked);
                    listReport.add(tourTop);
                }
            }

            Collections.sort(listReport, new Comparator<TourBookedTopReportDTO>() {
                @Override
                public int compare(TourBookedTopReportDTO tour1, TourBookedTopReportDTO tour2) {
                    if (tour1.getNumOfbooked() > tour2.getNumOfbooked()) {
                        return -1;
                    }
                    if (tour1.getNumOfbooked() < tour2.getNumOfbooked()) {
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
    public List<TourBookedTopReportDTO> top05HighestRevenueOfTour(Date from, Date to) {
        List<TourBookedTopReportDTO> listReport = new ArrayList<>();
        List<TourBookedTopReportDTO> listReportShowed = new ArrayList<>();
        try {
            List<Tours> tourList = listTours();
            for (Tours tours : tourList) {
                double revenue = 0.0;
                Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.createdDate BETWEEN :from and :to and t.tourID.tourID = :tourID").setParameter("from", from).setParameter("to", to).setParameter("tourID", tours.getTourID());
                List<TourBooked> listTourBooked = query.getResultList();
                if (!listTourBooked.isEmpty()) {
                    for (TourBooked tourBooked : listTourBooked) {
                        if (tourBooked.getISGroup()) {
                            revenue += (tourBooked.getNumberOfAdult() * tours.getEvenTourPrice())
                                    + ((tourBooked.getNumberOfKid() * tours.getEvenTourPrice()) / 2)
                                    + (tourBooked.getIndividualRoom() * 15);
                        } else {
                            revenue += (tourBooked.getNumberOfAdult() * tours.getOddTourPrice())
                                    + ((tourBooked.getNumberOfKid() * tours.getOddTourPrice()) / 2)
                                    + (tourBooked.getIndividualRoom() * 15);
                        }

                    }
                    TourBookedTopReportDTO tourTop = new TourBookedTopReportDTO(tours.getTourID(), tours.getTourTitle(), revenue);
                    listReport.add(tourTop);
                }
            }

            Collections.sort(listReport, new Comparator<TourBookedTopReportDTO>() {
                @Override
                public int compare(TourBookedTopReportDTO tour1, TourBookedTopReportDTO tour2) {
                    if (tour1.getRevenue() > tour2.getRevenue()) {
                        return -1;
                    }
                    if (tour1.getRevenue() < tour2.getRevenue()) {
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
    public List<TourBooked> searchByTourBookedIDAndStatus(String bookedId, Short status) {
        List<TourBooked> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.tourBookedID = :tourBookedID and t.status = :status");
            query.setParameter("tourBookedID", bookedId);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBooked> searchLikeTourIDAndStatus(String tourId, Short status) {
        List<TourBooked> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.tourID.tourID like :tourID and t.status = :status");
            query.setParameter("tourID", "%" + tourId + "%");
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBooked> searchLikeDepartureDateAndStatus(Date departureDate, Short status) {
        List<TourBooked> listSearch = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.departureDate like :departureDate and t.status = :status");
            query.setParameter("departureDate", departureDate);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBooked> searchLikeBookedDateAndStatus(Date bookedDate, Short status) {
        List<TourBooked> listSearch = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.createdDate like :createdDate and t.status = :status");
            query.setParameter("createdDate", bookedDate);
            query.setParameter("status", status);
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBooked> searchByMultiCondition_Toan(int bookedId, String tourId, boolean isGroup, Date departureDate, Date createdDate, int representative) {
        List<TourBooked> listSearch = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.tourBookedID like :tourBookedID"
                    + " and t.tourID.tourID like :tourID and t.iSGroup = :isGroup"
                    + " and t.departureDate like :departureDate and t.createdDate like :createdDate"
                    + " and t.customerID like :customerID");
            query.setParameter("tourBookedID", "%" + bookedId + "%");
            query.setParameter("tourID", "%" + tourId + "%");
            query.setParameter("isGroup", isGroup);
            query.setParameter("departureDate", departureDate);
            query.setParameter("createdDate", createdDate);
            query.setParameter("customerID", "%" + representative + "%");

            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSearch;
    }

    @Override
    public List<TourBooked> isGenerated(String destination) {
        List<TourBooked> listReturn = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.tourID.headingTo = :headingTo");
            query.setParameter("headingTo", destination);
            listReturn = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listReturn;
    }

    @Override
    public List<TourBooked> isGeneratedOfDate(Date departureDate, String tourID) {
        List<TourBooked> listReturn = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT t FROM TourBooked t WHERE t.departureDate = :departureDate and t.tourID.tourID = :tourID");
            query.setParameter("departureDate", departureDate);
            query.setParameter("tourID", tourID);
            listReturn = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listReturn;
    }

    @Override
    public List<TourBooked> selectTourBooked_PendingStatus() {
        List<TourBooked> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourBooked.findByStatus");
            query.setParameter("status", Short.valueOf(1 + ""));
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TourBooked> selectTourBooked_DepartingStatus() {
        List<TourBooked> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourBooked.findByStatus");
            query.setParameter("status", Short.valueOf(2 + ""));
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TourBooked> selectTourBooked_CompletedStatus() {
        List<TourBooked> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourBooked.findByStatus");
            query.setParameter("status", Short.valueOf(3 + ""));
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TourBooked> selectTourBooked_CancelStatus() {
        List<TourBooked> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourBooked.findByStatus");
            query.setParameter("status", Short.valueOf(4 + ""));
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void setIsNew_Toan(String tourBookedid, boolean isNew) {
        TourBooked tourbooked = searchByTourBookID(tourBookedid);
        tourbooked.setIsNew(isNew);
        em.merge(tourbooked);
    }
    ///////////////////////TOAN END////////////////
}
