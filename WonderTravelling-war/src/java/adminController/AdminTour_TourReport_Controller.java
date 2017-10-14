/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import entities.TourBookedTopReportDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TourBookedFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_TourReport_Controller extends HttpServlet {
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");

            if (action.equals("reportPageCalling")) {
                request.getRequestDispatcher("/admin/adminTour_Report.jsp").forward(request, response);
            } else if (action.equals("btnViewReport")) {
                String datefromString = request.getParameter("txtDateFrom");
                String datetoString = request.getParameter("txtDateTo");
                String reportType = request.getParameter("slReportType");
                
                Date toDay = new Date();
                
                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p = new ParsePosition(0);
                ParsePosition p1 = new ParsePosition(0);
                Date dateFrom = fm.parse(datefromString, p);
                Date dateTo = fm.parse(datetoString, p1);
                
                String dayOfIssued = fm.format(toDay);
                
                if (reportType.equals("Top 05 Most Booked Of Tours")) {
                    List<TourBookedTopReportDTO> list = tourBookedFacade.top05TourBookedMost(dateFrom, dateTo);
                    
                    int sum = 0;
                    
                    for (TourBookedTopReportDTO DTO : list) {
                        sum += DTO.getNumOfbooked();
                    }
                    
                    request.setAttribute("sum", sum);
                    request.setAttribute("dayOfIssued", dayOfIssued);
                    request.setAttribute("list", list);
                    request.setAttribute("dateFromString", datefromString);
                    request.setAttribute("dateToString", datetoString);
                    request.getRequestDispatcher("/admin/adminTour_ReportTop05OfBook.jsp").forward(request, response);
                } else if (reportType.equals("Top 05 Highest Revenue Of Tours")) {
                    List<TourBookedTopReportDTO> list = tourBookedFacade.top05HighestRevenueOfTour(dateFrom, dateTo);
                    
                    double sum = 0;
                    
                    for (TourBookedTopReportDTO DTO : list) {
                        sum += DTO.getRevenue();
                    }
                    
                    request.setAttribute("sum", sum);
                    request.setAttribute("dayOfIssued", dayOfIssued);
                    request.setAttribute("list", list);
                    request.setAttribute("dateFromString", datefromString);
                    request.setAttribute("dateToString", datetoString);
                    request.getRequestDispatcher("/admin/adminTour_ReportTop05OfRevenue.jsp").forward(request, response);
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
