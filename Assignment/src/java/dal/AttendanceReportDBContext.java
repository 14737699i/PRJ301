/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AttendanceReport;
import model.Group;
import model.Student;

/**
 *
 * @author win
 */
public class AttendanceReportDBContext extends DBContext<AttendanceReport> {

    public ArrayList<AttendanceReport> getBySession(int sessionID) {
        ArrayList<AttendanceReport> ars = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[SessionID]\n"
                    + "      ,[StudentID]\n"
                    + "      ,[StudentName]\n"
                    + "      ,[Status]\n"
                    + "      ,[Comment]\n"
                    + "      ,[RecordTime]\n"
                    + "  FROM [dbo].[AttendanceReport]\n"
                    + "WHERE [SessionID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sessionID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                AttendanceReport ar = new AttendanceReport();
                ar.setId(rs.getInt("ID"));
                ar.setSessionId(rs.getInt("SessionID"));
                Student s = new Student();
                s.setId(rs.getInt("StudentID"));
                s.setName(rs.getString("StudentName"));
                ar.setStudent(s);
                ar.setStatus(rs.getBoolean("Status"));
                ar.setComment(rs.getString("Comment"));
                ar.setRecordTime(rs.getDate("RecordTime"));
                ars.add(ar);
                }
            return ars;
            
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<AttendanceReport> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AttendanceReport get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AttendanceReport model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AttendanceReport model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AttendanceReport model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
