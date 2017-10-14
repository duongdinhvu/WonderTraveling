/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.Schedule;
import entities.TourCategory;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.ScheduleFacadeLocal;
import sessionbean.TourCategoryFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_TourInsert_Controller extends HttpServlet {

    @EJB
    private ScheduleFacadeLocal scheduleFacade;
    @EJB
    private ToursFacadeLocal toursFacade;
    @EJB
    private TourCategoryFacadeLocal tourCategoryFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            HttpSession session;
            if (action == null) {
                System.out.println("NULLL");
            }
            if (action.equals("changeStatus")) {
                String txtTourIdOnChange = request.getParameter("txtTourIdOnChange");
                session = request.getSession();
                session.setAttribute("tourId", txtTourIdOnChange);
            }

            if (action.equals("InsertLink")) {
                List<TourCategory> tcList = tourCategoryFacade.listAll();
                List<String> listDestinationDefault = new ArrayList<>();
                String[] desArray = tcList.get(0).getDestination().split(", ");

                request.setAttribute("listDestinationDefault", desArray);
                request.setAttribute("TourCategoryList", tcList);
                request.getRequestDispatcher("/admin/createNewTourPackage.jsp").forward(request, response);

            } else if (action.equals("btnCreateSchedule")) {
                //Turn To Upper Case And Remove WhiteSpace
                String tourID = request.getParameter("txtHeadingTo").toUpperCase().replace(" ", "");
                //get All ID like tourID 
                List<String> listID = toursFacade.searchLikeTourID(tourID);
                String tourIDFinal = "";
                if (listID.isEmpty()) {
                    tourIDFinal += tourID.concat("01");
                } else {
                    List<Integer> listIDInteger = new ArrayList<>();
                    for (String tID : listID) {
                        listIDInteger.add(Integer.valueOf(tID.substring(tID.length() - 2, tID.length())));
                    }
                    int maxID = 0;
                    for (int i = 0; i < listIDInteger.size(); i++) {
                        if (listIDInteger.get(i) > maxID) {
                            maxID = listIDInteger.get(i);
                        }
                    }
                    maxID = maxID + 1;
                    String maxIDString = String.valueOf(maxID);
                    tourIDFinal += tourID.concat("0" + maxIDString);
                }

                String tourTitle = request.getParameter("txtTourTitle_Insert");
                String[] tourTitleArray = tourTitle.split(" ");
                ArrayList<String> tourTitleArrayList = new ArrayList<>();
                for (String element : tourTitleArray) {
                    tourTitleArrayList.add(element);
                }

                ArrayList<Integer> listInteger = new ArrayList<>();
                listInteger.add(0);
                for (String element : tourTitleArrayList) {
                    if (element.equals("1") || element.equals("2") || element.equals("3")
                            || element.equals("4") || element.equals("5") || element.equals("6")
                            || element.equals("7") || element.equals("8") || element.equals("9") || element.equals("10")) {
                        listInteger.add(Integer.valueOf(element));
                    }
                }

                Object obj = Collections.max(listInteger);
                int maxSchedule = Integer.valueOf(obj + "");

                String evenPriceString = request.getParameter("txtEvenTourPrice_Insert");
                double evenPriceDouble = Double.valueOf(evenPriceString);

                String oddPriceString = request.getParameter("txtOddTourPrice_Insert");
                double oddPriceDouble = Double.valueOf(oddPriceString);

                //DEPARTURE DATES PROCCESSING
                String departureDays = request.getParameter("txtTourDepartureDays_Insert");
                String departureDaysFinal = departureDays.substring(2, departureDays.length() - 2);

                String hotelRankString = request.getParameter("hotel");
                Short hotelRankShort = Short.valueOf(hotelRankString);

                String departurePoint = request.getParameter("txtDeparturePoint_Insert");
                //String departurePointDecode = URLDecoder.decode(departurePoint, "UTF-8");

                String headingTo = request.getParameter("txtHeadingTo");

                String transportationStringBus = request.getParameter("cbxBus");
                String transportationStringAirPlane = request.getParameter("cbxAirPlane");
                Short transportationShort = 0;
                if (transportationStringBus != null && transportationStringAirPlane != null) {
                    transportationShort = 3;
                } else if ((transportationStringBus != null) && (transportationStringAirPlane == null)) {
                    transportationShort = 2;
                } else {
                    transportationShort = 1;
                }

                String ticketsString = request.getParameter("txtTickets_Insert");
                Short ticketsShort = Short.valueOf(ticketsString);

                boolean status = false;

                String tcDes = request.getParameter("txtTourCategoryDestination");
                //String tcTitleDecode = URLDecoder.decode(tcTitle, "UTF-8");
                TourCategory tc = tourCategoryFacade.findByDestination(tcDes);

                String reprentativePic = request.getParameter("txtImage");

                Date d = new Date();

                Tours tour = new Tours();

                tour.setTourID(tourIDFinal);
                tour.setTourTitle(tourTitle);
                tour.setEvenTourPrice(evenPriceDouble);
                tour.setOddTourPrice(oddPriceDouble);
                tour.setDepatureDay(departureDaysFinal);
                tour.setHotelRank(hotelRankShort);
                tour.setDepaturePoint(departurePoint);
                tour.setHeadingTo(headingTo);
                tour.setTransportation(transportationShort);
                tour.setDuration(Short.valueOf(0 + ""));
                tour.setTickets(ticketsShort);
                tour.setStatus(status);
                tour.setTourCategoryID(tc);
                tour.setImage(reprentativePic);
                tour.setCreatedDate(d);

                if (toursFacade.insertTour(tour)) {
                    String days = "Scheduling Day 1";

                    request.setAttribute("isCompleted", 0);
                    request.setAttribute("maxSchedule", maxSchedule);
                    request.setAttribute("tourID", tourIDFinal);
                    request.setAttribute("tourTitle", tourTitle);
                    request.setAttribute("dayTitles", days);
                    request.getRequestDispatcher("/admin/scheduleInsertForm.jsp").forward(request, response);
                }
            } else if (action.equals("btnCancelTourCreate")) {
                request.setAttribute("list", toursFacade.tourList());
                request.setAttribute("maxSchedule", 0);
                request.setAttribute("checkStatus", "0");
                request.getRequestDispatcher("/admin/tourPackages.jsp").forward(request, response);
            } else if (action.equals("btnResetCreateTour")) {
                List<TourCategory> tcList = tourCategoryFacade.listAll();
                request.setAttribute("TourCategoryList", tcList);
                request.getRequestDispatcher("/admin/createNewTourPackage.jsp").forward(request, response);
            } else if (action.equals("btnCreateScheduleLate")) {
                session = request.getSession();
                String tourID = (String) session.getAttribute("tourId");
                //System.out.println("CHECK TOUR ID:" + tourID);
                Tours tour = toursFacade.searchByTourID(tourID);
                String tourTitle = tour.getTourTitle();
                String days = "Scheduling Day 1";

                String[] tourTitleArray = tourTitle.split(" ");
                ArrayList<String> tourTitleArrayList = new ArrayList<>();
                for (String element : tourTitleArray) {
                    tourTitleArrayList.add(element);
                }

                ArrayList<Integer> listInteger = new ArrayList<>();
                listInteger.add(0);
                for (String element : tourTitleArrayList) {
                    if (element.equals("1") || element.equals("2") || element.equals("3")
                            || element.equals("4") || element.equals("5") || element.equals("6")
                            || element.equals("7") || element.equals("8") || element.equals("9") || element.equals("10")) {
                        listInteger.add(Integer.valueOf(element));
                    }
                }

                Object obj = Collections.max(listInteger);
                int maxScheduleFromTitle = Integer.valueOf(obj + "");

                request.setAttribute("maxSchedule", maxScheduleFromTitle);

                request.setAttribute("tourID", tourID);
                request.setAttribute("tourTitle", tourTitle);
                request.setAttribute("dayTitles", days);
                request.setAttribute("isCompleted", 0);
                request.getRequestDispatcher("/admin/scheduleInsertForm.jsp").forward(request, response);
            } else if (action.equals("btnCreateScheduleAfter")) {
                String tourID = request.getParameter("txttourid");
                Tours tour = toursFacade.searchByTourID(tourID);
                String tourTitle = tour.getTourTitle();
                String days = "Scheduling Day 1";

                String[] tourTitleArray = tourTitle.split(" ");
                ArrayList<String> tourTitleArrayList = new ArrayList<>();
                for (String element : tourTitleArray) {
                    tourTitleArrayList.add(element);
                }

                ArrayList<Integer> listInteger = new ArrayList<>();
                listInteger.add(0);
                for (String element : tourTitleArrayList) {
                    if (element.equals("1") || element.equals("2") || element.equals("3")
                            || element.equals("4") || element.equals("5") || element.equals("6")
                            || element.equals("7") || element.equals("8") || element.equals("9") || element.equals("10")) {
                        listInteger.add(Integer.valueOf(element));
                    }
                }

                Object obj = Collections.max(listInteger);
                int maxScheduleFromTitle = Integer.valueOf(obj + "");

                request.setAttribute("maxSchedule", maxScheduleFromTitle);
                request.setAttribute("isCompleted", 0);
                request.setAttribute("tourID", tourID);
                request.setAttribute("tourTitle", tourTitle);
                request.setAttribute("dayTitles", days);
                request.getRequestDispatcher("/admin/scheduleInsertForm.jsp").forward(request, response);
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
