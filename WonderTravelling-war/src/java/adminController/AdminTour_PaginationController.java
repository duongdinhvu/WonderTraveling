/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminController;

import Untils.Pagination;
import entities.Tours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dieut
 */
public class AdminTour_PaginationController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int recordOnPage = 3;
            String currentPage = request.getParameter("txtCurrentPage");
            
  
            HttpSession session = request.getSession();
            Pagination paging = new Pagination();
            List<String> listAllKey = (List<String>) session.getAttribute("listKey");
            List<String> listDestionation = (List<String>) session.getAttribute("listDestination");
      
            paging.setRecordOnPage(recordOnPage);
            paging.setCurrentPage(Integer.parseInt(currentPage));
            paging.setListAllKey(listAllKey);
            paging.GetToursFromListKey();

            List<Tours> listTour = paging.getListOnPage();
            paging.GetStartEnd();

            request.setAttribute("listTour", listTour);
            request.setAttribute("CurrentPage", currentPage);
            request.setAttribute("StartPage", paging.getStartPage());
            request.setAttribute("EndPage", paging.getEndPage());
            request.setAttribute("RecordOnPage", recordOnPage);
            request.setAttribute("TotalPage", paging.getTotalPage());
            session.setAttribute("listDestination", listDestionation);
            request.getRequestDispatcher("/admin/adminTour_SearchTour.jsp").forward(request, response);
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
