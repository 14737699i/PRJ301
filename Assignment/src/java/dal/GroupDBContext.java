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
import model.Group;

/**
 *
 * @author win
 */
public class GroupDBContext extends DBContext<Group> {

    public ArrayList<Group> getByLecture(String lectureId) {
        ArrayList<Group> groups = new ArrayList<>();
        
        try {
            String sql = "select ID, GroupName, CourseID, LectureID from [Group]\n"
                    + "where lectureID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lectureId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Group g = new Group();
                g.setId(rs.getInt("ID"));
                g.setGroupName(rs.getString("GroupName"));
                g.setCourseId(rs.getString("CourseID"));
                g.setLectureId(rs.getString("LectureID"));
                groups.add(g);
            }
            return groups;
            
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group get(int id) {
        try {
            String sql = "SELECT [ID]\n"
                    + "      ,[GroupName]\n"
                    + "      ,[CourseID]\n"
                    + "      ,[LectureID]\n"
                    + "  FROM [Group]\n"
                    + "WHERE ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Group g = new Group();
                g.setId(rs.getInt("ID"));
                g.setGroupName(rs.getString("GroupName"));
                g.setCourseId(rs.getString("CourseID"));
                g.setLectureId(rs.getString("LectureID"));
                return g;

            }

        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
