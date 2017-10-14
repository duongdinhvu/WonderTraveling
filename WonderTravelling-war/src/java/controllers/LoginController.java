/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.CustomerUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CustomerUserFacadeLocal;

/**
 *
 * @author vahu
 */
public class LoginController extends HttpServlet {

    @EJB
    private CustomerUserFacadeLocal customerUserFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            if (action.equalsIgnoreCase("formLogin")) {
                Gson gson0 = new Gson();
                String json0 = gson0.toJson("form_login");
                response.getWriter().write(json0);
            }
            if (action.equalsIgnoreCase("Login")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String format = "{\"user\":\"%s\",\"message\":\"%s\"}";
                if (customerUserFacade.isUserExist(username, password)) {
                    CustomerUser role = customerUserFacade.getCustomerUser(username);

                    switch (role.getRoleID().getRoleID()) {
                        case 1:
                            //Set admin name in admin.jsp
                            //  request.setAttribute("rolename", "Admin");
                            //session
                            //initialize Session
                            session.setAttribute("sessionAdmin", username);
                            session.setAttribute("rolename", "Admin");
                            response.getWriter().write(String.format(format, username,"success_admin"));
                            // request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                            break;

                        case 3:
                            session.setAttribute("sessionUser", username);
                            session.setAttribute("rolename", username);
                       
                            
                           // String json = gson.toJson("[{user:"+username+"}]");
                            response.getWriter().write(String.format(format, username,"success_user"));
                            //request.getRequestDispatcher("FirstController").forward(request, response);
                            break;

                    }
                } else {
                    Gson gson = new Gson();
                    String json = gson.toJson("error");
                    response.getWriter().write(json);
                }
            } else if (action.equalsIgnoreCase("logout")) {
                session.invalidate();
                request.getRequestDispatcher("FirstController").forward(request, response);
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
