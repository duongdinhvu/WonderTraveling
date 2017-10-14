/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.CustomerList;
import entities.TourBooked;
import entities.TourBookedSub;
import entities.Tours;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CustomerListFacadeLocal;
import sessionbean.TourBookedFacadeLocal;
import sessionbean.TourBookedSubFacadeLocal;

/**
 *
 * @author dieut
 */
public class AdminTour_PrintTour_Controller extends HttpServlet {
    @EJB
    private TourBookedSubFacadeLocal tourBookedSubFacade;

    @EJB
    private CustomerListFacadeLocal customerListFacade;
    @EJB
    private TourBookedFacadeLocal tourBookedFacade;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        String action = request.getParameter("action");

        if (action.equals("btnPrintGroupInvoice")) {
            String tourBookedID = request.getParameter("tourBookIDInvoice");
            TourBooked tourBooked = tourBookedFacade.searchByTourBookID(tourBookedID);
            int representativeID = Integer.valueOf(request.getParameter("representativeIDInvoice"));
            Tours tour = tourBooked.getTourID();
            List<CustomerList> cusList = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeID, tourBookedID);
            double total = (tourBooked.getNumberOfAdult() * tour.getEvenTourPrice())
                    + (tourBooked.getNumberOfKid() * (tour.getEvenTourPrice() / 2))
                    + (tourBooked.getIndividualRoom() * 15);

            Short transportShort = tourBooked.getTransportation();
            String transportation = "";
            if (transportShort == 1) {
                transportation = "AirPlane";
            } else {
                transportation = "Bus";
            }
            try {
                Document document = new Document();

                PdfWriter.getInstance(document, out);

                document.open();

                ///---- Information of Web
                Paragraph parInfo = new Paragraph();
                Font fontinfo = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLUE);

                parInfo.add(new Phrase("Address: 590 CMT8 -Distric 3 - Ho Chi Minh City", fontinfo));
                parInfo.add(new Phrase(Chunk.NEWLINE));
                parInfo.add(new Phrase("School: FPT APTECH", fontinfo));
                parInfo.add(new Phrase(Chunk.NEWLINE));
                parInfo.add(new Phrase("Project Semester 4", fontinfo));
                parInfo.setAlignment(Element.ALIGN_LEFT);
                parInfo.setIndentationLeft(7);
                parInfo.add(new Phrase(Chunk.NEWLINE));
                ///------Image-
                String absolutepath = getServletContext().getRealPath("\\assets\\images\\logo.png");
                Image image = Image.getInstance(absolutepath);
                image.setAlignment(Element.ALIGN_LEFT);
                image.scaleToFit(200, 150);

