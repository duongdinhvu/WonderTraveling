/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Schedule;
import entities.Tours;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vahu
 */
@Local
public interface ScheduleFacadeLocal {

    void create(Schedule schedule);

    void edit(Schedule schedule);

    void remove(Schedule schedule);

    Schedule find(Object id);

    List<Schedule> findAll();

    List<Schedule> findRange(int[] range);

    int count();

    List<Schedule> findScheduleByTourID(String tourID);

    ///////////////TOAN///////////////////////
    boolean insertSchedule(Schedule s);

    boolean deleteSchedule(int id);

    List<Schedule> countTourID(Tours t);

    Schedule searchById(int id);

    boolean updateSchedule(Schedule s);
    //////////////TOAN END///////////////////
}
