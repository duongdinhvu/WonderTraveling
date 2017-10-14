/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adminController;

import entities.Car;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CarFacadeLocal;

/**
 *
 * @author REY
 */
public class adminCarEditController extends HttpServlet {

    @EJB
    private CarFacadeLocal carFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            
            if (action.equals("edit")) {
                int carID = Integer.parseInt(request.getParameter("carID"));
                Car car = carFacade.find(carID);
                request.setAttribute("id", car);
                request.getRequestDispatcher("admin/adminCarEdit.jsp").forward(request, response);
            }

            if (action.equals("update")) {
                String carName = (request.getParameter("txtCarName")).replaceAll("\\s+", " ");
                String carName1 = carName.replaceAll("(^\\s+|\\s+$)", "");
                
                String carImage = "assets/images/cars" + "/" + request.getParameter("txtCarImage");
                String imageLoad = request.getParameter("imgCarImage");

                if (carImage.length()>20) {
                    imageLoad = carImage;
                }
                
                
                String carLic = (request.getParameter("txtCarLic")).replaceAll("\\s+", "");
                String carLic1 = carLic.replaceAll("(^\\s+|\\s+$)", "");
                
                int carIDs = Integer.parseInt(request.getParameter("txtCarID"));

                String trans = "";
                if (request.getParameter("radTrans").equals("automatic")) {
                    trans = "automatic";
                } else if (request.getParameter("radTrans").equals("manual")) {
                    trans = "manual";
                }

                boolean gps = true;
                if (request.getParameter("radGPS").equals("true")) {
                    gps = true;
                } else if (request.getParameter("radGPS").equals("false")) {
                    gps = false;
                }

                boolean chair = true;
                if (request.getParameter("radChair").equals("true")) {
                    chair = true;
                } else if (request.getParameter("radChair").equals("false")) {
                    chair = false;
                }

                boolean air = true;
                if (request.getParameter("radAir").equals("true")) {
                    air = true;
                } else if (request.getParameter("radAir").equals("false")) {
                    air = false;
                }

                boolean stt = true;
                if (request.getParameter("radStatus").equals("true")) {
                    stt = true;
                } else if (request.getParameter("radStatus").equals("false")) {
                    stt = false;
                }

                Double price = Double.parseDouble(request.getParameter("txtPrice"));
                Short seat = Short.parseShort(request.getParameter("txtSeat"));
                Short door = Short.parseShort(request.getParameter("txtDoor"));

                Car carUp = new Car(carIDs, carName1, imageLoad, trans, air, door, seat, stt, price, gps, chair, carLic1);
                carFacade.edit(carUp);

                request.getRequestDispatcher("adminCarListController").forward(request, response);
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
