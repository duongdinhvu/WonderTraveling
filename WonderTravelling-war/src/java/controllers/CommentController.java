/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Car;
import entities.Comment;
import entities.CustomerUser;
import entities.ReviewDetail;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CarFacadeLocal;
import sessionbean.CommentFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;

/**
 *
 * @author vahu
 */
public class CommentController extends HttpServlet {

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;
    @EJB
    private CommentFacadeLocal commentFacade;
    @EJB
    private CarFacadeLocal carFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            String content = request.getParameter("txtComment");
            String isUserRated = request.getParameter("txtUser");

            CustomerUser customeruser = customerUserFacade.getCustomerUser(isUserRated);
            Tours tour = (Tours) session.getAttribute("sTour");
            String tourId = tour.getTourID();
            Car car = carFacade.find(1);


            if (action.equalsIgnoreCase("Comment")) {
                Date date = new Date();
                Comment cm = new Comment();
                cm.setContent(content);
                cm.setCustomerID(customeruser);
                cm.setCarID(car);
                cm.setTourID(tour);
                cm.setCreatedDate(date);
                commentFacade.create(cm);
                
                
            }
            List<Comment> list = commentFacade.findByTourId(tourId);
         
   
            request.setAttribute("list", list);
            request.getRequestDispatcher("TourDetail?txtTourID="+tourId).forward(request, response);
   
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
