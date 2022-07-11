/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.lecture;

import dal.AttendanceReportDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import model.AttendanceReport;
import model.Student;

/**
 *
 * @author win
 */
public class UpdateAttendanceController extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateAttendanceController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAttendanceController at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        
        //processRequest(request, response);
//        SessionDBContext sDB = new SessionDBContext();
        String[] index = request.getParameterValues("index");
        int sId = Integer.parseInt(request.getParameter("sessionId")); 
        for (String i : index) {
            
            AttendanceReport ar = new AttendanceReport();
            ar.setId(Integer.parseInt(request.getParameter("a.id_"+ i)));
            ar.setSessionId(sId);
            Student s = new Student();
            s.setId(Integer.parseInt(request.getParameter("sId_"+i)));
            s.setName(request.getParameter("sName_"+ i));
            ar.setStudent(s);
            ar.setStatus(Boolean.parseBoolean(request.getParameter("status_"+ i)));
            ar.setComment(request.getParameter("comment_"+ i));
            response.getWriter().println( ar.getComment());
            ar.setRecordTime(Date.valueOf(LocalDate.now()));
            AttendanceReportDBContext arDB = new AttendanceReportDBContext();
            arDB.update(ar);
            
        }
        
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
