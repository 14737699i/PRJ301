/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecture;

import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Session;
import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import java.util.Calendar;

/**
 *
 * @author win
 */
@WebServlet(name = "TimeTableController", urlPatterns = {"/view/timetable"})
public class TimeTableController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeTableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeTableController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        SessionDBContext sDB = new SessionDBContext();
        String lectureId = "sonnt5";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        ArrayList<Date> dates = new ArrayList<>();  
        for (int i = 0; i < 7; i++) {
            dates.add(Date.valueOf(format1.format(c.getTime())));
            c.add(Calendar.DAY_OF_WEEK, 1);
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.YEAR, 2022);
        
        ArrayList<Date> weeks = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            weeks.add(Date.valueOf(format1.format(cal.getTime())));
            cal.add(Calendar.DAY_OF_WEEK, 7);
        }
        
        ArrayList<Session> sessions = sDB.getByDate(dates.get(0), dates.get(dates.size() - 1), lectureId);
        request.setAttribute("sessions", sessions);
        request.setAttribute("dates", dates);
        request.setAttribute("weeks", weeks);
        request.setAttribute("lectureId", lectureId);
        request.getRequestDispatcher("../view/lecture/timetable.jsp").forward(request, response);
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
//        SessionDBContext sDB = new SessionDBContext();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
//        Calendar c = Calendar.getInstance();
//        Date fromDate = Date.valueOf(LocalDate.now().with(firstInMonth(DayOfWeek.MONDAY)));
//        c.setTime(fromDate);
//        c.add(Calendar.DATE, 7);
//        Date toDate = Date.valueOf("2022-05-15");
//        String lectureId = "sonnt5";
//        ArrayList<Session> sessions = sDB.getByDate(fromDate, toDate, lectureId);
//        
//        
//        ArrayList<Date> dates = new ArrayList<>();
//        dates.add(Date.valueOf("2022-05-09"));
//        dates.add(Date.valueOf("2022-05-10"));
//        dates.add(Date.valueOf("2022-05-11"));
//        dates.add(Date.valueOf("2022-05-12"));
//        dates.add(Date.valueOf("2022-05-13"));
//        dates.add(Date.valueOf("2022-05-14"));
//        dates.add(Date.valueOf("2022-05-15"));
//        
//        
//        request.setAttribute("sessions", sessions);
//        request.setAttribute("dates", dates);
//        
//        
//        request.setAttribute("lectureId", lectureId);
//        request.getRequestDispatcher("../view/lecture/timetable.jsp").forward(request, response);
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
