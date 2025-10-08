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
@WebServlet(name = "DeleteEmployee", urlPatterns = {"/DeleteEmployee"})
public class DeleteEmployee extends HttpServlet {

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
        if (!employeeDao.isIdExist(id)) {
            request.setAttribute("error2", "ID is not exist");
            request.getRequestDispatcher("WEB-INF/views/ManagerDashBoard.jsp").forward(request, response);
        }
        employeeDao.deleteEmployee(id);
        response.sendRedirect(request.getContextPath() + "/ManagerDashBoard");
    }

}
