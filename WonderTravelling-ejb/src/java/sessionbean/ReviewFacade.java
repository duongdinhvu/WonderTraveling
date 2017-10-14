/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.Review;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author vahu
 */
@Stateless
public class ReviewFacade extends AbstractFacade<Review> implements ReviewFacadeLocal {
    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewFacade() {
        super(Review.class);
    }

    @Override
    public boolean findByUserName(int usernameID, String tourID) {
        
        try {
            String jpql = "SELECT r FROM Review r WHERE r.customerID.customerID = :username and r.tourID.tourID = :tourID";
            Query query = em.createQuery(jpql);
            query.setParameter("username", usernameID);
            query.setParameter("tourID", tourID);
            Object obj = query.getSingleResult();
            if(obj != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    @Override
    public Review findReviewId() {
        Review review = null;
        try {
            String jpql = "SELECT r FROM Review r WHERE r.reviewID = (SELECT top 1 r.reviewID FROM Review r ORDER BY r.reviewID DESC)";
            Query query = em.createQuery(jpql);

            Object obj = query.getSingleResult();
            if(obj != null) {
                 review = (Review)obj;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return review;
    }


    
}
