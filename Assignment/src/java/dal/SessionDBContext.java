/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Session;

/**
 *
 * @author win
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Session> getByDate(Date currentDate, String groupId) {
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
                    + "  FROM [dbo].[Session]\n"
                    + "WHERE [SessionDate] = '2022/04/13'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(0, sql);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
