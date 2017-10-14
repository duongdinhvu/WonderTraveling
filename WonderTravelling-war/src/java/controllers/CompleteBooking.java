package controllers;

import entities.CustomerList;
import entities.CustomerUser;
import entities.Promotion;
import entities.Review;
import entities.Role;
import entities.TourBooked;
import entities.TourBookedSub;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
import javax.servlet.http.HttpSession;
import sessionbean.CustomerListFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;
import sessionbean.PromotionFacadeLocal;
import sessionbean.ReviewFacadeLocal;
import sessionbean.RoleFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.TourBookedSubFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class CompleteBooking extends HttpServlet {

    @EJB
    private TourBookedSubFacadeLocal tourBookedSubFacade;

    @EJB
    private ReviewFacadeLocal reviewFacade;
    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private CustomerListFacadeLocal customerListFacade;

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;
    @EJB
    private PromotionFacadeLocal promotionFacade;
    @EJB
    private ToursFacadeLocal toursFacade;
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");

            if (action.equals("complete_booking")) {
                HttpSession session = request.getSession();

                List<CustomerList> cusList = new ArrayList<>();
                CustomerList customers = null;
                TourBooked tourBooked = null;

                ////// Set and get Session ( for Complete page)
                String username = (String) session.getAttribute("sessionUser");
                CustomerUser customerUser = customerUserFacade.getCustomerUser(username);

                session.setAttribute("Customeruser", customerUser);

                //////////
                Promotion promotionId = promotionFacade.find(1);
                Tours tour = (Tours) session.getAttribute("sTour");
                double unitPrice = tour.getOddTourPrice();

                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = null;

                String isGroup = request.getParameter("hdGroup");
                String isBusOrAir = request.getParameter("hdTransport");
                String room = request.getParameter("txtRoom");

                String numPeople = request.getParameter("txtNumPeople");
                String numAdult = request.getParameter("txtAdult");
                String numKid = request.getParameter("txtKid");
                String numBaby = request.getParameter("txtBaby");
                String totalPrice = request.getParameter("txtTotalPrice");

                short numPeoples = Short.parseShort(numPeople);
                short numAdults = Short.parseShort(numAdult);
                short numKids = Short.parseShort(numKid);
                short numBabies = Short.parseShort(numBaby);
                short rooms = Short.parseShort(room);

                ///////Set session for Individual Room
                session.setAttribute("room", rooms);

                /////// Set session
                double parseTotalPrice = Double.parseDouble(totalPrice);
                session.setAttribute("TotalPrice", parseTotalPrice);

                ////
                ///   Add new Tour Booked
                String tmp = tourBookedFacade.getTourBookedID();

                int tmp1 = Integer.parseInt(tmp.substring(3));

                tmp1 = tmp1 + 1;
                String tourbookedId = "TB0" + tmp1;
                boolean setIsGroup = false;
                if (isGroup.equalsIgnoreCase("group")) {
                    setIsGroup = true;
                    unitPrice = tour.getEvenTourPrice();
                }
                ///// Set session for Price and Tour booked Id
                session.setAttribute("price", unitPrice);
                session.setAttribute("TourBookedId", tourbookedId);

                ////// Get depature
                String depature = (String) session.getAttribute("depature");
                p = new ParsePosition(0);
                Date dateDepature = df.parse(depature, p);

                short status = 1;
                Date createdDate = new Date();

                /////Set Session for transportation/
                session.setAttribute("Transportation", isBusOrAir);
                short isBusorAir = 1;
                if (isBusOrAir.equalsIgnoreCase("bus")) {
                    isBusorAir = 2;
                }
                //(String tourBookedID, Boolean iSGroup, Date departureDate, Short numberOfAdult, Short numberOfKid, Short numberOfBaby, Short numberOfPeople, Short individualRoom, Short transportation, Short status, Date createdDate, Tours tourID, Promotion promotionID, CustomerUser customerID)
                tourBooked = new TourBooked(tourbookedId, setIsGroup, dateDepature, numAdults, numKids, numBabies, numPeoples, rooms, isBusorAir, status, createdDate, true, tour, promotionId, customerUser);

                tourBookedFacade.create(tourBooked);
                ///////////////////////////////////////////////
                /////Add Tour Sub /////

                if (!setIsGroup) {
                    TourBookedSub tourBookedSub = new TourBookedSub(dateDepature, numAdults, numKids, numBabies, numPeoples, rooms, isBusorAir, status, createdDate, true, tour, tourBooked, customerUser);

                    tourBookedSubFacade.create(tourBookedSub);
                }

                ////////////////////////////////
                // Add new list Passengers
                if (numAdults != 0) {
                    for (int j = 0; j < numAdults; j++) {
                        int k = j + 1;
                        String fullname = request.getParameter("txtFullName" + k).replaceAll("\\s+", " ");
                        fullname = fullname.replaceAll("(^\\s+|\\s+$)", "");
                        String getSex = request.getParameter("hdSex" + k);

                        String getDay = request.getParameter("slDay" + k);

                        String getMonth = request.getParameter("slMonth" + k);
                        String getYear = request.getParameter("slYear" + k);

                        boolean sex = false;
                        if (getSex.equalsIgnoreCase("male")) {
                            sex = true;
                        }

                        String mergeDate = getDay + "-" + getMonth + "-" + getYear;
                        p = new ParsePosition(0);

                        Date dateBirth = df.parse(mergeDate, p);
                        System.out.println("Date Birth:" + dateBirth);
                        customers = new CustomerList(fullname, sex, dateBirth, tourBooked, customerUser);

                        cusList.add(customers);

                    }
                }

                if (numKids != 0) {
                    for (int j = 0; j < numKids; j++) {
                        int k = numAdults + j + 1;
                        String fullname = request.getParameter("txtFullName" + k).replaceAll("\\s+", " ");
                        fullname = fullname.replaceAll("(^\\s+|\\s+$)", "");;
                        String getSex = request.getParameter("hdSex" + k);
                        String getDay = request.getParameter("slDay" + k);
                        String getMonth = request.getParameter("slMonth" + k);
                        String getYear = request.getParameter("slYear" + k);

                        boolean sex = false;
                        if (getSex.equalsIgnoreCase("male")) {
                            sex = true;
                        }
                        String mergeDate = getDay + "-" + getMonth + "-" + getYear;
                        p = new ParsePosition(0);

                        Date dateBirth = df.parse(mergeDate, p);

                        customers = new CustomerList(fullname, sex, dateBirth, tourBooked, customerUser);

                        cusList.add(customers);

                    }
                }
                if (numBabies != 0) {
                    for (int j = 0; j < numBabies; j++) {
                        int k = numAdults + numKids + j + 1;
                        String fullname = request.getParameter("txtFullName" + k).replaceAll("\\s+", " ");
                        fullname = fullname.replaceAll("(^\\s+|\\s+$)", "");
                        String getSex = request.getParameter("hdSex" + k);
                        String getDay = request.getParameter("slDay" + k);
                        String getMonth = request.getParameter("slMonth" + k);
                        String getYear = request.getParameter("slYear" + k);

                        boolean sex = false;
                        if (getSex.equalsIgnoreCase("male")) {
                            sex = true;
                        }
                        String mergeDate = getDay + "-" + getMonth + "-" + getYear;
                        p = new ParsePosition(0);

                        Date dateBirth = df.parse(mergeDate, p);

                        customers = new CustomerList(fullname, sex, dateBirth, tourBooked, customerUser);

                        cusList.add(customers);

                    }
                }
                // set session passenger on Tour

                session.setAttribute("ListPasseger", cusList);

                for (CustomerList items : cusList) {
                    customerListFacade.create(items);
                }

                request.getRequestDispatcher("user/template/complete.jsp").forward(request, response);

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
