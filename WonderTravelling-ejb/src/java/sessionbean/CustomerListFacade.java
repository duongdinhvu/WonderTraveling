/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CustomerList;
import entities.CustomerListHasAge;
import entities.CustomerUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class CustomerListFacade extends AbstractFacade<CustomerList> implements CustomerListFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerListFacade() {
        super(CustomerList.class);
    }

    /////////////TOAN///////////////////
    @Override
    public List<CustomerList> searchByRepresentiveCustomer(CustomerUser cus) {
        List<CustomerList> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.customerID = :customerID");
            query.setParameter("customerID", cus);

            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public CustomerList searchByCusIdAndName(int id, String name) {
        CustomerList cus = new CustomerList();

        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.cusID = :cusID and c.fullName = :fullName");
            query.setParameter("cusID", id);
            query.setParameter("fullName", name);
            cus = (CustomerList) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cus;
    }

    @Override
    public CustomerListHasAge searchByCusIdHasAge(int id) {
        CustomerList cus = new CustomerList();
        CustomerListHasAge cusreturn = new CustomerListHasAge();
        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.cusID = :cusID");
            query.setParameter("cusID", id);
            cus = (CustomerList) query.getSingleResult();

            cusreturn.setCusID(cus.getCusID());
            cusreturn.setFullName(cus.getFullName());
            cusreturn.setCustomerID(cus.getCustomerID());
            cusreturn.setTourBookedID(cus.getTourBookedID());
            cusreturn.setDateOfBirth(cus.getDateOfBirth());
            cusreturn.setSex(cus.getSex());

            SimpleDateFormat fm = new SimpleDateFormat("yyyy");
            String currentDateString = fm.format(new Date());
            int currentDateInt = Integer.valueOf(currentDateString);
            String sqlDateString = fm.format(cus.getDateOfBirth());
            int sqlDateInt = Integer.valueOf(sqlDateString);
            int age = currentDateInt - sqlDateInt;
            cusreturn.setAge(age);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cusreturn;
    }

    @Override
    public boolean deleteCusByIdAndName(int id, String name) {
        boolean check = false;
        try {
            CustomerList cus = searchByCusIdAndName(id, name);
            em.remove(cus);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean addCus(CustomerList cus) {
        boolean check = false;
        try {
            em.persist(cus);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean editCus(CustomerList cusEdit) {
        boolean check = false;
        try {
            em.merge(cusEdit);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public List<CustomerList> searchByRepresentiveCustomerIdAndBookedID(int customerUserId, String bookedId) {
        List<CustomerList> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.customerID.customerID = :customerID and c.tourBookedID.tourBookedID = :tourBookedID");
            query.setParameter("customerID", customerUserId);
            query.setParameter("tourBookedID", bookedId);

            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<CustomerListHasAge> searchByBookedID(String bookedId) {
        List<CustomerListHasAge> listCusReturn = new ArrayList<>();
        List<CustomerList> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.tourBookedID.tourBookedID = :tourBookedID");
            query.setParameter("tourBookedID", bookedId);

            list = query.getResultList();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy");
            String currentDateString = fm.format(new Date());
            int currentDateInt = Integer.valueOf(currentDateString);
            for (CustomerList cus : list) {
                CustomerListHasAge hasAge = new CustomerListHasAge();
                hasAge.setCusID(cus.getCusID());
                hasAge.setFullName(cus.getFullName());
                hasAge.setSex(cus.getSex());
                hasAge.setDateOfBirth(cus.getDateOfBirth());
                hasAge.setTourBookedID(cus.getTourBookedID());
                hasAge.setCustomerID(cus.getCustomerID());

                String sqlDateString = fm.format(cus.getDateOfBirth());
                int sqlDateInt = Integer.valueOf(sqlDateString);
                int age = currentDateInt - sqlDateInt;
                hasAge.setAge(age);

                listCusReturn.add(hasAge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCusReturn;
    }

    @Override
    public List<CustomerListHasAge> searchByRepresentiveCustomerIdAndBookedID_HasAge(int customerUserId, String bookedID) {
        List<CustomerListHasAge> listCusReturn = new ArrayList<>();
        List<CustomerList> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM CustomerList c WHERE c.customerID.customerID = :customerID and c.tourBookedID.tourBookedID = :tourBookedID");
            query.setParameter("customerID", customerUserId);
            query.setParameter("tourBookedID", bookedID);

            list = query.getResultList();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy");
            String currentDateString = fm.format(new Date());
            int currentDateInt = Integer.valueOf(currentDateString);
            for (CustomerList cus : list) {
                CustomerListHasAge hasAge = new CustomerListHasAge();
                hasAge.setCusID(cus.getCusID());
                hasAge.setFullName(cus.getFullName());
                hasAge.setSex(cus.getSex());
                hasAge.setDateOfBirth(cus.getDateOfBirth());
                hasAge.setTourBookedID(cus.getTourBookedID());
                hasAge.setCustomerID(cus.getCustomerID());

                String sqlDateString = fm.format(cus.getDateOfBirth());
                int sqlDateInt = Integer.valueOf(sqlDateString);
                int age = currentDateInt - sqlDateInt;
                hasAge.setAge(age);

                listCusReturn.add(hasAge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCusReturn;
    }
    ////////////////TOAN END//////////////////
}
