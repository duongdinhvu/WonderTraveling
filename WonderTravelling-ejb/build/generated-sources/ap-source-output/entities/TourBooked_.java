package entities;

import entities.CustomerList;
import entities.CustomerUser;
import entities.Promotion;
import entities.TourBookedSub;
import entities.Tours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(TourBooked.class)
public class TourBooked_ { 

    public static volatile SingularAttribute<TourBooked, Short> numberOfPeople;
    public static volatile SingularAttribute<TourBooked, Short> numberOfKid;
    public static volatile SingularAttribute<TourBooked, Date> departureDate;
    public static volatile SingularAttribute<TourBooked, Short> status;
    public static volatile SingularAttribute<TourBooked, Boolean> isNew;
    public static volatile SingularAttribute<TourBooked, Short> transportation;
    public static volatile SingularAttribute<TourBooked, Promotion> promotionID;
    public static volatile SingularAttribute<TourBooked, Tours> tourID;
    public static volatile SingularAttribute<TourBooked, String> tourBookedID;
    public static volatile SingularAttribute<TourBooked, Short> numberOfAdult;
    public static volatile SingularAttribute<TourBooked, Short> numberOfBaby;
    public static volatile SingularAttribute<TourBooked, Short> individualRoom;
    public static volatile CollectionAttribute<TourBooked, CustomerList> customerListCollection;
    public static volatile CollectionAttribute<TourBooked, TourBookedSub> tourBookedSubCollection;
    public static volatile SingularAttribute<TourBooked, CustomerUser> customerID;
    public static volatile SingularAttribute<TourBooked, Date> createdDate;
    public static volatile SingularAttribute<TourBooked, Boolean> iSGroup;

}