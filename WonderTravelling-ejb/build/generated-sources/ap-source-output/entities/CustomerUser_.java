package entities;

import entities.CarBooked;
import entities.Comment;
import entities.CustomerList;
import entities.Review;
import entities.Role;
import entities.TourBooked;
import entities.TourBookedSub;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(CustomerUser.class)
public class CustomerUser_ { 

    public static volatile CollectionAttribute<CustomerUser, TourBooked> tourBookedCollection;
    public static volatile SingularAttribute<CustomerUser, String> phone;
    public static volatile CollectionAttribute<CustomerUser, CarBooked> carBookedCollection;
    public static volatile CollectionAttribute<CustomerUser, Comment> commentCollection;
    public static volatile SingularAttribute<CustomerUser, Boolean> status;
    public static volatile SingularAttribute<CustomerUser, String> password;
    public static volatile CollectionAttribute<CustomerUser, Review> reviewCollection;
    public static volatile SingularAttribute<CustomerUser, String> email;
    public static volatile SingularAttribute<CustomerUser, String> customerUsername;
    public static volatile CollectionAttribute<CustomerUser, CustomerList> customerListCollection;
    public static volatile SingularAttribute<CustomerUser, String> fullName;
    public static volatile CollectionAttribute<CustomerUser, TourBookedSub> tourBookedSubCollection;
    public static volatile SingularAttribute<CustomerUser, Integer> customerID;
    public static volatile SingularAttribute<CustomerUser, Role> roleID;

}