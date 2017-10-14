package entities;

import entities.Car;
import entities.Review;
import entities.Tours;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(ReviewDetail.class)
public class ReviewDetail_ { 

    public static volatile SingularAttribute<ReviewDetail, String> content;
    public static volatile SingularAttribute<ReviewDetail, Tours> tourID;
    public static volatile SingularAttribute<ReviewDetail, Review> reviewID;
    public static volatile SingularAttribute<ReviewDetail, Car> carID;
    public static volatile SingularAttribute<ReviewDetail, Integer> reviewDetailID;
    public static volatile SingularAttribute<ReviewDetail, Short> rating;

}