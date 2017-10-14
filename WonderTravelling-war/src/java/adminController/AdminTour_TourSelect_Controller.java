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
import java.util.ArrayList;
import java.util.Collections;
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
public class AdminTour_TourSelect_Controller extends HttpServlet {

    @EJB
    private ScheduleFacadeLocal scheduleFacade;
    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            List<Tours> listTour = toursFacade.tourList();

            for (int i = 0; i < listTour.size(); i++) {
                List<Schedule> listSchedule = scheduleFacade.countTourID(listTour.get(i));

                String tourTitle = listTour.get(i).getTourTitle();
                String[] tourTitleArray = tourTitle.split(" ");
                ArrayList<String> tourTitleArrayList = new ArrayList<>();
                for (String element : tourTitleArray) {
                    tourTitleArrayList.add(element);
                }

                ArrayList<Integer> listInteger = new ArrayList<>();
                listInteger.add(0);
                for (String element : tourTitleArrayList) {
                    if (element.equals("1") || element.equals("2") || element.equals("3")
                            || element.equals("4") || element.equals("5") || element.equals("6")
                            || element.equals("7") || element.equals("8") || element.equals("9") || element.equals("10")) {
                        listInteger.add(Integer.valueOf(element));
                    }
                }

                Object obj = Collections.max(listInteger);
                int maxScheduleFromTitle = Integer.valueOf(obj + "");
                
                int countSchedule = listSchedule.size();
                if (countSchedule < maxScheduleFromTitle) {
                    toursFacade.updateStatus(listTour.get(i).getTourID(), false);
                }

            }
            List<Tours> listTourAfterCheckStatus = toursFacade.tourList();

            request.setAttribute("checkStatus", "0");
            request.setAttribute("maxSchedule", 0);
            request.setAttribute("list", listTourAfterCheckStatus);
            request.getRequestDispatcher("/admin/tourPackages.jsp").forward(request, response);
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
