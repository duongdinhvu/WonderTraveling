package entities;

import entities.CustomerUser;
import entities.TourBooked;
import entities.Tours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(TourBookedSub.class)
public class TourBookedSub_ { 

    public static volatile SingularAttribute<TourBookedSub, Tours> tourID;
    public static volatile SingularAttribute<TourBookedSub, Short> numberOfPeople;
    public static volatile SingularAttribute<TourBookedSub, TourBooked> tourBookedID;
    public static volatile SingularAttribute<TourBookedSub, Short> numberOfKid;
    public static volatile SingularAttribute<TourBookedSub, Short> status;
    public static volatile SingularAttribute<TourBookedSub, Date> departureDate;
    public static volatile SingularAttribute<TourBookedSub, Boolean> isNew;
    public static volatile SingularAttribute<TourBookedSub, Short> numberOfAdult;
    public static volatile SingularAttribute<TourBookedSub, Short> individualRoom;
    public static volatile SingularAttribute<TourBookedSub, Short> numberOfBaby;
    public static volatile SingularAttribute<TourBookedSub, Short> transportation;
    public static volatile SingularAttribute<TourBookedSub, CustomerUser> customerID;
    public static volatile SingularAttribute<TourBookedSub, Date> createdDate;
    public static volatile SingularAttribute<TourBookedSub, Integer> tourBookedSubID;

}