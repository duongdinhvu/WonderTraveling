/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.adminController;

import entities.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CarBookedFacadeLocal;
import sessionbean.CarFacadeLocal;

/**
 *
 * @author REY
 */
public class adminCarListController extends HttpServlet {

    @EJB
    private CarBookedFacadeLocal carBookedDetailFacade;
    @EJB
    private CarFacadeLocal carFacade;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //request.setAttribute("cars", carFacade.findAll());
            List<Car> carList = new ArrayList<>();
            carList = carFacade.findAll();
            
            Collections.sort(carList, new Comparator<Car>() {
                @Override
                public int compare(Car cus1, Car cus2) {
                        if (cus1.getCarID() > cus2.getCarID()) {
                            return -1;
                        }
                        if (cus1.getCarID() < cus2.getCarID()) {
                            return 1;
                        }
                        return 0;
                    }
                });
            request.setAttribute("cars", carList);
            
            request.getRequestDispatcher("admin/adminCarDisplay.jsp").forward(request, response);
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
