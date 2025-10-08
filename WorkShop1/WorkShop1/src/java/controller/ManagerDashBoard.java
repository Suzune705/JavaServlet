/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.EmployeeDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Employee;

/**
 *
 * @author hieuchu
 */
@WebServlet(name="ManagerDashBoard", urlPatterns={"/ManagerDashBoard"})
public class ManagerDashBoard extends HttpServlet {
  
    EmployeeDao employeeDao = new EmployeeDao();            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
            List<Employee> list = employeeDao.getAllEmployee();
            
            request.setAttribute("empList", list);
                      
           request.getRequestDispatcher("WEB-INF/views/ManagerDashBoard.jsp").forward(request, response);
           return ;
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    }

}
