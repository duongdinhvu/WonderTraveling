/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.Schedule;
import entities.TourBooked;
import entities.TourCategory;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.ScheduleFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.TourCategoryFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_Tour_Update_Controller extends HttpServlet {

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

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

            if (action.equals("btnUpdate_tourPackages")) {
                String tourID = request.getParameter("txtTourIDUpdate");
                Tours tourUpdate = toursFacade.searchByTourID(tourID);

                List<Schedule> listSchedule = scheduleFacade.countTourID(tourUpdate);
                int countSchedule = listSchedule.size();

                String headingTo = tourUpdate.getHeadingTo();

                TourCategory tourCategory = tourUpdate.getTourCategoryID();
                String destinationString = tourCategory.getDestination();
                String[] destinationArray = destinationString.split(", ");
                //EXTRA
                List<String> listDeparture = new ArrayList<>();
                listDeparture.add("An Giang");
                listDeparture.add("Vung Tau");
                listDeparture.add("Bac Giang");
                listDeparture.add("Bac Kan");
                listDeparture.add("Bac Lieu");
                listDeparture.add("Bac Ninh");
                listDeparture.add("Ben Tre");
                listDeparture.add("Binh Dinh");
                listDeparture.add("Binh Duong");
                listDeparture.add("Binh Phuoc");
                listDeparture.add("Binh Thuan");
                listDeparture.add("Can Tho");
                listDeparture.add("Ca Mau");
                listDeparture.add("Cao Bang");
                listDeparture.add("Dak Lak");
                listDeparture.add("Dak Nong");
                listDeparture.add("Da Nang");
                listDeparture.add("Dien Bien");
                listDeparture.add("Dong Nai");
                listDeparture.add("Dong Thap");
                listDeparture.add("Gia Lai");
                listDeparture.add("Ha Giang");
                listDeparture.add("Ha Nam");
                listDeparture.add("Ha Tinh");
                listDeparture.add("Hai Phong");
                listDeparture.add("Ha Noi");
                listDeparture.add("Hai Duong");
                listDeparture.add("Hau Giang");
                listDeparture.add("Hoa Binh");
                listDeparture.add("Hung Yen");
                listDeparture.add("Khanh Hoa");
                listDeparture.add("Kien Giang");
                listDeparture.add("Phu Quoc");
                listDeparture.add("Kon Tum");
                listDeparture.add("Lai Chau");
                listDeparture.add("Lam Dong");
                listDeparture.add("Da Lat");
                listDeparture.add("Lang Son");
                listDeparture.add("Lao Cai");
                listDeparture.add("Long An");
                listDeparture.add("Nam Dinh");
                listDeparture.add("Nghe An");
                listDeparture.add("Ninh Binh");
                listDeparture.add("Ninh Thuan");
                listDeparture.add("Phu Tho");
                listDeparture.add("Quang Binh");
                listDeparture.add("Quang Nam");
                listDeparture.add("Quang Ngai");
                listDeparture.add("Quang Ninh");
                listDeparture.add("Quang Tri");
                listDeparture.add("Soc Trang");
                listDeparture.add("Son La");
                listDeparture.add("Ho Chi Minh City");
                listDeparture.add("Tay Ninh");
                listDeparture.add("Thai Binh");
                listDeparture.add("Thai Nguyen");
                listDeparture.add("Thanh Hoa");
                listDeparture.add("Thua Thien Hue");
                listDeparture.add("Tien Giang");
                listDeparture.add("Tra Vinh");
                listDeparture.add("Tuyen Quang");
                listDeparture.add("Vinh Long");
                listDeparture.add("Vinh Phuc");
                listDeparture.add("Yen Bai");
                listDeparture.add("Phu Yen");
                listDeparture.add("Pleiku");
                listDeparture.add("Buon Me");

                //get departure Dates are already generated of Book
                String itsDepartureString = tourUpdate.getDepatureDay();
                String[] itsDepartureArray = itsDepartureString.split(", ");
                ArrayList<String> itsDepartureDateArrayList = new ArrayList<>();
                for (String des : itsDepartureArray) {
                    itsDepartureDateArrayList.add(des);
                }

                String stringOfDepartureDateAlreadyGenerated = "";
                for (int i = 0; i < itsDepartureDateArrayList.size(); i++) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date datePassing = fm.parse(itsDepartureDateArrayList.get(i), p);
                    List<TourBooked> list = tourBookedFacade.isGeneratedOfDate(datePassing, tourID);
                    if (!list.isEmpty()) {
                        stringOfDepartureDateAlreadyGenerated += (", " + itsDepartureDateArrayList.get(i));
                    }
                }
                if (stringOfDepartureDateAlreadyGenerated.length() > 0) {
                    stringOfDepartureDateAlreadyGenerated = stringOfDepartureDateAlreadyGenerated.substring(2, stringOfDepartureDateAlreadyGenerated.length());
                }
                //END get destination is already generated of Book

                //EXTRA
                request.setAttribute("departureList", listDeparture);
                request.setAttribute("stringOfDepartureDateAlreadyGenerated", stringOfDepartureDateAlreadyGenerated);
                request.setAttribute("departure", tourUpdate.getDepaturePoint());
                request.setAttribute("destinationArray", destinationArray);
                request.setAttribute("headingTo", headingTo);
                request.setAttribute("tour", tourUpdate);

                if (countSchedule > 0) {
                    request.getRequestDispatcher("/admin/editTourPackage.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/admin/editTourPackageWithoutSchedule.jsp").forward(request, response);
                }

            } else if (action.equals("btnUpdateSchedule")) {

                String tourID = request.getParameter("txtTourID_Update");

                Tours tourSearch = toursFacade.searchByTourID(tourID);
                List<Schedule> listSchedule = scheduleFacade.countTourID(tourSearch);
                
                String tourTitle = tourSearch.getTourTitle();
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
                
                int isEnoughOfSchedule = 0;
                
                if (maxScheduleFromTitle == listSchedule.size()) {
                    isEnoughOfSchedule = 1;
                } else {
                    isEnoughOfSchedule = 0;
                } 
                
                request.setAttribute("isEnoughOfSchedule", isEnoughOfSchedule);
                request.setAttribute("tour", tourSearch);
                request.setAttribute("listSchedule", listSchedule);
                request.setAttribute("tourID", tourID);
                request.getRequestDispatcher("/admin/scheduleUpdateForm.jsp").forward(request, response);

            } else if (action.equals("btnDone")) {

                String tourID = request.getParameter("txtTourID_Update");
                Tours tourUpdate = toursFacade.searchByTourID(tourID);

                String tourTitle = request.getParameter("txtTourTitle_Update");

                String evenPrice = request.getParameter("txtEvenTourPrice_Update");
                double evenPriceDouble = Double.valueOf(evenPrice);

                String oddPrice = request.getParameter("txtOddTourPrice_Update");
                double oddPriceDouble = Double.valueOf(oddPrice);

                String departureDay = request.getParameter("txtTourDepartureDays_Update");
                String firstCharacter = String.valueOf(departureDay.charAt(0));
                String departureDayFinal = "";
                if (firstCharacter.equals(",")) {
                    departureDayFinal = departureDay.substring(2, departureDay.length() - 2);
                } else {
                    departureDayFinal += departureDay;
                }

                String hotelRank = request.getParameter("hotel");
                Short hotelRankShort = Short.valueOf(hotelRank);

                String departurePoint = request.getParameter("txtDeparturePoint_Update");
                String headingTo = request.getParameter("txtHeadingTo_Update");

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

                String duration = request.getParameter("txtDuration_Update");
                Short durationShort = Short.valueOf(duration);

                String ticket = request.getParameter("txtTickets_Update");
                Short ticketsShort = Short.valueOf(ticket);

                String imageFinal = "";
                String imageFromPage = request.getParameter("txtImage");
                String imageFromData = tourUpdate.getImage();

                if (imageFromPage.isEmpty()) {
                    //If Image has no changed, getting it's previous value
                    imageFinal = imageFromData;
                } else {
                    //Else getting it's new value which just changed
                    imageFinal = imageFromPage;
                }

                TourCategory tourCategory = tourCategoryFacade.findByTitle(request.getParameter("txtTourCategoryName_Update"));

                tourUpdate.setImage(imageFinal);
                tourUpdate.setTourTitle(tourTitle);
                tourUpdate.setEvenTourPrice(evenPriceDouble);
                tourUpdate.setOddTourPrice(oddPriceDouble);
                tourUpdate.setDepatureDay(departureDayFinal);
                tourUpdate.setHotelRank(hotelRankShort);
                tourUpdate.setDepaturePoint(departurePoint);
                tourUpdate.setHeadingTo(headingTo);
                tourUpdate.setTransportation(transportationShort);
                tourUpdate.setTickets(ticketsShort);
//                tourUpdate.setStatus(statusFinal);
                tourUpdate.setDuration(durationShort);
                tourUpdate.setTourCategoryID(tourCategory);

                if (toursFacade.updateTour(tourUpdate)) {
                    request.getRequestDispatcher("AdminTour_TourSelect_Controller").forward(request, response);

                }
            } else if (action.equals("btnReset")) {
                String tourID = request.getParameter("txtTourID_Update");
                Tours tourUpdate = toursFacade.searchByTourID(tourID);

                List<Schedule> listSchedule = scheduleFacade.countTourID(tourUpdate);
                int countSchedule = listSchedule.size();

                String headingTo = tourUpdate.getHeadingTo();

                TourCategory tourCategory = tourUpdate.getTourCategoryID();
                String destinationString = tourCategory.getDestination();
                String[] destinationArray = destinationString.split(", ");

                //EXTRA
                List<String> listDeparture = new ArrayList<>();
                listDeparture.add("An Giang");
                listDeparture.add("Vung Tau");
                listDeparture.add("Bac Giang");
                listDeparture.add("Bac Kan");
                listDeparture.add("Bac Lieu");
                listDeparture.add("Bac Ninh");
                listDeparture.add("Ben Tre");
                listDeparture.add("Binh Dinh");
                listDeparture.add("Binh Duong");
                listDeparture.add("Binh Phuoc");
                listDeparture.add("Binh Thuan");
                listDeparture.add("Can Tho");
                listDeparture.add("Ca Mau");
                listDeparture.add("Cao Bang");
                listDeparture.add("Dak Lak");
                listDeparture.add("Dak Nong");
                listDeparture.add("Da Nang");
                listDeparture.add("Dien Bien");
                listDeparture.add("Dong Nai");
                listDeparture.add("Dong Thap");
                listDeparture.add("Gia Lai");
                listDeparture.add("Ha Giang");
                listDeparture.add("Ha Nam");
                listDeparture.add("Ha Tinh");
                listDeparture.add("Hai Phong");
                listDeparture.add("Ha Noi");
                listDeparture.add("Hai Duong");
                listDeparture.add("Hau Giang");
                listDeparture.add("Hoa Binh");
                listDeparture.add("Hung Yen");
                listDeparture.add("Khanh Hoa");
                listDeparture.add("Kien Giang");
                listDeparture.add("Phu Quoc");
                listDeparture.add("Kon Tum");
                listDeparture.add("Lai Chau");
                listDeparture.add("Lam Dong");
                listDeparture.add("Da Lat");
                listDeparture.add("Lang Son");
                listDeparture.add("Lao Cai");
                listDeparture.add("Long An");
                listDeparture.add("Nam Dinh");
                listDeparture.add("Nghe An");
                listDeparture.add("Ninh Binh");
                listDeparture.add("Ninh Thuan");
                listDeparture.add("Phu Tho");
                listDeparture.add("Quang Binh");
                listDeparture.add("Quang Nam");
                listDeparture.add("Quang Ngai");
                listDeparture.add("Quang Ninh");
                listDeparture.add("Quang Tri");
                listDeparture.add("Soc Trang");
                listDeparture.add("Son La");
                listDeparture.add("Ho Chi Minh City");
                listDeparture.add("Tay Ninh");
                listDeparture.add("Thai Binh");
                listDeparture.add("Thai Nguyen");
                listDeparture.add("Thanh Hoa");
                listDeparture.add("Thua Thien Hue");
                listDeparture.add("Tien Giang");
                listDeparture.add("Tra Vinh");
                listDeparture.add("Tuyen Quang");
                listDeparture.add("Vinh Long");
                listDeparture.add("Vinh Phuc");
                listDeparture.add("Yen Bai");
                listDeparture.add("Phu Yen");
                listDeparture.add("Pleiku");
                listDeparture.add("Buon Me");

                //get departure Dates are already generated of Book
                String itsDepartureString = tourUpdate.getDepatureDay();
                String[] itsDepartureArray = itsDepartureString.split(", ");
                ArrayList<String> itsDepartureDateArrayList = new ArrayList<>();
                for (String des : itsDepartureArray) {
                    itsDepartureDateArrayList.add(des);
                }

                String stringOfDepartureDateAlreadyGenerated = "";
                for (int i = 0; i < itsDepartureDateArrayList.size(); i++) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date datePassing = fm.parse(itsDepartureDateArrayList.get(i), p);
                    List<TourBooked> list = tourBookedFacade.isGeneratedOfDate(datePassing, tourID);
                    if (!list.isEmpty()) {
                        stringOfDepartureDateAlreadyGenerated += (", " + itsDepartureDateArrayList.get(i));
                    }
                }
                if (stringOfDepartureDateAlreadyGenerated.length() > 0) {
                    stringOfDepartureDateAlreadyGenerated = stringOfDepartureDateAlreadyGenerated.substring(2, stringOfDepartureDateAlreadyGenerated.length());
                }
                //END get destination is already generated of Book

                //EXTRA
                request.setAttribute("departureList", listDeparture);
                request.setAttribute("stringOfDepartureDateAlreadyGenerated", stringOfDepartureDateAlreadyGenerated);
                request.setAttribute("departure", tourUpdate.getDepaturePoint());
                request.setAttribute("destinationArray", destinationArray);
                request.setAttribute("headingTo", headingTo);
                request.setAttribute("tour", tourUpdate);

                if (countSchedule > 0) {
                    request.getRequestDispatcher("/admin/editTourPackage.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/admin/editTourPackageWithoutSchedule.jsp").forward(request, response);
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
