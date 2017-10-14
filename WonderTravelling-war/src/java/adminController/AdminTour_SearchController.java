/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import com.google.gson.Gson;
import entities.TourCategory;
import entities.TourCategory_;
import entities.TourSearchDTO;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author dieut
 */
public class AdminTour_SearchController extends HttpServlet {
    @EJB
    private TourCategoryFacadeLocal tourCategoryFacade;

    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String depature = request.getParameter("depature");
            String arrival = request.getParameter("arrival");
            String depatureDate = request.getParameter("depatureDate");

            List<TourSearchDTO> list = new ArrayList<>();
            Gson gson = new Gson();
            if (action.equalsIgnoreCase("searchbysubmit")) {
                
                List<TourSearchDTO> listSearch = toursFacade.searchToursBySubmit_Toan(depature, arrival, depatureDate);

                for (TourSearchDTO tour : listSearch) {
                    TourSearchDTO tmp = new TourSearchDTO();
                    tmp.setTourID(tour.getTourID());
                    tmp.setTourTitle(tour.getTourTitle());
                    double oddPrice = Double.parseDouble(tour.getOddTourPrice() + "");
                    tmp.setOddTourPrice(oddPrice);
                    double evenPrice = Double.parseDouble(tour.getEvenTourPrice() + "");
                    tmp.setEvenTourPrice(evenPrice);
                    tmp.setDepatureDay(tour.getDepatureDay());
                    tmp.setDepaturePoint(tour.getDepaturePoint());
                    tmp.setHeadingTo(tour.getHeadingTo());
                    short transportation = Short.parseShort(tour.getTransportation() + "");
                    tmp.setTransportation(transportation);
                    short tickets = Short.parseShort(tour.getTickets() + "");
                    tmp.setTickets(tickets);
                    short duration = Short.parseShort(tour.getDuration() + "");
                    tmp.setDuration(duration);
                    short hotelRank = Short.parseShort(tour.getHotelRank() + "");
                    tmp.setHotelRank(hotelRank);
                    String image = tour.getImage();
                    tmp.setImage(image);
                    int tourCategoryID = tour.getTourCategoryID();
                    tmp.setTourCategoryID(tourCategoryID);
                    String tourCategoryName = tour.getTourCategoryName();
                    tmp.setTourCategoryName(tourCategoryName);
                    String destination = tour.getDestination();
                    tmp.setDestination(destination);
                    boolean status = tour.getStatus();
                    tmp.setStatus(status);
                    
                    Date createdDate = tour.getCreatedDate();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    String createD = fm.format(createdDate);
                    ParsePosition p = new ParsePosition(0);
                    Date dateAfterFormat = fm.parse(createD, p);
                    tmp.setCreatedDate(dateAfterFormat);
                    
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
