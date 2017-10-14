package entities;

import entities.Car;
import entities.CustomerUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(CarBooked.class)
public class CarBooked_ { 

    public static volatile SingularAttribute<CarBooked, Integer> carBookedID;
    public static volatile SingularAttribute<CarBooked, Short> payment;
    public static volatile SingularAttribute<CarBooked, Double> deposit;
    public static volatile SingularAttribute<CarBooked, String> promotionCode;
    public static volatile SingularAttribute<CarBooked, Double> extra;
    public static volatile SingularAttribute<CarBooked, String> code;
    public static volatile SingularAttribute<CarBooked, Date> carRealityDate;
    public static volatile SingularAttribute<CarBooked, Short> carBookedStatus;
    public static volatile SingularAttribute<CarBooked, Date> carReturnCaDate;
    public static volatile SingularAttribute<CarBooked, Car> carID;
    public static volatile SingularAttribute<CarBooked, Double> price;
    public static volatile SingularAttribute<CarBooked, Integer> quantity;
    public static volatile SingularAttribute<CarBooked, Date> carRecieveDate;
    public static volatile SingularAttribute<CarBooked, CustomerUser> customerID;
    public static volatile SingularAttribute<CarBooked, Date> createdDate;

}