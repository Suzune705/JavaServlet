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
import model.Employee;

/**
 *
 * @author hieuchu
 */
@WebServlet(name = "UpdateEmployee", urlPatterns = {"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {

     EmployeeDao employeeDao = new EmployeeDao();             
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("employee_id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));

        Employee e = new Employee(id, name, phone, age);
        employeeDao.updateEmployee(e);

        response.sendRedirect(request.getContextPath() + "/ManagerDashBoard");
    }

}
