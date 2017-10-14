/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.adminController;

import entities.Car;
import entities.Promotion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.PromotionFacadeLocal;

/**
 *
 * @author REY
 */
public class adminPromotionAddController extends HttpServlet {
    
    @EJB
    private PromotionFacadeLocal promotionFacade;

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        request.getRequestDispatcher("admin/adminPromotionAdd.jsp").forward(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            //String insert = URLDecoder.decode(action, "UTF-8");

            if (action.equals("add")) {
                String proCode = (request.getParameter("txtProCode")).replaceAll("\\s+", "");
                String proCode1 = proCode.replaceAll("(^\\s+|\\s+$)", "");
                               

                short stt = 0;
                if (request.getParameter("radStatus").equals("true")) {
                    stt = 1;
                } else if (request.getParameter("radStatus").equals("false")) {
                    stt = 2;
                }

                 //Create Date
                String createDate = request.getParameter("txtCreatedDate");

                SimpleDateFormat sfm = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p1 = new ParsePosition(0);
                Date cDate = sfm.parse(createDate, p1);

                //Start Update
                String startDate = request.getParameter("txtStartDate");

                SimpleDateFormat sfm1 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p2 = new ParsePosition(0);
                Date sDate = sfm1.parse(startDate, p2);
                
                //End Update
                String endDate = request.getParameter("txtEndDate");

                SimpleDateFormat sfm2 = new SimpleDateFormat("dd-MM-yyyy");
                ParsePosition p3 = new ParsePosition(0);
                Date eDate = sfm1.parse(endDate, p3);
                
                Promotion pro = new Promotion();
                
                pro.setPromotionCode(proCode1);
                pro.setStartDate(sDate);
                pro.setEndDate(eDate);
                pro.setStatus(stt);

                promotionFacade.create(pro);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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
