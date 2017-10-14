/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.TourBooked;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TourBookedFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_TourReserved_Select_Controller extends HttpServlet {

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            List<TourBooked> pendingList = tourBookedFacade.selectTourBooked_PendingStatus();

            List<TourBooked> departingList = tourBookedFacade.selectTourBooked_DepartingStatus();

            List<TourBooked> completedList = tourBookedFacade.selectTourBooked_CompletedStatus();

            List<TourBooked> cancelList = tourBookedFacade.selectTourBooked_CancelStatus();

            Collections.sort(pendingList, new Comparator<TourBooked>() {
                @Override
                public int compare(TourBooked tour1, TourBooked tour2) {
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) > 0) {
                        return -1;
                    }
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });

            Collections.sort(departingList, new Comparator<TourBooked>() {
                @Override
                public int compare(TourBooked tour1, TourBooked tour2) {
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) > 0) {
                        return -1;
                    }
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });

            Collections.sort(completedList, new Comparator<TourBooked>() {
                @Override
                public int compare(TourBooked tour1, TourBooked tour2) {
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) > 0) {
                        return -1;
                    }
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });

            Collections.sort(cancelList, new Comparator<TourBooked>() {
                @Override
                public int compare(TourBooked tour1, TourBooked tour2) {
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) > 0) {
                        return -1;
                    }
                    if (tour1.getCreatedDate().compareTo(tour2.getCreatedDate()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });

            request.setAttribute("PendingList", pendingList);
            request.setAttribute("DepartingList", departingList);
            request.setAttribute("CompletedList", completedList);
            request.setAttribute("CancelList", cancelList);

            request.getRequestDispatcher("/admin/adminTour_TourBooked.jsp").forward(request, response);
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
