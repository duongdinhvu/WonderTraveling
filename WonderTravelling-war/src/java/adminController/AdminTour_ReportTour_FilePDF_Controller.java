/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

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
import entities.TourBookedTopReportDTO;
import java.io.IOException;
import java.io.OutputStream;
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
public class AdminTour_ReportTour_FilePDF_Controller extends HttpServlet {

    @EJB
    private TourBookedFacadeLocal tourBookedFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                logo.scaleToFit(230, 130);

                Paragraph par = new Paragraph();
                Font fontInfo = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Address: 590 CMT8 - District 3 - Ho Chi Minh City", fontInfo));
                par.setAlignment(Element.ALIGN_LEFT);
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase("Contact: 01635 250 135 Mr.Dieu Van Toan", fontInfo));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));

                Paragraph par1 = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                par1.add(new Phrase("TOP 5 OF TOUR REVENUE", font));
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
                PdfPCell cell2 = new PdfPCell(new Paragraph("Tour ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Tour Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Revenue", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                Font fontDayOfIssueed = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Paragraph("Day Of Issued : " + dayOfIssued + "", fontDayOfIssueed));
                List<TourBookedTopReportDTO> listPrint = tourBookedFacade.top05HighestRevenueOfTour(dateFrom, dateTo);

                double sum = 0;

                for (TourBookedTopReportDTO DTO : listPrint) {
                    sum += DTO.getRevenue();
                }

                for (int i = 0; i < listPrint.size(); i++) {
                    table.addCell((i + 1) + "");
                    table.addCell(listPrint.get(i).getTourID());
                    table.addCell(listPrint.get(i).getTourtitle());
                    table.addCell(String.valueOf(listPrint.get(i).getRevenue() + " USD"));
                }

                table.addCell("");
                table.addCell("");
                table.addCell("Total:     ");
                table.addCell(String.valueOf(sum + " USD"));

                docement.add(logo);
                docement.add(par);
                docement.add(par1);
                docement.add(table);
                docement.add(par3);
                docement.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
        } else if (action.equals("btnPrintTop05OfBooked")) {

            try {
                Document docement = new Document();
                PdfWriter.getInstance(docement, out);

                docement.open();

                String absolutepath = getServletContext().getRealPath("\\assets\\images\\logo.png");

                Image logo = Image.getInstance(absolutepath);
                logo.setAlignment(Element.ALIGN_LEFT);
                logo.scaleToFit(230, 130);

                Paragraph par = new Paragraph();
                Font fontInfo = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Address: 590 CMT8 - District 3 - Ho Chi Minh City", fontInfo));
                par.setAlignment(Element.ALIGN_LEFT);
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase("Contact: 01635 250 135 Mr.Dieu Van Toan", fontInfo));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));
                par.add(new Phrase(Chunk.NEWLINE));

                Paragraph par1 = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
                par1.add(new Phrase("TOP 5 OF TOUR BOOKED", font));
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
                PdfPCell cell2 = new PdfPCell(new Paragraph("Tour ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Tour Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Number Of Booked", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                Font fontDayOfIssueed = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Paragraph("Day Of Issued : " + dayOfIssued + "", fontDayOfIssueed));
                List<TourBookedTopReportDTO> listPrint = tourBookedFacade.top05TourBookedMost(dateFrom, dateTo);

                int sum = 0;

                for (TourBookedTopReportDTO DTO : listPrint) {
                    sum += DTO.getNumOfbooked();
                }

                for (int i = 0; i < listPrint.size(); i++) {
                    table.addCell((i + 1) + "");
                    table.addCell(listPrint.get(i).getTourID());
                    table.addCell(listPrint.get(i).getTourtitle());
                    table.addCell(String.valueOf(listPrint.get(i).getNumOfbooked()));
                }
                
                table.addCell("");
                table.addCell("");
                table.addCell("Total:     ");
                table.addCell(String.valueOf(sum + ""));
                
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
