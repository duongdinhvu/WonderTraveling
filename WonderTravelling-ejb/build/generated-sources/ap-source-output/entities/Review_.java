package entities;

import entities.Car;
import entities.CustomerUser;
import entities.ReviewDetail;
import entities.Tours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, Tours> tourID;
    public static volatile SingularAttribute<Review, Integer> reviewID;
    public static volatile SingularAttribute<Review, Car> carID;
    public static volatile CollectionAttribute<Review, ReviewDetail> reviewDetailCollection;
    public static volatile SingularAttribute<Review, CustomerUser> customerID;
    public static volatile SingularAttribute<Review, Date> createdDate;

}