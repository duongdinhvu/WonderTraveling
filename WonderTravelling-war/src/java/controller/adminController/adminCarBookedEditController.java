/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adminController;

import entities.Car;
import entities.CarBooked;
//import entities.CarBookedDetail;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
//import sessionbean.CarBookedDetailFacadeLocal;
import sessionbean.CarBookedFacadeLocal;
import sessionbean.CarFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;

/**
 *
 * @author REY
 */
public class adminCarBookedEditController extends HttpServlet {

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

            String action = request.getParameter("action");
            System.out.println("Actionnnnnnnnnnnnnnnnn:" + action);
            if (action.equals("view")) {
                String carBookedID = request.getParameter("carBookedID");

                List<CarBooked> list1 = carBookedFacade.findAll();
                List<CarBooked> listSearch = new ArrayList<>();

                for (CarBooked carBook : list1) {
                    if ((carBook.getCarBookedID()).equals(carBookedID)) {
                        listSearch.add(carBook);
                    }
                }
                request.setAttribute("car", listSearch);

                request.getRequestDispatcher("admin/adminCarBookedDetailDisplay.jsp").forward(request, response);
            }

            if (action.equals("edit")) {
                String carBookedID = request.getParameter("carBookedID");

                CarBooked car = carBookedFacade.find(Integer.parseInt(carBookedID));
                request.setAttribute("id", car);
                request.getRequestDispatcher("admin/adminCarBookedEdit.jsp").forward(request, response);
            }

            if (action.equals("update")) {

                //Return Date
                String returnDate = request.getParameter("txtReturnDate");

                SimpleDateFormat sfm2 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p3 = new ParsePosition(0);
                Date retDate = sfm2.parse(returnDate, p3);

                //Real Date
                String realDate = request.getParameter("txtRealDate");

                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p1 = new ParsePosition(0);
                Date rDate = sfm.parse(realDate, p1);

                //Real Date Update
                String realDateUpdate = request.getParameter("txtRealDateUpdate");

                SimpleDateFormat sfm1 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p2 = new ParsePosition(0);
                Date rDateUpdate = sfm1.parse(realDateUpdate, p2);

                if (realDateUpdate.length() == 0) {
                    realDateUpdate = realDate;
                }

                //Booked ID
                String carBookedID = request.getParameter("txtCarBookedID");
                
                String proCode = request.getParameter("txtProCode");
                
                String pay = request.getParameter("txtPay");
                
                String cardCode = "0";
                
                if (pay.equals("2")) {
                    cardCode = request.getParameter("txtCode");
                }
                else if (pay.equals("1")) {
                    cardCode = "0";
                }

                String status = request.getParameter("txtStatus");

                double extra = Float.parseFloat(request.getParameter("txtExtra"));

                long startTime = retDate.getTime();
                long endTime = rDateUpdate.getTime();
                long diffTime = endTime - startTime;
                long diffDays = 0;

                if (diffTime == 0 && extra == 0) {
                    diffDays = 0;
                    extra = 0;
                } else if (diffTime == 0 && extra != 0) {
                    diffDays = 0;
                    extra = 0;
                } else if (diffTime != 0 && extra == 0) {
                    diffDays = diffTime / (1000 * 60 * 60 * 24);
                    extra = (diffDays) * 500;
                } else if (diffTime != 0 && extra != 0) {
                    diffDays = diffTime / (1000 * 60 * 60 * 24);
                    extra = (diffDays) * 500;
                }
                
                //double deposit;

                CarBooked carBooked = carBookedFacade.find(Integer.parseInt(carBookedID));

                carBooked.setCarBookedStatus(Short.parseShort(status));
                carBooked.setCarRealityDate(rDateUpdate);
                carBooked.setExtra(extra);
                carBooked.setCode(cardCode);
                carBooked.setPayment(Short.parseShort(pay));
                carBooked.setPromotionCode(proCode);
                
                //carBooked.setDeposit(deposit);
                
                carBookedFacade.edit(carBooked);
                request.getRequestDispatcher("adminCarBookedDisplayController").forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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
