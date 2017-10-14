/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CustomerUser;
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
public class CustomerUserFacade extends AbstractFacade<CustomerUser> implements CustomerUserFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerUserFacade() {
        super(CustomerUser.class);
    }

    @Override
    public boolean isUserExist(String username, String password) {
        boolean ok = false;
        try {
            String jpql = "SELECT c FROM CustomerUser c WHERE c.customerUsername = :customerUsername AND c.password = :password";
            Query query = em.createQuery(jpql);
            query.setParameter("customerUsername", username);
            query.setParameter("password", password);
            CustomerUser customerUser = (CustomerUser) query.getSingleResult();
            ok = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return ok;

    }

    //Authorization Method
    @Override
    public CustomerUser getCustomerUser(String username) {
        CustomerUser customerUser = null;
        try {
            TypedQuery query = em.createQuery("SELECT c FROM CustomerUser c WHERE c.customerUsername = :customerUsername", CustomerUser.class);
            query.setParameter("customerUsername", username);
             customerUser = (CustomerUser) query.getSingleResult();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
     
        }
        return customerUser;

    }

}
