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
public class AdminTour_TourDetail_Controller extends HttpServlet {

    @EJB
    private ScheduleFacadeLocal scheduleFacade;
    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            
            if (action.equals("btnTourPackageDetail")) {
                
                String tourID = request.getParameter("txtTourIDDetail");
                Tours tourDetail = toursFacade.searchByTourID(tourID);
                Short transportTationShort = tourDetail.getTransportation();
                String transportTation = "";
                if (transportTationShort == 1) {
                    transportTation = "AirPlane";
                } else if (transportTationShort == 2) {
                    transportTation = "Bus";
                } else {
                    transportTation = "Bus, AirPlane";
                }
                
                boolean statusBoolean = tourDetail.getStatus();
                String status = "";
                if (statusBoolean) {
                    status = "Active";
                } else {
                    status = "Deactive";
                }

                List<Schedule> listSchedule = scheduleFacade.countTourID(tourDetail);

                int countSchedule = listSchedule.size();

                if (countSchedule > 0) {
                    Short time = tourDetail.getDuration();
                    
                    request.setAttribute("listShedule", listSchedule);
                    
                    request.setAttribute("status", status);
                    request.setAttribute("duration", time + " Days " + (time - 1) + " Nights");
                    request.setAttribute("transport", transportTation);
                    request.setAttribute("tour", tourDetail);
                    request.getRequestDispatcher("/admin/tourDetail.jsp").forward(request, response);
                } else {
                    request.setAttribute("status", status);
                    request.setAttribute("transport", transportTation);
                    request.setAttribute("tour", tourDetail);
                    request.getRequestDispatcher("/admin/tourDetailWithoutSchedule.jsp").forward(request, response);
                }

            } else {
//                request.setAttribute("list", toursFacade.tourList());
//                request.setAttribute("maxSchedule", 0);
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
