package entities;

import entities.Car;
import entities.CustomerUser;
import entities.Tours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, Tours> tourID;
    public static volatile SingularAttribute<Comment, Car> carID;
    public static volatile SingularAttribute<Comment, Integer> commentID;
    public static volatile SingularAttribute<Comment, CustomerUser> customerID;
    public static volatile SingularAttribute<Comment, Date> createdDate;

}