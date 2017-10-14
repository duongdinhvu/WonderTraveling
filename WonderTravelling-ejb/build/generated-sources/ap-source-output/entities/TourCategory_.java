package entities;

import entities.Tours;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-10-09T16:25:08")
@StaticMetamodel(TourCategory.class)
public class TourCategory_ { 

    public static volatile CollectionAttribute<TourCategory, Tours> toursCollection;
    public static volatile SingularAttribute<TourCategory, String> tourCategoryName;
    public static volatile SingularAttribute<TourCategory, Integer> tourCategoryID;
    public static volatile SingularAttribute<TourCategory, String> destination;

}