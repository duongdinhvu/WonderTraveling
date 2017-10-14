/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Schedule;
import entities.Tours;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vahu
 */
@Stateless
public class ScheduleFacade extends AbstractFacade<Schedule> implements ScheduleFacadeLocal {

    @PersistenceContext(unitName = "WonderTravelling-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScheduleFacade() {
        super(Schedule.class);
    }

    @Override
    public List<Schedule> findScheduleByTourID(String tourID) {
        List<Schedule> list = null;
        try {
            Tours tour = em.find(Tours.class, tourID);
            list = (List<Schedule>) tour.getScheduleCollection();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return list;
    }

    /////////////////////TOAN /////////////////////////
    @Override
    public boolean insertSchedule(Schedule s) {
        boolean check = false;
        try {
            em.persist(s);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Schedule> countTourID(Tours t) {
        List<Schedule> list = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT s FROM Schedule s WHERE s.tourID = :tour");
            query.setParameter("tour", t);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteSchedule(int id) {
        boolean check = false;
        try {
            Schedule scheduleDelete = em.find(Schedule.class, id);
            em.remove(scheduleDelete);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }

    @Override
    public Schedule searchById(int id) {
        Schedule schedule = null;
        try {
            schedule = em.find(Schedule.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schedule;
    }

    @Override
    public boolean updateSchedule(Schedule s) {
        boolean check = false;
        try {
            em.merge(s);
            check = true;
        } catch (Exception e) {
            check = false;
            e.printStackTrace();
        }

        return check;
    }
    ////////////////////TOAN END//////////////////////
}
