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
        try {
            String sql = "INSERT INTO [AttendanceReport]\n"
                    + "           ([SessionID]\n"
                    + "           ,[StudentID]\n"
                    + "           ,[StudentName]\n"
                    + "           ,[Status]\n"
                    + "           ,[Comment]\n"
                    + "           ,[RecordTime])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSessionId());
            stm.setInt(2, model.getStudent().getId());
            stm.setString(3, model.getStudent().getName());
            stm.setBoolean(4, model.isStatus());
            stm.setString(5, model.getComment());
            stm.setDate(6, model.getRecordTime());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(AttendanceReport model) {
        try {
            String sql = "UPDATE [dbo].[AttendanceReport]\n"
                    + "   SET \n"
                    + "	   [Status] = ?\n"
                    + "      ,[Comment] = ?\n"
                    + "      ,[RecordTime] = ?\n"
                    + " WHERE ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, model.isStatus());
            stm.setString(2, model.getComment());
            stm.setDate(3, model.getRecordTime());
            stm.setInt(4, model.getId());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(AttendanceReport model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
