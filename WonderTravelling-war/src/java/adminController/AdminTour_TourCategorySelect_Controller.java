/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.TourCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TourCategoryFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_TourCategorySelect_Controller extends HttpServlet {

    @EJB
    private TourCategoryFacadeLocal tourCategoryFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
           
            request.setAttribute("list", listAll);
            request.setAttribute("desString", listDesArrayList);
            request.getRequestDispatcher("/admin/tourCategory.jsp").forward(request, response);
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
