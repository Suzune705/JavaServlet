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
@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {

    EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Employee> list = employeeDao.getAllEmployee();
        request.setAttribute("empList", list);
        
        String id = request.getParameter("employee_id");
        if (!id.startsWith("EM") || id == null || id.isBlank()) {
            request.setAttribute("error", "id cannot null and must start with EM ");
            request.getRequestDispatcher("WEB-INF/views/ManagerDashBoard.jsp").forward(request, response);
            return;
        }
        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            request.setAttribute("error", "name cannot null  ");
            request.getRequestDispatcher("WEB-INF/views/ManagerDashBoard.jsp").forward(request, response);
            return;
        }
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        if (age < 18 || age > 70) {
            request.setAttribute("error", "age must be in range of 18 to 70 age   ");
            request.getRequestDispatcher("WEB-INF/views/ManagerDashBoard.jsp").forward(request, response);
            return;
        }

        Employee e = new Employee(id, name, phone, age);
        employeeDao.addEmployee(e);

        response.sendRedirect(request.getContextPath() + "/ManagerDashBoard");
    }

}
