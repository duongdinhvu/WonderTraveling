/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adminController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.CarBookedReport;
import java.io.IOException;
import java.io.OutputStream;
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
import sessionbean.CarBookedFacadeLocal;

/**
 *
 * @author REY
 */
public class AdminCar_ReportTour_FilePDF_Controller extends HttpServlet {

    @EJB
    private CarBookedFacadeLocal carBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        String datefromString = request.getParameter("txtDateFrom");
        String datetoString = request.getParameter("txtDateTo");

        Date toDay = new Date();

        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        ParsePosition p = new ParsePosition(0);
        ParsePosition p1 = new ParsePosition(0);
        Date dateFrom = fm.parse(datefromString, p);
        Date dateTo = fm.parse(datetoString, p1);

        String dayOfIssued = fm.format(toDay);

        String action = request.getParameter("action");

        if (action.equals("btnPrintTop05OfRevenue")) {
            try {
                Document docement = new Document();
                PdfWriter.getInstance(docement, out);

                docement.open();

                String absolutepath = getServletContext().getRealPath("\\assets\\images\\logo.png");

                Image logo = Image.getInstance(absolutepath);
                logo.setAlignment(Element.ALIGN_LEFT);
                logo.scaleToFit(200, 150);

                Paragraph par = new Paragraph();
                Font fontInfo = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Address: 590 CMT8 - District 3 - Ho Chi Minh City", fontInfo));
                par.setAlignment(Element.ALIGN_LEFT);
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase("Contact: 0948 277 065 Mr.Khoa", fontInfo));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));

                Paragraph par1 = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                par1.add(new Phrase("TOP 5 OF CAR REVENUE", font));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("From : " + datefromString));
                par1.add(new Phrase("       "));
                par1.add(new Phrase("To : " + datetoString));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));

                PdfPTable table = new PdfPTable(4);
                PdfPCell cell1 = new PdfPCell(new Paragraph("Top", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Car ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Car Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Car Revenue", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                table.addCell(cell1);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell2);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell3);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell4);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                Font fontDayOfIssueed = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Paragraph("Day Of Issued : " + dayOfIssued + "", fontDayOfIssueed));

                List<CarBookedReport> listPrint = carBookedFacade.top05HighestRevenue(dateFrom, dateTo);

                double sum = 0;

                for (CarBookedReport car : listPrint) {
                    sum += car.getRevenue();
                }

                for (int i = 0; i < listPrint.size(); i++) {
                    if (sum != 0) {
                        table.addCell((i + 1) + "");
                        table.addCell(listPrint.get(i).getCarID() + "");
                        table.addCell(listPrint.get(i).getCarName());
                        table.addCell(String.valueOf(listPrint.get(i).getRevenue() + " USD"));
                        //table.addCell(String.valueOf(sum + "USD")); 
                    }
                    if (sum == 0) {
                        table.addCell("");
                        table.addCell("");
                        table.addCell("");
                        table.addCell("");
                    }

                }

                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell(String.valueOf("Total: " + sum + "USD"));

                table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                docement.add(logo);
                docement.add(par);
                docement.add(par1);
                docement.add(table);
                docement.add(par3);
                docement.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }

        if (action.equals("btnPrintTop05Car")) {
            try {
                Document docement = new Document();
                PdfWriter.getInstance(docement, out);

                docement.open();

                String absolutepath = getServletContext().getRealPath("\\assets\\images\\logo.png");

                Image logo = Image.getInstance(absolutepath);
                logo.setAlignment(Element.ALIGN_LEFT);
                logo.scaleToFit(200, 150);

                Paragraph par = new Paragraph();
                Font fontInfo = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Address: 590 CMT8 - District 3 - Ho Chi Minh City", fontInfo));
                par.setAlignment(Element.ALIGN_LEFT);
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase("Contact: 0948 277 065 Mr.Khoa", fontInfo));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));

                Paragraph par1 = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                par1.add(new Phrase("TOP 5 OF CAR REVENUE", font));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase("From : " + datefromString));
                par1.add(new Phrase("       "));
                par1.add(new Phrase("To : " + datetoString));
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));

                PdfPTable table = new PdfPTable(4);
                PdfPCell cell1 = new PdfPCell(new Paragraph("Top", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Car ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Car Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("No. of Car Booked", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                table.addCell(cell1);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell2);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell3);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                table.addCell(cell4);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                Font fontDayOfIssueed = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Paragraph("Day Of Issued : " + dayOfIssued + "", fontDayOfIssueed));

                List<CarBookedReport> listPrint = carBookedFacade.top05CarBook(dateFrom, dateTo);

                int sum = 0;

                for (CarBookedReport car : listPrint) {
                    sum += car.getNumOfBooked();
                }

                for (int i = 0; i < listPrint.size(); i++) {
                    table.addCell((i + 1) + "");
                    table.addCell(listPrint.get(i).getCarID() + "");
                    table.addCell(listPrint.get(i).getCarName());
                    table.addCell(String.valueOf(listPrint.get(i).getNumOfBooked()));
                    //table.addCell(String.valueOf(sum + "USD"));
                }

                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell(String.valueOf("Total: " + sum));

                table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                docement.add(logo);
                docement.add(par);
                docement.add(par1);
                docement.add(table);
                docement.add(par3);
                docement.close();
            } catch (Exception ex) {
                ex.getMessage();
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
