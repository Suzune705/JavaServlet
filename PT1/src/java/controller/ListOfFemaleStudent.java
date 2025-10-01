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
@WebServlet(name="ListOfFemaleStudent", urlPatterns={"/ListOfFemaleStudent"})
public class ListOfFemaleStudent extends HttpServlet {
 
 
    StudentDao studentDao = new StudentDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
           List<Student> femaleStudentList = studentDao.getFemaleStudent();
           request.setAttribute("femaleStudent", femaleStudentList);
           request.getRequestDispatcher("/view/ListOfFemaleStudent.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }


}
