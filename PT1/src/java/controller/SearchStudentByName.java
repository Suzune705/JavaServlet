/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Student;

/**
 *
 * @author hieuchu
 */
@WebServlet(name = "SearchStudentByName", urlPatterns = {"/SearchStudentByName"})
public class SearchStudentByName extends HttpServlet {

    StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = studentDao.getALLStudent();
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/view/SearchStudentByName.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String student = request.getParameter("studentName");
        Student foundStudent = studentDao.searchStudentByName(student);
        request.setAttribute("studentName", foundStudent);
        
        List<Student> studentList = studentDao.getALLStudent();
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/view/SearchStudentByName.jsp").forward(request, response);

    }

}
