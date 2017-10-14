/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.adminController;

//import entities.CarBookedDetail;
import entities.Car;
import entities.CarBooked;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import sessionbean.CarBookedDetailFacadeLocal;
import sessionbean.CarBookedFacadeLocal;
import sessionbean.CarFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;

/**
 *
 * @author REY
 */
public class adminCarBookedDisplayController extends HttpServlet {
//    @EJB
//    private CarBookedDetailFacadeLocal carBookedDetailFacade;
    
    @EJB
    private CustomerUserFacadeLocal customerUserFacade;
    @EJB
    private CarBookedFacadeLocal carBookedFacade;
    @EJB
    private CarFacadeLocal carFacade;
    
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("customerList", customerUserFacade.findAll());            
            //request.setAttribute("carBk", carBookedFacade.findAll());
            request.setAttribute("car", carBookedFacade.findAll());
            
            List<CarBooked> bList = new ArrayList<CarBooked>();
            
            bList = carBookedFacade.findAll();
            
            Collections.sort(bList, new Comparator<CarBooked>() {
                @Override
                public int compare(CarBooked cus1, CarBooked cus2) {
                        if (cus1.getCarBookedID() > cus2.getCarBookedID()) {
                            return -1;
                        }
                        if (cus1.getCarBookedID() < cus2.getCarBookedID()) {
                            return 1;
                        }
                        return 0;
                    }
                });
            request.setAttribute("carBk", bList);
//            List<CarBookedDetail> productList = carBookedDetailFacade.findAll();
//                List<CarBookedDetail> search = new ArrayList<>();
//                for (CarBookedDetail item : productList) {
////                    if (item.getManufacturerID().getManufacturerID().equals(Integer.parseInt(search2))) {
////                        search.add(item);
////                    }
//                    if (item.getCarBookedID().getCarBookedID().equals(carBookedFacade.find(item))) {
//                        search.add(item);
//                    }
//                }
            
            request.getRequestDispatcher("admin/adminCarBookedDisplay.jsp").forward(request, response);
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
