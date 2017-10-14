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
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CustomerListFacadeLocal;
import sessionbean.CustomerUserFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_GroupTourReserver_DetailEdit_Controller extends HttpServlet {

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;

    @EJB
    private CustomerListFacadeLocal customerListFacade;

    @EJB
    private ToursFacadeLocal toursFacade;

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("btnDetail_Pending")) {
                TourBooked tour = tourBookedFacade.find(request.getParameter("txtTourBookedID_Pending"));

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(request.getParameter("txtTourBookedID_Pending"), false);

                String bookedId = tour.getTourBookedID();
                int representativeCusId = tour.getCustomerID().getCustomerID();
                List<CustomerListHasAge> listCus = new ArrayList<>();
                listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.getRequestDispatcher("/admin/tourBooked_Group_Detail.jsp").forward(request, response);

            } else if (action.equals("btnDetail_Departing")) {
                TourBooked tour = tourBookedFacade.find(request.getParameter("txtTourBookedID_Departing"));
                String bookedId = tour.getTourBookedID();
                int representativeCusId = tour.getCustomerID().getCustomerID();

                List<CustomerListHasAge> listCus = new ArrayList<>();
                listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.getRequestDispatcher("/admin/tourBooked_Group_Detail.jsp").forward(request, response);

            } else if (action.equals("btnDetail_Completed")) {
                TourBooked tour = tourBookedFacade.find(request.getParameter("txtTourBookedID_Completed"));
                String bookedId = tour.getTourBookedID();
                int representativeCusId = tour.getCustomerID().getCustomerID();

                List<CustomerListHasAge> listCus = new ArrayList<>();
                listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.getRequestDispatcher("/admin/tourBooked_Group_Detail.jsp").forward(request, response);

            } else if (action.equals("btnDetail_Cancel")) {
                TourBooked tour = tourBookedFacade.find(request.getParameter("txtTourBookedID_Cancel"));
                String bookedId = tour.getTourBookedID();
                int representativeCusId = tour.getCustomerID().getCustomerID();

                List<CustomerListHasAge> listCus = new ArrayList<>();
                listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBooked", tour);
                request.getRequestDispatcher("/admin/tourBooked_Group_Detail.jsp").forward(request, response);
            } else if (action.equals("btnBack")) {

                request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);

            } else if (action.equals("btnCancelTourBooked_Pending")) {

                String tourBookedId = request.getParameter("txtTourBookedID_Cancel_Pending");

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(tourBookedId, false);

                if (tourBookedFacade.cancelTourBooked(tourBookedId)) {

                    request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);
                }

            } else if (action.equals("btnEdit_Pending_Link")) {
                TourBooked tourBookedUpdate = tourBookedFacade.searchByTourBookID(request.getParameter("txtTourBookedID_Edit_Pending"));
                String bookedId = tourBookedUpdate.getTourBookedID();

                //set tourBooked's isNew become false 
                tourBookedFacade.setIsNew_Toan(bookedId, false);

                int representativeCusId = tourBookedUpdate.getCustomerID().getCustomerID();

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

                List<CustomerListHasAge> listCus = new ArrayList<>();
                listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                int sumOfKidAndAdult = tourBookedUpdate.getNumberOfAdult() + tourBookedUpdate.getNumberOfKid();

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
                request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                request.setAttribute("isOver", 0);
                request.setAttribute("isOverEdit", 0);
                request.setAttribute("isOverAdd", 0);
                request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);

            } else if (action.equals("btnDeleteCus")) {
                int cusid = Integer.valueOf(request.getParameter("txtCusID_Delete"));
                String name = request.getParameter("txtCusName_Delete");

                CustomerList cusDelete = customerListFacade.searchByCusIdAndName(cusid, name);

                SimpleDateFormat fmYear = new SimpleDateFormat("yyyy");
                String currentDateString = fmYear.format(new Date());
                int currentDateInt = Integer.valueOf(currentDateString);

                String sqlDateString = fmYear.format(cusDelete.getDateOfBirth());
                int sqlDateInt = Integer.valueOf(sqlDateString);
                int age = currentDateInt - sqlDateInt;

                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(request.getParameter("txtTourBookID_DeleteCus"));
                int sumOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

                if (age <= 5) {
                    customerListFacade.deleteCusByIdAndName(cusid, name);

                    String bookedId = tourBooked.getTourBookedID();
                    int representativeCusId = tourBooked.getCustomerID().getCustomerID();

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
                    listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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
                    
                    
                    tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                    tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                    tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                    tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
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

                    int sumOfKidAndAdultPass = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

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
                    request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdultPass);
                    request.setAttribute("isOver", 0);
                    request.setAttribute("isOverEdit", 0);
                    request.setAttribute("isOverAdd", 0);
                    request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                } else {
                    if (sumOfKidAndAdult > 20) {

                        customerListFacade.deleteCusByIdAndName(cusid, name);

                        String bookedId = tourBooked.getTourBookedID();
                        int representativeCusId = tourBooked.getCustomerID().getCustomerID();

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
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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

                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                        tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
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

                        int sumOfKidAndAdultPass = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdultPass);
                        request.setAttribute("isOver", 0);
                        request.setAttribute("isOverEdit", 0);
                        request.setAttribute("isOverAdd", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);

                    } else {
                        String bookedId = tourBooked.getTourBookedID();
                        int representativeCusId = tourBooked.getCustomerID().getCustomerID();

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
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                        request.setAttribute("isOver", 1);
                        request.setAttribute("isOverEdit", 0);
                        request.setAttribute("isOverAdd", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                    }
                }

            } else if (action.equals("btnAddCus")) {
                CustomerList cusInsert = new CustomerList();
                int representiveCusID = Integer.parseInt(request.getParameter("txtRepresentiveCustomerId_AddCus"));
                CustomerUser representiveCus = customerUserFacade.find(representiveCusID);

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
                String bookedId = request.getParameter("txtTourBookID_AddCus");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(bookedId);

                cusInsert.setTourBookedID(tourBooked);
                cusInsert.setCustomerID(representiveCus);
                cusInsert.setFullName(cusName);
                cusInsert.setSex(gender);
                cusInsert.setDateOfBirth(dob);

                int preNumOfAdult = tourBooked.getNumberOfAdult();
                int preNumOfBaby = tourBooked.getNumberOfBaby();
                SimpleDateFormat fmYear = new SimpleDateFormat("yyyy");
                String currentDateString = fmYear.format(new Date());
                int currentDateInt = Integer.valueOf(currentDateString);
                String yearOfBirthFromUI = fmYear.format(dob);
                int yearOfBirthFromUIInt = Integer.valueOf(yearOfBirthFromUI);
                int ageFromUI = currentDateInt - yearOfBirthFromUIInt;
                
                if (ageFromUI >= 6) {
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

                        List<CustomerListHasAge> listCus = new ArrayList<>();
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusID, bookedId);

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

                        List<CustomerListHasAge> listKid = new ArrayList<>();
                        List<CustomerListHasAge> listAdult = new ArrayList<>();
                        List<CustomerListHasAge> listBaby = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCus) {
                            if (hasAge.getAge() <= 5) {
                                listBaby.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKid.add(hasAge);
                            } else {
                                listAdult.add(hasAge);
                            }
                        };

                        tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
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

                        int sumOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                        request.setAttribute("isOver", 0);
                        request.setAttribute("isOverEdit", 0);
                        request.setAttribute("isOverAdd", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                    }
                } else {

                    if (preNumOfBaby < preNumOfAdult) {
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

                            List<CustomerListHasAge> listCus = new ArrayList<>();
                            listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusID, bookedId);

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

                            List<CustomerListHasAge> listKid = new ArrayList<>();
                            List<CustomerListHasAge> listAdult = new ArrayList<>();
                            List<CustomerListHasAge> listBaby = new ArrayList<>();
                            for (CustomerListHasAge hasAge : listCus) {
                                if (hasAge.getAge() <= 5) {
                                    listBaby.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKid.add(hasAge);
                                } else {
                                    listAdult.add(hasAge);
                                }
                            };

                            tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
                            tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                            tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                            tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
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

                            int sumOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

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
                            request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                            request.setAttribute("isOver", 0);
                            request.setAttribute("isOverEdit", 0);
                            request.setAttribute("isOverAdd", 0);
                            request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
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
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusID, bookedId);

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

                        int sumOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                        request.setAttribute("isOver", 0);
                        request.setAttribute("isOverEdit", 0);
                        request.setAttribute("isOverAdd", 1);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                    }
                }

            } else if (action.equals("btnEditCus")) {
                int cusid = Integer.valueOf(request.getParameter("txtCusId_AddCus"));
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

                SimpleDateFormat fmYear = new SimpleDateFormat("yyyy");
                String currentDateString = fmYear.format(new Date());
                int currentDateInt = Integer.valueOf(currentDateString);

                String uiDateString = fmYear.format(dob);
                int uiDateInt = Integer.valueOf(uiDateString);

                int age = currentDateInt - uiDateInt;

                int representiveCusId = Integer.parseInt(request.getParameter("txtRepresentiveCustomerId_AddCus"));
                CustomerUser representiveCus = customerUserFacade.find(representiveCusId);
                String tourBookedID = request.getParameter("txtTourBookID_AddCus");
                TourBooked tourBookedUD = tourBookedFacade.searchByTourBookID(tourBookedID);

                CustomerList cusEdit = customerListFacade.searchByCusIdAndName(cusid, cusname);
                cusEdit.setCusID(cusid);
                cusEdit.setFullName(cusname);
                cusEdit.setSex(gender);
                cusEdit.setDateOfBirth(dob);
                cusEdit.setCustomerID(representiveCus);
                cusEdit.setTourBookedID(tourBookedUD);

                int sumOfKidAndAdult = tourBookedUD.getNumberOfAdult() + tourBookedUD.getNumberOfKid();

                if (sumOfKidAndAdult > 20) {
                    if (customerListFacade.editCus(cusEdit)) {
                        TourBooked tourBooked = tourBookedFacade.searchByTourBookID(request.getParameter("txtTourBookID_AddCus"));
                        String bookedId = tourBooked.getTourBookedID();

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
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBooked.getCustomerID().getCustomerID(), bookedId);

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

                        List<CustomerListHasAge> listKid = new ArrayList<>();
                        List<CustomerListHasAge> listAdult = new ArrayList<>();
                        List<CustomerListHasAge> listBaby = new ArrayList<>();
                        for (CustomerListHasAge hasAge : listCus) {
                            if (hasAge.getAge() <= 5) {
                                listBaby.add(hasAge);
                            } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                listKid.add(hasAge);
                            } else {
                                listAdult.add(hasAge);
                            }
                        };

                        tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
                        tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                        tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                        tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                        tourBookedFacade.editTourBooked(tourBooked);

                        int sumOfKidAndAdultPass = tourBookedUD.getNumberOfAdult() + tourBookedUD.getNumberOfKid();

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdultPass);
                        request.setAttribute("isOver", 0);
                        request.setAttribute("isOverEdit", 0);
                        request.setAttribute("isOverAdd", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                    }
                } else {
                    if (age >= 6) {

                        if (customerListFacade.editCus(cusEdit)) {
                            TourBooked tourBooked = tourBookedFacade.searchByTourBookID(request.getParameter("txtTourBookID_AddCus"));
                            String bookedId = tourBooked.getTourBookedID();

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
                            listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBooked.getCustomerID().getCustomerID(), bookedId);

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

                            List<CustomerListHasAge> listKid = new ArrayList<>();
                            List<CustomerListHasAge> listAdult = new ArrayList<>();
                            List<CustomerListHasAge> listBaby = new ArrayList<>();
                            for (CustomerListHasAge hasAge : listCus) {
                                if (hasAge.getAge() <= 5) {
                                    listBaby.add(hasAge);
                                } else if (hasAge.getAge() >= 6 && hasAge.getAge() <= 15) {
                                    listKid.add(hasAge);
                                } else {
                                    listAdult.add(hasAge);
                                }
                            };

                            tourBooked.setNumberOfPeople(Short.valueOf(listCus.size() + ""));
                            tourBooked.setNumberOfBaby(Short.valueOf(listBaby.size() + ""));
                            tourBooked.setNumberOfKid(Short.valueOf(listKid.size() + ""));
                            tourBooked.setNumberOfAdult(Short.valueOf(listAdult.size() + ""));
                            tourBookedFacade.editTourBooked(tourBooked);

                            int sumOfKidAndAdultPass = tourBookedUD.getNumberOfAdult() + tourBookedUD.getNumberOfKid();

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
                            request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdultPass);
                            request.setAttribute("isOver", 0);
                            request.setAttribute("isOverEdit", 0);
                            request.setAttribute("isOverAdd", 0);
                            request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);
                        }

                    } else {

//                        SimpleDateFormat fmY = new SimpleDateFormat("yyyy");
//                        String preDOBYear = fmY.format(cusEdit.getDateOfBirth());
//                        int preDOBYearInt = Integer.valueOf(preDOBYear);
//
//                        int resultOfTheTwoYearOfBirth = preDOBYearInt - uiDateInt;
                        TourBooked tourBooked = tourBookedFacade.searchByTourBookID(request.getParameter("txtTourBookID_AddCus"));
                        String bookedId = tourBooked.getTourBookedID();
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
                        listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBooked.getCustomerID().getCustomerID(), bookedId);

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
                        request.setAttribute("sumOfKidAndAdult", sumOfKidAndAdult);
                        request.setAttribute("isOver", 0);
                        request.setAttribute("isOverEdit", 1);
                        request.setAttribute("isOverAdd", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Group_Update.jsp").forward(request, response);

                    }
                }

            } else if (action.equals("btnEditTourBooked")) {

                String tourBookedId = request.getParameter("txtTourBookIDUpdate");
                TourBooked tourbookedEdit = tourBookedFacade.searchByTourBookID(tourBookedId);

                List<CustomerListHasAge> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourbookedEdit.getCustomerID().getCustomerID(), tourBookedId);
                int realNumOfPeople = listCus.size();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String departureDateStr = request.getParameter("txtDepartureDateSelectBox");
                ParsePosition p = new ParsePosition(0);
                Date departureDateDate = sdf.parse(departureDateStr, p);

                Short individualroom = Short.valueOf(request.getParameter("txtIndividualRoom"));
                
                Short transportation = Short.valueOf(request.getParameter("rdTransportation"));
                
                tourbookedEdit.setNumberOfPeople(Short.valueOf(realNumOfPeople + ""));
                tourbookedEdit.setDepartureDate(departureDateDate);
                tourbookedEdit.setIndividualRoom(individualroom);
                tourbookedEdit.setTransportation(transportation);
                
                if (tourBookedFacade.editTourBooked(tourbookedEdit)) {

                    request.getRequestDispatcher("AdminTour_TourReserved_Select_Controller").forward(request, response);
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
