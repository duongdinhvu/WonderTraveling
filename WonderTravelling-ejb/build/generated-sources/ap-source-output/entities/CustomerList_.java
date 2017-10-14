package entities;

import entities.CustomerUser;
import entities.TourBooked;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(CustomerList.class)
public class CustomerList_ { 

    public static volatile SingularAttribute<CustomerList, Date> dateOfBirth;
    public static volatile SingularAttribute<CustomerList, Boolean> sex;
    public static volatile SingularAttribute<CustomerList, TourBooked> tourBookedID;
    public static volatile SingularAttribute<CustomerList, String> fullName;
    public static volatile SingularAttribute<CustomerList, CustomerUser> customerID;
    public static volatile SingularAttribute<CustomerList, Integer> cusID;

}