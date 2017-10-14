/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.TourBooked;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class TicketsAvailable extends HttpServlet {

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;
    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            Tours tours = (Tours) session.getAttribute("sTour");
            String tourId = tours.getTourID();
            String depature = request.getParameter("depature");
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("checktickets")) {
                List<TourBooked> tmp = new ArrayList<>();

                List<TourBooked> listTourBooked = tourBookedFacade.getBookedQuantity(tourId);

                DateFormat df = new SimpleDateFormat("dd-MM-YYYY");

                for (TourBooked item : listTourBooked) {

                    String str1 = df.format(item.getDepartureDate());
                    String str2 = depature;

                    if (str1.equals(str2.trim())) {

                        tmp.add(item);
                    }
                }

                int total = 0;
                for (TourBooked item : tmp) {
                    total += (item.getNumberOfAdult() + item.getNumberOfKid());
                }

                Tours tour = toursFacade.find(tourId);

                int tickets = tour.getTickets();

                int ticketsAvailable = tickets - total;

                Gson gson = new Gson();
                String json = gson.toJson(ticketsAvailable);
                response.getWriter().write(json);
                System.out.println("Tickets:" + json);

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
