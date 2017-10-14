/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.CustomerList;
import entities.CustomerListHasAge;
import entities.CustomerUser;
import entities.TourBooked;
import entities.TourBookedSub;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CustomerListFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.TourBookedSubFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_OddTourReserved_DetailEdit_Controller extends HttpServlet {

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;

    @EJB
    private TourBookedSubFacadeLocal tourBookedSubFacade;
    @EJB
    private CustomerListFacadeLocal customerListFacade;
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("btnDetail_Pending")) {
                String tourBookedId = request.getParameter("txtTourBookedID_Pending");
                TourBooked tour = tourBookedFacade.searchByTourBookID(tourBookedId);
                String bookedId = tour.getTourBookedID();

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(tourBookedId, false);

                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(bookedId);

                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                    @Override
                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                int availableTicket = (tour.getTourID().getTickets() - (tour.getNumberOfAdult() + tour.getNumberOfKid()));

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.setAttribute("availableTicket", availableTicket);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Detail.jsp").forward(request, response);

            } else if (action.equals("btnBack")) {

                request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);

            } else if (action.equals("btnDetail_Departing")) {
                String tourbookedId = request.getParameter("txtTourBookedID_Departing");
                TourBooked tour = tourBookedFacade.searchByTourBookID(tourbookedId);

                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourbookedId);

                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                    @Override
                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                int availableTicket = tour.getTourID().getTickets() - (tour.getNumberOfAdult() + tour.getNumberOfKid());

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.setAttribute("availableTicket", availableTicket);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Detail.jsp").forward(request, response);
            } else if (action.equals("btnDetail_Completed")) {
                String tourBookedId = request.getParameter("txtTourBookedID_Completed");
                TourBooked tour = tourBookedFacade.searchByTourBookID(tourBookedId);

                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);

                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                    @Override
                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                int availableTicket = tour.getTourID().getTickets() - (tour.getNumberOfAdult() + tour.getNumberOfKid());

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.setAttribute("availableTicket", availableTicket);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Detail.jsp").forward(request, response);
            } else if (action.equals("btnDetail_Cancel")) {
                String tourBookedId = request.getParameter("txtTourBookedID_Cancel");
                TourBooked tour = tourBookedFacade.searchByTourBookID(tourBookedId);

                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);

                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                    @Override
                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                int availableTicket = tour.getTourID().getTickets() - (tour.getNumberOfAdult() + tour.getNumberOfKid());

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.setAttribute("availableTicket", availableTicket);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Detail.jsp").forward(request, response);
            } else if (action.equals("btnCancelTourBooked_Pending")) {
                String tourBookedId = request.getParameter("txtTourBookedID_Cancel_Pending");

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(tourBookedId, false);

                if (tourBookedFacade.cancelTourBooked(tourBookedId)) {

                    request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);
                }

            } else if (action.equals("btnEdit_Pending_Link")) {
                String tourBookedId = request.getParameter("txtTourBookedID_Edit_Pending");

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(tourBookedId, false);

                TourBooked tourBookedUpdate = tourBookedFacade.searchByTourBookID(tourBookedId);

                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                String departureDate = fm.format(tourBookedUpdate.getDepartureDate());

                String[] departureDatesArray = tourBookedUpdate.getTourID().getDepatureDay().split(", ");
                List<String> listDepartureDates = new ArrayList<>();
                for (int i = 0; i < departureDatesArray.length; i++) {
                    try {
                        Date dt = fm.parse(departureDatesArray[i]);
                        int result = compareWithCurrentDates(dt);
                        if (result > 0) {
                            String dtS = fm.format(dt);
                            listDepartureDates.add(dtS);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                }

                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                List<Integer> listRepresentativeId = new ArrayList<>();

                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                    List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                    for (CustomerListHasAge customerList : listCusSub) {
                        //listCus.add(customerList);
                        listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                    }
                }

                Set<Integer> hs = new HashSet<>();
                hs.addAll(listRepresentativeId);
                listRepresentativeId.clear();
                listRepresentativeId.addAll(hs);

                Short stShort = tourBookedUpdate.getStatus();
                String stStr = "";
                if (stShort == 1) {
                    stStr = "Pending";
                } else if (stShort == 2) {
                    stStr = "Departing";
                } else if (stShort == 3) {
                    stStr = "Completed";
                } else {
                    stStr = "Cancel";
                }

                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                    @Override
                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                int availableTicket = (tourBookedUpdate.getTourID().getTickets() - (tourBookedUpdate.getNumberOfAdult() + tourBookedUpdate.getNumberOfKid()));

                request.setAttribute("availableTicket", availableTicket);
                request.setAttribute("listRepresentativeId", listRepresentativeId);
                request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                request.setAttribute("btnAdd_Edit_Text", "Add");
                request.setAttribute("st", stStr);
                request.setAttribute("listcus", listCus);
                request.setAttribute("tourID", tourBookedUpdate.getTourID().getTourID());
                request.setAttribute("tourTitle", tourBookedUpdate.getTourID().getTourTitle());
                request.setAttribute("departureDatesArray", listDepartureDates);
                request.setAttribute("departureDate", departureDate);
                request.setAttribute("tourBookedupdate", tourBookedUpdate);
                request.setAttribute("numOfKid", tourBookedUpdate.getNumberOfKid());
                request.setAttribute("numOfBaby", tourBookedUpdate.getNumberOfBaby());
                request.setAttribute("ticket", 0);
                request.setAttribute("numOfKidAndAdult", 0);
                request.setAttribute("isOutOfTicket", 0);
                request.setAttribute("isOutOfKidAndAdult", 0);
                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                request.setAttribute("babyError", 0);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
            } else if (action.equals("btnAddCus")) {
                CustomerList cusInsert = new CustomerList();

                int representativeCusID = Integer.parseInt(request.getParameter("txtRepresentiveCustomerId_AddCus"));
                CustomerUser representiveCus = customerUserFacade.find(representativeCusID);
                String tourBookedId = request.getParameter("txtTourBookID_AddCus");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                TourBookedSub tourBookedSubValidate = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);

                Short ticket = tourBooked.getTourID().getTickets();
                int numberOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();
                int availableTicket = ticket - numberOfKidAndAdult;

                if (availableTicket > 0) {
                    String cusName = request.getParameter("txtCusNameAdd");
                    String cusGender = request.getParameter("rdGender");
                    boolean gender = false;
                    if (cusGender.equals("true")) {
                        gender = true;
                    } else {
                        gender = false;
                    }
                    String cusDOB = request.getParameter("txtDOB");
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date dob = format.parse(cusDOB, p);

                    cusInsert.setTourBookedID(tourBooked);
                    cusInsert.setCustomerID(representiveCus);
                    cusInsert.setFullName(cusName);
                    cusInsert.setSex(gender);
                    cusInsert.setDateOfBirth(dob);

                    SimpleDateFormat fmy = new SimpleDateFormat("yyyy");
                    String currentDateString = fmy.format(new Date());
                    int currentDateInt = Integer.valueOf(currentDateString);
                    String dobStr = fmy.format(dob);
                    int sqlDateInt = Integer.valueOf(dobStr);
                    int age = currentDateInt - sqlDateInt;

                    if (age <= 5) {
                        if (tourBookedSubValidate.getNumberOfBaby() < tourBookedSubValidate.getNumberOfAdult()) {
                            if (customerListFacade.addCus(cusInsert)) {
                                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                                String departureDate = fm.format(tourBooked.getDepartureDate());

                                String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                                List<String> listDepartureDates = new ArrayList<>();
                                for (int i = 0; i < departureDatesArray.length; i++) {
                                    try {
                                        Date dt = fm.parse(departureDatesArray[i]);
                                        int result = compareWithCurrentDates(dt);
                                        if (result > 0) {
                                            String dtS = fm.format(dt);
                                            listDepartureDates.add(dtS);
                                        }
                                    } catch (ParseException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                                List<Integer> listRepresentativeId = new ArrayList<>();

                                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                    List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                    for (CustomerListHasAge customerList : listCusSub) {
                                        //listCus.add(customerList);
                                        listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                    }
                                }

                                TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                                List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                                List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                                List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                                List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();

                                for (CustomerListHasAge hasAge : listCusSubHasAge) {
                                    if (hasAge.getAge() <= 5) {
                                        listBabyTourBookedSub.add(hasAge);
                                    } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                        listKidTourBookedSub.add(hasAge);
                                    } else {
                                        listAdultTourBookedSub.add(hasAge);
                                    }
                                };

                                tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                                tourBookedSubFacade.update(tourBookedsub);

                                Set<Integer> hs = new HashSet<>();
                                hs.addAll(listRepresentativeId);
                                listRepresentativeId.clear();
                                listRepresentativeId.addAll(hs);

                                Short stShort = tourBooked.getStatus();
                                String stStr = "";
                                if (stShort == 1) {
                                    stStr = "Pending";
                                } else if (stShort == 2) {
                                    stStr = "Departing";
                                } else if (stShort == 3) {
                                    stStr = "Completed";
                                } else {
                                    stStr = "Cancel";
                                }

                                List<CustomerListHasAge> listBaby = new ArrayList<>();
                                List<CustomerListHasAge> listKid = new ArrayList<>();
                                List<CustomerListHasAge> listAdult = new ArrayList<>();
                                for (CustomerListHasAge hasAge : listCus) {
                                    if (hasAge.getAge() <= 5) {
                                        listBaby.add(hasAge);
                                    } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                        listKid.add(hasAge);
                                    } else {
                                        listAdult.add(hasAge);
                                    }
                                };
                                int realNumOfPeople = listCus.size();
                                tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                                tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                                tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                                tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                                tourBookedFacade.editTourBooked(tourBooked);

                                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                    @Override
                                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                        if (cus1.getCusID() > cus2.getCusID()) {
                                            return -1;
                                        }
                                        if (cus1.getCusID() < cus2.getCusID()) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                });

                                int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                                request.setAttribute("listRepresentativeId", listRepresentativeId);
                                request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                                request.setAttribute("btnAdd_Edit_Text", "Add");
                                request.setAttribute("st", stStr);
                                request.setAttribute("listcus", listCus);
                                request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                                request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                                request.setAttribute("departureDatesArray", listDepartureDates);
                                request.setAttribute("tourBookedupdate", tourBooked);
                                request.setAttribute("departureDate", departureDate);
                                request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                                request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                                request.setAttribute("ticket", 0);
                                request.setAttribute("numOfKidAndAdult", 0);
                                request.setAttribute("isOutOfTicket", 0);
                                request.setAttribute("isOutOfKidAndAdult", 0);
                                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                                request.setAttribute("babyError", 0);
                                request.setAttribute("availableTicket", availableTicketRemained);
                                request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);

                            }
                        } else {
                            ///ERROR OF NUMBER OF BABY
                            SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                            String departureDate = fm.format(tourBooked.getDepartureDate());

                            String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                            List<String> listDepartureDates = new ArrayList<>();
                            for (int i = 0; i < departureDatesArray.length; i++) {
                                try {
                                    Date dt = fm.parse(departureDatesArray[i]);
                                    int result = compareWithCurrentDates(dt);
                                    if (result > 0) {
                                        String dtS = fm.format(dt);
                                        listDepartureDates.add(dtS);
                                    }
                                } catch (ParseException ex) {
                                    ex.printStackTrace();
                                }
                            }

                            List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                            List<Integer> listRepresentativeId = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    //listCus.add(customerList);
                                    listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                }
                            }

                            Set<Integer> hs = new HashSet<>();
                            hs.addAll(listRepresentativeId);
                            listRepresentativeId.clear();
                            listRepresentativeId.addAll(hs);

                            Short stShort = tourBooked.getStatus();
                            String stStr = "";
                            if (stShort == 1) {
                                stStr = "Pending";
                            } else if (stShort == 2) {
                                stStr = "Departing";
                            } else if (stShort == 3) {
                                stStr = "Completed";
                            } else {
                                stStr = "Cancel";
                            }

                            Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                @Override
                                public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                    if (cus1.getCusID() > cus2.getCusID()) {
                                        return -1;
                                    }
                                    if (cus1.getCusID() < cus2.getCusID()) {
                                        return 1;
                                    }
                                    return 0;
                                }
                            });

                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                            request.setAttribute("listRepresentativeId", listRepresentativeId);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("st", stStr);
                            request.setAttribute("listcus", listCus);
                            request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                            request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                            request.setAttribute("departureDatesArray", listDepartureDates);
                            request.setAttribute("tourBookedupdate", tourBooked);
                            request.setAttribute("departureDate", departureDate);
                            request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                            request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                            request.setAttribute("ticket", ticket);
                            request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("babyError", 1);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("availableTicket", availableTicketRemained);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                        }
                    } else {
                        if (customerListFacade.addCus(cusInsert)) {
                            SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                            String departureDate = fm.format(tourBooked.getDepartureDate());

                            String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                            List<String> listDepartureDates = new ArrayList<>();
                            for (int i = 0; i < departureDatesArray.length; i++) {
                                try {
                                    Date dt = fm.parse(departureDatesArray[i]);
                                    int result = compareWithCurrentDates(dt);
                                    if (result > 0) {
                                        String dtS = fm.format(dt);
                                        listDepartureDates.add(dtS);
                                    }
                                } catch (ParseException ex) {
                                    ex.printStackTrace();
                                }
                            }

                            List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                            List<Integer> listRepresentativeId = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    //listCus.add(customerList);
                                    listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                }
                            }

                            TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                            List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                            List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                            List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                            List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();

                            for (CustomerListHasAge hasAge : listCusSubHasAge) {
                                if (hasAge.getAge() <= 5) {
                                    listBabyTourBookedSub.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKidTourBookedSub.add(hasAge);
                                } else {
                                    listAdultTourBookedSub.add(hasAge);
                                }
                            };

                            tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                            tourBookedSubFacade.update(tourBookedsub);

                            Set<Integer> hs = new HashSet<>();
                            hs.addAll(listRepresentativeId);
                            listRepresentativeId.clear();
                            listRepresentativeId.addAll(hs);

                            Short stShort = tourBooked.getStatus();
                            String stStr = "";
                            if (stShort == 1) {
                                stStr = "Pending";
                            } else if (stShort == 2) {
                                stStr = "Departing";
                            } else if (stShort == 3) {
                                stStr = "Completed";
                            } else {
                                stStr = "Cancel";
                            }

                            List<CustomerListHasAge> listBaby = new ArrayList<>();
                            List<CustomerListHasAge> listKid = new ArrayList<>();
                            List<CustomerListHasAge> listAdult = new ArrayList<>();
                            for (CustomerListHasAge hasAge : listCus) {
                                if (hasAge.getAge() <= 5) {
                                    listBaby.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKid.add(hasAge);
                                } else {
                                    listAdult.add(hasAge);
                                }
                            };
                            int realNumOfPeople = listCus.size();
                            tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                            tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                            tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                            tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                            tourBookedFacade.editTourBooked(tourBooked);

                            Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                @Override
                                public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                    if (cus1.getCusID() > cus2.getCusID()) {
                                        return -1;
                                    }
                                    if (cus1.getCusID() < cus2.getCusID()) {
                                        return 1;
                                    }
                                    return 0;
                                }
                            });

                            int avalableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                            request.setAttribute("listRepresentativeId", listRepresentativeId);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("st", stStr);
                            request.setAttribute("listcus", listCus);
                            request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                            request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                            request.setAttribute("departureDatesArray", listDepartureDates);
                            request.setAttribute("tourBookedupdate", tourBooked);
                            request.setAttribute("departureDate", departureDate);
                            request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                            request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                            request.setAttribute("ticket", 0);
                            request.setAttribute("numOfKidAndAdult", 0);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("babyError", 0);
                            request.setAttribute("availableTicket", avalableTicketRemained);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);

                        }
                    }

                } else {

                    String cusName = request.getParameter("txtCusNameAdd");
                    String cusGender = request.getParameter("rdGender");
                    boolean gender = false;
                    if (cusGender.equals("true")) {
                        gender = true;
                    } else {
                        gender = false;
                    }

                    String cusDOB = request.getParameter("txtDOB");
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date dob = format.parse(cusDOB, p);

                    cusInsert.setTourBookedID(tourBooked);
                    cusInsert.setCustomerID(representiveCus);
                    cusInsert.setFullName(cusName);
                    cusInsert.setSex(gender);
                    cusInsert.setDateOfBirth(dob);

                    SimpleDateFormat fmy = new SimpleDateFormat("yyyy");
                    String currentDateString = fmy.format(new Date());
                    int currentDateInt = Integer.valueOf(currentDateString);
                    String dobStr = fmy.format(dob);
                    int sqlDateInt = Integer.valueOf(dobStr);
                    int age = currentDateInt - sqlDateInt;

                    if (age <= 5) {
                        if (tourBookedSubValidate.getNumberOfBaby() < tourBookedSubValidate.getNumberOfAdult()) {
                            if (customerListFacade.addCus(cusInsert)) {
                                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                                String departureDate = fm.format(tourBooked.getDepartureDate());

                                String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                                List<String> listDepartureDates = new ArrayList<>();
                                for (int i = 0; i < departureDatesArray.length; i++) {
                                    try {
                                        Date dt = fm.parse(departureDatesArray[i]);
                                        int result = compareWithCurrentDates(dt);
                                        if (result > 0) {
                                            String dtS = fm.format(dt);
                                            listDepartureDates.add(dtS);
                                        }
                                    } catch (ParseException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                                List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                                List<Integer> listRepresentativeId = new ArrayList<>();

                                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                    List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                    for (CustomerListHasAge customerList : listCusSub) {
                                        //listCus.add(customerList);
                                        listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                    }
                                }

                                TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                                List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                                List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                                List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                                List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();

                                for (CustomerListHasAge hasAge : listCusSubHasAge) {
                                    if (hasAge.getAge() <= 5) {
                                        listBabyTourBookedSub.add(hasAge);
                                    } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                        listKidTourBookedSub.add(hasAge);
                                    } else {
                                        listAdultTourBookedSub.add(hasAge);
                                    }
                                };

                                tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                                tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                                tourBookedSubFacade.update(tourBookedsub);

                                Set<Integer> hs = new HashSet<>();
                                hs.addAll(listRepresentativeId);
                                listRepresentativeId.clear();
                                listRepresentativeId.addAll(hs);

                                Short stShort = tourBooked.getStatus();
                                String stStr = "";
                                if (stShort == 1) {
                                    stStr = "Pending";
                                } else if (stShort == 2) {
                                    stStr = "Departing";
                                } else if (stShort == 3) {
                                    stStr = "Completed";
                                } else {
                                    stStr = "Cancel";
                                }

                                List<CustomerListHasAge> listBaby = new ArrayList<>();
                                List<CustomerListHasAge> listKid = new ArrayList<>();
                                List<CustomerListHasAge> listAdult = new ArrayList<>();
                                for (CustomerListHasAge hasAge : listCus) {
                                    if (hasAge.getAge() <= 5) {
                                        listBaby.add(hasAge);
                                    } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                        listKid.add(hasAge);
                                    } else {
                                        listAdult.add(hasAge);
                                    }
                                };
                                int realNumOfPeople = listCus.size();
                                tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                                tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                                tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                                tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                                tourBookedFacade.editTourBooked(tourBooked);

                                Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                    @Override
                                    public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                        if (cus1.getCusID() > cus2.getCusID()) {
                                            return -1;
                                        }
                                        if (cus1.getCusID() < cus2.getCusID()) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                });

                                int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                                request.setAttribute("listRepresentativeId", listRepresentativeId);
                                request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                                request.setAttribute("btnAdd_Edit_Text", "Add");
                                request.setAttribute("st", stStr);
                                request.setAttribute("listcus", listCus);
                                request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                                request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                                request.setAttribute("departureDatesArray", listDepartureDates);
                                request.setAttribute("tourBookedupdate", tourBooked);
                                request.setAttribute("departureDate", departureDate);
                                request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                                request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                                request.setAttribute("ticket", 0);
                                request.setAttribute("numOfKidAndAdult", 0);
                                request.setAttribute("isOutOfTicket", 0);
                                request.setAttribute("isOutOfKidAndAdult", 0);
                                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                                request.setAttribute("babyError", 0);
                                request.setAttribute("availableTicket", availableTicketRemained);
                                request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);

                            }
                        } else {
                            ///ERROR OF NUMBER OF BABY
                            SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                            String departureDate = fm.format(tourBooked.getDepartureDate());

                            String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                            List<String> listDepartureDates = new ArrayList<>();
                            for (int i = 0; i < departureDatesArray.length; i++) {
                                try {
                                    Date dt = fm.parse(departureDatesArray[i]);
                                    int result = compareWithCurrentDates(dt);
                                    if (result > 0) {
                                        String dtS = fm.format(dt);
                                        listDepartureDates.add(dtS);
                                    }
                                } catch (ParseException ex) {
                                    ex.printStackTrace();
                                }
                            }

                            List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                            List<Integer> listRepresentativeId = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    //listCus.add(customerList);
                                    listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                }
                            }

                            Set<Integer> hs = new HashSet<>();
                            hs.addAll(listRepresentativeId);
                            listRepresentativeId.clear();
                            listRepresentativeId.addAll(hs);

                            Short stShort = tourBooked.getStatus();
                            String stStr = "";
                            if (stShort == 1) {
                                stStr = "Pending";
                            } else if (stShort == 2) {
                                stStr = "Departing";
                            } else if (stShort == 3) {
                                stStr = "Completed";
                            } else {
                                stStr = "Cancel";
                            }

                            Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                @Override
                                public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                    if (cus1.getCusID() > cus2.getCusID()) {
                                        return -1;
                                    }
                                    if (cus1.getCusID() < cus2.getCusID()) {
                                        return 1;
                                    }
                                    return 0;
                                }
                            });

                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                            request.setAttribute("listRepresentativeId", listRepresentativeId);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("st", stStr);
                            request.setAttribute("listcus", listCus);
                            request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                            request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                            request.setAttribute("departureDatesArray", listDepartureDates);
                            request.setAttribute("tourBookedupdate", tourBooked);
                            request.setAttribute("departureDate", departureDate);
                            request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                            request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                            request.setAttribute("ticket", ticket);
                            request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("babyError", 1);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("availableTicket", availableTicketRemained);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                        }

                    } else {
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        String departureDate = fm.format(tourBooked.getDepartureDate());

                        String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                        List<String> listDepartureDates = new ArrayList<>();
                        for (int i = 0; i < departureDatesArray.length; i++) {
                            try {
                                Date dt = fm.parse(departureDatesArray[i]);
                                int result = compareWithCurrentDates(dt);
                                if (result > 0) {
                                    String dtS = fm.format(dt);
                                    listDepartureDates.add(dtS);
                                }
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }
                        }

                        List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                        List<Integer> listRepresentativeId = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                //listCus.add(customerList);
                                listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                            }
                        }

                        Set<Integer> hs = new HashSet<>();
                        hs.addAll(listRepresentativeId);
                        listRepresentativeId.clear();
                        listRepresentativeId.addAll(hs);

                        Short stShort = tourBooked.getStatus();
                        String stStr = "";
                        if (stShort == 1) {
                            stStr = "Pending";
                        } else if (stShort == 2) {
                            stStr = "Departing";
                        } else if (stShort == 3) {
                            stStr = "Completed";
                        } else {
                            stStr = "Cancel";
                        }

                        Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                            @Override
                            public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                if (cus1.getCusID() > cus2.getCusID()) {
                                    return -1;
                                }
                                if (cus1.getCusID() < cus2.getCusID()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });

                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                        request.setAttribute("listRepresentativeId", listRepresentativeId);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("st", stStr);
                        request.setAttribute("listcus", listCus);
                        request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                        request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                        request.setAttribute("departureDatesArray", listDepartureDates);
                        request.setAttribute("tourBookedupdate", tourBooked);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                        request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                        request.setAttribute("ticket", ticket);
                        request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                        request.setAttribute("isOutOfTicket", 1);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("babyError", 0);
                        request.setAttribute("availableTicket", availableTicketRemained);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                    }
                }

            } else if (action.equals("btnEditCus")) {

                int cusid = Integer.valueOf(request.getParameter("txtCusId_EditCus"));
                String cusname = request.getParameter("txtCusNameAdd");
                String cusGender = request.getParameter("rdGender");
                boolean gender = false;
                if (cusGender.equals("true")) {
                    gender = true;
                } else {
                    gender = false;
                }
                String cusDOB = request.getParameter("txtDOB");
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date dob = format.parse(cusDOB, p);

                String tourBookedId = request.getParameter("txtTourBookID_AddCus");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                int representiveCusId = Integer.parseInt(request.getParameter("txtRepresentiveCustomerId_EditCus"));
                CustomerUser representiveCus = customerUserFacade.find(representiveCusId);

                CustomerList cusEdit = new CustomerList();
                cusEdit.setCusID(cusid);
                cusEdit.setFullName(cusname);
                cusEdit.setSex(gender);
                cusEdit.setDateOfBirth(dob);
                cusEdit.setCustomerID(representiveCus);
                cusEdit.setTourBookedID(tourBooked);

                TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representiveCusId);

                int AdultTourBookedSub = tourBookedsub.getNumberOfAdult();

                SimpleDateFormat fmYear = new SimpleDateFormat("yyyy");
                String currentYearString = fmYear.format(new Date());
                int currentYearInt = Integer.valueOf(currentYearString);

                String uiDateString = fmYear.format(dob);
                int uiDateInt = Integer.valueOf(uiDateString);

                int age = currentYearInt - uiDateInt;

