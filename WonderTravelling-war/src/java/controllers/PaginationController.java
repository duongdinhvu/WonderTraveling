package controllers;

import Untils.Pagination;
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
import javax.servlet.http.HttpSession;
import sessionbean.ToursFacadeLocal;

/**
 *
 * @author vahu
 */
public class PaginationController extends HttpServlet {

    @EJB
    private ToursFacadeLocal toursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int recordOnPage = 9;
            String currentPage = request.getParameter("txtCurrentPage");

            HttpSession session = request.getSession();
            Pagination paging = new Pagination();
            List<String> listAllKey = (List<String>) session.getAttribute("listKey");

            paging.setRecordOnPage(recordOnPage);
            paging.setCurrentPage(Integer.parseInt(currentPage));
            paging.setListAllKey(listAllKey);
            paging.GetToursFromListKey();

            List<Tours> listTour = paging.getListOnPage();
            paging.GetStartEnd();

            String depaturePoint = "";
            List<Tours> tours = toursFacade.findAll();
            List<Tours> tourDepaturePoint = new ArrayList<>();
            for (Tours item : tours) {
                if (!item.getDepaturePoint().equals(depaturePoint)) {

                    tourDepaturePoint.add(item);
                }
                depaturePoint = item.getDepaturePoint();

            }
            request.setAttribute("tourDepaturePoint", tourDepaturePoint);
            request.setAttribute("tours", tours);

            request.setAttribute("listTour", listTour);
            request.setAttribute("CurrentPage", currentPage);
            request.setAttribute("StartPage", paging.getStartPage());
            request.setAttribute("EndPage", paging.getEndPage());
            request.setAttribute("RecordOnPage", recordOnPage);
            request.setAttribute("TotalPage", paging.getTotalPage());
            request.getRequestDispatcher("user/template/tour.jsp").forward(request, response);
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
