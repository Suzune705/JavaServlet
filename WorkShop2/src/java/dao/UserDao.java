/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

import util.DBConnection;

/**
 *
 * @author hieuchu
 */
public class UserDao {


    public List<User> getAllUsers() {

        String sql = "select * from users ";
//        logger.debug("seletc * from users ", sql);
        List<User> userList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            {

                while (rs.next()) {
                    User u = new User();
                    u.setUserID(rs.getString("user_id"));
                    u.setAccount(rs.getString("account"));
                    u.setPassword(rs.getString("password"));
                    u.setRole(rs.getString("role"));
                    userList.add(u);
                }
      
            }
        } catch (Exception e) {
//            logger.error("Get user data failed !!! ", e);
        }
        return userList;
    }

    public User checkLogin(String account, String password) {
        String sql = "select * from users where account = ? and password = ? and role like 'manager' ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            {
                ps.setString(1, account);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User u = new User();
                    u.setUserID(rs.getString("user_id"));
                    u.setAccount(rs.getString("account"));
                    u.setPassword(rs.getString("password"));
                    u.setRole(rs.getString("role"));
                    return u;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
