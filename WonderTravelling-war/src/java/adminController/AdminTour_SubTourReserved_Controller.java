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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
public class AdminTour_SubTourReserved_Controller extends HttpServlet {

    @EJB
    private CustomerListFacadeLocal customerListFacade;
    @EJB
    private CustomerUserFacadeLocal customerUserFacade;
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    @EJB
    private TourBookedSubFacadeLocal tourBookedSubFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("selectList")) {

                List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(departingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(completedList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                request.setAttribute("PendingList", pendingList);
                request.setAttribute("DepartingList", departingList);
                request.setAttribute("CompletedList", completedList);
                request.setAttribute("CancelList", cancelList);

                request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
            } else if (action.equals("btnDetail_CancelSub")) {
                String tourBookedID = request.getParameter("txtTourBookedID_CancelSub");
                int representativeID = Integer.parseInt(request.getParameter("txtRepresentativeID_CancelSub"));
                int tourBookedSubID = Integer.parseInt(request.getParameter("txtTourBookedSubID_CancelSub"));

                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedID);
                CustomerUser representativeCus = customerUserFacade.find(representativeID);
                TourBookedSub tourBookedSub = tourBookedSubFacade.searchByiD(tourBookedSubID);

                //set tourBooked's isNew become false 
                tourBookedSubFacade.setIsNew(tourBookedSubID, false);

                List<CustomerListHasAge> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeID, tourBookedID);

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

                request.setAttribute("availabelTicket", availableTicketRemained);
                request.setAttribute("tourBooked", tourBooked);
                request.setAttribute("representativeCus", representativeCus);
                request.setAttribute("listCus", listCus);
                request.setAttribute("tourBookedSub", tourBookedSub);
                request.getRequestDispatcher("/admin/tourBookedSub_OddDetail.jsp").forward(request, response);
            } else if (action.equals("btnBack_TourBookedSub_Odd_Back_Extra")) {

                List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(departingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(completedList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                request.setAttribute("PendingList", pendingList);
                request.setAttribute("DepartingList", departingList);
                request.setAttribute("CompletedList", completedList);
                request.setAttribute("CancelList", cancelList);

                request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

            } else if (action.equals("btnEdit_Pending_Link")) {
                String bookedId = request.getParameter("txtTourBookedID_Edit_Pending");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(bookedId);
                int representativeCusId = Integer.parseInt(request.getParameter("txtRepresentativeID_Edit_Pending"));
                CustomerUser representativeCus = customerUserFacade.find(representativeCusId);

                //int tourBookedSubId = Integer.valueOf(request.getParameter("txtTourBookedSubID_Edit_Pending"));
                TourBookedSub bookedSub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(bookedId, representativeCusId);
                int tourBookedSubId = bookedSub.getTourBookedSubID();
                //set tourBooked's isNew become false 
                tourBookedSubFacade.setIsNew(tourBookedSubId, false);

                List<CustomerListHasAge> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusId, bookedId);
                TourBookedSub tourBookedSub = tourBookedSubFacade.searchByiD(tourBookedSubId);

                int totalKidAndAdult = tourBookedSub.getNumberOfAdult() + tourBookedSub.getNumberOfKid();

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

                String fromWhere = request.getParameter("fromWhere");

                int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                request.setAttribute("availabelTicket", availableTicketRemained);
                request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                request.setAttribute("btnAdd_Edit_Text", "Add");
                request.setAttribute("tourBooked", tourBooked);
                request.setAttribute("representativeCus", representativeCus);
                request.setAttribute("listcus", listCus);
                request.setAttribute("tourBookedSub", tourBookedSub);
                request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                request.setAttribute("ticket", 0);
                request.setAttribute("numOfKidAndAdult", 0);
                request.setAttribute("isOutOfTicket", 0);
                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                request.setAttribute("isOutOfKidAndAdult", 0);
                request.setAttribute("fromWhere", fromWhere);
                request.setAttribute("babyError", 0);
                request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
            } else if (action.equals("btnBack_Update")) {
                List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(departingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(completedList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                request.setAttribute("PendingList", pendingList);
                request.setAttribute("DepartingList", departingList);
                request.setAttribute("CompletedList", completedList);
                request.setAttribute("CancelList", cancelList);

                request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

            } else if (action.equals("btnCancelSmallTeamReservation")) {
                String tourBookedId = request.getParameter("txtTourBookID");
                int representativeCusId = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                TourBookedSub tourBookedSubCancel = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusId);

                if (tourBookedSubFacade.cancelTourBookedSub(tourBookedSubCancel.getTourBookedSubID())) {
                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                }
            } else if (action.equals("btnEditSmallTeamPerform")) {
                String bookedID = request.getParameter("txtTourBookedID");
                String representativeCusID = request.getParameter("txtRepresentativeCustomerId");

                TourBookedSub tourBookedSub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(bookedID, Integer.valueOf(representativeCusID));

                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(bookedID);

                int individualRoomTotal = tourBooked.getIndividualRoom();
                int individualRoomWithout = individualRoomTotal - tourBookedSub.getIndividualRoom();
                int individualRoom = Integer.valueOf(request.getParameter("txtIndividualRoom"));

                int individualRoomUpdate = individualRoomWithout + individualRoom;
                Short transport = Short.valueOf(request.getParameter("txtTransportation"));

                tourBookedSub.setIndividualRoom(Short.valueOf(individualRoom + ""));
                tourBookedSub.setTransportation(transport);

                if (tourBookedSubFacade.update(tourBookedSub)) {

                    tourBooked.setIndividualRoom(Short.valueOf(individualRoomUpdate + ""));
                    tourBookedFacade.editTourBooked(tourBooked);

                    CustomerUser representativeCus = customerUserFacade.find(Integer.valueOf(representativeCusID));
                    List<CustomerListHasAge> listCus = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(Integer.valueOf(representativeCusID), bookedID);

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
                    int totalKidAndAdult = tourBookedSub.getNumberOfAdult() + tourBookedSub.getNumberOfKid();
                    int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                    request.setAttribute("availabelTicket", availableTicketRemained);
                    request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                    request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                    request.setAttribute("btnAdd_Edit_Text", "Add");
                    request.setAttribute("tourBooked", tourBooked);
                    request.setAttribute("representativeCus", representativeCus);
                    request.setAttribute("listcus", listCus);
                    request.setAttribute("tourBookedSub", tourBookedSub);
                    request.setAttribute("ticket", 0);
                    request.setAttribute("numOfKidAndAdult", 0);
                    request.setAttribute("isOutOfTicket", 0);
                    request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                    request.setAttribute("isOutOfKidAndAdult", 0);
                    request.setAttribute("babyError", 0);
                    request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                }

            } else if (action.equals("btnAddCus_Extra")) {
                CustomerList cusInsert = new CustomerList();

                int representativeCusID = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                CustomerUser representiveCus = customerUserFacade.find(representativeCusID);
                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                Short ticket = tourBooked.getTourID().getTickets();
                int numberOfKidAndAdult = tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid();
                int availableTicket = ticket - numberOfKidAndAdult;

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

                TourBookedSub tourBookedSubValidate = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);

                if (availableTicket > 0) {

                    if (age <= 5) {
                        if (tourBookedSubValidate.getNumberOfBaby() < tourBookedSubValidate.getNumberOfAdult()) {
                            if (customerListFacade.addCus(cusInsert)) {

                                List<CustomerListHasAge> listCus = new ArrayList<>();

                                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                    List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                    for (CustomerListHasAge customerList : listCusSub) {
                                        listCus.add(customerList);
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

                                Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                                int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                                int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                                request.setAttribute("availabelTicket", availableTicketRemained);
                                request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                                request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                                request.setAttribute("btnAdd_Edit_Text", "Add");
                                request.setAttribute("tourBooked", tourBooked);
                                request.setAttribute("representativeCus", representiveCus);
                                request.setAttribute("listcus", listCusSubHasAge);
                                request.setAttribute("tourBookedSub", tourBookedsub);
                                request.setAttribute("ticket", 0);
                                request.setAttribute("numOfKidAndAdult", 0);
                                request.setAttribute("isOutOfTicket", 0);
                                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                                request.setAttribute("isOutOfKidAndAdult", 0);
                                request.setAttribute("babyError", 0);
                                request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                            }
                        } else {
                            ///ERROR OF NUMBER OF BABY
                            TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                            List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                            Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                            int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                            request.setAttribute("availabelTicket", availableTicketRemained);
                            request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("tourBooked", tourBooked);
                            request.setAttribute("representativeCus", representiveCus);
                            request.setAttribute("listcus", listCusSubHasAge);
                            request.setAttribute("tourBookedSub", tourBookedsub);
                            request.setAttribute("ticket", ticket);
                            request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("babyError", 1);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                        }
                    } else {
                        if (customerListFacade.addCus(cusInsert)) {

                            List<CustomerListHasAge> listCus = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    listCus.add(customerList);
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

                            Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                            int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                            request.setAttribute("availabelTicket", availableTicketRemained);
                            request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("tourBooked", tourBooked);
                            request.setAttribute("representativeCus", representiveCus);
                            request.setAttribute("listcus", listCusSubHasAge);
                            request.setAttribute("tourBookedSub", tourBookedsub);
                            request.setAttribute("ticket", 0);
                            request.setAttribute("numOfKidAndAdult", 0);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("babyError", 0);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                        }
                    }

                } else {

                    if (age <= 5) {
                        if (tourBookedSubValidate.getNumberOfBaby() < tourBookedSubValidate.getNumberOfAdult()) {
                            if (customerListFacade.addCus(cusInsert)) {

                                List<CustomerListHasAge> listCus = new ArrayList<>();

                                List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                                for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                    List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                    for (CustomerListHasAge customerList : listCusSub) {
                                        listCus.add(customerList);
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

                                Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                                int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                                int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                                request.setAttribute("availabelTicket", availableTicketRemained);
                                request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                                request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                                request.setAttribute("btnAdd_Edit_Text", "Add");
                                request.setAttribute("tourBooked", tourBooked);
                                request.setAttribute("representativeCus", representiveCus);
                                request.setAttribute("listcus", listCusSubHasAge);
                                request.setAttribute("tourBookedSub", tourBookedsub);
                                request.setAttribute("ticket", 0);
                                request.setAttribute("numOfKidAndAdult", 0);
                                request.setAttribute("isOutOfTicket", 0);
                                request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                                request.setAttribute("isOutOfKidAndAdult", 0);
                                request.setAttribute("babyError", 0);
                                request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                            }
                        } else {
                            ///ERROR OF NUMBER OF BABY
                            TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                            List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                            Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                            int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                            request.setAttribute("availabelTicket", availableTicketRemained);
                            request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("tourBooked", tourBooked);
                            request.setAttribute("representativeCus", representiveCus);
                            request.setAttribute("listcus", listCusSubHasAge);
                            request.setAttribute("tourBookedSub", tourBookedsub);
                            request.setAttribute("ticket", ticket);
                            request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("babyError", 1);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                        }
                    } else {

                        TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representativeCusID);
                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representativeCusID, tourBookedId);
                        Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                        int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                        request.setAttribute("availabelTicket", availableTicketRemained);
                        request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("tourBooked", tourBooked);
                        request.setAttribute("representativeCus", representiveCus);
                        request.setAttribute("listcus", listCusSubHasAge);
                        request.setAttribute("tourBookedSub", tourBookedsub);
                        request.setAttribute("ticket", ticket);
                        request.setAttribute("numOfKidAndAdult", numberOfKidAndAdult);
                        request.setAttribute("isOutOfTicket", 1);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("babyError", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                    }

                }

            } else if (action.equals("btnEditCus_Extra")) {

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

                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                int representiveCusId = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
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

                String uiYearString = fmYear.format(dob);
                int uiDateInt = Integer.valueOf(uiYearString);

                int age = currentYearInt - uiDateInt;

                if (AdultTourBookedSub > 1) {
                    if (customerListFacade.editCus(cusEdit)) {

                        List<CustomerListHasAge> listCus = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                listCus.add(customerList);
                            }
                        }

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

                        Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                        int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                        request.setAttribute("availabelTicket", availableTicketRemained);
                        request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("tourBooked", tourBooked);
                        request.setAttribute("representativeCus", representiveCus);
                        request.setAttribute("listcus", listCusSubHasAge);
                        request.setAttribute("tourBookedSub", tourBookedsub);
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("babyError", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                    }
                } else {
                    if (age > 15) {
                        if (customerListFacade.editCus(cusEdit)) {

                            List<CustomerListHasAge> listCus = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    listCus.add(customerList);
                                }
                            }

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

                            Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                            int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                            request.setAttribute("availabelTicket", availableTicketRemained);
                            request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("tourBooked", tourBooked);
                            request.setAttribute("representativeCus", representiveCus);
                            request.setAttribute("listcus", listCusSubHasAge);
                            request.setAttribute("tourBookedSub", tourBookedsub);
                            request.setAttribute("ticket", 0);
                            request.setAttribute("numOfKidAndAdult", 0);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("babyError", 0);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                        }
                    } else {
                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                        Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                        int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                        request.setAttribute("availabelTicket", availableTicketRemained);
                        request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("tourBooked", tourBooked);
                        request.setAttribute("representativeCus", representiveCus);
                        request.setAttribute("listcus", listCusSubHasAge);
                        request.setAttribute("tourBookedSub", tourBookedsub);
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 1);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("babyError", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                    }
                }

            } else if (action.equals("btnDeleteCus_Extra")) {

                String tourBookedId = request.getParameter("txtTourBookID");
                TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedId);

                int representiveCusId = Integer.parseInt(request.getParameter("txtRepresentativeCustomerId"));
                CustomerUser representiveCus = customerUserFacade.find(representiveCusId);

                int cusid = Integer.valueOf(request.getParameter("txtCusID_Delete"));
                String name = request.getParameter("txtCusName_Delete");

                CustomerList cusDelete = customerListFacade.searchByCusIdAndName(cusid, name);

                SimpleDateFormat fmYear = new SimpleDateFormat("yyyy");
                String currentYearString = fmYear.format(new Date());
                int currentYearInt = Integer.valueOf(currentYearString);

                String sqlYearString = fmYear.format(cusDelete.getDateOfBirth());
                int realInt = Integer.valueOf(sqlYearString);

                int age = currentYearInt - realInt;

                TourBookedSub tourBookedsub = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedId, representiveCusId);

                int numOfKidAndAdultTourBookedSub = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                
                if (numOfKidAndAdultTourBookedSub > 1) {
                    if (customerListFacade.deleteCusByIdAndName(cusid, name)) {
                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                        List<CustomerListHasAge> listCus = new ArrayList<>();

                        List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                        for (TourBookedSub tourBookedSub : listTourBookedSub) {
                            List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                            for (CustomerListHasAge customerList : listCusSub) {
                                listCus.add(customerList);
                            }
                        }

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

                        Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                        int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                        request.setAttribute("availabelTicket", availableTicketRemained);
                        request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("tourBooked", tourBooked);
                        request.setAttribute("representativeCus", representiveCus);
                        request.setAttribute("listcus", listCusSubHasAge);
                        request.setAttribute("tourBookedSub", tourBookedsub);
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("isOutOfKidAndAdult", 0);
                        request.setAttribute("babyError", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                    }
                } else {
                    
                    CustomerListHasAge cusdelete = customerListFacade.searchByCusIdHasAge(cusid);
                    
                    if (cusdelete.getAge() < 16) {
                        if (customerListFacade.deleteCusByIdAndName(cusid, name)) {
                            List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                            List<CustomerListHasAge> listCus = new ArrayList<>();

                            List<TourBookedSub> listTourBookedSub = tourBookedSubFacade.searchlistTourBookedSub_ByTourBookedIdAndStatus(tourBookedId, Short.valueOf(1 + ""));

                            for (TourBookedSub tourBookedSub : listTourBookedSub) {
                                List<CustomerListHasAge> listCusSub = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(tourBookedSub.getCustomerID().getCustomerID(), tourBookedId);
                                for (CustomerListHasAge customerList : listCusSub) {
                                    listCus.add(customerList);
                                }
                            }

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

                            Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                            int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                            int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                            request.setAttribute("availabelTicket", availableTicketRemained);
                            request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                            request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                            request.setAttribute("btnAdd_Edit_Text", "Add");
                            request.setAttribute("tourBooked", tourBooked);
                            request.setAttribute("representativeCus", representiveCus);
                            request.setAttribute("listcus", listCusSubHasAge);
                            request.setAttribute("tourBookedSub", tourBookedsub);
                            request.setAttribute("ticket", 0);
                            request.setAttribute("numOfKidAndAdult", 0);
                            request.setAttribute("isOutOfTicket", 0);
                            request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                            request.setAttribute("isOutOfKidAndAdult", 0);
                            request.setAttribute("babyError", 0);
                            request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);

                        }
                    } else {
                        List<CustomerListHasAge> listCusSubHasAge = customerListFacade.searchByRepresentiveCustomerIdAndBookedID_HasAge(representiveCusId, tourBookedId);
                        Collections.sort(listCusSubHasAge, new Comparator<CustomerListHasAge>() {
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

                        int totalKidAndAdult = tourBookedsub.getNumberOfAdult() + tourBookedsub.getNumberOfKid();
                        int availableTicketRemained = tourBooked.getTourID().getTickets() - (tourBooked.getNumberOfAdult() + tourBooked.getNumberOfKid());
                        request.setAttribute("availabelTicket", availableTicketRemained);
                        request.setAttribute("totalKidAndAdult", totalKidAndAdult);
                        request.setAttribute("btnAdd_Edit_Value", "btnAddCus_Extra");
                        request.setAttribute("btnAdd_Edit_Text", "Add");
                        request.setAttribute("tourBooked", tourBooked);
                        request.setAttribute("representativeCus", representiveCus);
                        request.setAttribute("listcus", listCusSubHasAge);
                        request.setAttribute("tourBookedSub", tourBookedsub);
                        request.setAttribute("ticket", 0);
                        request.setAttribute("numOfKidAndAdult", 0);
                        request.setAttribute("isOutOfTicket", 0);
                        request.setAttribute("isOutOfKidAndAdult_Edit", 0);
                        request.setAttribute("isOutOfKidAndAdult", 1);
                        request.setAttribute("babyError", 0);
                        request.getRequestDispatcher("/admin/tourBooked_Odd_Sub_Update.jsp").forward(request, response);
                    }

                }

            } else if (action.equals("SearchTourBookedSub_Cancel")) {

                String searchType = request.getParameter("searchType");
                String searchText = request.getParameter("txtSearch");
                if (searchType.equals("Tour Booked ID")) {
                    int bookedSubID = Integer.valueOf(searchText);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourBookedSubIdAndStatus_Toan(bookedSubID, Short.valueOf(4 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", listSearch);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Tour ID")) {
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourIDAndStatus_Toan(searchText, Short.valueOf(4 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", listSearch);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Departure Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeDerpartureDateAndStatus_Toan(searchTextDate, Short.valueOf(4 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", listSearch);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Booked Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeBookedDateAndStatus_Toan(searchTextDate, Short.valueOf(4 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", listSearch);
                    //request.setAttribute("CancelListSub", listSearch);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                }

            } else if (action.equals("SearchTourBookedSub_Pending")) {

                String searchType = request.getParameter("searchType");
                String searchText = request.getParameter("txtSearch");
                if (searchType.equals("Tour Booked ID")) {
                    int bookedSubID = Integer.valueOf(searchText);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourBookedSubIdAndStatus_Toan(bookedSubID, Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", listSearch);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Tour ID")) {
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourIDAndStatus_Toan(searchText, Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", listSearch);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Departure Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeDerpartureDateAndStatus_Toan(searchTextDate, Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", listSearch);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Booked Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeBookedDateAndStatus_Toan(searchTextDate, Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", listSearch);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                }
            } else if (action.equals("SearchTourBookedSub_Departing")) {

                String searchType = request.getParameter("searchType");
                String searchText = request.getParameter("txtSearch");
                if (searchType.equals("Tour Booked ID")) {
                    int bookedSubID = Integer.valueOf(searchText);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourBookedSubIdAndStatus_Toan(bookedSubID, Short.valueOf(2 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", listSearch);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Tour ID")) {
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourIDAndStatus_Toan(searchText, Short.valueOf(2 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", listSearch);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Departure Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeDerpartureDateAndStatus_Toan(searchTextDate, Short.valueOf(2 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", listSearch);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Booked Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeBookedDateAndStatus_Toan(searchTextDate, Short.valueOf(2 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(completedList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", listSearch);
                    request.setAttribute("CompletedList", completedList);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                }
            } else if (action.equals("SearchTourBookedSub_Completed")) {

                String searchType = request.getParameter("searchType");
                String searchText = request.getParameter("txtSearch");
                if (searchType.equals("Tour Booked ID")) {
                    int bookedSubID = Integer.valueOf(searchText);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourBookedSubIdAndStatus_Toan(bookedSubID, Short.valueOf(3 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", listSearch);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Tour ID")) {
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeTourIDAndStatus_Toan(searchText, Short.valueOf(3 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", listSearch);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);

                } else if (searchType.equals("Departure Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeDerpartureDateAndStatus_Toan(searchTextDate, Short.valueOf(3 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", listSearch);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                } else if (searchType.equals("Booked Date")) {
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    ParsePosition p = new ParsePosition(0);
                    Date searchTextDate = fm.parse(searchText, p);
                    List<TourBookedSub> listSearch = tourBookedSubFacade.searchlikeBookedDateAndStatus_Toan(searchTextDate, Short.valueOf(3 + ""));

                    List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                    List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                    List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                    Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    Collections.sort(departingList, new Comparator<TourBookedSub>() {
                        @Override
                        public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                            if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                                return -1;
                            }
                            if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                                return 1;
                            }
                            return 0;
                        }
                    });

                    request.setAttribute("PendingList", pendingList);
                    request.setAttribute("DepartingList", departingList);
                    request.setAttribute("CompletedList", listSearch);
                    request.setAttribute("CancelList", cancelList);

                    request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
                }
            } else if (action.equals("btnReload")) {

                List<TourBookedSub> pendingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(1 + ""));

                List<TourBookedSub> departingList = tourBookedSubFacade.searchListByStatus(Short.valueOf(2 + ""));

                List<TourBookedSub> completedList = tourBookedSubFacade.searchListByStatus(Short.valueOf(3 + ""));

                List<TourBookedSub> cancelList = tourBookedSubFacade.searchListByStatus(Short.valueOf(4 + ""));

                Collections.sort(pendingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(departingList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(completedList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                Collections.sort(cancelList, new Comparator<TourBookedSub>() {
                    @Override
                    public int compare(TourBookedSub tour1, TourBookedSub tour2) {
                        if (tour1.getTourBookedSubID() > tour2.getTourBookedSubID()) {
                            return -1;
                        }
                        if (tour1.getTourBookedSubID() < tour2.getTourBookedSubID()) {
                            return 1;
                        }
                        return 0;
                    }
                });

                request.setAttribute("PendingList", pendingList);
                request.setAttribute("DepartingList", departingList);
                request.setAttribute("CompletedList", completedList);
                request.setAttribute("CancelList", cancelList);

                request.getRequestDispatcher("/admin/adminTour_SubTour_Reserved.jsp").forward(request, response);
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
