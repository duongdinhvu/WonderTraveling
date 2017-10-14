/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.TourCategory;
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
public class TourCategoryFacade extends AbstractFacade<TourCategory> implements TourCategoryFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourCategoryFacade() {
        super(TourCategory.class);
    }

    ////////////////////TOAN/////////////////////////
    @Override
    public boolean updateTourCategory(TourCategory tc) {
        boolean check = false;
        try {
            em.merge(tc);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public TourCategory findById(int id) {
        TourCategory tc = em.find(TourCategory.class, id);
        return tc;
    }

    @Override
    public List<TourCategory> listAll() {
        List<TourCategory> list = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourCategory.findAll");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TourCategory findByDestination(String d) {
        TourCategory tc = null;
        try {
            Query query = em.createNamedQuery("TourCategory.findByDestination");
            query.setParameter("destination", d);
            tc = (TourCategory) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tc;
    }

    @Override
    public TourCategory findByTitle(String tt) {
        TourCategory tc = null;
        try {
            Query query = em.createNamedQuery("TourCategory.findByTourCategoryName");
            query.setParameter("tourCategoryName", tt);
            tc = (TourCategory) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tc;
    }

    @Override
    public List<String> listdestinationAll_Toan() {
        List<TourCategory> listCategory = new ArrayList<>();
        String destination = "";
        List<String> listDesString = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("TourCategory.findAll");
            listCategory = query.getResultList();
            for (TourCategory tourCategory : listCategory) {
                String s = tourCategory.getDestination();
                destination += ", " + s;
            }

            String[] DesArray = destination.split(", ");
            for (int i = 0; i < DesArray.length; i++) {
                listDesString.add(DesArray[i]);
            }

            for (int i = 0; i < listDesString.size(); i++) {
                for (int j = listDesString.size() - 1; j > i; j--) {
                    if (listDesString.get(j) == listDesString.get(i)) {
                        listDesString.remove(j);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDesString;
    }
    ///////////////////TOAN END//////////////////////
}
