/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import com.google.gson.Gson;
import entities.TourBooked;
import entities.TourCategory;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.TourCategoryFacadeLocal;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_TourCategoryUpdate_Controller extends HttpServlet {

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    @EJB
    private ToursFacadeLocal toursFacade;

    @EJB
    private TourCategoryFacadeLocal tourCategoryFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");

            if (action.equals("btnTourCategoryUpdate_Link")) {

                int tcID = Integer.valueOf(request.getParameter("txtTourCategoryIDUpdate"));
                TourCategory tourcategory = tourCategoryFacade.findById(tcID);

                //Filter Destination List
                List<TourCategory> listAll = tourCategoryFacade.findAll();

                String listDesString = "An Giang, Vung Tau, Bac Giang, Bac Kan, Bac Lieu, Bac Ninh, Ben Tre, "
                        + "Binh Dinh, Binh Duong, Binh Phuoc, Binh Thuan, Can Tho, Ca Mau, Cao Bang, Dak Lak, Dak Nong, "
                        + "Da Nang, Dien Bien, Dong Nai, Dong Thap, Gia Lai, Ha Giang, Ha Nam, Ha Tinh, Hai Phong, "
                        + "Ha Noi, Hai Duong, Hau Giang, Hoa Binh, Hung Yen, Khanh Hoa, Kien Giang, Phu Quoc, Kon Tum, "
                        + "Lai Chau, Lam Dong, Da Lat, Lang Son, Lao Cai, Long An, Nam Dinh, Nghe An, Ninh Binh, "
                        + "Ninh Thuan, Phu Tho, Quang Binh, Quang Nam, Quang Ngai, Quang Ninh, Quang Tri, Soc Trang, "
                        + "Son La, Ho Chi Minh City, Tay Ninh, Thai Binh, Thai Nguyen, Thanh Hoa, Thua Thien Hue, Tien Giang, "
                        + "Tra Vinh, Tuyen Quang, Vinh Long, Vinh Phuc, Yen Bai, Phu Yen";

                String[] listDesArray = listDesString.split(", ");
                ArrayList<String> listDesArrayList = new ArrayList<>();
                for (String des : listDesArray) {
                    listDesArrayList.add(des);
                }

                String listDesStringFromData = "";
                for (TourCategory tourCategory : listAll) {
                    listDesStringFromData += (", " + tourCategory.getDestination());
                }
                listDesStringFromData = listDesStringFromData.substring(2, listDesStringFromData.length());

                String[] listDesFromDataArray = listDesStringFromData.split(", ");
                ArrayList<String> listDesFromDataArrayList = new ArrayList<>();

                for (String des : listDesFromDataArray) {
                    listDesFromDataArrayList.add(des);
                }

                for (int i = 0; i < listDesFromDataArrayList.size(); i++) {
                    for (int j = 0; j < listDesArrayList.size(); j++) {
                        if (listDesArrayList.get(j).equals(listDesFromDataArrayList.get(i))) {
                            listDesArrayList.remove(listDesArrayList.get(j));
                        }
                    }
                }
                //END Filter Destination List

                //get destination is already generated of Book
                String itsDestinationString = tourcategory.getDestination();
                String[] itsDestinationArray = itsDestinationString.split(", ");
                ArrayList<String> itsDestinationArrayList = new ArrayList<>();
                for (String des : itsDestinationArray) {
                    itsDestinationArrayList.add(des);
                }

                String stringOfDesAlreadyGenerated = "";
                for (int i = 0; i < itsDestinationArrayList.size(); i++) {
                    List<TourBooked> list = tourBookedFacade.isGenerated(itsDestinationArrayList.get(i));
                    if (!list.isEmpty()) {
                        stringOfDesAlreadyGenerated += (", " + itsDestinationArrayList.get(i));
                    }
                }
                if (stringOfDesAlreadyGenerated.length() > 0) {
                    stringOfDesAlreadyGenerated = stringOfDesAlreadyGenerated.substring(2, stringOfDesAlreadyGenerated.length());
                }
                //END get destination is already generated of Book
                
                request.setAttribute("tourcategory", tourcategory);
                request.setAttribute("desString", listDesArrayList);
                request.setAttribute("stringOfDesGenerated", stringOfDesAlreadyGenerated);
                request.getRequestDispatcher("/admin/tourCategoryUpdate.jsp").forward(request, response);

            } else if (action.equals("btnUpdate_Action")) {

                String tourCategoryID = request.getParameter("txtTourCategoryID");
                String tourCategoryName = request.getParameter("txtTourCategoryName");
                String tourCT_Destination = request.getParameter("txtTourCategoryDestination");
                String des = "";
                String lastCharacter = String.valueOf(tourCT_Destination.charAt(tourCT_Destination.length() - 1));

                if (lastCharacter.equals(" ") || lastCharacter.equals(",")) {

                    des = tourCT_Destination.substring(0, tourCT_Destination.length() - 2);
                } else {
                    des = tourCT_Destination;
                }

                TourCategory tcup = tourCategoryFacade.findById(Integer.valueOf(tourCategoryID));
                tcup.setTourCategoryName(tourCategoryName);
                tcup.setDestination(des);
                if (tourCategoryFacade.updateTourCategory(tcup)) {
                    request.getRequestDispatcher("AdminTour_TourCategorySelect_Controller").forward(request, response);
                }

            } else if (action.equals("btnReset")) {
                int tcID = Integer.valueOf(request.getParameter("txtTourCategoryID"));
                TourCategory tourcategory = tourCategoryFacade.findById(tcID);

                //Filter Destination List
                List<TourCategory> listAll = tourCategoryFacade.findAll();

                String listDesString = "An Giang, Vung Tau, Bac Giang, Bac Kan, Bac Lieu, Bac Ninh, Ben Tre, "
                        + "Binh Dinh, Binh Duong, Binh Phuoc, Binh Thuan, Can Tho, Ca Mau, Cao Bang, Dak Lak, Dak Nong, "
                        + "Da Nang, Dien Bien, Dong Nai, Dong Thap, Gia Lai, Ha Giang, Ha Nam, Ha Tinh, Hai Phong, "
                        + "Ha Noi, Hai Duong, Hau Giang, Hoa Binh, Hung Yen, Khanh Hoa, Kien Giang, Phu Quoc, Kon Tum, "
                        + "Lai Chau, Lam Dong, Da Lat, Lang Son, Lao Cai, Long An, Nam Dinh, Nghe An, Ninh Binh, "
                        + "Ninh Thuan, Phu Tho, Quang Binh, Quang Nam, Quang Ngai, Quang Ninh, Quang Tri, Soc Trang, "
                        + "Son La, Ho Chi Minh City, Tay Ninh, Thai Binh, Thai Nguyen, Thanh Hoa, Thua Thien Hue, Tien Giang, "
                        + "Tra Vinh, Tuyen Quang, Vinh Long, Vinh Phuc, Yen Bai, Phu Yen";

                String[] listDesArray = listDesString.split(", ");
                ArrayList<String> listDesArrayList = new ArrayList<>();
                for (String des : listDesArray) {
                    listDesArrayList.add(des);
                }

                String listDesStringFromData = "";
                for (TourCategory tourCategory : listAll) {
                    listDesStringFromData += (", " + tourCategory.getDestination());
                }
                listDesStringFromData = listDesStringFromData.substring(2, listDesStringFromData.length());

                String[] listDesFromDataArray = listDesStringFromData.split(", ");
                ArrayList<String> listDesFromDataArrayList = new ArrayList<>();

                for (String des : listDesFromDataArray) {
                    listDesFromDataArrayList.add(des);
                }

                for (int i = 0; i < listDesFromDataArrayList.size(); i++) {
                    for (int j = 0; j < listDesArrayList.size(); j++) {
                        if (listDesArrayList.get(j).equals(listDesFromDataArrayList.get(i))) {
                            listDesArrayList.remove(listDesArrayList.get(j));
                        }
                    }
                }
                //END Filter Destination List
                
                //get destination is already generated of Book
                String itsDestinationString = tourcategory.getDestination();
                String[] itsDestinationArray = itsDestinationString.split(", ");
                ArrayList<String> itsDestinationArrayList = new ArrayList<>();
                for (String des : itsDestinationArray) {
                    itsDestinationArrayList.add(des);
                }

                String stringOfDesAlreadyGenerated = "";
                for (int i = 0; i < itsDestinationArrayList.size(); i++) {
                    List<TourBooked> list = tourBookedFacade.isGenerated(itsDestinationArrayList.get(i));
                    if (!list.isEmpty()) {
                        stringOfDesAlreadyGenerated += (", " + itsDestinationArrayList.get(i));
                    }
                }
                if (stringOfDesAlreadyGenerated.length() > 0) {
                    stringOfDesAlreadyGenerated = stringOfDesAlreadyGenerated.substring(2, stringOfDesAlreadyGenerated.length());
                }
                //END get destination is already generated of Book
                
                request.setAttribute("tourcategory", tourcategory);
                request.setAttribute("desString", listDesArrayList);
                request.setAttribute("stringOfDesGenerated", stringOfDesAlreadyGenerated);
                request.getRequestDispatcher("/admin/tourCategoryUpdate.jsp").forward(request, response);
            } else if (action.equals("btnCancel")) {
                request.getRequestDispatcher("AdminTour_TourCategorySelect_Controller").forward(request, response);
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
