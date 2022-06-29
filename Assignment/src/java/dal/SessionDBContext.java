/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author win
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Session> getByDate(Date currentDate, String lectureId) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[GroupID]\n"
                    + "      ,[TimeSlotID]\n"
                    + "      ,[SessionNo]\n"
                    + "      ,[SessionDate]\n"
                    + "      ,[Room]\n"
                    + "      ,[LectureID]\n"
                    + "      ,[Status]\n"
                    + "  FROM [Session]\n"
                    + "WHERE [SessionDate] = ? AND LectureID = ?";
                    
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, currentDate.toString());
            stm.setString(2, lectureId);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("ID"));
                GroupDBContext gDB = new GroupDBContext();
                Group g = gDB.get(rs.getInt("GroupID"));
                s.setGroup(g);
                s.setTimeSlotId(rs.getInt("TimeSlotID"));
                s.setSessionNo(rs.getInt("SessionNo"));
                s.setSessionDate(rs.getDate("SessionDate"));
                s.setRoom(rs.getString("Room"));
                s.setLectureId(rs.getString("LectureID"));
                s.setStatus(rs.getBoolean("Status"));

                sessions.add(s);
            }
            return sessions;

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(int id) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[GroupID]\n"
                    + "      ,[TimeSlotID]\n"
                    + "      ,[SessionNo]\n"
                    + "      ,[SessionDate]\n"
                    + "      ,[Room]\n"
                    + "      ,[LectureID]\n"
                    + "      ,[Status]\n"
                    + "  FROM [Session]\n"
                    + "  where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("ID"));
                GroupDBContext gDB = new GroupDBContext();
                Group g = gDB.get(rs.getInt("GroupID"));
                s.setGroup(g);
                s.setTimeSlotId(rs.getInt("TimeSlotID"));
                s.setSessionNo(rs.getInt("SessionNo"));
                s.setSessionDate(rs.getDate("SessionDate"));
                s.setRoom(rs.getString("Room"));
                s.setLectureId(rs.getString("LectureID"));
                s.setStatus(rs.getBoolean("Status"));
                
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Session model) {

    }

    @Override
    public void update(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
