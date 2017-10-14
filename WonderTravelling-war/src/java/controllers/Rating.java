/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Car;
import entities.CustomerUser;
import entities.Review;
import entities.ReviewDetail;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CarFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;
import sessionbean.ReviewDetailFacadeLocal;
import sessionbean.ReviewFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class Rating extends HttpServlet {
    @EJB
    private ToursFacadeLocal toursFacade;

    @EJB
    private CarFacadeLocal carFacade;
    
    @EJB
    private CustomerUserFacadeLocal customerUserFacade;
    
    @EJB
    private ReviewDetailFacadeLocal reviewDetailFacade;
    @EJB
    private ReviewFacadeLocal reviewFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            String rating = request.getParameter("rating");
            String isUserRated = request.getParameter("isRated");
            
            CustomerUser customeruser = customerUserFacade.getCustomerUser(isUserRated);
            Tours tour = (Tours) session.getAttribute("sTour");
            Gson gson = new Gson();
            List<ReviewDetail> listDetail = new ArrayList<>();
           
            if (action.equalsIgnoreCase("rate")) {
       
                if (!reviewFacade.findByUserName(customeruser.getCustomerID(), tour.getTourID())) {
                    ///// Insert into Review table
                    
                    Review reviewNew = new Review();
                    reviewNew.setCustomerID(customeruser);
                    reviewNew.setCarID(carFacade.find(1));
                    reviewNew.setTourID(toursFacade.find(tour.getTourID()));
                    reviewNew.setCreatedDate(new Date());
                    
                    reviewFacade.create(reviewNew);
                    
                    List<Review> newList = reviewFacade.findAll();
                    
                    Review tmp = new Review();

                    for(int i = 0; i < newList.size(); i++) {
                        if((i + 1) == newList.size()) {
                            tmp = newList.get(i);
                        }
                    }

                    ///// Insert into Review Detail table
                    Review getReview = reviewFacade.find(tmp.getReviewID());
                    
                    ReviewDetail rvDetail = new ReviewDetail();
                    rvDetail.setContent("Nothing");
                    rvDetail.setRating(Short.parseShort(rating));
                    rvDetail.setReviewID(getReview);
                    rvDetail.setCarID(carFacade.find(1));
                    rvDetail.setTourID(toursFacade.find(tour.getTourID()));
                    
                    reviewDetailFacade.create(rvDetail);
                    
                    List<ReviewDetail> listAll = reviewDetailFacade.findAll();
                    ReviewDetail rvTMP = null;
                    for (ReviewDetail rv : listAll) {
                        if (rv.getTourID().getTourID().equalsIgnoreCase(tour.getTourID())) {
                            rvTMP = new ReviewDetail(rv.getRating());
                            listDetail.add(rvTMP);
                        }
                    }
                    
                    String json = gson.toJson(listDetail);
                    response.getWriter().write(json);
                    System.out.println("Json:" + json);
                }
                  
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