                ///---- List of Passenger
                Paragraph par2 = new Paragraph();
                Font fontdescript = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLUE);
                par2.add(new Phrase("INFORMATION OF PASSENGERS", fontdescript));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));

                //// ------Location -------------
                Paragraph parlocation = new Paragraph();
                Font fontLocation = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parlocation.add(new Phrase("Location:  " + tour.getHeadingTo(), fontLocation));

                parlocation.setAlignment(Element.ALIGN_CENTER);
                parlocation.add(new Phrase(Chunk.NEWLINE));

                //// ------Depature -------------
                Paragraph par = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Depature:  " + tour.getDepaturePoint(), font));

                par.setAlignment(Element.ALIGN_CENTER);
                par.add(new Phrase(Chunk.NEWLINE));

                //// ------Duration -------------
                Paragraph parDuration = new Paragraph();
                Font fontDuration = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parDuration.add(new Phrase("Duration:  " + tour.getDuration() + " days", fontDuration));

                parDuration.setAlignment(Element.ALIGN_CENTER);
                parDuration.add(new Phrase(Chunk.NEWLINE));
                parDuration.add(new Phrase(Chunk.NEWLINE));

                /////  Table ---
                PdfPTable table = new PdfPTable(4);
                table.setWidths(new float[]{15, 40, 20, 25});

                PdfPCell cell1 = new PdfPCell(new Paragraph("No", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Full Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Sex", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Date of Birth", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));

                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));

                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                PdfPCell cell;

                for (int i = 0; i < cusList.size(); i++) {

                    cell = new PdfPCell(new Paragraph((i + 1) + "", FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(cusList.get(i).getFullName(), FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    String sex = "Female";
                    if (cusList.get(i).getSex()) {
                        sex = "Male";
                    }
                    cell = new PdfPCell(new Paragraph(sex, FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    String dateOfBirth = fm.format(cusList.get(i).getDateOfBirth());
                    cell = new PdfPCell(new Paragraph(dateOfBirth, FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    if ((i + 1) == (cusList.size())) {
                        ///// Transportation
                        cell = new PdfPCell(new Paragraph("Transportation", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(transportation, FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        ///// Rooms
                        cell = new PdfPCell(new Paragraph("Individual room(+15$)", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(tourBooked.getIndividualRoom() + "", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        /// Unit Price
                        cell = new PdfPCell(new Paragraph("Unit Price", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(tour.getEvenTourPrice() + "$", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        //// Total 
                        cell = new PdfPCell(new Paragraph("Total", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(total + "$", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                    }

                }
                ///// Set information -----------
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date d = new Date();
                String sDate = df.format(d);
                Paragraph par0 = new Paragraph();
                Font font0 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par0.add(new Phrase("Date: " + sDate, font0));

                par0.setAlignment(Element.ALIGN_RIGHT);
                par0.setIndentationRight(60);
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));

                Paragraph parSignature = new Paragraph();
                Font fontSignature = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parSignature.add(new Phrase("Signature  ", fontSignature));

                parSignature.setAlignment(Element.ALIGN_RIGHT);
                parSignature.setIndentationRight(60);
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));

                document.add(image);
                document.add(parInfo);

                document.add(parlocation);
                document.add(par);

                document.add(parDuration);
                document.add(par2);
                document.add(table);
                document.add(par3);
                document.add(par0);
                document.add(parSignature);
                document.close();
            } catch (DocumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } else if (action.equals("btnPrintSubInvoice")) {
            
            String tourBookedID = request.getParameter("tourBookIDInvoice");
            int representativeID = Integer.valueOf(request.getParameter("representativeIDInvoice"));
            TourBookedSub tourBooked = tourBookedSubFacade.searchByBookedIdAndRepresentativeId(tourBookedID, representativeID);
            Tours tour = tourBooked.getTourID();
            List<CustomerList> cusList = customerListFacade.searchByRepresentiveCustomerIdAndBookedID(representativeID, tourBookedID);
            double total = (tourBooked.getNumberOfAdult() * tour.getOddTourPrice())
                    + (tourBooked.getNumberOfKid() * (tour.getOddTourPrice() / 2))
                    + (tourBooked.getIndividualRoom() * 15);

            Short transportShort = tourBooked.getTransportation();
            String transportation = "";
            if (transportShort == 1) {
                transportation = "AirPlane";
            } else {
                transportation = "Bus";
            }
            try {
                Document document = new Document();

                PdfWriter.getInstance(document, out);

                document.open();

                ///---- Information of Web
                Paragraph parInfo = new Paragraph();
                Font fontinfo = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLUE);

                parInfo.add(new Phrase("Address: 590 CMT8 - Distric 3 - Ho Chi Minh City", fontinfo));
                parInfo.add(new Phrase(Chunk.NEWLINE));
                parInfo.add(new Phrase("School: FPT APTECH", fontinfo));
                parInfo.add(new Phrase(Chunk.NEWLINE));
                parInfo.add(new Phrase("Project Semester 4", fontinfo));
                parInfo.setAlignment(Element.ALIGN_LEFT);
                parInfo.setIndentationLeft(7);
                parInfo.add(new Phrase(Chunk.NEWLINE));
                ///------Image-
                String absolutepath = getServletContext().getRealPath("\\assets\\images\\logo.png");
                Image image = Image.getInstance(absolutepath);
                image.setAlignment(Element.ALIGN_LEFT);
                image.scaleToFit(200, 150);

                ///---- List of Passenger
                Paragraph par2 = new Paragraph();
                Font fontdescript = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLUE);
                par2.add(new Phrase("INFORMATION OF PASSENGERS", fontdescript));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));

                //// ------Location -------------
                Paragraph parlocation = new Paragraph();
                Font fontLocation = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parlocation.add(new Phrase("Location:  " + tour.getHeadingTo(), fontLocation));

                parlocation.setAlignment(Element.ALIGN_CENTER);
                parlocation.add(new Phrase(Chunk.NEWLINE));

                //// ------Depature -------------
                Paragraph par = new Paragraph();
                Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par.add(new Phrase("Depature:  " + tour.getDepaturePoint(), font));

                par.setAlignment(Element.ALIGN_CENTER);
                par.add(new Phrase(Chunk.NEWLINE));

                //// ------Duration -------------
                Paragraph parDuration = new Paragraph();
                Font fontDuration = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parDuration.add(new Phrase("Duration:  " + tour.getDuration() + " Days", fontDuration));

                parDuration.setAlignment(Element.ALIGN_CENTER);
                parDuration.add(new Phrase(Chunk.NEWLINE));
                parDuration.add(new Phrase(Chunk.NEWLINE));

                /////  Table ---
                PdfPTable table = new PdfPTable(4);
                table.setWidths(new float[]{15, 40, 20, 25});

                PdfPCell cell1 = new PdfPCell(new Paragraph("No", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Full Name", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Sex", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Date of Birth", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.DARK_GRAY)));

                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                Paragraph par3 = new Paragraph();
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));

                SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                PdfPCell cell;

                for (int i = 0; i < cusList.size(); i++) {

                    cell = new PdfPCell(new Paragraph((i + 1) + "", FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(cusList.get(i).getFullName(), FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    String sex = "Female";
                    if (cusList.get(i).getSex()) {
                        sex = "Male";
                    }
                    cell = new PdfPCell(new Paragraph(sex, FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    String dateOfBirth = fm.format(cusList.get(i).getDateOfBirth());
                    cell = new PdfPCell(new Paragraph(dateOfBirth, FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    table.addCell(cell);

                    if ((i + 1) == (cusList.size())) {
                        ///// Transportation
                        cell = new PdfPCell(new Paragraph("Transportation", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(transportation, FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        ///// Rooms
                        cell = new PdfPCell(new Paragraph("Individual room(+15$)", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(tourBooked.getIndividualRoom() + "", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        /// Unit Price
                        cell = new PdfPCell(new Paragraph("Unit Price", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(tour.getOddTourPrice() + "$", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        //// Total 
                        cell = new PdfPCell(new Paragraph("Total", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setColspan(3);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(total + "$", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        table.addCell(cell);

                    }

                }
                ///// Set information -----------
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date d = new Date();
                String sDate = df.format(d);
                Paragraph par0 = new Paragraph();
                Font font0 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                par0.add(new Phrase("Date: " + sDate, font0));

                par0.setAlignment(Element.ALIGN_RIGHT);
                par0.setIndentationRight(60);
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));
                par0.add(new Phrase(Chunk.NEWLINE));

                Paragraph parSignature = new Paragraph();
                Font fontSignature = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
                parSignature.add(new Phrase("Signature  ", fontSignature));

                parSignature.setAlignment(Element.ALIGN_RIGHT);
                parSignature.setIndentationRight(60);
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));
                parSignature.add(new Phrase(Chunk.NEWLINE));

                document.add(image);
                document.add(parInfo);

                document.add(parlocation);
                document.add(par);

                document.add(parDuration);
                document.add(par2);
                document.add(table);
                document.add(par3);
                document.add(par0);
                document.add(parSignature);
                document.close();
            } catch (DocumentException ex) {
                System.out.println("Error: " + ex.getMessage());
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
