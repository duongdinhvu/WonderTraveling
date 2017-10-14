/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.Comment;
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
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {
    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }

    @Override
    public List<Comment> findByTourId(String tourId) {
       List<Comment> list = null;
        try {
            String jpql = "SELECT c FROM Comment c WHERE c.tourID.tourID = :tourId";
            Query query = em.createQuery(jpql).setParameter("tourId", tourId);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
       return list;
    }
    
}
