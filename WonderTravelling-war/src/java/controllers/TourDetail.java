package controllers;

import entities.Comment;
import entities.ReviewDetail;
import entities.Schedule;
import entities.TourBooked;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CommentFacadeLocal;
import sessionbean.ReviewDetailFacadeLocal;
import sessionbean.ScheduleFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class TourDetail extends HttpServlet {
    @EJB
    private CommentFacadeLocal commentFacade;

    @EJB
    private ReviewDetailFacadeLocal reviewDetailFacade;
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;
    @EJB
    private ToursFacadeLocal toursFacade;
    @EJB
    private ScheduleFacadeLocal scheduleFacade;
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String image = null;

            String tourId = request.getParameter("txtTourID");
             System.out.println("TourId of Detail:" + tourId);
            // Get Depatures for Tours
            Tours tour = toursFacade.find(tourId);

            List<String> strDepature = new ArrayList<>();
            String strDate = tour.getDepatureDay();
            String[] str = strDate.split(",");
            String strDefaultDate = "";
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            for (String i : str) {
                if (df.parse(i).compareTo(new Date()) > 0) {
                    strDepature.add(i);
                }
            }
            for (String s : strDepature) {
                strDefaultDate = s;
                break;
            }

            // image for tour and details
            List<Schedule> listSchedule = scheduleFacade.findScheduleByTourID(tourId);
            for (Schedule item : listSchedule) {
                image = item.getImage1();
                break;
            }
            System.out.println("Image Schedule: " + image);
            //// Get Tour Detail and Set rating and Total number people

            List<ReviewDetail> listDetail = reviewDetailFacade.findAll();
            int totalRating = 0;
            int totalNumPeople = 0;
            float rated = 0;
            for (int i = 0; i < listDetail.size(); i++) {
                if (listDetail.get(i).getTourID().getTourID().equalsIgnoreCase(tourId)) {
                    totalRating += listDetail.get(i).getRating();
                    totalNumPeople++;
                }
            }
            if (totalNumPeople <= 0) {
                rated = totalRating;
            } else {
                rated = (float) totalRating / totalNumPeople;
            }


             int parsingRated = Math.round(rated);
            ////////////////////////
             ///Comment------------------
             List<Comment> list = commentFacade.findByTourId(tourId);
                System.out.println("List of tour Comment: " + list.size());
             Collections.sort(list, new Comparator<Comment>(){

                @Override
                public int compare(Comment o1, Comment o2) {
                      if(o1.getCreatedDate().compareTo(o2.getCreatedDate()) > 0) {
                        return -1;
                    }
                    if(o1.getCreatedDate().compareTo(o2.getCreatedDate()) < 0) {
                        return 1;
                    }
                    return 0;
                }
                 
             });
             
             
            request.setAttribute("list", list);
            session.setAttribute("rated", parsingRated);
            session.setAttribute("totalNumPeople", totalNumPeople);
            request.setAttribute("strDefaultDate", strDefaultDate);
            request.setAttribute("strDepature", strDepature);
            session.setAttribute("sTour", tour);
            //   request.setAttribute("tour", tour);
            request.setAttribute("image", image);
            request.setAttribute("listSchedule", listSchedule);
            request.getRequestDispatcher("user/template/tourdetail.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TourDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TourDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
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
