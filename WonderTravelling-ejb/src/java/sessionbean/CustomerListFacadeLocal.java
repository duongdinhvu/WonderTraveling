/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CustomerList;
import entities.CustomerListHasAge;
import entities.CustomerUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface CustomerListFacadeLocal {

    void create(CustomerList customerList);

    void edit(CustomerList customerList);

    void remove(CustomerList customerList);

    CustomerList find(Object id);

    List<CustomerList> findAll();

    List<CustomerList> findRange(int[] range);

    int count();

    ////TOAN//////////////////////////////
    List<CustomerList> searchByRepresentiveCustomer (CustomerUser cus);
    
    List<CustomerList> searchByRepresentiveCustomerIdAndBookedID (int customerUserId, String bookedID);
    
    List<CustomerListHasAge> searchByBookedID (String bookedID);
    //NEW
    List<CustomerListHasAge> searchByRepresentiveCustomerIdAndBookedID_HasAge (int customerUserId, String bookedID);
    
    boolean deleteCusByIdAndName (int id, String name);
    
    boolean addCus (CustomerList cus);
    
    CustomerList searchByCusIdAndName (int id, String name);
    
    CustomerListHasAge searchByCusIdHasAge (int id);
    
    boolean editCus (CustomerList cusEdit);
    /////////////TOAN - END////////////////
}