//                String ageSQLStr = fmYear.format(cusEdit.getDateOfBirth());
//                int ageSQLInt = Integer.parseInt(ageSQLStr);
//
//                int realAge = currentYearInt - ageSQLInt;

                if (AdultTourBookedSub > 1) {
                    if (customerListFacade.editCus(cusEdit)) {

                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                        List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();

                        for (CustomerListHasAge hasAge : listCusSubHasAge) {
                            if (hasAge.getAge() <= 5) {
                                listBabyTourBookedSub.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKidTourBookedSub.add(hasAge);
                            } else {
                                listAdultTourBookedSub.add(hasAge);
                            }
                        };

                        tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                        tourBookedSubFacade.update(tourBookedsub);

                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        String departureDate = fm.format(tourBooked.getDepartureDate());

                        String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                        List<String> listDepartureDates = new ArrayList<>();
                        for (int i = 0; i < departureDatesArray.length; i++) {
                            try {
                                Date dt = fm.parse(departureDatesArray[i]);
                                int result = compareWithCurrentDates(dt);
                                if (result > 0) {
                                    String dtS = fm.format(dt);
                                    listDepartureDates.add(dtS);
                                }
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }

                        }

                        List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                        List<Integer> listRepresentativeId = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                //listCus.add(customerList);
                                listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                            }
                        }

                        List<CustomerListHasAge> listBaby = new ArrayList<>();
                        List<CustomerListHasAge> listKid = new ArrayList<>();
                        List<CustomerListHasAge> listAdult = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCus) {
                            if (hasAge.getAge() <= 5) {
                                listBaby.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKid.add(hasAge);
                            } else {
                                listAdult.add(hasAge);
                            }
                        };
                        int realNumOfPeople = listCus.size();
                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                        tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                        tourBookedFacade.editTourBooked(tourBooked);

                        Set<Integer> hs = new HashSet<>();
                        hs.addAll(listRepresentativeId);
                        listRepresentativeId.clear();
                        listRepresentativeId.addAll(hs);

                        Short stShort = tourBooked.getStatus();
                        String stStr = "";
                        if (stShort == 1) {
                            stStr = "Pending";
                        } else if (stShort == 2) {
                            stStr = "Departing";
                        } else if (stShort == 3) {
                            stStr = "Completed";
                        } else {
                            stStr = "Cancel";
                        }

                        Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                            @Override
                            public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                if (cus1.getCusID() > cus2.getCusID()) {
                                    return -1;
                                }
                                if (cus1.getCusID() < cus2.getCusID()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });

                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                        request.setAttribute("listRepresentativeId", listRepresentativeId);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("st", stStr);
                        request.setAttribute("listcus", listCus);
                        request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                        request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                        request.setAttribute("departureDatesArray", listDepartureDates);
                        request.setAttribute("tourBookedupdate", tourBooked);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                        request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("babyError", 0);
                        request.setAttribute("availableTicket", availableTicketRemained);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                    }
                } else if (AdultTourBookedSub <= 1 && age > 15) {
                    if (customerListFacade.editCus(cusEdit)) {

                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                        List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();

                        for (CustomerListHasAge hasAge : listCusSubHasAge) {
                            if (hasAge.getAge() <= 5) {
                                listBabyTourBookedSub.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKidTourBookedSub.add(hasAge);
                            } else {
                                listAdultTourBookedSub.add(hasAge);
                            }
                        };

                        tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                        tourBookedSubFacade.update(tourBookedsub);

                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        String departureDate = fm.format(tourBooked.getDepartureDate());

                        String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                        List<String> listDepartureDates = new ArrayList<>();
                        for (int i = 0; i < departureDatesArray.length; i++) {
                            try {
                                Date dt = fm.parse(departureDatesArray[i]);
                                int result = compareWithCurrentDates(dt);
                                if (result > 0) {
                                    String dtS = fm.format(dt);
                                    listDepartureDates.add(dtS);
                                }
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }

                        }

                        List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                        List<Integer> listRepresentativeId = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                //listCus.add(customerList);
                                listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                            }
                        }

                        List<CustomerListHasAge> listBaby = new ArrayList<>();
                        List<CustomerListHasAge> listKid = new ArrayList<>();
                        List<CustomerListHasAge> listAdult = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCus) {
                            if (hasAge.getAge() <= 5) {
                                listBaby.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKid.add(hasAge);
                            } else {
                                listAdult.add(hasAge);
                            }
                        };
                        int realNumOfPeople = listCus.size();
                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                        tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                        tourBookedFacade.editTourBooked(tourBooked);

                        Set<Integer> hs = new HashSet<>();
                        hs.addAll(listRepresentativeId);
                        listRepresentativeId.clear();
                        listRepresentativeId.addAll(hs);

                        Short stShort = tourBooked.getStatus();
                        String stStr = "";
                        if (stShort == 1) {
                            stStr = "Pending";
                        } else if (stShort == 2) {
                            stStr = "Departing";
                        } else if (stShort == 3) {
                            stStr = "Completed";
                        } else {
                            stStr = "Cancel";
                        }

                        Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                            @Override
                            public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                if (cus1.getCusID() > cus2.getCusID()) {
                                    return -1;
                                }
                                if (cus1.getCusID() < cus2.getCusID()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });

                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                        request.setAttribute("listRepresentativeId", listRepresentativeId);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("st", stStr);
                        request.setAttribute("listcus", listCus);
                        request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                        request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                        request.setAttribute("departureDatesArray", listDepartureDates);
                        request.setAttribute("tourBookedupdate", tourBooked);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                        request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("babyError", 0);
                        request.setAttribute("availableTicket", availableTicketRemained);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                    }

                } else {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    String departureDate = fm.format(tourBooked.getDepartureDate());

                    String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                    List<String> listDepartureDates = new ArrayList<>();
                    for (int i = 0; i < departureDatesArray.length; i++) {
                        try {
                            Date dt = fm.parse(departureDatesArray[i]);
                            int result = compareWithCurrentDates(dt);
                            if (result > 0) {
                                String dtS = fm.format(dt);
                                listDepartureDates.add(dtS);
                            }
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                    }

                    List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                    List<Integer> listRepresentativeId = new ArrayList<>();

                    List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                    for (TourBookedSub tourBookedSub : listTourBookedSub) {
                        List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                        for (CustomerListHasAge customerList : listCusSub) {
                            //listCus.add(customerList);
                            listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                        }
                    }

                    Set<Integer> hs = new HashSet<>();
                    hs.addAll(listRepresentativeId);
                    listRepresentativeId.clear();
                    listRepresentativeId.addAll(hs);

                    Short stShort = tourBooked.getStatus();
                    String stStr = "";
                    if (stShort == 1) {
                        stStr = "Pending";
                    } else if (stShort == 2) {
                        stStr = "Departing";
                    } else if (stShort == 3) {
                        stStr = "Completed";
                    } else {
                        stStr = "Cancel";
                    }

                    Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                        @Override
                        public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                    request.setAttribute("listRepresentativeId", listRepresentativeId);
                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("st", stStr);
                    request.setAttribute("listcus", listCus);
                    request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                    request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                    request.setAttribute("departureDatesArray", listDepartureDates);
                    request.setAttribute("tourBookedupdate", tourBooked);
                    request.setAttribute("departureDate", departureDate);
                    request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                    request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                    request.setAttribute("ticket", 0);
                    request.setAttribute("numOfKidAndAdult", 0);
                    request.setAttribute("isOutOfTicket", 0);
                    request.setAttribute("isOutOfKidAndAdult", 0);
                    request.setAttribute("isOutOfKidAndAdult_Edit", 1);
                    request.setAttribute("babyError", 0);
                    request.setAttribute("availableTicket", availableTicketRemained);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                }

            } else if (action.equals("btnDeleteCus")) {

                int cusid = Integer.valueOf(request.getParameter("txtCusID_Delete"));
                String name = request.getParameter("txtCusName_Delete");

                CustomerList cusDelete = customerListFacade.searchByCusIdAndName(cusid, name);
                int representativeID = cusDelete.getCustomerID().getCustomerID();

                String tourBookedId = request.getParameter("txtTourBookID_DeleteCus");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeID);

                int numOfAdultTourBookedSub = tourBookedsub.getNumberOfAdult();

                if (numOfAdultTourBookedSub > 1) {
                    if (customerListFacade.deleteCusByIdAndName(cusid, name)) {

                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeID, tourBookedId);
                        List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                        List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCusSubHasAge) {
                            if (hasAge.getAge() <= 5) {
                                listBabyTourBookedSub.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKidTourBookedSub.add(hasAge);
                            } else {
                                listAdultTourBookedSub.add(hasAge);
                            }
                        }

                        tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                        tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                        tourBookedSubFacade.update(tourBookedsub);

                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        String departureDate = fm.format(tourBooked.getDepartureDate());

                        String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                        List<String> listDepartureDates = new ArrayList<>();
                        for (int i = 0; i < departureDatesArray.length; i++) {
                            try {
                                Date dt = fm.parse(departureDatesArray[i]);
                                int result = compareWithCurrentDates(dt);
                                if (result > 0) {
                                    String dtS = fm.format(dt);
                                    listDepartureDates.add(dtS);
                                }
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }

                        }

                        List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                        List<Integer> listRepresentativeId = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                //listCus.add(customerList);
                                listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                            }
                        }

                        Set<Integer> hs = new HashSet<>();
                        hs.addAll(listRepresentativeId);
                        listRepresentativeId.clear();
                        listRepresentativeId.addAll(hs);

                        Short stShort = tourBooked.getStatus();
                        String stStr = "";
                        if (stShort == 1) {
                            stStr = "Pending";
                        } else if (stShort == 2) {
                            stStr = "Departing";
                        } else if (stShort == 3) {
                            stStr = "Completed";
                        } else {
                            stStr = "Cancel";
                        }

                        List<CustomerListHasAge> listBaby = new ArrayList<>();
                        List<CustomerListHasAge> listKid = new ArrayList<>();
                        List<CustomerListHasAge> listAdult = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCus) {
                            if (hasAge.getAge() <= 5) {
                                listBaby.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKid.add(hasAge);
                            } else {
                                listAdult.add(hasAge);
                            }
                        };
                        int realNumOfPeople = listCus.size();
                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                        tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                        tourBookedFacade.editTourBooked(tourBooked);

                        Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                            @Override
                            public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                if (cus1.getCusID() > cus2.getCusID()) {
                                    return -1;
                                }
                                if (cus1.getCusID() < cus2.getCusID()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });

                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                        request.setAttribute("listRepresentativeId", listRepresentativeId);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("st", stStr);
                        request.setAttribute("listcus", listCus);
                        request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                        request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                        request.setAttribute("departureDatesArray", listDepartureDates);
                        request.setAttribute("tourBookedupdate", tourBooked);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                        request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("babyError", 0);
                        request.setAttribute("availableTicket", availableTicketRemained);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                    }
                } else {

                    CustomerListHasAge cusdelete = customerListFacade.searchByCusIdHasAge(cusid);

                    if (cusdelete.getAge() < 16) {
                        if (customerListFacade.deleteCusByIdAndName(cusid, name)) {

                            List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeID, tourBookedId);
                            List<CustomerListHasAge> listBabyTourBookedSub = new ArrayList<>();
                            List<CustomerListHasAge> listKidTourBookedSub = new ArrayList<>();
                            List<CustomerListHasAge> listAdultTourBookedSub = new ArrayList<>();
                            for (CustomerListHasAge hasAge : listCusSubHasAge) {
                                if (hasAge.getAge() <= 5) {
                                    listBabyTourBookedSub.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKidTourBookedSub.add(hasAge);
                                } else {
                                    listAdultTourBookedSub.add(hasAge);
                                }
                            }

                            tourBookedsub.setNumberOfAdult(Short.valueOf(listAdultTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfKid(Short.valueOf(listKidTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfBaby(Short.valueOf(listBabyTourBookedSub.size() + ""));
                            tourBookedsub.setNumberOfPeople(Short.valueOf(listCusSubHasAge.size() + ""));
                            tourBookedSubFacade.update(tourBookedsub);

                            SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                            String departureDate = fm.format(tourBooked.getDepartureDate());

                            String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                            List<String> listDepartureDates = new ArrayList<>();
                            for (int i = 0; i < departureDatesArray.length; i++) {
                                try {
                                    Date dt = fm.parse(departureDatesArray[i]);
                                    int result = compareWithCurrentDates(dt);
                                    if (result > 0) {
                                        String dtS = fm.format(dt);
                                        listDepartureDates.add(dtS);
                                    }
                                } catch (ParseException ex) {
                                    ex.printStackTrace();
                                }

                            }

                            List<CustomerListHasAge> listCus = customerListFacade.searchByBookedID(tourBookedId);
                            List<Integer> listRepresentativeId = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    //listCus.add(customerList);
                                    listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                                }
                            }

                            Set<Integer> hs = new HashSet<>();
                            hs.addAll(listRepresentativeId);
                            listRepresentativeId.clear();
                            listRepresentativeId.addAll(hs);

                            Short stShort = tourBooked.getStatus();
                            String stStr = "";
                            if (stShort == 1) {
                                stStr = "Pending";
                            } else if (stShort == 2) {
                                stStr = "Departing";
                            } else if (stShort == 3) {
                                stStr = "Completed";
                            } else {
                                stStr = "Cancel";
                            }

                            List<CustomerListHasAge> listBaby = new ArrayList<>();
                            List<CustomerListHasAge> listKid = new ArrayList<>();
                            List<CustomerListHasAge> listAdult = new ArrayList<>();
                            for (CustomerListHasAge hasAge : listCus) {
                                if (hasAge.getAge() <= 5) {
                                    listBaby.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKid.add(hasAge);
                                } else {
                                    listAdult.add(hasAge);
                                }
                            };
                            int realNumOfPeople = listCus.size();
                            tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                            tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                            tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                            tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                            tourBookedFacade.editTourBooked(tourBooked);

                            Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                                @Override
                                public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                    if (cus1.getCusID() > cus2.getCusID()) {
                                        return -1;
                                    }
                                    if (cus1.getCusID() < cus2.getCusID()) {
                                        return 1;
                                    }
                                    return 0;
                                }
                            });

                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                            request.setAttribute("listRepresentativeId", listRepresentativeId);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("st", stStr);
                            request.setAttribute("listcus", listCus);
                            request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                            request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                            request.setAttribute("departureDatesArray", listDepartureDates);
                            request.setAttribute("tourBookedupdate", tourBooked);
                            request.setAttribute("departureDate", departureDate);
                            request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                            request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                            request.setAttribute("ticket", 0);
                            request.setAttribute("numOfKidAndAdult", 0);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("babyError", 0);
                            request.setAttribute("availableTicket", availableTicketRemained);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                        }
                    } else {
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        String departureDate = fm.format(tourBooked.getDepartureDate());

                        String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                        List<String> listDepartureDates = new ArrayList<>();
                        for (int i = 0; i < departureDatesArray.length; i++) {
                            try {
                                Date dt = fm.parse(departureDatesArray[i]);
                                int result = compareWithCurrentDates(dt);
                                if (result > 0) {
                                    String dtS = fm.format(dt);
                                    listDepartureDates.add(dtS);
                                }
                            } catch (ParseException ex) {
                                ex.printStackTrace();
                            }

                        }

                        List<CustomerListHasAge> listCus = new ArrayList<>();
                        List<Integer> listRepresentativeId = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                listCus.add(customerList);
                                listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                            }
                        }

                        Set<Integer> hs = new HashSet<>();
                        hs.addAll(listRepresentativeId);
                        listRepresentativeId.clear();
                        listRepresentativeId.addAll(hs);

                        Short stShort = tourBooked.getStatus();
                        String stStr = "";
                        if (stShort == 1) {
                            stStr = "Pending";
                        } else if (stShort == 2) {
                            stStr = "Departing";
                        } else if (stShort == 3) {
                            stStr = "Completed";
                        } else {
                            stStr = "Cancel";
                        }

                        Collections.sort(listCus, new Comparator<CustomerListHasAge>() {
                            @Override
                            public int compare(CustomerListHasAge cus1, CustomerListHasAge cus2) {
                                if (cus1.getCusID() > cus2.getCusID()) {
                                    return -1;
                                }
                                if (cus1.getCusID() < cus2.getCusID()) {
                                    return 1;
                                }
                                return 0;
                            }
                        });

                        int availabeTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());

                        request.setAttribute("listRepresentativeId", listRepresentativeId);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("st", stStr);
                        request.setAttribute("listcus", listCus);
                        request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                        request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                        request.setAttribute("departureDatesArray", listDepartureDates);
                        request.setAttribute("tourBookedupdate", tourBooked);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                        request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult", 1);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("babyError", 0);
                        request.setAttribute("availableTicket", availabeTicketRemained);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                    }

                }

            } else if (action.equals("btnEditTourBooked")) {

                String tourBookedId = request.getParameter("txtTourBookIDUpdate");
                TourBooked tourbookedEdit = tourBookedFacade.searchByTourBookID(tourBookedId);

                List<CustomerList> listCus = new ArrayList<>();

                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                    List<CustomerList> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                    for (CustomerList customerList : listCusSub) {
                        listCus.add(customerList);
                    }
                }

                int realNumOfPeople = listCus.size();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String departureDateStr = request.getParameter("txtDepartureDateSelectBox");
                ParsePosition p = new ParsePosition(0);
                Date departureDateDate = sdf.parse(departureDateStr, p);

                tourbookedEdit.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                tourbookedEdit.setDepartureDate(departureDateDate);

                if (tourBookedFacade.editTourBooked(tourbookedEdit)) {

                    request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);
                }
            } else if (action.equals("btnEditSmallTeam")) {
                String bookedId = request.getParameter("txtTourBookIdPassing");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(bookedId);
                int representativeCusId = Integer.parseInt(request.getParameter("passingRepreSentativeID"));
                CustomerUser representativeCus = customerUserFacade.find(representativeCusId);
                List<CustomerList> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeCusId, bookedId);
                TourBookedSub tourBookedSub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(bookedId, representativeCusId);

                request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                request.setAttribute("btnAdd_Edit_Text", "Add");
                request.setAttribute("tourBooked", tourBooked);
                request.setAttribute("representativeCus", representativeCus);
                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBookedSub", tourBookedSub);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Update_Extra.jsp").forward(request, response);
            } else if (action.equals("btnAddCus_Extra")) {
                CustomerList cusInsert = new CustomerList();

                int representativeCusID = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                CustomerUser representiveCus = customerUserFacade.find(representativeCusID);
                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                String cusName = request.getParameter("txtCusNameAdd");
                String cusGender = request.getParameter("rdGender");
                boolean gender = false;
                if (cusGender.equals("true")) {
                    gender = true;
                } else {
                    gender = false;
                }
                String cusDOB = request.getParameter("txtDOB");
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date dob = format.parse(cusDOB, p);

                cusInsert.setTourBookedID(tourBooked);
                cusInsert.setCustomerID(representiveCus);
                cusInsert.setFullName(cusName);
                cusInsert.setSex(gender);
                cusInsert.setDateOfBirth(dob);

                if (customerListFacade.addCus(cusInsert)) {
                    List<CustomerList> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeCusID, tourBookedId);

                    List<CustomerList> listCusCount = new ArrayList<>();
                    List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));
                    for (TourBookedSub tourBookedSub : listTourBookedSub) {
                        List<CustomerList> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                        for (CustomerList customerList : listCusSub) {
                            listCusCount.add(customerList);
                        }
                    }

                    int realNumOfPeople = listCusCount.size();
                    tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                    tourBookedFacade.editTourBooked(tourBooked);

                    Collections.sort(listCus, new Comparator<CustomerList>() {
                        @Override
                        public int compare(CustomerList cus1, CustomerList cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("tourBooked", tourBooked);
                    request.setAttribute("representativeCus", representiveCus);
                    request.setAttribute("listcus", listCus);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update_Extra.jsp").forward(request, response);
                }
            } else if (action.equals("btnEditCus_Extra")) {
                int representativeCusID = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                CustomerUser representiveCus = customerUserFacade.find(representativeCusID);
                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                int cusid = Integer.valueOf(request.getParameter("txtCusId_EditCus"));
                String cusName = request.getParameter("txtCusNameAdd");
                String cusGender = request.getParameter("rdGender");
                boolean gender = false;
                if (cusGender.equals("true")) {
                    gender = true;
                } else {
                    gender = false;
                }
                String cusDOB = request.getParameter("txtDOB");
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                Date dob = format.parse(cusDOB, p);

                CustomerList cusUpdate = customerListFacade.find(cusid);

                cusUpdate.setFullName(cusName);
                cusUpdate.setSex(gender);
                cusUpdate.setDateOfBirth(dob);

                if (customerListFacade.editCus(cusUpdate)) {
                    List<CustomerList> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeCusID, tourBookedId);

                    Collections.sort(listCus, new Comparator<CustomerList>() {
                        @Override
                        public int compare(CustomerList cus1, CustomerList cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("tourBooked", tourBooked);
                    request.setAttribute("representativeCus", representiveCus);
                    request.setAttribute("listcus", listCus);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update_Extra.jsp").forward(request, response);
                }
            } else if (action.equals("btnDeleteCus_Extra")) {
                int representativeCusID = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                CustomerUser representiveCus = customerUserFacade.find(representativeCusID);
                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                int cusid = Integer.valueOf(request.getParameter("txtCusID_Delete"));
                String cusname = request.getParameter("txtCusName_Delete");

                if (customerListFacade.deleteCusByIdAndName(cusid, cusname)) {
                    List<CustomerList> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeCusID, tourBookedId);

                    List<CustomerList> listCusCount = new ArrayList<>();
                    List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));
                    for (TourBookedSub tourBookedSub : listTourBookedSub) {
                        List<CustomerList> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                        for (CustomerList customerList : listCusSub) {
                            listCusCount.add(customerList);
                        }
                    }

                    int realNumOfPeople = listCusCount.size();

                    tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                    tourBookedFacade.editTourBooked(tourBooked);

                    Collections.sort(listCus, new Comparator<CustomerList>() {
                        @Override
                        public int compare(CustomerList cus1, CustomerList cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("tourBooked", tourBooked);
                    request.setAttribute("representativeCus", representiveCus);
                    request.setAttribute("listcus", listCus);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update_Extra.jsp").forward(request, response);
                }
            } else if (action.equals("btnBack_Update_Extra")) {
                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBookedUpdate = tourBookedFacade.searchByTourBookID(tourBookedId);

                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                String departureDate = fm.format(tourBookedUpdate.getDepartureDate());

                String[] departureDatesArray = tourBookedUpdate.getTourID().getDepatureDay().split(", ");
                List<String> listDepartureDates = new ArrayList<>();
                for (int i = 0; i < departureDatesArray.length; i++) {
                    try {
                        Date dt = fm.parse(departureDatesArray[i]);
                        int result = compareWithCurrentDates(dt);
                        if (result > 0) {
                            String dtS = fm.format(dt);
                            listDepartureDates.add(dtS);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                }

                //List<Object> listCusMajor = new ArrayList<>();
                List<CustomerList> listCus = new ArrayList<>();
                List<Integer> listRepresentativeId = new ArrayList<>();

                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                    List<CustomerList> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                    for (CustomerList customerList : listCusSub) {
                        listCus.add(customerList);
                        listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                    }
                    //listCusMajor.add(listCusSub);
                }

                if (!listRepresentativeId.isEmpty()) {
                    for (int i = 0; i < listRepresentativeId.size(); i++) {
                        for (int j = listRepresentativeId.size() - 1; j > i; j--) {
                            if (listRepresentativeId.get(j) == listRepresentativeId.get(i)) {
                                listRepresentativeId.remove(j);
                            }
                        }

                    }
                }

                Short stShort = tourBookedUpdate.getStatus();
                String stStr = "";
                if (stShort == 1) {
                    stStr = "Pending";
                } else if (stShort == 2) {
                    stStr = "Departing";
                } else if (stShort == 3) {
                    stStr = "Completed";
                } else {
                    stStr = "Cancel";
                }

                Collections.sort(listCus, new Comparator<CustomerList>() {
                    @Override
                    public int compare(CustomerList cus1, CustomerList cus2) {
                        if (cus1.getCusID() > cus2.getCusID()) {
                            return -1;
                        }
                        if (cus1.getCusID() < cus2.getCusID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                request.setAttribute("listRepresentativeId", listRepresentativeId);
                request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                request.setAttribute("btnAdd_Edit_Text", "Add");
                request.setAttribute("st", stStr);
                request.setAttribute("listcus", listCus);
                //request.setAttribute("listcus", listCusMajor);
                request.setAttribute("tourID", tourBookedUpdate.getTourID().getTourID());
                request.setAttribute("tourTitle", tourBookedUpdate.getTourID().getTourTitle());
                request.setAttribute("departureDatesArray", listDepartureDates);
                request.setAttribute("departureDate", departureDate);
                request.setAttribute("tourBookedupdate", tourBookedUpdate);
                request.setAttribute("numOfKid", tourBookedUpdate.getNumberOfKid());
                request.setAttribute("numOfBaby", tourBookedUpdate.getNumberOfBaby());
                request.setAttribute("babyError", 0);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);

            } else if (action.equals("btnCancelSmallTeamReservation")) {
                String tourBookedId = request.getParameter("txtTourBookID");
                int representativeCusId = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                TourBookedSub tourBookedSubCancel = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusId);

                if (tourBookedSubFacade.cancelTourBookedSub(tourBookedSubCancel.getTourBookedSubID())) {
                    TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    String departureDate = fm.format(tourBooked.getDepartureDate());

                    String[] departureDatesArray = tourBooked.getTourID().getDepatureDay().split(", ");
                    List<String> listDepartureDates = new ArrayList<>();
                    for (int i = 0; i < departureDatesArray.length; i++) {
                        try {
                            Date dt = fm.parse(departureDatesArray[i]);
                            int result = compareWithCurrentDates(dt);
                            if (result > 0) {
                                String dtS = fm.format(dt);
                                listDepartureDates.add(dtS);
                            }
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                    }

                    //List<Object> listCusMajor = new ArrayList<>();
                    List<CustomerList> listCus = new ArrayList<>();
                    List<Integer> listRepresentativeId = new ArrayList<>();

                    List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                    for (TourBookedSub tourBookedSub : listTourBookedSub) {
                        List<CustomerList> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                        for (CustomerList customerList : listCusSub) {
                            listCus.add(customerList);
                            listRepresentativeId.add(customerList.getCustomerID().getCustomerID());
                        }
                        //listCusMajor.add(listCusSub);
                    }

                    Set<Integer> hs = new HashSet<>();
                    hs.addAll(listRepresentativeId);
                    listRepresentativeId.clear();
                    listRepresentativeId.addAll(hs);

                    int realNumOfPeople = listCus.size();

                    tourBooked.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                    tourBookedFacade.editTourBooked(tourBooked);

                    Short stShort = tourBooked.getStatus();
                    String stStr = "";
                    if (stShort == 1) {
                        stStr = "Pending";
                    } else if (stShort == 2) {
                        stStr = "Departing";
                    } else if (stShort == 3) {
                        stStr = "Completed";
                    } else {
                        stStr = "Cancel";
                    }

                    Collections.sort(listCus, new Comparator<CustomerList>() {
                        @Override
                        public int compare(CustomerList cus1, CustomerList cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("listRepresentativeId", listRepresentativeId);
                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("st", stStr);
                    request.setAttribute("listcus", listCus);
                    //request.setAttribute("listcus", listCusMajor);
                    request.setAttribute("tourID", tourBooked.getTourID().getTourID());
                    request.setAttribute("tourTitle", tourBooked.getTourID().getTourTitle());
                    request.setAttribute("departureDatesArray", listDepartureDates);
                    request.setAttribute("departureDate", departureDate);
                    request.setAttribute("tourBookedupdate", tourBooked);
                    request.setAttribute("numOfKid", tourBooked.getNumberOfKid());
                    request.setAttribute("numOfBaby", tourBooked.getNumberOfBaby());
                    request.setAttribute("babyError", 0);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update.jsp").forward(request, response);
                }
            } else if (action.equals("btnEditSmallTeamPerform")) {
                String bookedID = request.getParameter("txtTourBookedID");
                String representativeCusID = request.getParameter("txtRepresentativeCustomerId");

                TourBookedSub tourBookedSub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(bookedID, Integer.valueOf(representativeCusID));
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(bookedID);

                int numOfBabyTotal = tourBooked.getNumberOfBaby();
                int numOfKidTotal = tourBooked.getNumberOfKid();
                int individualRoomTotal = tourBooked.getIndividualRoom();

                int numberOfBabyWithout = numOfBabyTotal - tourBookedSub.getNumberOfBaby();
                int numberOfKidWithout = numOfKidTotal - tourBookedSub.getNumberOfKid();
                int individualRoomWithout = individualRoomTotal - tourBookedSub.getIndividualRoom();

                int numberOfBaby = Integer.valueOf(request.getParameter("txtNumberOfBaby"));
                int numberOfKid = Integer.valueOf(request.getParameter("txtNumberOfKid"));
                int individualRoom = Integer.valueOf(request.getParameter("txtIndividualRoom"));

                int numberOfBabyTotalUpdate = numberOfBabyWithout + numberOfBaby;
                int numberOfKidTotalUpdate = numberOfKidWithout + numberOfKid;
                int individualRoomUpdate = individualRoomWithout + individualRoom;

                Short transport = Short.valueOf(request.getParameter("txtTransportation"));

                tourBookedSub.setNumberOfBaby(Short.valueOf(numberOfBaby + ""));
                tourBookedSub.setNumberOfKid(Short.valueOf(numberOfKid + ""));
                tourBookedSub.setIndividualRoom(Short.valueOf(individualRoom + ""));
                tourBookedSub.setTransportation(transport);

                if (tourBookedSubFacade.update(tourBookedSub)) {
                    tourBooked.setNumberOfBaby(Short.valueOf(numberOfBabyTotalUpdate + ""));
                    tourBooked.setNumberOfKid(Short.valueOf(numberOfKidTotalUpdate + ""));
                    tourBooked.setIndividualRoom(Short.valueOf(individualRoomUpdate + ""));

                    tourBookedFacade.editTourBooked(tourBooked);

                    CustomerUser representativeCus = customerUserFacade.find(Integer.valueOf(representativeCusID));
                    List<CustomerList> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(Integer.valueOf(representativeCusID), bookedID);

                    Collections.sort(listCus, new Comparator<CustomerList>() {
                        @Override
                        public int compare(CustomerList cus1, CustomerList cus2) {
                            if (cus1.getCusID() > cus2.getCusID()) {
                                return -1;
                            }
                            if (cus1.getCusID() < cus2.getCusID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("tourBooked", tourBooked);
                    request.setAttribute("representativeCus", representativeCus);
                    request.setAttribute("listcus", listCus);
                    request.setAttribute("tourBookedSub", tourBookedSub);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Update_Extra.jsp").forward(request, response);
                }
            }

        }
    }

    private static int compareWithCurrentDates(Date dateCompare) {
        Date dateCp = getZeroTimeDate(dateCompare);
        Date curentDate = getZeroTimeDate(new Date());
        int result = dateCp.compareTo(curentDate);

        return result;
    }

    private static Date getZeroTimeDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date = calendar.getTime();

        return date;
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
