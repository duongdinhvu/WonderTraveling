/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entities.ReviewDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface ReviewDetailFacadeLocal {

    void create(ReviewDetail reviewDetail);

    void edit(ReviewDetail reviewDetail);

    void remove(ReviewDetail reviewDetail);

    ReviewDetail find(Object id);

    List<ReviewDetail> findAll();

    List<ReviewDetail> findRange(int[] range);

    int count();
    
}
