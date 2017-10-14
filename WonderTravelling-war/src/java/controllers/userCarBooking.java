/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entities.Car;
import entities.CarBooked;
import entities.CustomerUser;
import entities.Promotion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CarBookedFacadeLocal;
import sessionbean.CarFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;
import sessionbean.PromotionFacadeLocal;

/**
 *
 * @author REY
 */
public class userCarBooking extends HttpServlet {

    @EJB
    private CarBookedFacadeLocal carBookedFacade;

    @EJB
    private PromotionFacadeLocal promotionFacade;

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;

    @EJB
    private CarFacadeLocal carFacade;
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            HttpSession session = request.getSession();

            if (action.equals("book")) {
                int carID = Integer.parseInt(request.getParameter("carID"));
                Car car = carFacade.find(carID);
                request.setAttribute("id", car);

//                int proID = Integer.parseInt(request.getParameter("txtProID"));
                request.setAttribute("promotionID", promotionFacade.findAll());

                //int cusID = 11;
                String username = (String) session.getAttribute("sessionUser");
                CustomerUser customerUser = customerUserFacade.getCustomerUser(username);

                session.setAttribute("Customeruser", customerUser);

                String returnDate = request.getParameter("txtReturnDate");

                String reiDate = request.getParameter("txtReiveDate");
                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date receiveDate = sfm.parse(reiDate, p);
                request.setAttribute("rei", receiveDate);

                request.getRequestDispatcher("user/template/carbooking1.jsp").forward(request, response);
            }

            if (action.equals("bookStep2")) {
                int carID = Integer.parseInt(request.getParameter("txtcarIDBook"));
                Car car = carFacade.find(carID);
                request.setAttribute("id", car);

                List<Promotion> promotion1 = promotionFacade.findAll();
                Promotion promotion = new Promotion();
                String pro = request.getParameter("txtProID");
                

                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                request.setAttribute("quan", quantity);

                Double price = Double.parseDouble(request.getParameter("txtcarPriceBook"));

                String reiDate = request.getParameter("txtRecDate");
                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date rec = sfm.parse(reiDate, p);
                request.setAttribute("rec", rec);

                String retDate = request.getParameter("txtReturnDate");
                SimpleDateFormat sfm2 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p2 = new ParsePosition(0);
                Date ret = sfm.parse(retDate, p2);
                request.setAttribute("ret", ret);

                int cusID = Integer.parseInt(request.getParameter("txtCusID"));
                CustomerUser customerUser = customerUserFacade.find(cusID);
                session.setAttribute("Customeruser", customerUser);

                long startTime = rec.getTime();
                long endTime = ret.getTime();
                long diffTime = endTime - startTime;
                long diffDays = 0;

                if (diffTime != 0) {
                    diffDays = diffTime / (1000 * 60 * 60 * 24);
                    price = (((diffDays) * price) * quantity);
                    //request.setAttribute("price", price);
                }

                if (diffTime == 0) {
                    diffDays = 1;
                    price = (((diffDays) * price) * quantity);
                    //request.setAttribute("price", price);
                }

                for (Promotion prom : promotion1) {
                    prom.getPromotionCode();
                    //promotion1.add(prom);
                    if (pro.trim().equals(prom.getPromotionCode()) && prom.getStatus() == 1) {
                        price = price - (price * 0.2);    
                        request.setAttribute("pro", pro);
                        break;
                    }
                }
                
                double deposit = price / 5;
                request.setAttribute("dep", deposit);
                request.setAttribute("price", price);
                //request.setAttribute("pro", pro);
                
                

                request.getRequestDispatcher("user/template/carbooking2.jsp").forward(request, response);
            }

            if (action.equals("bookComplete")) {

                int carID = Integer.parseInt(request.getParameter("txtcarIDBook"));
                Car car = carFacade.find(carID);
                request.setAttribute("id", car);

                int cusID = Integer.parseInt(request.getParameter("txtCusID"));
                CustomerUser user = customerUserFacade.find(cusID);
                request.setAttribute("cusID", user);

                String createDate = request.getParameter("txtCreDate");
                SimpleDateFormat sfm1 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p1 = new ParsePosition(0);
                Date cre = sfm1.parse(createDate, p1);

                String reiDate = request.getParameter("txtRecDate");
                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date rei = sfm.parse(reiDate, p);
                request.setAttribute("rei", rei);

                String retDate = request.getParameter("txtRetDate");
                SimpleDateFormat sfm2 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p2 = new ParsePosition(0);
                Date ret = sfm.parse(retDate, p2);
                request.setAttribute("ret", ret);

                Date real = ret;

                Double price = Double.parseDouble(request.getParameter("txtTotal"));
                request.setAttribute("price", price);

                short stt = Short.parseShort(request.getParameter("txtStt"));
                request.setAttribute("stt", stt);

                String pro = request.getParameter("txtProID");
                request.setAttribute("pro", pro);

                String code = "0";

                Short pay = Short.parseShort(request.getParameter("txtPay"));
                request.setAttribute("pay", pay);

                if (pay == 1) {
                    code = "0";
                    request.setAttribute("code", code);
                }
                if (pay == 2) {
                    code = request.getParameter("txtCode");
                    request.setAttribute("code", code);
                }

                Double extra = 0.0;

                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                request.setAttribute("quantity", quantity);

                double deposit = Double.parseDouble(request.getParameter("txtDep"));
                request.setAttribute("dep", deposit);

                CarBooked carB = new CarBooked(cre, rei, ret, real, price, stt, pro, user, car, extra, code, pay, quantity, deposit);

                carBookedFacade.create(carB);

                request.getRequestDispatcher("user/template/carBookingComplete1.jsp").forward(request, response);

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
