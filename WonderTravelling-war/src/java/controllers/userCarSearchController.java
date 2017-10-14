/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.google.gson.Gson;
import entities.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CarFacadeLocal;

/**
 *
 * @author REY
 */
public class userCarSearchController extends HttpServlet {
    
    @EJB
    private CarFacadeLocal carFacade;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            
            String seatFrom = request.getParameter("seatFrom");
            String seatTo = request.getParameter("seatTo");
//            Short seatFrom = Short.parseShort(request.getParameter("seatFrom"));
//            Short seatTo = Short.parseShort(request.getParameter("seatTo"));
//            
//            String depature = request.getParameter("depature");
//            String arrival = request.getParameter("arrival");
//            String depatureDate = request.getParameter("depatureDate");
            String priceFrom = request.getParameter("priceFrom");
            String priceTo = request.getParameter("priceTo");
 
            Car tmp = null;
            List<Car> list = new ArrayList<>();
            Gson gson = new Gson();
            if (action.equalsIgnoreCase("searchbysubmit")) {

                //List<Car> listSearch = carFacade.searchCarBySubmit(depature, arrival, depatureDate);
                List<Car> listSearch = carFacade.searchCarBySubmit(Short.parseShort(seatFrom), Short.parseShort(seatTo));
                System.out.println("ListSSSSSs:" + listSearch);
                
                for (Car car : listSearch) {
                    int carID = car.getCarID();
                    String carName = car.getCarName();
                    String image = car.getCarImage();
                    String carTrans = car.getCarTrasmission();
                    boolean carAir = car.getCarAirConditioning();
                    short carDoor = car.getCarDoors();
                    short carSeat = car.getCarSeats();                    
                    double carPrice = car.getCarPrice();
                    boolean carGPS = car.getCarGPS();
                    boolean carChair= car.getCarPushChair();
                    String carLic = car.getLicensePlate();
                    boolean stt = car.getCarStatus();
                    
                    tmp = new Car(carID, carName, image, carTrans, carAir, carDoor, carSeat, stt, carPrice, carGPS, carChair, carLic);
                    list.add(tmp);
                }
  
                String json = gson.toJson(list);
                response.getWriter().write(json);
            }

            if (action.equalsIgnoreCase("searchbyprice")) {
                //List<Tours> listSearch = toursFacade.searchToursByPrice(depature, arrival, depatureDate, Double.parseDouble(priceFrom), Double.parseDouble(priceTo));
                List<Car> listSearch = carFacade.searchCarByPrice(Short.parseShort(seatFrom), Short.parseShort(seatTo), Double.parseDouble(priceFrom), Double.parseDouble(priceTo));
                System.out.println("ListSSSSSs:" + listSearch);

                for (Car car : listSearch) {
                    int carID = car.getCarID();
                    String carName = car.getCarName();
                    String image = car.getCarImage();
                    String carTrans = car.getCarTrasmission();
                    boolean carAir = car.getCarAirConditioning();
                    short carDoor = car.getCarDoors();
                    short carSeat = car.getCarSeats();                    
                    double carPrice = car.getCarPrice();
                    boolean carGPS = car.getCarGPS();
                    boolean carChair= car.getCarPushChair();
                    String carLic = car.getLicensePlate();
                    boolean stt = car.getCarStatus();
                    
                    tmp = new Car(carID, carName, image, carTrans, carAir, carDoor, carSeat, stt, carPrice, carGPS, carChair, carLic);
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
