package entities;

import entities.Comment;
import entities.Review;
import entities.ReviewDetail;
import entities.Schedule;
import entities.TourBooked;
import entities.TourBookedSub;
import entities.TourCategory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(Tours.class)
public class Tours_ { 

    public static volatile CollectionAttribute<Tours, Schedule> scheduleCollection;
    public static volatile CollectionAttribute<Tours, TourBooked> tourBookedCollection;
    public static volatile SingularAttribute<Tours, Boolean> status;
    public static volatile CollectionAttribute<Tours, Comment> commentCollection;
    public static volatile SingularAttribute<Tours, String> image;
    public static volatile SingularAttribute<Tours, Double> oddTourPrice;
    public static volatile SingularAttribute<Tours, Short> transportation;
    public static volatile CollectionAttribute<Tours, ReviewDetail> reviewDetailCollection;
    public static volatile SingularAttribute<Tours, String> depatureDay;
    public static volatile SingularAttribute<Tours, String> tourID;
    public static volatile SingularAttribute<Tours, Short> duration;
    public static volatile CollectionAttribute<Tours, Review> reviewCollection;
    public static volatile SingularAttribute<Tours, Short> hotelRank;
    public static volatile SingularAttribute<Tours, String> headingTo;
    public static volatile CollectionAttribute<Tours, TourBookedSub> tourBookedSubCollection;
    public static volatile SingularAttribute<Tours, String> depaturePoint;
    public static volatile SingularAttribute<Tours, Double> evenTourPrice;
    public static volatile SingularAttribute<Tours, String> tourTitle;
    public static volatile SingularAttribute<Tours, Date> createdDate;
    public static volatile SingularAttribute<Tours, Short> tickets;
    public static volatile SingularAttribute<Tours, TourCategory> tourCategoryID;

}