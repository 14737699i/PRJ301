/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecture;

import dal.AttendanceReportDBContext;
import dal.GroupDBContext;
import dal.GroupStudentDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.AttendanceReport;
import model.GroupStudent;
import model.Session;
import model.Student;

/**
 *
 * @author win
 */
public class TakeAttendanceController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TakeAttendanceController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeAttendanceController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Date currentDate = Date.valueOf("2022-07-04");
        SessionDBContext sDB = new SessionDBContext();
        String lectureId = "sonnt5";
        ArrayList<Session> sessions = sDB.getByDate(currentDate, lectureId);
//        Collections.sort(sessions, new Comparator<Session>() {
//            @Override
//            public int compare(Session o1, Session o2) {
//                return o1.getTimeSlotId() - o2.getTimeSlotId();
//            }
//        });
        request.setAttribute("currentDate", currentDate);
        request.setAttribute("sessions", sessions);
        request.setAttribute("lectureId", lectureId);
        request.getRequestDispatcher("../view/lecture/takeattendance.jsp").forward(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SessionDBContext sDB = new SessionDBContext();
        Session s = sDB.get(Integer.parseInt(request.getParameter("sid")));
        
        if(s.isStatus()){
            AttendanceReportDBContext arDB = new AttendanceReportDBContext();
           ArrayList<AttendanceReport> ars = arDB.getBySession(s.getId());
           request.setAttribute("ars", ars);
        } else {
            GroupStudentDBContext gsDB = new GroupStudentDBContext();
            ArrayList<Student> students = gsDB.getStudentsByGroup(s.getGroup().getId());
            request.setAttribute("students", students);
        }
        
        request.setAttribute("session", s);
        request.getRequestDispatcher("../view/lecture/attendancereport.jsp").forward(request, response);
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
