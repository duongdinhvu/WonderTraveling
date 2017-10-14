package entities;

import entities.CarBooked;
import entities.ReviewDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile CollectionAttribute<Car, CarBooked> carBookedCollection;
    public static volatile SingularAttribute<Car, Short> carSeats;
    public static volatile CollectionAttribute<Car, ReviewDetail> reviewDetailCollection;
    public static volatile SingularAttribute<Car, String> carTrasmission;
    public static volatile SingularAttribute<Car, Boolean> carGPS;
    public static volatile SingularAttribute<Car, String> licensePlate;
    public static volatile SingularAttribute<Car, Integer> carID;
    public static volatile SingularAttribute<Car, Boolean> carAirConditioning;
    public static volatile SingularAttribute<Car, Boolean> carStatus;
    public static volatile SingularAttribute<Car, String> carName;
    public static volatile SingularAttribute<Car, Short> carDoors;
    public static volatile SingularAttribute<Car, Double> carPrice;
    public static volatile SingularAttribute<Car, Boolean> carPushChair;
    public static volatile SingularAttribute<Car, String> carImage;

}