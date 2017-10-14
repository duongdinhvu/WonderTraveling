/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TourCategoryFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class SearchController extends HttpServlet {

    @EJB
    private TourCategoryFacadeLocal tourCategoryFacade;

    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");

        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String depature = request.getParameter("depature");
            String arrival = request.getParameter("arrival");
            String depatureDate = request.getParameter("depatureDate");
            String priceFrom = request.getParameter("priceFrom");
            String priceTo = request.getParameter("priceTo");
            System.out.println("FFFFFFFFFFFFFFFF:" + depature);
            System.out.println("TTTTTTTTTTTT:" + arrival);
             System.out.println("DDDDDDd:" + depatureDate);
            Tours tmp = null;
            List<Tours> list = new ArrayList<>();
            Gson gson = new Gson();
            if (action.equalsIgnoreCase("searchbysubmit")) {

                List<Tours> listSearch = toursFacade.searchToursBySubmit(depature, arrival, depatureDate);
                System.out.println("ListSSSSSs:" + listSearch);
                for (Tours tour : listSearch) {
                    String tourId = tour.getTourID();
                    String tourTitle = tour.getTourTitle();
                    double oddPrice = Double.parseDouble(tour.getOddTourPrice() + "");
                    String depatureDay = tour.getDepatureDay();
                    String depaturePoint = tour.getDepaturePoint();
                    String headingPoint = tour.getHeadingTo();
                    short transportation = Short.parseShort(tour.getTransportation() + "");
                    short tickets = Short.parseShort(tour.getTickets() + "");
                    short duration = Short.parseShort(tour.getDuration() + "");
                    String image = tour.getImage();
                    tmp = new Tours(tourId, tourTitle, oddPrice, depatureDay, depaturePoint, headingPoint, transportation, duration, tickets, image);
                    list.add(tmp);
                }
                System.out.println("List:" + list.size());
                String json = gson.toJson(list);
                response.getWriter().write(json);
            }

            if (action.equalsIgnoreCase("searchbyprice")) {
                List<Tours> listSearch = toursFacade.searchToursByPrice(depature, arrival, depatureDate, Double.parseDouble(priceFrom), Double.parseDouble(priceTo));

                for (Tours tour : listSearch) {
                    String tourId = tour.getTourID();
                    String tourTitle = tour.getTourTitle();
                    double oddPrice = Double.parseDouble(tour.getOddTourPrice() + "");
                    String depatureDay = tour.getDepatureDay();
                    String depaturePoint = tour.getDepaturePoint();
                    String headingPoint = tour.getHeadingTo();
                    short transportation = Short.parseShort(tour.getTransportation() + "");
                    short tickets = Short.parseShort(tour.getTickets() + "");
                    short duration = Short.parseShort(tour.getDuration() + "");
                    String image = tour.getImage();
                    tmp = new Tours(tourId, tourTitle, oddPrice, depatureDay, depaturePoint, headingPoint, transportation, duration, tickets, image);
                    list.add(tmp);
                }
                String json = gson.toJson(list);
                response.getWriter().write(json);
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
