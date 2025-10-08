/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import util.DBConnection;

/**
 *
 * @author hieuchu
 */
public class EmployeeDao {

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from employees";
        try {

            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getString("employee_id"));
                e.setName(rs.getString("name"));
                e.setPhone(rs.getString("phone"));
                e.setAge(rs.getInt("age"));
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addEmployee(Employee e) {
        String sql = "insert into employees (employee_id, name , phone , age ) values (? , ? , ? , ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getEmployeeID());
            ps.setString(2, e.getName());
            ps.setString(3, e.getPhone());
            ps.setInt(4, e.getAge());

            ps.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void updateEmployee(Employee e) {
        String sql = "update employees set name = ? , phone = ? , age = ? where employee_id = ? ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getPhone());
            ps.setInt(3, e.getAge());
            ps.setString(4, e.getEmployeeID());

            ps.executeUpdate();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void deleteEmployee(String id) {
        String sql = "delete from employees where employee_id = ? ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public Employee searchEmployee(String name, String id) {
        String sql = "select * from employees where name = ? or employee_id = ? ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getString("employee_id"));
                e.setName(rs.getString("name"));
                e.setPhone(rs.getString("phone"));
                e.setAge(rs.getInt("age"));
                return e;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
    public boolean isIdExist(String id){
        String sql = "select * from employees where employee_id = ? ";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true ;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false ;
    }
}
