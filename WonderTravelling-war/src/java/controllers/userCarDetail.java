

package controllers;

import entities.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import sessionbean.CarFacadeLocal;

/**
 *
 * @author REY
 */
public class userCarDetail extends HttpServlet {
    
    @EJB
    private CarFacadeLocal carFacade;

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String image = null;
           
            String carId = request.getParameter("txtCarID");

            Car car = carFacade.find(Integer.parseInt(carId));

            List<Car> listCar = carFacade.findListCarOnPage(carId);
            for(Car item: listCar) {
                image = item.getCarImage();
                break;
            }
//            request.setAttribute("strDefaultDate", strDefaultDate);
//            request.setAttribute("strDepature",strDepature );
            session.setAttribute("sCarName", car);
            session.setAttribute("sCarID", car);
            request.setAttribute("image", image);
            request.setAttribute("listCar", listCar);
            request.getRequestDispatcher("user/template/carDetail.jsp").forward(request, response);
            
//            String action = request.getParameter("action");
//            if (action.equals("select")) {
//                //int carID = Integer.parseInt(request.getParameter("carID"));
//                car = carFacade.find(carId);
//                request.setAttribute("id", car);
//                request.getRequestDispatcher("user/template/carDetail.jsp").forward(request, response);
//            }
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
