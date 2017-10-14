/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.Schedule;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.ScheduleFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_ScheduleInsert_Controller extends HttpServlet {

    @EJB
    private ScheduleFacadeLocal scheduleFacade;
    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            if (action.equals("btnCreateSchedule")) {
                String tourTitle = request.getParameter("txtTourTitle");
                String tourID = request.getParameter("txtTourID");

                String scheduleTitle = request.getParameter("txtScheduleTitle");
                String imagePath = request.getParameter("txtImage_Insert_Extra");
                String content = request.getParameter("txtAreaContent");

                Tours tour = toursFacade.searchByTourID(tourID);

                Schedule schedule = new Schedule();

                schedule.setSummary(scheduleTitle);
                schedule.setContent(content);
                schedule.setImage1(imagePath);
                schedule.setImage2("");
                schedule.setImage3("");
                schedule.setImage4("");
                schedule.setImage5("");
                schedule.setTourID(tour);

                
                int maxSchedule = Integer.valueOf(request.getParameter("maxSchedule"));
                
                if (scheduleFacade.insertSchedule(schedule)) {
                    
                    int i = 1;
                    int tourDuration = 0;
                    List<Schedule> list = scheduleFacade.countTourID(tour);
                    for (Schedule s : list) {
                        i++;
                        tourDuration++;
                    }
                    //update Duration in table Tours
                    toursFacade.updateDuration(tourID, Short.valueOf(tourDuration + ""));

                    if (i <= maxSchedule) {
                        String days = "Scheduling Day " + i;
                        request.setAttribute("tourTitle", tourTitle);
                        request.setAttribute("tourID", tourID);
                        request.setAttribute("dayTitles", days);
                        request.setAttribute("maxSchedule", maxSchedule);
                        request.setAttribute("isCompleted", 0);
                        request.getRequestDispatcher("/admin/scheduleInsertForm.jsp").forward(request, response);
                    } else {
                        request.setAttribute("tourTitle", tourTitle);
                        request.setAttribute("tourID", tourID);
                        request.setAttribute("dayTitles", "");
                        request.setAttribute("maxSchedule", maxSchedule);
                        request.setAttribute("isCompleted", 1);
                        request.getRequestDispatcher("/admin/scheduleInsertForm.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("list", toursFacade.tourList());
                request.getRequestDispatcher("AdminTour_TourSelect_Controller").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
