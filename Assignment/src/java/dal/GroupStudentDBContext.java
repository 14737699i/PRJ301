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
import model.GroupStudent;
import model.Student;

/**
 *
 * @author win
 */
public class GroupStudentDBContext extends DBContext<GroupStudent> {

    public ArrayList<Student> getStudentsByGroup(int groupId) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT "
                    + "   [StudentID]\n"
                    + "	  ,StudentName\n"
                    + "  FROM [GroupStudent] as gs INNER JOIN Student as s\n"
                    + "  ON gs.StudentID = s.ID\n"
                    + "WHERE GroupID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, groupId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("StudentID"));
                s.setName(rs.getString("StudentName"));
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(GroupStudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public ArrayList<GroupStudent> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GroupStudent get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(GroupStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(GroupStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(GroupStudent model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
